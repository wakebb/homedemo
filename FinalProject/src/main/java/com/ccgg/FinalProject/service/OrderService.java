package com.ccgg.FinalProject.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ccgg.FinalProject.beans.Order;
import com.ccgg.FinalProject.dao.OrderDao;
import com.ccgg.FinalProject.http.Response;

@Service
@Transactional
public class OrderService {
	@Autowired
	OrderDao orderDao;
	
	public Response addOrder(Order order) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		long num = timestamp.getTime();
		String ordernum = Long.toString(num);
		order.setOrderNum(ordernum);
		orderDao.save(order);
		return new Response(true);
	}
}
