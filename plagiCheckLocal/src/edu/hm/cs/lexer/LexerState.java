package edu.hm.cs.lexer;

public enum LexerState {
	READY, ID, WHITESPACE, INT, FLOAT, DATE, COMMA, EOF, UNKNOWN, SPECIALCHAR;
}
