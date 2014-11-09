package com.soe.streams.business;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Bank account has a balance that can be changed by
 * deposits and withdrawals
 * @author Sam
 *
 */
public class BankAccount implements Serializable{

	private int AccountNumber;
	private BigDecimal balance;
	
	/**
	 * Creates a new Bank account with zero balance
	 * @parem anAccountNumber
	 */
	public BankAccount(int anAccountNumber){
		this.AccountNumber = anAccountNumber;
		this.balance = new BigDecimal(0);
	}
	
	/**
	 * Creates a new bank account with a given balance
	 * @param anAccountNumber
	 * @param anBalance
	 */
	public BankAccount(int anAccountNumber, BigDecimal anBalance){
		this.AccountNumber = anAccountNumber;
		this.balance = anBalance;
	}
	
	/**
	 * Get account number
	 * @return
	 */
	public int getAccountNumber(){
		return this.AccountNumber;
	}
	
	/**
	 * Return balance of bank account
	 * @return
	 */
	public BigDecimal getBalance(){
		return this.balance;
	}
	
	/**
	 * Deposit money in bank account
	 * @param value
	 */
	public void deposit(BigDecimal value){
		this.balance = this.balance.add(value);
	}
	
	/**
	 * Withdraw some money from bank account
	 * @param value
	 */
	public void withdraw(BigDecimal value){
		this.balance = this.balance.subtract(value);
	}
	
	
	
}
