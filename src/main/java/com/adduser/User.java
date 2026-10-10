package com.adduser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.dbConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/backend")
public class User extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String qry=
			"SELECT ID , EMAIL, PASSWORD FROM STUDENT WHERE ID=? AND EMAIL=? AND PASSWORD=?";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int s_id=Integer.parseInt(req.getParameter("id"));
	String smail=req.getParameter("email");
	String pas=req.getParameter("pass");
	RequestDispatcher rd;
	PrintWriter out=resp.getWriter();
	try {
		Connection con=dbConnection.getConnection();
		PreparedStatement stm=con.prepareStatement(qry);
		stm.setInt(1, s_id);
		stm.setString(2, smail);
		stm.setString(3, pas);
		ResultSet rst=stm.executeQuery();
		boolean isfound=rst.next();
		if(isfound) {
			System.out.println("login successfully");
		//	resp.sendRedirect("home.jsp");
			out.print("Main page is under Maintanance ");
			
		}else {
		    System.out.println("Unable to login");

            req.setAttribute("msg", "Invalid ID, Email or Password!");

            rd = req.getRequestDispatcher("/Loginpage.jsp");
            rd.forward(req, resp);
		}
		
	
	}catch(SQLException e) {
		System.out.println("Exception by sql"+e);
	}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
