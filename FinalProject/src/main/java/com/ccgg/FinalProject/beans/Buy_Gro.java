package com.ccgg.FinalProject.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BUY_GRO")
public class Buy_Gro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "BUYGRO_SEQ")
	private int buy_gro_id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orders_id")
	private Order orders;
	
	@Column
	private int gro_id;
	
	@Column
	private int cnt;

	public int getId() {
		return buy_gro_id;
	}

	public void setId(int id) {
		this.buy_gro_id = id;
	}

	public int getGro_id() {
		return gro_id;
	}

	public void setCab_id(int gro_id) {
		this.gro_id = gro_id;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Buy_Gro() {
		super();
	}

	public int getBuy_gro_id() {
		return buy_gro_id;
	}

	public void setBuy_cab_id(int buy_gro_id) {
		this.buy_gro_id = buy_gro_id;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public Buy_Gro(int buy_gro_id, Order orders, int gro_id, int cnt) {
		super();
		this.buy_gro_id = buy_gro_id;
		this.orders = orders;
		this.gro_id = gro_id;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Buy_gro [buy_gro_id=" + buy_gro_id + ", orders=" + orders + ", gro_id=" + gro_id + ", cnt=" + cnt + "]";
	}
}