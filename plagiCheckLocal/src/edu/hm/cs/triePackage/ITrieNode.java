package edu.hm.cs.triePackage;

import java.util.Iterator;

interface ITrieNode {
	
	/**
	 * 
	 * @param itr
	 * @param value
	 * @return
	 */
	ITrieReference recursiveInsert(Iterator itr, Object value);
	
	void printTrieNode();
	
	String toString();

	Object recursiveLookUp(Iterator itr);
}
