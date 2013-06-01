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
	}
}
