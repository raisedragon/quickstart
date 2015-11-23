package com.raise.core.datatables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class SentParameters {
	private int draw;
	private int start;
	private int length;
	private Search search;
	private List<Column> columns;
	
	public SentParameters(HttpServletRequest request) {
		this.draw = Integer.valueOf(request.getParameter("draw"));
		this.start = Integer.valueOf(request.getParameter("start"));
		this.length = Integer.valueOf(request.getParameter("length"));
		//search
		this.search = new Search();
		this.search.setRegex(Boolean.valueOf(request.getParameter("search[value]")));
		this.search.setRegex(Boolean.valueOf(request.getParameter("search[regex]")));
		
		//columns
		this.columns = new ArrayList<Column>();
		
		List<String> names = Collections.list(request.getParameterNames());
		for(int i=0;;i++){
			if(!names.contains("columns["+i+"][data]")){
				break;
			}
			Column column = new Column();
			column.setData(request.getParameter("columns["+i+"][data]"));;
			column.setName(request.getParameter("columns["+i+"][name]"));;
			column.setSearchable(Boolean.valueOf("columns["+i+"][searchable]"));;
			column.setOrderable(Boolean.valueOf("columns["+i+"][data]"));
			if(column.isOrderable()){
				column.setOrderDirection(request.getParameter("order["+i+"][column][dir]"));
			}
			columns.add(column);
		}
	
	}
	public long getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Search getSearch() {
		return search;
	}
	public void setSearch(Search search) {
		this.search = search;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	
}
