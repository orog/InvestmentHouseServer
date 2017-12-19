package com.Main.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Main.Entities.SystemData;

public interface SystemDataDao extends JpaRepository<SystemData ,String> {
	
}
