package edu.hm.cs.token;

import edu.hm.cs.lexer.LexerState;

public interface IToken {
	
	public LexerState getType();
	public String getValue();
}
