package edu.hm.cs;

import java.util.ArrayList;
import java.util.Iterator;

import edu.hm.cs.aux.Aux;
import edu.hm.cs.input.IReader;
import edu.hm.cs.input.Reader;
import edu.hm.cs.token.IToken;
import edu.hm.cs.triePackage.ITrie;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		for(int file = 0; file < args.length; file++) {
			IReader reader = new Reader(args[file]);
			ArrayList<IToken> tokens = reader.readFile(reader.getPfad());
			ArrayList<ITrie> tries = new Aux().wordsToTrie(tokens);
			
			System.out.println("\n\n################ FILE-NR: " + (file+1) + " ################");
			
			Iterator<ITrie> iteratorOverTries = tries.iterator();
			
			while(iteratorOverTries.hasNext()) {
				ITrie trie = iteratorOverTries.next();
				
				if(trie.rootHasValue()) {
					trie.printTrie();
				}
			}
		}
		
//		IReader reader = new Reader(args[0]);
//		ArrayList<IToken> tokens = reader.readFile(reader.getPfad());
//		ArrayList<ITrie> tries = new Aux().wordsToTrie(tokens);
//		
//		Iterator<ITrie> itr = tries.iterator();
//		
//		while(itr.hasNext()) {
//			ITrie trie = itr.next();
//			
//			if(trie.rootHasValue()) {
//				trie.printTrie();
//			}	
//		}
		
		
//		ITrieFactory factory = new TrieFactory();
//		ITrie trie = factory.createTrie();
//		IActionAtInsert action = new StringCoding();
		
		
//		String str = "wolf";
//		String str2 = "wo";
//		String str3 = "Hallo";
//		String str4 = "Affe";
		
//		String[] strings = new String[] {"wolf", "wo", "Hallo", "Affe"};
//		
//		
//		
//		for(int i=0; i<strings.length; i++) {
//			ArrayList al = new ArrayList();
//			for(int j=0; j<strings[i].length(); j++) {
//				al.add(strings[i].charAt(j));
//			}
//			Iterator itr = al.iterator();
//			trie.insert(itr, action);
//		}
		
		
		
//		trie.put(str2, 2);
//		trie.put(str3, 3);
//		trie.put(str4, 4);
		
//		trie.printTrie();

	}
}
