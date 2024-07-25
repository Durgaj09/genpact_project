package com.bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.Model.Customer;
import com.bank.Model.Transaction;
import com.bank.Model.Transaction;


public class customerDAO {
	
	
    public Connection connection() throws ClassNotFoundException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/admindb";
        String jdbcUser = "root";
        String jdbcPass = "root";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    
    
    
    public boolean validateAccNo(long accno) throws ClassNotFoundException, SQLException
    {
    	List<Long> arr=new ArrayList<>();
    	Connection con=connection();
    	PreparedStatement ps = con.prepareStatement("Select Account_Number from customerdetails");
    	ResultSet rs=ps.executeQuery();
    	while(rs.next()) {
    		arr.add(rs.getLong(1));
    	}
    	if(!arr.contains(accno)) {
    		return true;
    	}
    	else {
    		return false;
    	}

    }
    
    
    public boolean Insert(Customer cus) throws ClassNotFoundException {
    	boolean result=false;
        String sql = "INSERT INTO customerdetails VALUES(?,?,?,?,?,?,?,?,?,?,?);";
        try { 
        	Connection con = connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cus.getAccount_Number());
            ps.setInt(2, cus.getPin());
            ps.setString(3, cus.getName());
            ps.setString(4, cus.getAddress());
            ps.setString(5, cus.getMobile_no());
            ps.setString(6, cus.getEmail_id());
            ps.setString(7, cus.getAccount_type());
            ps.setLong(8, cus.getInitial_balance());
            ps.setString(9, cus.getDate_of_Birth());
            ps.setString(10, cus.getId_proof());
            ps.setString(11, cus.getId_number());
            result=ps.executeUpdate() > 0;
            
            String tname="Acc_"+cus.getAccount_Number();
            String sql1="create table if not exists "+tname+"(`id` INT NOT NULL AUTO_INCREMENT,\r\n"
    				+"`date` DATETIME NOT NULL,\r\n"
    				+ " `desc` VARCHAR(40) NOT NULL,\r\n"
    				+ " `debit` INT(10),\r\n"
    				+ "	`credit` INT(10),\r\n"
    				+ "	`balance` INT(20),\r\n"
    				+ "	PRIMARY KEY (id)\r\n"
    				+ ")";
            PreparedStatement pst=con.prepareStatement(sql1);
            pst.executeUpdate();
            PreparedStatement data=con.prepareStatement("select balance from "+tname+" ORDER BY id DESC LIMIT 1");	
    		ResultSet set=data.executeQuery();
    		long bal=0L;
    		if(set.next()) {
    			bal=set.getLong(1);
    		}
    		
    		String  query3="insert into "+tname+" values(NULL,now(),?,?,?,?)";
    		
    		PreparedStatement p=con.prepareStatement(query3);
    		p.setString(1,"Initial deposit");
    		p.setLong(2, 0);
    		p.setLong(3, cus.getInitial_balance());
    		p.setLong(4, bal+cus.getInitial_balance());
    		p.executeUpdate();
    		p.close();
    		data.close();
    		
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    			return false;
    		
        }
        return result;
    }

    
    
    public ResultSet ViewDetails(Customer cus) throws ClassNotFoundException {
        String sql = "SELECT Name, Address, Mobile_no, email_id, Account_type, Initial_balance, Date_of_Birth, id_proof, Id_number FROM customerdetails WHERE Account_Number=?;";
        ResultSet rs=null;
        try {
            Connection con = connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cus.getAccount_Number());
            rs=ps.executeQuery();

            return rs;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    
    public int DeleteDetails(Customer cus) throws ClassNotFoundException {
        String sql = "DELETE FROM customerdetails WHERE Account_Number=?;";
        try (Connection con = connection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cus.getAccount_Number());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    
    public int Reset(Customer cus) throws ClassNotFoundException{
    	String sql="update customerdetails set pin=? where Account_Number=?;";
        try (Connection con = connection();
             PreparedStatement ps = con.prepareStatement(sql)) {
        	ps.setInt(1,cus.getPin());
            ps.setString(2, cus.getAccount_Number());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    
    public int ModifyDetails(Customer cus) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE customerdetails SET Name=?, Address=?, Mobile_no=?, email_id=?, Account_type=?, Initial_balance=?, Date_of_Birth=?, id_proof=?, Id_number=? WHERE Account_number=?;";
        try {Connection con = connection();
             PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cus.getName());
            ps.setString(2, cus.getAddress());
            ps.setString(3, cus.getMobile_no());
            ps.setString(4, cus.getEmail_id());
            ps.setString(5, cus.getAccount_type());
            ps.setLong(6, cus.getInitial_balance());
            ps.setString(7, cus.getDate_of_Birth());
            ps.setString(8, cus.getId_proof());
            ps.setString(9, cus.getId_number());
            ps.setString(10, cus.getAccount_Number());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    
    public List<Customer> getAllCustomers(){
		List<Customer> customers=new ArrayList<>();
		try {
			Connection con = connection();
			PreparedStatement ps=con.prepareStatement("select Name,Address,Mobile_no,email_id,Account_type,Date_of_Birth,id_proof,Id_number,Account_Number from customerdetails;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Customer c=new Customer();
				c.setName(rs.getString(1));
				c.setAddress(rs.getString(2));
				c.setMobile_no(rs.getString(3));
				c.setEmail_id(rs.getString(4));
				c.setAccount_type(rs.getString(5));
				c.setDate_of_Birth(rs.getString(6));
				c.setId_proof(rs.getString(7));
				c.setId_number(rs.getString(8));
				c.setAccount_Number(rs.getString(9));
				
				customers.add(c);
			}
			rs.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return customers;
	}
    
    
	public String updatePassword(String accno,int oldpass,int newpass,int confpass) {
			
			try {
			Connection con=connection();
			PreparedStatement ps=con.prepareStatement("select pin from customerdetails where Account_Number=?");
			ps.setString(1, accno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(newpass==confpass) {
					if(rs.getInt(1)==oldpass) {
						PreparedStatement ps1=con.prepareStatement("update customerdetails set pin=? where Account_Number=?");
						ps1.setInt(1, newpass);
						ps1.setString(2, accno);
						ps1.execute();
					}
					else {
						return "old";
					}
					
				}
				else {
					return "con";
				}
			}
			return "success";
			}
			catch(Exception e) {
				e.printStackTrace();
				return "failed";
			}
			
			
		}
	
    public ResultSet customerVerify(Customer cus) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
        	System.out.println("customerVerify");
            con = connection();
            ps = con.prepareStatement("SELECT Account_Number,Name, Pin FROM customerdetails WHERE ((Name=? or Account_Number=?) AND Pin=?);");
            ps.setString(1, cus.getName());
            ps.setString(2, cus.getAccount_Number());
            ps.setInt(3, cus.getPin());
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return rs;
        
    }
    
    
    public String withdraw(String accno,Transaction t) {
		
		
		String tname="Acc_"+accno;
		int debit=t.getDebit();
		String query1="select balance from "+tname+" ORDER BY id DESC LIMIT 1";
		String query2="update customerdetails set Initial_balance=? where Account_Number=?";
		try {
		Connection con=connection();
		PreparedStatement ps1,ps2,ps3;
		ps1=con.prepareStatement(query1);
		ResultSet rs1=ps1.executeQuery();
		long prevBalance=0L;
		while(rs1.next()) {
			prevBalance=rs1.getLong(1);
		}
		if(debit>prevBalance) {
			return "high";
		}
		if(prevBalance==0L) {
			return "zero";
		}
		ps2=con.prepareStatement(query2);
		ps2.setLong(1, prevBalance-debit);
		ps2.setString(2,accno);
		ps2.executeUpdate();
		ps3=con.prepareStatement("insert into "+tname+" values(NULL,now(),?,?,?,?)");
		ps3.setString(1,t.getDesc());
		ps3.setInt(2, t.getDebit());
		ps3.setInt(3, t.getCredit());
		ps3.setLong(4, prevBalance-debit);
		ps3.executeUpdate();
		ps1.close();
		ps2.close();
		ps3.close();
		con.close();
		return "success";
	
		}
		catch(Exception e) {
			e.printStackTrace();
			return "failed";
		}
		
	}
	
    
	public boolean credit(String accno,Transaction ts1) {
		
		String tname="Acc_"+accno;
		int credit=ts1.getCredit();
		String query1="select balance from "+tname+" ORDER BY id DESC LIMIT 1";
		String query2="update customerdetails set Initial_balance=? where Account_Number=?";
		try {
		Connection con=connection();
		PreparedStatement ps1,ps2,ps3;
		ps1=con.prepareStatement(query1);
		ResultSet rs1=ps1.executeQuery();
		long prevBalance=0L;
		while(rs1.next()) {
			prevBalance=rs1.getLong(1);
		}
		ps2=con.prepareStatement(query2);
		ps2.setLong(1, prevBalance+credit);
		ps2.setString(2,accno);
		ps2.executeUpdate();
		ps3=con.prepareStatement("insert into "+tname+" values(NULL,now(),?,?,?,?)");
		ps3.setString(1,ts1.getDesc());
		ps3.setInt(2, ts1.getDebit());
		ps3.setInt(3, ts1.getCredit());
		ps3.setLong(4, prevBalance+credit);
		ps3.executeUpdate();
		ps1.close();
		ps2.close();
		ps3.close();
		con.close();
		return true;
		
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public long getBalance(String accno){
		
		long bal=0L;
		try {
		Connection con=connection();
		PreparedStatement ps=con.prepareStatement("select Initial_balance from customerdetails where Account_Number=?");
		ps.setString(1, accno);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			bal=rs.getLong(1);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return bal;
	}
	
	
public List<Transaction> getTransactions(String accno){
	List<Transaction> transactions=new ArrayList<>();
	
	String tname="Acc_"+accno;
	System.out.println(accno);
	String query1="select * from "+tname+" ORDER BY id DESC LIMIT 10";
	try {
		Connection con=connection();
		PreparedStatement ps=con.prepareStatement(query1);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Transaction t=new Transaction();
			t.setId(rs.getInt(1));
			t.setDate(rs.getString(2));
			t.setDesc(rs.getString(3));
			t.setDebit(rs.getInt(4));
			t.setCredit(rs.getInt(5));
			t.setBalance(rs.getLong(6));
			System.out.print(t.getId());
			transactions.add(t);
		}
		rs.close();
		ps.close();
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return transactions;
}
}