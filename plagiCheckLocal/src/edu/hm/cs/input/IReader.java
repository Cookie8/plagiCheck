package edu.hm.cs.input;

import java.util.ArrayList;

import edu.hm.cs.triePackage.ITrie;

public interface IReader {
	
	ArrayList<String> readFile();
	ITrie wordsToTrie(ArrayList<String> words);
}
