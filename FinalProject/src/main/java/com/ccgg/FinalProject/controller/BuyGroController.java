package com.ccgg.FinalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ccgg.FinalProject.beans.Buy_Gro;
import com.ccgg.FinalProject.dao.BuyGroDao;
import com.ccgg.FinalProject.http.Response;

@RestController()
public class BuyGroController {
	@Autowired
	BuyGroDao buyGroDao;
	
	@GetMapping("/buygros/{orderNum}")
	public List<Buy_Gro> getAllGros(@PathVariable int orderNum) {
		return buyGroDao.findByorders_id(orderNum);
	}
	
	@GetMapping("/buygros")
	public List<Buy_Gro> getAllGros() {
		return buyGroDao.findAll();
	}
	
	@Transactional
	@DeleteMapping("/buygros/{orderNum}")
	public Response deleteTheGros(@PathVariable int orderNum) {
		buyGroDao.deleteByorders_id(orderNum);
		return new Response(true);
	}
}