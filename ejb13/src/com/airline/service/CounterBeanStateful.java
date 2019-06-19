package com.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class CounterBean
 */
@Stateful
@LocalBean
public class CounterBeanStateful {

    /**
     * Default constructor. 
     */
	
	Integer count = 0;
	
    public CounterBeanStateful() {
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
