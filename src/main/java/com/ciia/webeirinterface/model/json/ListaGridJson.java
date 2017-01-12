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
public class ListaGridJson {
	private int page;
	private int total;
	private int records;
	private List<FilaGridJson> rows;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public List<FilaGridJson> getRows() {
		return rows;
	}

	public void setRows(List<FilaGridJson> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
