package com.spring.transaction.hibernate;

public interface AccountDAO {

	public void deposit(int accno, double amt);
	public void withdraw(int accno, double amt);
	public void fundsTransfer(int saccno, int daccno, double amt);
	public double getBalance(int accno);
	
}
