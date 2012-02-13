/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciia.webeirinterface.model.json;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class FilaGridJson {
	private int id;
	private List<String> cell;

	public List<String> getCell() {
		return cell;
	}

	public void setCell(List<String> cell) {
		this.cell = cell;
	}
	
	public void agregaCeldas(String ... celdas){
		cell=Arrays.asList(celdas);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
