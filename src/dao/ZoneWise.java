package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import utility.ConnectionManager;
import vo.DivisionVO;

public class ZoneWise {
	private static Connection con = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	public static ArrayList<DivisionVO> fetchZoneWise(String zone){
		ArrayList<DivisionVO> records = new ArrayList<DivisionVO>();
		try{
			con = ConnectionManager.getConnection();
			stmt = con.prepareStatement("SELECT DIVISION,COUNT(*) AS COUNT FROM DT_PRO_DETAILS WHERE DIVISION IN (SELECT DISTINCT(DIVISION_CODE) AS DC FROM MT_COACH_DEPOT WHERE ZONE_CODE=?) GROUP BY(DIVISION)");
			stmt.setString(1,zone);
			rs = stmt.executeQuery();
			while(rs.next()){
				DivisionVO record = new DivisionVO();
				record.setDivision(rs.getString("DIVISION"));
				record.setCountpro(rs.getString("COUNT"));
				records.add(record);
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return records;
	}
}
