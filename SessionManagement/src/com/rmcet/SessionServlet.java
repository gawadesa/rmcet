
package com.rmcet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		session.setAttribute("sessionName", "sessionValue");
		out.println("session value "+session.getAttribute("sessionName"));
		out.println("<br>");
		out.println(session.getId());
		out.println("<br>");
		out.println(session.getMaxInactiveInterval());
		out.println("<br>");
		out.println(session.isNew());
		
		
		Cookie ck = new Cookie("cookiename","cookievalue");
		response.addCookie(ck);
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<form action=SecondServlet >");
		out.println("<input type=submit />");
		out.println("</form>");
		out.println("</body>");
		out.println("<html>");
		
		
		
	}
}