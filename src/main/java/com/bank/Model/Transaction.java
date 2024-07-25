package com.bank.Model;

public class Transaction {
	int id;
	String date;
	String desc;
	int debit;
	int credit;
	long balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Transaction() {
		super();
	}
	public Transaction(String desc, int debit, int credit, long balance) {
		super();
		this.desc = desc;
		this.debit = debit;
		this.credit = credit;
		this.balance = balance;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getDebit() {
		return debit;
	}
	public void setDebit(int debit) {
		this.debit = debit;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}