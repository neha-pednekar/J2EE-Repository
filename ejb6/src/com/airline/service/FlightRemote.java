package com.airline.service;

import javax.ejb.Remote;

@Remote
public interface FlightRemote {
	public Integer getId();
	
	public void setId(Integer id);
	
	public String getFrom();
	
	public void setFrom(String from);
	
	public String getTo();
	
	public void setTo(String to);
	
	public Double getPrice();
	
	public void setPrice(Double price);
	
	public Integer getSeats();
	
	public void setSeats(Integer seats);
	
	public String getAirlaneModel();
	
	public void setAirlaneModel(String airlaneModel);
	
	public String toString();
}
