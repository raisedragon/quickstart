package com.raise.core.datatables;

import java.util.List;

import com.raise.core.mybatis.Page;

public class ReturnedData {
	private long draw;
	private long recordsTotal;
	private long recordsFiltered;
	private List<?> data;
	private String error;
	
	
	public ReturnedData(){
	}

	public ReturnedData(List<?> data,Page page,long draw){
		this.data = data;
		this.recordsTotal = page.getTotal();
		this.recordsFiltered = data.size();
		this.draw = draw;
	}
	
	public long getDraw() {
		return draw;
	}
	public void setDraw(long draw) {
		this.draw = draw;
	}
	public long getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
