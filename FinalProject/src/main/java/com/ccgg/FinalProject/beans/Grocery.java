package com.ccgg.FinalProject.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "grocery")
public class Grocery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "GRO_SEQ")
	private int id;
	
	@Column(name = "gro_name", unique = true, nullable = false)
	private String gro_name;
	
	@Column(name = "gro_desc", nullable = false)
	private String gro_desc;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "pic")
	private String pic;
	
	@Column(name = "cnt_ord")
	private int cnt_ord;

	@Column(name = "odate")
	private Timestamp odate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGro_name() {
		return gro_name;
	}

	public void setGro_name(String gro_name) {
		this.gro_name = gro_name;
	}

	public String getGro_desc() {
		return gro_desc;
	}

	public void setGro_desc(String gro_desc) {
		this.gro_desc = gro_desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getCnt_ord() {
		return cnt_ord;
	}

	public void setCnt_ord(int cnt_ord) {
		this.cnt_ord = cnt_ord;
	}

	public Timestamp getOdate() {
		return odate;
	}

	public void setOdate(Timestamp odate) {
		this.odate = odate;
	}

	public Grocery(int id, String gro_name, String gro_desc, double price, String pic, int cnt_ord, Timestamp odate) {
		super();
		this.id = id;
		this.gro_name = gro_name;
		this.gro_desc = gro_desc;
		this.price = price;
		this.pic = pic;
		this.cnt_ord = cnt_ord;
		this.odate = odate;
	}

	public Grocery() {
		super();
	}

	@Override
	public String toString() {
		return "Grocery [id=" + id + ", gro_name=" + gro_name + ", gro_desc=" + gro_desc + ", price=" + price
				+ ", pic=" + pic + ", cnt_ord=" + cnt_ord + ", odate=" + odate + "]";
	}
	
}
