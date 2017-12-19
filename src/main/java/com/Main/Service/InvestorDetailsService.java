package com.Main.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Main.DAO.BrokerDao;
import com.Main.DAO.CommandDao;
import com.Main.DAO.InvestorDao;
import com.Main.Entities.Investor;
import com.Main.Entities.Command;
import com.Main.Support.InvestorDetailsResponse;
import com.Main.Support.MyCommandsResponse;
import com.Main.Support.MyDetailsResponse;
import com.Main.Support.UpdateInvestorRequest;


@Service
public class InvestorDetailsService {

	@Autowired
	private InvestorDao investorDao;
	@Autowired
	private BrokerDao brokerDao;
	@Autowired
	private CommandDao commandDao;


	@Transactional(readOnly = true)
	public MyDetailsResponse showMyDetails(Long investorId) {
		Investor investor = investorDao.findOne(investorId);
		if (investor == null)
			return null;
		return (new MyDetailsResponse(investor.getAccName(), investor.getEmail(), investor.getBalance(),
				investor.getStatus()));
	}

	public boolean updateMyDetails(UpdateInvestorRequest updateInvestorRequest) {
		Investor investor = investorDao.findOne(updateInvestorRequest.getAccId());
		// investor doesn't exist in the system
		if (investor == null)
			return false;
		if (updateInvestorRequest.getEmail() != null) {//email has changed
			// new email is not valid - already exists
			if (updateInvestorRequest.getEmail().isEmpty() || !(investorDao.findInvestorByEmail(updateInvestorRequest.getEmail())).isEmpty() ||
					!(brokerDao.findBrokerByEmail(updateInvestorRequest.getEmail())).isEmpty())
				return false;
			investor.setEmail(updateInvestorRequest.getEmail());
		}
		if((updateInvestorRequest.getAccName() != null)){
			if(updateInvestorRequest.getAccName().isEmpty())
				return false;
			investor.setAccName(updateInvestorRequest.getAccName());
		}
			
		if((updateInvestorRequest.getPassword() != null)){
			if(updateInvestorRequest.getPassword().isEmpty())
				return false;
			investor.setPassword(updateInvestorRequest.getPassword());
		}
		investorDao.save(investor);
		return true;
	}

	public List<MyCommandsResponse> myCommands(Long investorId) {
		  List<Command> commands = commandDao.findCommandsByInvestor(investorId);
		  List<MyCommandsResponse> commandsResponse = new ArrayList<>();
		  for (Command c : commands) {
		   commandsResponse.add(new MyCommandsResponse(c.getCommandId(), c.getCommandType(), c.getStockName(),
		     c.getStockId(), c.getMinPrice(), c.getMaxPrice(), c.getInitAmount(), c.getStatus()));
		  }
		  return commandsResponse;
		 }

	public List<InvestorDetailsResponse> getAllInvestorsDetailsByBroker(Long id) {
		List<Investor> investors = investorDao.findInvestorsByBroker(id);
		List<InvestorDetailsResponse> investorsDetailsResponse = new ArrayList<>();
		for (Investor i : investors) {
			investorsDetailsResponse.add(new InvestorDetailsResponse(i.getAccId(), i.getAccName(), i.getEmail(),
					i.getStatus(), i.getBalance()));
		}
		return investorsDetailsResponse;
	}
	
	

}
