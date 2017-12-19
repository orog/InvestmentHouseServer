package com.Main.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Main.DAO.CommandDao;
import com.Main.DAO.InvestorDao;
import com.Main.DAO.SystemDataDao;
import com.Main.Entities.Command;
import com.Main.Entities.Investor;
import com.Main.Entities.SystemData;
import com.Main.Support.BidAskRequest;
import com.Main.Support.PortfolioStockDetails;
import com.Main.Support.StockMarketResponse;

import stockexchange.client.Stock;
import stockexchange.client.StockCommandType;
import stockexchange.client.StockExchangeClient;
import stockexchange.client.StockExchangeCommand;
import stockexchange.client.StockExchangeTransaction;

@Service
public class StockMarketService {

	@Autowired
	private SystemDataDao systemDataDao;
	@Autowired
	private InvestorDao investorDao;
	@Autowired
	private CommandDao commandDao;
	@Autowired
	private StockExchangeClient stockExchangeClient;
	// private String stockClientId = "client1";

	public StockMarketService(StockExchangeClient stockExchangeClient) {
		super();
		this.stockExchangeClient = stockExchangeClient;
	}

	// this method is not @transactional
	public List<StockMarketResponse> getStocks() {
		ArrayList<StockMarketResponse> stocks = new ArrayList<StockMarketResponse>();
		List<String> stocksIdList = stockExchangeClient.getStocksId();
		for (String s : stocksIdList) {
			Stock stock = stockExchangeClient.getQuote(s);
			stocks.add(new StockMarketResponse(stock.getId(), stock.getName(), stock.getQuote()));
		}

		return (List<StockMarketResponse>) stocks;
	}

	@Transactional
	public Long newCommandRequest(BidAskRequest newCommand) {
		String invokerId = systemDataDao.findAll().get(0).getSystemId();
		StockCommandType commandType;
		Command cmd = new Command();
		if (newCommand.getCommandType() == 1)
			commandType = StockCommandType.BID;
		else
			commandType = StockCommandType.ASK;
		// validate command
		if (newCommand.getAmount() > 0 && newCommand.getMinPrice() <= newCommand.getMaxPrice()
				&& newCommand.getMinPrice() >= 0) {
			// send command to stock market
			Long commandId = stockExchangeClient
					.sendCommand(new StockExchangeCommand(commandType, invokerId, newCommand.getStockId(),
							newCommand.getMinPrice(), newCommand.getMaxPrice(), newCommand.getAmount()));
			// save command in DB
			cmd = new Command(investorDao.findOne(newCommand.getAccId()), newCommand.getAmount(),
					newCommand.getCommandType(), commandId, newCommand.getMinPrice(), newCommand.getMaxPrice(),
					newCommand.getStockId(), newCommand.getStockName());
			commandDao.save(cmd);
			// update balance
			Investor investor = investorDao.findOne(newCommand.getAccId());
			SystemData systemData = systemDataDao.findAll().get(0);
			investor.setBalance(investor.getBalance() - systemData.getCommission());// charge
			// investor
			systemData.setRevenue(systemData.getRevenue() + systemData.getCommission());// update
			// revenue
			// save in DB
			investorDao.save(investor);
			systemDataDao.save(systemData);
		}
		return cmd.getCommandId();
	}

	@Transactional(readOnly = true)
	public List<PortfolioStockDetails> reportPortfolio(Long investorId) {
		// retrieve all investor's commands
		// TBD: add current Worth
		checkMatching(investorId);
		List<Command> commands = commandDao.findCommandsByInvestor(investorId);
		Map<String, PortfolioStockDetails> stockMap = new TreeMap<>();
		PortfolioStockDetails currentStockDetails = new PortfolioStockDetails();
		for (Command c : commands) {
			if (stockMap.containsKey(c.getStockId()))// stock already exists
				currentStockDetails = stockMap.get(c.getStockId());
			else// new stock
				currentStockDetails = new PortfolioStockDetails(c.getStockId(), c.getStockName(), 0, 0, 0);
			if (c.getCommandType() == 1) {// BID
				currentStockDetails.setTotalPurchased(currentStockDetails.getTotalPurchased() + c.getActualAmount());
				currentStockDetails.setAmount(currentStockDetails.getAmount() + c.getActualAmount());
				currentStockDetails.setPurchaseValue(currentStockDetails.getPurchaseValue() + c.getFinalPrice());
			} else {// ASK
				currentStockDetails.setAmount(currentStockDetails.getAmount() - c.getActualAmount());
			}
			stockMap.put(currentStockDetails.getStockId(), currentStockDetails);
		}
		ArrayList<String> keys = new ArrayList<>();// stocks to remove
		for (Map.Entry<String, PortfolioStockDetails> entry : stockMap.entrySet()) {
			PortfolioStockDetails current = entry.getValue();
			if (current.getPurchaseValue() > 0) {
				current.setPurchaseValue(current.getPurchaseValue() / current.getTotalPurchased());
				// current value in the stock exchange market
				current.setCurrentWorth(stockExchangeClient.getQuote(current.getStockId()).getQuote());
				entry.setValue(current);
			}
			// in case sell amount is equal to purchase amount - total amount=0
			if (current.getAmount() == 0)
				keys.add(entry.getKey());
		}
		// remove all stocks with 0 amount value
		for (String key : keys)
			stockMap.remove(key);
		List<PortfolioStockDetails> arr = new ArrayList<>(stockMap.values());
		return arr;
	}

	@Transactional
	public double getTotalWorth(Long investorId) {
		List<PortfolioStockDetails> portfolioStocks = reportPortfolio(investorId);
		double totalWorth = 0;
		for (PortfolioStockDetails stock : portfolioStocks) {
			totalWorth += (stock.getAmount() * stock.getCurrentWorth());
		}
		return totalWorth;
	}

	@Transactional
	public void checkMatching(Long investorId) {
		Investor investor = investorDao.findOne(investorId);
		List<Command> commands = commandDao.findCommandsByInvestor(investorId);
		for (Command c : commands) {
			if (c.getStatus() == 1)// commited
			{
				List<StockExchangeTransaction> txList = stockExchangeClient.getTransactionsForCommand(c.getCommandId());
				for (StockExchangeTransaction tx : txList) {
					// TBD: fix calculation of total purchase
					if (tx.getTimestamp().after(c.getLastModified())) {
						c.setActualAmount(c.getActualAmount() + tx.getActualAmount());
						c.setFinalPrice(c.getFinalPrice() + (tx.getActualPrice() * tx.getActualAmount()));
						if (c.getCommandType() == 1)// BID
							investor.setBalance(investor.getBalance() - (tx.getActualPrice() * tx.getActualAmount()));
						else// ASK
							investor.setBalance(investor.getBalance() + (tx.getActualPrice() * tx.getActualAmount()));
						investorDao.save(investor);
					}
				}
				if (c.getActualAmount() == c.getInitAmount())
					c.setStatus(2);// performed
				c.setLastModified(new java.util.Date());
			}
		}
	}
}
