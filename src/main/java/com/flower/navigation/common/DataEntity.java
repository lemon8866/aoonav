package com.flower.navigation.common;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class DataEntity<T> {

	
	@Transient
	private int pageNo = 1;
	
	@Transient
	private int pageSize = 15;

	public int getPageNo() {
		return pageNo-1;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	
}
