package com.messenger.beanParam;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class BeanFilterResource {

	private @QueryParam("year") int year;
	private @QueryParam("start")@DefaultValue("-1") int start;
	private @QueryParam("size")@DefaultValue("-1") int size;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
