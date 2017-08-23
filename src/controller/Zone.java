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
import dao.ZoneWise;
import vo.DivisionVO;

/**
 * Servlet implementation class Zone
 */
@WebServlet("/Zone")
public class Zone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Zone() {
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
		ArrayList<DivisionVO> records;
		try{
			if (session != null){
				String zone = User.getZone((String)session.getAttribute("user"));
				records = ZoneWise.fetchZoneWise(zone);
				out.print("<table id='example' class='table table-striped table-bordered' cellspacing='0' width='100%'><thead><tr><th>Division</th><th>No. of records</th></tr></thead>");
				out.print("<tbody>");
				for(int i = 0; i < records.size(); i++){
					out.print("<tr>");
					out.print("<td>"+records.get(i).getDivision()+"\t");	
					out.println("<td><a href='Division?division="+records.get(i).getDivision()+"'>"+records.get(i).getCountpro()+"</a><br>");
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
