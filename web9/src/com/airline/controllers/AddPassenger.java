package com.airline.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Gender;
import com.airline.models.Passenger;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		out.println("<html><body>");
		out.println("<h2>Welcome to Neha Airlines!</h2>");
		out.println("</body></html>");*/
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Passenger p = new Passenger();
		
		request.setAttribute("error", false);
		
		String firstName = request.getParameter("first-name");
		System.out.println("First Name: "+ firstName);
		
		if(firstName.length() == 0)
		{
			System.out.println("First Name cannot be empty.");
			
			request.setAttribute("error", true);
			request.setAttribute("firstNameError", true);
		}
		else
		{
			p.setFirstName(firstName);
		}
		
		String lastName = request.getParameter("last-name");
		System.out.println("Last Name: "+ lastName);
		
		if(lastName.length() == 0)
		{
			System.out.println("Last Name cannot be empty.");
			
			request.setAttribute("error", true);
			request.setAttribute("lastNameError", true);
		}
		else
		{
			p.setLastName(lastName);
		}
		
		String dob_raw = request.getParameter("dob");
		
		String regex = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(dob_raw);
		System.out.println("DOB raw: "+ dob_raw);
		
		if(m.find())
		{
			String[] dobArray = dob_raw.split("\\/");
			
			int month = Integer.parseInt(dobArray[0]);
			int date = Integer.parseInt(dobArray[1]);
			int year = Integer.parseInt(dobArray[2]);
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, month);
			cal.set(Calendar.DATE, date);
			cal.set(Calendar.YEAR, year);

			Date dob = cal.getTime();			
			
			System.out.println("DOB: "+ dob);
			p.setDob(dob);
		}
		else
		{
			System.out.println("Please enter the date of birth in correct format");
			request.setAttribute("error", true);
			request.setAttribute("doberror", true);
		}	
	
		
		String gender = request.getParameter("gender");
		System.out.println("Gender: "+ gender);
		p.setGender(Gender.valueOf(gender));
		
		 
		if((boolean) request.getAttribute("error"))
		{
			RequestDispatcher view = request.getRequestDispatcher(	"WEB-INF/views/add_passenger.jsp");
			view.forward(request, response);
		}
		else
		{
			ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
			passengerList.add(p);
			
			response.sendRedirect("");
		}
		
	}

}
