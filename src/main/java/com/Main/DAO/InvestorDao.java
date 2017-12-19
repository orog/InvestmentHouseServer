package com.Main.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Main.Entities.Investor;

public interface InvestorDao extends JpaRepository<Investor , Long> {
    @Query("SELECT i from Investor as i where i.email like :email and i.password like :password")
    public List<Investor> findInvestorByEmail(@Param("email") String email , @Param("password") String password);
    
    @Query("SELECT i from Investor as i where i.email like :email")
    public List<Investor> findInvestorByEmail(@Param("email") String email);
    
    @Query("SELECT i from Investor as i where i.broker.id = :brokerId")
    public List<Investor> findInvestorsByBroker(@Param("brokerId") Long brokerId);
    
}
