package com.Main.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Main.DAO.BrokerDao;
import com.Main.DAO.InvestorDao;
import com.Main.Entities.Broker;
import com.Main.Entities.Investor;
import com.Main.Support.AuthorizeRequest;
import com.Main.Support.LoginRequest;
import com.Main.Support.LoginValidation;

@Service
public class AccountsManagmentService {
	public static final int MAX_INVESTORS = 15;

	@Autowired
	private InvestorDao investorDao;
	@Autowired
	private BrokerDao brokerDao;

	@Transactional(readOnly = true)
	public LoginValidation loginRequest(LoginRequest loginRequest) {

		List<Investor> investorsList = investorDao.findInvestorByEmail(loginRequest.getEmail(),
				loginRequest.getPassword());
		if (investorsList != null && investorsList.size() == 1) {

			return new LoginValidation(investorsList.get(0).getAccId(), investorsList.get(0).getAccName(),
					new Integer(1), loginRequest.getPassword().equals(investorsList.get(0).getPassword())
							&& investorsList.get(0).getStatus() != 1,
					investorsList.get(0).getStatus());
		} else {
			List<Broker> brokersList = brokerDao.findBrokerByEmail(loginRequest.getEmail(), loginRequest.getPassword());
			if (brokersList != null && brokersList.size() == 1) {
				return new LoginValidation(brokersList.get(0).getAccId(), brokersList.get(0).getAccName(),
						new Integer(2), loginRequest.getPassword().equals(brokersList.get(0).getPassword()), null);
			}
		}
		return (new LoginValidation(false));
	}

	@Transactional
	public boolean register(Investor newInvestor) {
		List<Investor> investorsList = investorDao.findInvestorByEmail(newInvestor.getEmail());
		if (!investorsList.isEmpty())
			return false;
		List<Broker> brokersList = brokerDao.findAll();
		for (Broker b : brokersList) {
			List<Investor> tempList = investorDao.findInvestorsByBroker(b.getAccId());
			int numOfInvestors = tempList.size();
			if (numOfInvestors < MAX_INVESTORS) {
				newInvestor.setBroker(b);
				newInvestor.getStatus();
				newInvestor.setStatus(1);// Pending
				investorDao.save(newInvestor);
				b.setInvestors(investorDao.findInvestorsByBroker(b.getAccId()));
				b.getInvestors().forEach(i -> System.err.println(i));
				brokerDao.save(b);
				return true;
			}
		}
		return false;
	}

	@Transactional
	public boolean authorize(AuthorizeRequest authorizeRequest) {
		Investor investor = investorDao.findOne(authorizeRequest.getAccId());
		if (investor == null)
			return false;
		if (authorizeRequest.getBalance() != null)
			investor.setBalance(authorizeRequest.getBalance());
		if (authorizeRequest.getStatusId() != null)
			investor.setStatus(authorizeRequest.getStatusId());
		investorDao.save(investor);
		return true;
	}
}