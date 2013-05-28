package edu.hm.cs.aux;

import java.util.ArrayList;
import java.util.Iterator;

import edu.hm.cs.actionAtInsert.IActionAtInsert;
import edu.hm.cs.actionAtInsert.StringCoding;
import edu.hm.cs.lexer.LexerState;
import edu.hm.cs.token.IToken;
import edu.hm.cs.triePackage.ITrie;
import edu.hm.cs.triePackage.TrieFactory;

public class Aux {

	public ArrayList<ITrie> wordsToTrie(ArrayList<IToken> values) {

		Iterator<IToken> tokenIter = values.iterator();
		ArrayList<ITrie> trieList = new ArrayList<ITrie>();
		
		ITrie idTrie = new TrieFactory().createTrie();
		IActionAtInsert idAction = new StringCoding();
		
		ITrie dateTrie = new TrieFactory().createTrie();
		IActionAtInsert dateAction = new StringCoding();
		
		ITrie intTrie = new TrieFactory().createTrie();
		IActionAtInsert intAction = new StringCoding();
		
		ITrie floatTrie = new TrieFactory().createTrie();
		IActionAtInsert floatAction = new StringCoding();
		
		ITrie whitespaceTrie = new TrieFactory().createTrie();
		IActionAtInsert whitespaceAction = new StringCoding();
		
		ITrie commaTrie = new TrieFactory().createTrie();
		IActionAtInsert commaAction = new StringCoding();
		
		ITrie specialCharTrie = new TrieFactory().createTrie();
		IActionAtInsert specialCharAction = new StringCoding();
		
		ITrie unknownTrie = new TrieFactory().createTrie();
		IActionAtInsert unknownAction = new StringCoding();

		while(tokenIter.hasNext()) {
			IToken token = tokenIter.next();
			
			if(token.getType().equals(LexerState.ID)) {	
				idTrie.put(token.getValue(), idAction);	
			}
			else if(token.getType().equals(LexerState.DATE)) {
				dateTrie.put(token.getValue(), dateAction);
			}
			else if(token.getType().equals(LexerState.INT)) {
				intTrie.put(token.getValue(), intAction);
			}
			else if(token.getType().equals(LexerState.FLOAT)) {
				floatTrie.put(token.getValue(), floatAction);
			}
			else if(token.getType().equals(LexerState.WHITESPACE)) {
				whitespaceTrie.put(token.getValue(), whitespaceAction);
			}
			else if(token.getType().equals(LexerState.COMMA)) {
				commaTrie.put(token.getValue(), commaAction);
			}
			else if(token.getType().equals(LexerState.SPECIALCHAR)) {
				specialCharTrie.put(token.getValue(), specialCharAction);
			}
			else if(token.getType().equals(LexerState.UNKNOWN)) {
				unknownTrie.put(token.getValue(), unknownAction);
			}
		}
		
		trieList.add(idTrie);
		trieList.add(dateTrie);
		trieList.add(intTrie);
		trieList.add(floatTrie);
		trieList.add(whitespaceTrie);
		trieList.add(commaTrie);
		trieList.add(specialCharTrie);
		trieList.add(unknownTrie);
		
		return trieList;
	}
	
	private String tabsNachWortlaenge(String word) {
		String tabs = "";

		if(word.length() <= 6) {
			tabs = "\t\t\t";
		}
		else if(word.length() < 15) {
			tabs = "\t\t";
		}
		else {
			tabs = "\t";
		}

		return tabs;
	}
}
