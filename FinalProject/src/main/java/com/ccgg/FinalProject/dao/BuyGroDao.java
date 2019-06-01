package com.ccgg.FinalProject.dao;

import java.util.List;
import com.ccgg.FinalProject.beans.Buy_Gro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyGroDao extends JpaRepository<Buy_Gro, Integer> {
	
	List<Buy_Gro> findByorders_id(int id);
	
	void deleteByorders_id(int id);
}
