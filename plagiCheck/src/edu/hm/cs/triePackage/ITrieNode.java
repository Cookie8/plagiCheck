package edu.hm.cs.triePackage;

import java.util.Iterator;
import java.util.Map;

import edu.hm.cs.actionAtInsert.IActionAtInsert;

interface ITrieNode {
	
	/**
	 * 
	 * @param itr
	 * @param value
	 * @return
	 */
	ITrieReference recursiveInsert(Iterator itr, IActionAtInsert valueAddingStategy);
	
	/**
	 * 
	 * @param detpth
	 */
	void printTrieNode();
	
	/**
	 * 
	 * @return
	 */
	String toString();
	
	/**
	 * 
	 * @param itr
	 * @return
	 */
	Object recursiveLookUp(Iterator itr);
	
	/**
	 * 
	 * @return
	 */
	Object getValue();
	
	/**
	 * 
	 * @return
	 */
	int getDepth();
	
	/**
	 * 
	 * @return
	 */
	ITrieNode getParent();
	
	/**
	 * 
	 * @return
	 */
	Comparable getSymbol();
	
	/**
	 * 
	 * @return
	 */
	Map<Comparable, ITrieNode> getPartOfKeyToTrieNode();
	
}
