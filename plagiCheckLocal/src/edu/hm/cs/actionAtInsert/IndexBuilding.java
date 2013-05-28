package edu.hm.cs.actionAtInsert;

import java.util.LinkedList;

public class IndexBuilding implements IActionAtInsert {
	
	LinkedList index;
	
	
	public IndexBuilding() {
		
	}

	@Override
	public void setActualValue(Object updateValue) {
		this.index = new LinkedList();
	}

	@Override
	public Object actionInCaseOfFoundKey(Object foundValue) {
		return null;
	}

	@Override
	public Object actionInCaseOfNotFoundKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
