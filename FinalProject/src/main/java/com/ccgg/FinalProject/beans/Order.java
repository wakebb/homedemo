package com.ccgg.FinalProject.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "ord_SEQ")
	@Column(name = "orders_id")
	private int id;
	
	@Column(name = "order_num", nullable = false)
	private String order_num;
	
	@Column(name = "ord_price", nullable = false)
	private double ord_price;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "zip", nullable = false)
	private int zip;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "email", nullable = false)
	private String email;
	
//	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
	private List<Buy_Gro> gro = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNum() {
		return order_num;
	}

	public void setOrderNum(String order_num) {
		this.order_num = order_num;
	}

	public double getOrd_price() {
		return ord_price;
	}

	public void setOrd_price(double ord_price) {
		this.ord_price = ord_price;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public List<Buy_Gro> getGro() {
		return gro;
	}

	public void setgro(List<Buy_Gro> gro) {
		this.gro = gro;
	}

	public Order(int id, String order_num, double ord_price, String first_name, String last_name, String address,
			int zip, String phone, String email, List<Buy_Gro> gro) {
		super();
		this.id = id;
		this.order_num = order_num;
		this.ord_price = ord_price;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.gro = gro;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", order_num=" + order_num + ", ord_price=" + ord_price + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", address=" + address + ", zip=" + zip + ", phone=" + phone + ", email="
				+ email + ", gro=" + gro + "]";
	}
	
}