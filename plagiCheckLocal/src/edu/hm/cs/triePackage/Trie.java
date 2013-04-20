package edu.hm.cs.triePackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

class Trie implements ITrie {
	
	static final boolean traseFlag = false;
	
	private ITrieNode root;
	
	/**
	 * Konstruktor
	 */
	public Trie() {
		this.root = new TrieNode(null, 0);
	}

	@Override
	public Object put(Iterator itr, Object value) {
		return root.recursiveInsert(itr, value).getValue();
	}

	@Override
	public Object put(String str, Object value) {
		
		ArrayList aList = new ArrayList();
		
		for(int charNumber=0; charNumber<str.length(); charNumber++) {
			aList.add(str.charAt(charNumber));
		}
		
		Iterator aItr = aList.iterator();
		
		return this.root.recursiveInsert(aItr, value).getValue();
	}

	@Override
	public Object put(Set set, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Iterator itr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(String str) {
		
		ArrayList aList = new ArrayList();
		
		for(int charNumber=0; charNumber<str.length(); charNumber++) {
			aList.add(str.charAt(charNumber));
		}
		
		Iterator aItr = aList.iterator();

		return this.root.recursiveLookUp(aItr);
	}

	@Override
	public Object get(Set set) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object hasKey(Iterator itr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object hasKey(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object hasKey(Set set) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void printTrie() {
		root.printTrieNode();
	}
}
