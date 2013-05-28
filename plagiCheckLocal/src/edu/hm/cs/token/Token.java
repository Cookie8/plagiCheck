package edu.hm.cs.token;

import edu.hm.cs.lexer.LexerState;

public class Token implements IToken {
	
	private LexerState type;
	private String value;
	
	public Token(LexerState inType, String inValue) {
		this.type = inType;
		this.value = inValue;
	}
	
	@Override
	public LexerState getType() {
		return type;
	}

	@Override
	public String getValue() {
		return value;
	}

}
