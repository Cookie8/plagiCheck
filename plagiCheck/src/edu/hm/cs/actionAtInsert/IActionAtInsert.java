package edu.hm.cs.actionAtInsert;

public interface IActionAtInsert {
	
	void setActualValue(Object updateValue);
	
	Object actionInCaseOfFoundKey(Object foundValue);
	
	Object actionInCaseOfNotFoundKey();
}
