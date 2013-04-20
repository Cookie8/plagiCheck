package edu.hm.cs.triePackage;

import java.util.Iterator;
import java.util.Set;

public interface ITrie {
	
	/**
	 * 
	 * @param itr
	 * @param value
	 * @return
	 */
	Object put(Iterator itr, Object value);
	
	/**
	 * 
	 * @param str
	 * @param value
	 * @return
	 */
	Object put(String str, Object value);
	
	/**
	 * 
	 * @param set
	 * @param value
	 * @return
	 */
	Object put(Set set, Object value);
	
	/**
	 * 
	 * @param itr
	 * @return
	 */
	Object get(Iterator itr);
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	Object get(String str);
	
	/**
	 * 
	 * @param set
	 * @return
	 */
	Object get(Set set);
	
	/**
	 * 
	 * @param itr
	 * @return
	 */
	Object hasKey(Iterator itr);
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	Object hasKey(String str);
	
	/**
	 * 
	 * @param set
	 * @return
	 */
	Object hasKey(Set set);
	
	void printTrie();
}
