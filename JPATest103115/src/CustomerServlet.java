

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CustomerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String message = "";
		try {
			model.DemoCustomer cust = em.find(model.DemoCustomer.class,(long)2);
			message = cust.getCustFirstName();			
		}
			catch (Exception e) {
				message = e.getMessage();
			}
			finally {
				em.close();
				message = "Finished!";
			}

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<p>" + message + "</p>");
			out.println("<table>");
			out.close();
	//	 request.setAttribute("message",message);
	//     getServletContext()
	//     	.getRequestDispatcher("/output.jsp")
	//     		.forward(request, response);
	}

}
