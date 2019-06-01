package com.ccgg.FinalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ccgg.FinalProject.beans.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	
	void deleteByid(int id);

}
