package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.User;
import dao.DepotWise;
import vo.ProDetVO;

/**
 * Servlet implementation class Depot
 */
@WebServlet("/Depot")
public class Depot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Depot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		ArrayList<ProDetVO> records;
		try{
			if (session!= null){
				String depot;
		        if (request.getParameterMap().containsKey("depot")) {
		        	depot = request.getParameter("depot");
				}
				else{
					depot = User.getDepot((String)session.getAttribute("user"));	
				}
				records = DepotWise.fetchDepotWise(depot);
				request.setAttribute("records", records);
				out.print("<table id='example' class='table table-striped table-bordered' cellspacing='0' width='100%'><thead><tr><th>COACH_NUMBER</th><th>DEPOT</th><th>DIVISION</th><th>WORKSHOP</th><th>BUILT_DATE</th><th>MANUFACTURER</th><th>RETURN_DATE</th><th>IOH_DATE</th><th>POH_DATE</th><th>COACH_ID</th><th>OWNING_RLY</th><th>COACH_TYPE</th><th>UPDATE_TIME</th><th>USERID</th><th>IOH_LOCATION</th></tr></thead>");
				out.print("<tbody>");
				for(int i = 0; i < records.size(); i++){
					out.print("<tr>");
					out.print("<td>"+records.get(i).getCoach_number()+"</td>");
					out.print("<td>"+records.get(i).getDepot()+"</td>");
					out.print("<td>"+records.get(i).getDivision()+"</td>");	
					out.print("<td>"+records.get(i).getWorkshop()+"</td>");
					out.print("<td>"+records.get(i).getBuilt_date()+"</td>");	
					out.print("<td>"+records.get(i).getManufacturer()+"</td>");
					out.print("<td>"+records.get(i).getIoh_date()+"</td>");
					out.print("<td>"+records.get(i).getPoh_date()+"</td>");
					out.print("<td>"+records.get(i).getCoach_id()+"</td>");
					out.print("<td>"+records.get(i).getOwning_rly()+"</td>");
					out.print("<td>"+records.get(i).getCoach_type()+"</td>");
					out.print("<td>"+records.get(i).getUpdate_time()+"</td>");
					out.print("<td>"+records.get(i).getUserid()+"</td>");
					out.print("<td>"+records.get(i).getIoh_location()+"</td>");	
					out.print("</tr>");
				}
				out.print("</tbody>");
				out.print("</table>");

			}
			else{
				out.println("No user session exists to get logged out. <a href='index.html'>Login here</a>");			
			}
		}catch(Exception ex){
			System.out.println(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
