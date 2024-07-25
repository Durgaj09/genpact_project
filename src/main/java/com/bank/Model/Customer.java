package com.bank.Model;

public class Customer {
	private String Account_Number; 
	private int Pin;  
	private String Name;
	private String Address;                 
	private String Mobile_no;
	private String email_id;
	private String Account_type;
	private long Initial_balance;
	private String Date_of_Birth;
	private String id_proof;
	private String Id_number;
	public String getAccount_Number() {
		return Account_Number;
	}
	public void setAccount_Number(String account_Number) {
		this.Account_Number = account_Number;
	}
	public int getPin() {
		return Pin;
	}
	public void setPin(int pin) {
		this.Pin = pin;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getMobile_no() {
		return Mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.Mobile_no = mobile_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getAccount_type() {
		return Account_type;
	}
	public void setAccount_type(String account_type) {
		this.Account_type = account_type;
	}
	public long getInitial_balance() {
		return Initial_balance;
	}
	public void setInitial_balance(long initial_balance) {
		this.Initial_balance = initial_balance;
	}
	public String getDate_of_Birth() {
		return Date_of_Birth;
	}
	public void setDate_of_Birth(String date_of_Birth) {
		Date_of_Birth = date_of_Birth;
	}
	public String getId_proof() {
		return id_proof;
	}
	public void setId_proof(String id_proof) {
		this.id_proof = id_proof;
	}
	public String getId_number() {
		return Id_number;
	}
	public void setId_number(String id_number) {
		Id_number = id_number;
	}
}