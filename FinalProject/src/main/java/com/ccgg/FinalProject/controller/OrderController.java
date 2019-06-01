package com.ccgg.FinalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ccgg.FinalProject.beans.Order;
import com.ccgg.FinalProject.dao.BuyGroDao;
import com.ccgg.FinalProject.dao.OrderDao;
import com.ccgg.FinalProject.http.Response;
import com.ccgg.FinalProject.service.OrderService;

@RestController()
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	BuyGroDao buyGroDao;
	
	@PostMapping("/order")
	public Response addOrder(@RequestBody Order order) {
		order.getGro().forEach(gro -> gro.setOrders(order));
		return orderService.addOrder(order);
	}
	
	@GetMapping("/order")
	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}
	
//	@DeleteMapping("/order/{id}")
	@Transactional
	@DeleteMapping("/order/{orderNum}")
	public Response deleteTheOrder(@PathVariable int orderNum) {
		buyGroDao.deleteByorders_id(orderNum);
		orderDao.deleteByid(orderNum);
		return new Response(true);
	}
}