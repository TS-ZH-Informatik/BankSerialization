package com.soe.streams.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import com.soe.streams.business.Bank;
import com.soe.streams.business.BankAccount;
import com.soe.streams.persistence.Serialization;

public class SerializationTest {

	/**
	 * Test a bank serialization
	 * @param args
	 */
	public static void main(String[] args){
		
		Bank BankofJava = new Bank("Bank of Java");
		
		BankAccount myBankAccount = new BankAccount(14, new BigDecimal(0.5));
		
		BankofJava.addAccount(myBankAccount);
		BankofJava.addAccount(new BankAccount(1, new BigDecimal(1000)));
		BankofJava.addAccount(new BankAccount(1000, new BigDecimal(200)));
		BankofJava.addAccount(new BankAccount(12, new BigDecimal(1022200)));
		BankofJava.addAccount(new BankAccount(14, new BigDecimal(133000)));
		
		// Serialize bank and account in files
		try {
			Serialization serial = new Serialization(BankofJava, "/tmp/BankofJava.dat");
			serial = new Serialization(myBankAccount, "/tmp/myBankAccount.dat");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Read from file
		
		Serialization readFile = new Serialization();
		try {
			// Read bank from file
			Bank readBank = (Bank) readFile.readObject("/tmp/BankofJava.dat");
			BankAccount account = readBank.findAccount(1);
			System.out.println("Account from bank -ID: "+account.getAccountNumber()+", Balance: "+account.getBalance());
			
			// Read bank account from file
			BankAccount ba = (BankAccount) readFile.readObject("/tmp/myBankAccount.dat");
			System.out.println("MyBank Account - ID: "+ba.getAccountNumber()+", Balance: "+ba.getBalance());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
