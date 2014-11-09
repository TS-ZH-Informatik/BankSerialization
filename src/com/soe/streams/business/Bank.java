package com.soe.streams.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Holds the bank accounts
 * @author Sam
 *
 */
public class Bank implements Serializable{
	
	private String name;
	private ArrayList<BankAccount> Accounts;
	
	/**
	 * Creates a new Bank
	 */
	public Bank(String BankName){
		this.name = BankName;
		this.Accounts = new ArrayList<BankAccount>();
	}
	
	/**
	 * Add a new Bank Account
	 * @param Account
	 */
	public void addAccount(BankAccount Account){
		Accounts.add(Account);
	}
	
	/**
	 * Get total of all bank accounts
	 * @return total
	 */
	public BigDecimal getTotalBalance(){
		BigDecimal total = new BigDecimal(0);
		for(BankAccount a : Accounts){
			total = total.add(a.getBalance());
		}
		return total;
	}
	/**
	 * Returns BankAccount if Exists
	 * @param AccountNumber
	 * @return BankAccount | Null
	 */
	public BankAccount findAccount(int AccountNumber){
		for (BankAccount a : Accounts){
			if(a.getAccountNumber() == AccountNumber)
				return a;
		}
		return null;
	}
	
	

}
