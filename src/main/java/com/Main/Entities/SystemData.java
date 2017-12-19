package com.Main.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SYSTEM_DATA")
public class SystemData {
    private Double commission;
    private Double revenue;
    private String systemId;
    
    public SystemData(Double commission, Double revenue , String systemId) {
        this.commission = commission;
        this.revenue = revenue;
        this.systemId = systemId;
    }

	public SystemData(){
	}
    
    @Id
    public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}


	public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

}
