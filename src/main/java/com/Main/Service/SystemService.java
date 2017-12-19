package com.Main.Service;

import com.Main.DAO.SystemDataDao;
import com.Main.Entities.SystemData;
import com.Main.Support.SystemDataResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemService {
	
    private SystemDataDao systemDataDao;
//???
    @Autowired
    public void setSystemDataDao(SystemDataDao systemDataDao) {
        this.systemDataDao = systemDataDao;
    }

    

    @Transactional
    public boolean setCommission(Double commission){
        //verify input
        if(commission != null && commission > 0){
        	SystemData systemData = systemDataDao.findAll().get(0);
        	systemData.setCommission(commission);
        	systemDataDao.save(systemData);
        	return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public SystemDataResponse getSystemData(){
        SystemData systemData = systemDataDao.findAll().get(0);
    	return new SystemDataResponse(systemData.getRevenue(), systemData.getCommission());
    }
}
