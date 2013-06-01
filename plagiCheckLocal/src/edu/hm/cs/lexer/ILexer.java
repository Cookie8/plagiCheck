package edu.hm.cs.lexer;

import java.util.ArrayList;

import edu.hm.cs.token.IToken;

public interface ILexer {
	
	ArrayList<IToken> getToken();
	
	boolean isEOF();
}
