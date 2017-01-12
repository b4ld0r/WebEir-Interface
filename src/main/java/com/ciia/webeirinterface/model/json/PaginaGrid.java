/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciia.webeirinterface.model.json;

import java.util.List;
import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 *
 * @author Sergio
 */
@JsonAutoDetect
public class PaginaGrid<T> {
	private List<T> rows;
	private int page;
	private int total;
	private int max;

	public PaginaGrid(){}
	
	public PaginaGrid(List<T> rows, int page, int total, int max) {
		this.rows = rows;
		this.page = page;
		this.total = total;
		this.max = max;
	}
	
	

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
