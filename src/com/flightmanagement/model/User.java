package com.flightmanagement.model;

public class User {
	private String userId;
	 private String name;
	 private double funds;
	 public User(String userId,String name,double funds) {
		 this.userId=userId;
		 this.name=name;
		 this.funds=funds;
	 }
 public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFunds() {
		return funds;
	}
	public void setFunds(double funds) {
		this.funds = funds;
	} 
	public void deductFunds(double amount) {
		this.funds-=amount;
	}

}
