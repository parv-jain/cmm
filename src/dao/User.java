package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utility.ConnectionManager;

public class User {
	private static Connection con = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	private static int count=0;

	public static boolean checkUser(String un,String pwd){
		try{
			con = ConnectionManager.getConnection();
			stmt = con.prepareStatement("SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?");
			stmt.setString(1,un);
			stmt.setString(2,pwd);		
			rs = stmt.executeQuery();
			while(rs.next()){
				count++;
			}
			if (count!=0){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return false;
	}
	public static String getZone(String user){
		try{
			con = ConnectionManager.getConnection();
			stmt = con.prepareStatement("SELECT ZONE FROM USERS WHERE USERNAME=?");
			stmt.setString(1,user);
			rs = stmt.executeQuery();
			rs.next();
			return rs.getString("ZONE"); 
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return "error";
	}
	public static String getDivision(String user){
		try{
			con = ConnectionManager.getConnection();
			stmt = con.prepareStatement("SELECT DIVISION FROM USERS WHERE USERNAME=?");
			stmt.setString(1,user);
			rs = stmt.executeQuery();
			rs.next();
			return rs.getString("DIVISION"); 
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return "error";
	}
	public static String getDepot(String user){
		try{
			con = ConnectionManager.getConnection();
			stmt = con.prepareStatement("SELECT DEPOT FROM USERS WHERE USERNAME=?");
			stmt.setString(1,user);
			rs = stmt.executeQuery();
			rs.next();
			return rs.getString("DEPOT"); 
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return "error";
	}
}
