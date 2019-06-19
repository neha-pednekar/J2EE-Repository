package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightLocal;
import com.airline.service.FlightRemote;
import com.airline.service.FlightService;

/**
 * Servlet implementation class FlightDetails
 */
@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FlightLocal fs;
	//private FlightService fs = null;
	
	@EJB
	private FlightRemote fsRemote;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("Hello and welcome to the world of EJB");
		
		out.println(fs.getAirlaneModel());
		
		out.println(fsRemote.getAirlaneModel());
		
		/*
		 * try { Context context = new InitialContext(); Object fObj = context.lookup(
		 * "java:global/ejb5/FlightService!com.airline.service.FlightService"); fs =
		 * (FlightService) fObj;
		 * 
		 * } catch (NamingException e) { // TODO Auto-generated catch block
		 * out.println("A naming error has occurred."); e.printStackTrace(); }
		 * 
		 * if(fs != null) { out.println(fs.getAirlaneModel()); }
		 */
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
