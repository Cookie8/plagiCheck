package edu.hm.cs.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import edu.hm.cs.triePackage.ITrie;
import edu.hm.cs.triePackage.TrieFactory;

public class Reader implements IReader {

	@Override
	public ArrayList<String> readFile() {

		ArrayList<String> lines = new ArrayList<String>();

		try {
			FileReader fr = new FileReader(
					"/Users/Cookie/GitHub/plagiCheck/plagiCheckLocal/Test.txt");
			BufferedReader br = new BufferedReader(fr);
			String stringline;

			while ((stringline = br.readLine()) != null) {
				lines.add(stringline);
			}
			br.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getWords(lines);
	}
	
	ArrayList<String> getWords(ArrayList<String> lines) {
		
		ArrayList<String> words = new ArrayList<String>();
		Iterator<String> itr = lines.iterator();
		
		while(itr.hasNext()) {
			String string = itr.next().toString();
			String[] wordString = string.split(" ");
			
			for(int i=0; i<wordString.length; i++) {
				
				if(wordString[i].contains(".")) {
					String s = wordString[i].substring(0, wordString[i].length() -1);
					words.add(s);
				}
				else {
					words.add(wordString[i]);
				}
			}
		}
		
		Iterator<String> itr2 = words.iterator();
		while(itr2.hasNext()) {
			String s = itr2.next();
//			System.out.println(s);
		}
		return words;
	}
	
	public ITrie wordsToTrie(ArrayList<String> words) {
		
		ITrie trie = new TrieFactory().createTrie();
		Iterator<String> itr = words.iterator();
		int counter = 1;
		
		while(itr.hasNext()) {
			String str = itr.next().toString();
			
			if(trie.get(str)!= null) {
				System.out.println(str+ "\that Value " +trie.get(str));
				trie.put(str, trie.get(str));
			}
			else {
				System.out.println(str+ "\that Value " +counter);
				trie.put(str, counter);
				counter++;
			}
			
		}
		return trie;
	}
}
