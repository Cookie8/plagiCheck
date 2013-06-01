package edu.hm.cs.lexer;

public enum LexerState {
	READY, ID, WS, INT, FLOAT, DATE, COMMA, COLON, EOF, UNKNOWN, SPECIALCHAR;
}
