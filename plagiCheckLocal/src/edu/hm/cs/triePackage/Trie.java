package edu.hm.cs.triePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.naming.PartialResultException;

import edu.hm.cs.actionAtInsert.IActionAtInsert;

class Trie implements ITrie {

	static final boolean traceFlag = false;

	private ITrieNode root;

	/**
	 * Konstruktor
	 */
	public Trie() {
		this.root = new TrieNode(null, 0);
	}

	@Override
	public Object put(Iterator itr, IActionAtInsert valueAddingStrategy) {
		return root.recursiveInsert(itr, valueAddingStrategy).getValue();
	}

	@Override
	public Object put(String str, IActionAtInsert valueAddingStrategy) {
		ArrayList listOfCharacters = new ArrayList();

		for(int charNumber = 0; charNumber < str.length(); charNumber++) {
			listOfCharacters.add(str.charAt(charNumber));
		}

		Iterator listItr = listOfCharacters.iterator();
		return this.root.recursiveInsert(listItr, valueAddingStrategy)
				.getValue();
	}

	@Override
	public Object put(Set set, Object value) {
		Iterator IteratorOverSet = set.iterator();
		Set setOfITrieReferences = new HashSet();
		ArrayList listOfCharacters = new ArrayList();

		while(IteratorOverSet.hasNext()) {
			String word = (String) IteratorOverSet.next();

			for(int charNumber = 0; charNumber < word.length(); charNumber++) {
				listOfCharacters.add(word.charAt(charNumber));
			}

			Iterator itrToPut = listOfCharacters.iterator();
		}

		return setOfITrieReferences;
	}

	@Override
	public Object get(Iterator itr) {
		return this.root.recursiveLookUp(itr);
	}

	@Override
	public Object get(String str) {
		ArrayList listOfCharacters = new ArrayList();

		for(int charNumber = 0; charNumber < str.length(); charNumber++) {
			listOfCharacters.add(str.charAt(charNumber));
		}

		Iterator listItr = listOfCharacters.iterator();
		return this.root.recursiveLookUp(listItr);
	}

	@Override
	public Object get(Set set) {
		Iterator iteratorOverSet = set.iterator();
		Map mapOfValues = new HashMap();
		ArrayList listOfCharacters = new ArrayList();

		while(iteratorOverSet.hasNext()) {
			String word = (String) iteratorOverSet.next();

			for(int charNumber = 0; charNumber < word.length(); charNumber++) {
				listOfCharacters.add(word.charAt(charNumber));
			}

			Iterator itrToGet = listOfCharacters.iterator();
			mapOfValues.put(word, this.root.recursiveLookUp(itrToGet));
		}

		return mapOfValues;
	}

	@Override
	public boolean hasKey(Iterator itr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasKey(String str) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasKey(Set set) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printTrie() {		
		System.out.print("\n=============== Baumausgabe ===============\n");
		this.root.printTrieNode();
	}

	private boolean isDigit(Comparable symbol) {
		char character = (Character) symbol;
		int number =  character;
		
		if(number>=48 && number<=57) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isCharacter(Comparable symbol) {
		char character = (Character) symbol;
		int number =  character;
		
		// Großbuchstaben
		if(number >= 65 && number <= 90) {
			return true;
		}
		// Kleinbuchstaben
		else if(number >= 97 && number <= 122) {
			return true;
		}
		else {
			return false;
		}

	}

	@Override
	public Object insert(Iterator itr, IActionAtInsert valueAddingStrategy) {
		return this.root.recursiveInsert(itr, valueAddingStrategy);
	}

	@Override
	public boolean rootHasValue() {
		return this.root.getSymbol() != null;
	}

}
