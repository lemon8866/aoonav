package com.flower.navigation.common;

public class RequestEntity {
	
	private Integer page;
	
	private Integer limit;
	
	private Object seachDate;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Object getSeachDate() {
		return seachDate;
	}

	public void setSeachDate(Object seachDate) {
		this.seachDate = seachDate;
	}
	
	

}
