package edu.hm.cs.input;

import java.util.ArrayList;

import edu.hm.cs.token.IToken;
import edu.hm.cs.triePackage.ITrie;

public interface IReader {
	
	ArrayList<IToken> readFile(String pfad);
	String getPfad();
	
}
