package actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.User;
/**
 * Servlet implementation class Action
 */
@WebServlet("/Action")
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action.equals("Login.checkUser")){
			String un = request.getParameter("Username");
			String pwd = request.getParameter("Password");
			boolean res = User.checkUser(un,pwd);
			if(res){
				HttpSession session = request.getSession();
				session.setAttribute("user",un);
				response.sendRedirect("welcome.jsp");
			}
			else{
				out.println("No user found");
			}
		}
		else if (action.equals("logout")){
				RequestDispatcher rd = request.getRequestDispatcher("Logout");
				rd.forward(request, response);
		}
		else if (action.equals("zone")){
			RequestDispatcher rd = request.getRequestDispatcher("Zone");
			rd.forward(request, response);
		}
		else if (action.equals("division")){
			RequestDispatcher rd = request.getRequestDispatcher("Division");
			rd.forward(request, response);
		}
		else if (action.equals("depot")){
			RequestDispatcher rd = request.getRequestDispatcher("Depot");
			rd.forward(request, response);
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
