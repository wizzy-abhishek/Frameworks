package com.practice.DemoHib;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AlienName {
	@Column(name = "name")
	private String First_name ;
	
	@Column(name = "Mid_name")
	private String Mid_name ;
	
	@Column(name = "Last_name")
	private String Last_name ;
	
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public String getMid_name() {
		return Mid_name;
	}
	public void setMid_name(String mid_name) {
		Mid_name = mid_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	@Override
	public String toString() {
		return "AlienName [First_name=" + First_name + ", Mid_name=" + Mid_name + ", Last_name=" + Last_name + "]";
	}
	
	
	

}
