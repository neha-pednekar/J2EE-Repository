package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.service.CounterBean;
import com.airline.service.CounterBeanStateful;

/**
 * Servlet implementation class AddOne
 */
@WebServlet("/AddOne")
public class AddOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CounterBean counterBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		
		HttpSession s = request.getSession();
		
		CounterBeanStateful cbStateful = (CounterBeanStateful) s.getAttribute("cbStateful");
		
		pw.println("The current value of count in SINGLETON BEAN is: " + counterBean.getCount());
		
		pw.println("The current value of count in STATEFUL BEAN is: " + cbStateful.getCount());
		
		counterBean.incrementCountBy1();
		
		cbStateful.incrementCountBy1();
		
		pw.println("The value of count was incremented. Now, the count in SINGLETON BEAN is: " + counterBean.getCount());
		
		pw.println("The value of count was incremented. Now, the count in STATEFUL BEAN is: " + cbStateful.getCount());

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
