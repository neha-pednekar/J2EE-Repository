package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class CounterBean
 */
@Singleton
@LocalBean
public class CounterBean {

    /**
     * Default constructor. 
     */
	
	Integer count = 0;
	
    public CounterBean() {
        // TODO Auto-generated constructor stub
    }

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
    
    public void incrementCountBy1()
    {
    	count++;
    }

}
