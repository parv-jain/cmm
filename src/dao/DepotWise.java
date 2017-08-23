package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import utility.ConnectionManager;
import vo.ProDetVO;

public class DepotWise {
	private static Connection con = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	public static ArrayList<ProDetVO> fetchDepotWise(String depot){
		ArrayList<ProDetVO> records = new ArrayList<ProDetVO>();
		try{
			con = ConnectionManager.getConnection();
			stmt = con.prepareStatement("SELECT * FROM DT_PRO_DETAILS WHERE DEPOT=?");
			stmt.setString(1, depot);
			rs = stmt.executeQuery();
			while(rs.next()){
				ProDetVO record = new ProDetVO();
				record.setCoach_number(rs.getString("COACH_NUMBER"));	
				record.setDepot(rs.getString("DEPOT"));
				record.setDivision(rs.getString("DIVISION"));
				record.setWorkshop(rs.getString("WORKSHOP"));
				record.setBuilt_date(rs.getString("BUILT_DATE"));
				record.setManufacturer(rs.getString("MANUFACTURER"));
				record.setIoh_date(rs.getString("IOH_DATE"));
				record.setPoh_date(rs.getString("POH_DATE"));
				record.setCoach_id(rs.getString("COACH_ID"));
				record.setOwning_rly(rs.getString("OWNING_RLY"));
				record.setCoach_type(rs.getString("COACH_TYPE"));
				record.setUpdate_time(rs.getString("UPDATE_TIME"));
				record.setUserid(rs.getString("USERID"));
				record.setIoh_location(rs.getString("IOH_LOCATION"));
				records.add(record);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println(ex);
		}
		return records;
	}
}
