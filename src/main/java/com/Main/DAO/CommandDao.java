package com.Main.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Main.Entities.Command;

public interface CommandDao extends JpaRepository<Command , Long> {
	 @Query("SELECT c from Command as c where c.investor.id = :investorId")
	    public List<Command> findCommandsByInvestor(@Param("investorId") Long investorId);
}
