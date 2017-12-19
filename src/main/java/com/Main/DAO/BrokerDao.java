package com.Main.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Main.Entities.Broker;

public interface BrokerDao extends JpaRepository<Broker, Long> {
    @Query("SELECT i from Broker as i where i.email like :email and i.password like :password")
    public List<Broker> findBrokerByEmail(@Param("email") String email , @Param("password") String password);
    
    @Query("SELECT i from Broker as i where i.email like :email")
    public List<Broker> findBrokerByEmail(@Param("email") String email);
    
}
