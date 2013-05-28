package edu.hm.cs.actionAtInsert;

import java.util.LinkedList;


public class StringCoding implements IActionAtInsert {
	
	private int counter;
	
	/**
	 * Konstruktor
	 */
	public StringCoding() {
		this.counter = 1;
		
	}

	@Override
	public void setActualValue(Object updateValue) {
		
		
	}

	@Override
	public Object actionInCaseOfFoundKey(Object foundValue) {
		return foundValue;
	}

	@Override
	public Object actionInCaseOfNotFoundKey() {
		return new Integer(counter++); 
	}

}
