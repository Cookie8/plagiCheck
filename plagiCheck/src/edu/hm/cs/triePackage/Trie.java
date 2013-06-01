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
			// setOfITrieReferences
			// .add(this.root.recursiveInsert(itrToPut, value));
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

//		if(isCharacter(this.root.getSymbol())) {
//			System.out.print("Baumausgabe der ID-TOKENS ");
//		}
//		else if(getDate(rootIter).matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
//			System.out.print("Baumausgabe der DATE-TOKENS ");
//		}
		
//		System.out.println("===============\n");
		this.root.printTrieNode();
	}

//	private String getDate(Iterator iter) {
//		
//		ITrie target;
//		String builtDate = "";
//		
//		if(iter.hasNext()) {
//			int next = (int) iter.next();
//			char character = (char) next;
//			builtDate = builtDate + character;
//			
//			if(!this.root.getPartOfKeyToTrieNode().containsKey(next)) {
//				return null;
//			}
//			else {
//				Iterator itr = this.root.getPartOfKeyToTrieNode().get(next).getPartOfKeyToTrieNode().keySet().iterator();
//				return this.getDate(itr);
//			}
//		}
//		else {
//			return builtDate;
//		}
		
//		Iterator itr = partOfKey.keySet().iterator();
//		String date = "";
//		Iterator itr2;
//		
//		do {
//			int next = (int) itr.next();
//			char character = (char) next;
//			date = date + character;
//			Map<Comparable, ITrieNode> newPart = partOfKey.get(next).getPartOfKeyToTrieNode();
//			itr2 = newPart.keySet().iterator();
//		}
//		while(itr2.hasNext());
//			
//			
//		
//		return date;
		
//		String date = "";
//		date = date + toBuild;
//		String state = "";
//		
//		while(itr.hasNext()) {
//			int nextAsInt = (int) itr.next();
//			char character = (char) nextAsInt;
//			String checkMapValue = ""+character;
//			date = date + character;
//			
//			if(partOfKey.get(nextAsInt).getValue() == null && checkMapValue.length() >= 1) {
//				state = getDate(partOfKey.get(nextAsInt).getPartOfKeyToTrieNode(), date);
//			}
//		}
//		
//		return state;

//	}

//	private String getDate(Object root) {
//		String date = "";
////		ITrieNode next = (ITrieNode) root;
//		Iterator itr = 
//		
//		
////		if(next.getSymbol() != null) {
////			date = date +  next.getSymbol();
////			return getDate(next.getPartOfKeyToTrieNode().get(key));
////		}
////		else {
////			return date;
////		}
//	}

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
