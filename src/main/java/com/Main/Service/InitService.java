package com.Main.Service;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Main.DAO.BrokerDao;
import com.Main.DAO.SystemDataDao;
import com.Main.Entities.Broker;
import com.Main.Entities.SystemData;
@Service
public class InitService {
	@Autowired
	private BrokerDao brokerDao;
	@Autowired
	private SystemDataDao systemDataDao;
	
	@PostConstruct
    @Transactional
    public void init(){
		try{
			//systemDataDao.save(Arrays.asList(new SystemData(3d , 0d , "client1")));
		    //brokerDao.save(Arrays.asList(new Broker("Eyal", "100", "eyale@afeka.ac.il")));
		    

			}
			catch (Exception e) {
				
			}
    }
}
