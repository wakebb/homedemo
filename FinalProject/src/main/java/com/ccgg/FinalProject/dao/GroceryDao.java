package com.ccgg.FinalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ccgg.FinalProject.beans.Grocery; 

public interface GroceryDao extends JpaRepository<Grocery, Integer> {

}
