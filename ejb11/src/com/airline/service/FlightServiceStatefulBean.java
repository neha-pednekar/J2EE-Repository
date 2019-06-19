package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class FlightService
 */
@Stateful(name="statefulBean")
public class FlightServiceStatefulBean implements FlightLocal_ejb10 {

    /**
     * Default constructor. 
     */
    public FlightServiceStatefulBean() {
        // TODO Auto-generated constructor stub
    }
    
    private Integer id = 1234567;
    private String from = "Los Angeles";
    private String to = "Boston";
    private Double price = 450.0;
    private Integer seats = 250;
    private String airlaneModel = "Boeing 777";
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public String getAirlaneModel() {
		return airlaneModel;
	}
	public void setAirlaneModel(String airlaneModel) {
		this.airlaneModel = airlaneModel;
	}
	
	@Override
	public String toString() {
		return "FlightService [id=" + id + ", from=" + from + ", to=" + to + ", price=" + price + ", seats=" + seats
				+ ", airlaneModel=" + airlaneModel + "]";
	}
	
	

    
}
