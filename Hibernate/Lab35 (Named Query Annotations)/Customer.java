package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="AllCustomers", query="from Customer"),
	@NamedQuery(name="CustomersByEmail", query="from Customer cust where cust.email=?"),
	@NamedQuery(name="CustomersByCity", query="from Customer cust where cust.city=?"),
	@NamedQuery(name="CustomersByCityAndStatus", query="from Customer cust where cust.city=? and cust.status=?")
})
@Entity
@Table(name="Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String cname, email, city, cardType, status;
	private double cardBal;
	private int cardNo;
	
	public Customer(){}

	public Customer(int cid, String cname, String email, String city,
			String cardType, String status, double cardBal, int cardNo) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.city = city;
		this.cardType = cardType;
		this.status = status;
		this.cardBal = cardBal;
		this.cardNo = cardNo;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getCardBal() {
		return cardBal;
	}

	public void setCardBal(double cardBal) {
		this.cardBal = cardBal;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	@Override
	public String toString() {
		return cid+"\t"+cname+"\t"+email+"\t"+city+"\t"+cardType+"\t"+status+"    \t"+cardBal+"\t  "+cardNo;
	}
	
	
	
	
}
