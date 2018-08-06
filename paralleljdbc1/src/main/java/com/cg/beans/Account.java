package com.cg.beans;



import java.sql.Date;
import java.time.LocalDateTime;

public class Account {
	private String mobileno;
	private String name;
	private String email;
	private double balance;
	Date date;

	public Account(String mobileno, String name, String email, double balance) {
		super();
		this.mobileno = mobileno;
		this.name = name;
		this.email = email;
		this.balance = balance;

	}

	public Account() {
		super();
	}



	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

}
