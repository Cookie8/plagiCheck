package edu.hm.cs;

import java.util.ArrayList;

import edu.hm.cs.aligner.Displayer;
import edu.hm.cs.aligner.ISelector;
import edu.hm.cs.aligner.Selector;
import edu.hm.cs.input.IReader;
import edu.hm.cs.input.Reader;
import edu.hm.cs.token.IToken;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ISelector selector = new Selector();
		
		for(int file = 0; file < args.length; file++) {
			IReader reader = new Reader(args[file]);
			ArrayList<IToken> tokens = reader.readFile(reader.getPfad());

			selector.saveFiles(tokens);
			
			
			
			
			
			
//			ArrayList<ITrie> tries = new Aux().wordsToTrie(tokens);
			
//			System.out.println("\n\n################ FILE-NR: " + (file+1) + " ################");
//			
//			Iterator<ITrie> iteratorOverTries = tries.iterator();
//			
//			while(iteratorOverTries.hasNext()) {
//				ITrie trie = iteratorOverTries.next();
//				
//				if(trie.rootHasValue()) {
//					trie.printTrie();
//				}
//			}
		}
		
		
	}
}
