package edu.hm.cs;

import java.util.ArrayList;
import java.util.Iterator;

import edu.hm.cs.triePackage.ITrie;
import edu.hm.cs.triePackage.TrieFactory;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "wolf";
		String str2 = "wo";
		String str3 = "Hallo";
		String str4 = "Affe";
		ITrie trie = new TrieFactory().createTrie();
		
		
		
		ArrayList aL = new ArrayList();	
		for(int i=0; i<str.length(); i++) {
			aL.add(str.charAt(i));
		}	
		Iterator itr = aL.iterator();
		
		
		
		trie.put(itr, new Integer(4711));
		trie.put(str2, new Integer(4712));
		trie.put(str3, new Integer(4713));
		trie.put(str4, new Integer(4714));
		
		trie.printTrie();
	}

}
