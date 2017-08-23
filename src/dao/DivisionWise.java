package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import utility.ConnectionManager;
import vo.DepotVO;

public class DivisionWise {
	private static Connection con = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	public static ArrayList<DepotVO> fetchDivisionWise(String division){
		ArrayList<DepotVO> records = new ArrayList<DepotVO>();
		try{
			con = ConnectionManager.getConnection();
			stmt = con.prepareStatement("SELECT DEPOT,COUNT(*) FROM DT_PRO_DETAILS WHERE DIVISION IN (SELECT DISTINCT(DEPOT_CODE) AS DC FROM MT_COACH_DEPOT WHERE DIVISION_CODE=?) GROUP BY(DEPOT)");
			stmt.setString(1, division);
			rs = stmt.executeQuery();
			while(rs.next()){
				DepotVO record = new DepotVO();
				record.setDepot(rs.getString("DEPOT"));
				record.setCountpro(rs.getString("COUNT(*)"));
				records.add(record);
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return records;
	}
}
