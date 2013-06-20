package edu.hm.cs.lexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.hm.cs.token.IToken;
import edu.hm.cs.token.Token;

public class BaseLexer implements ILexer {

	BufferedReader symbol;
	LexerState lexerStateIs;
	boolean isEOF;
	int overlap = 0;
	int keepComma = 0;
	char toGetLexerState;
	int intToGetLexerState;
	int tokenCounter = 0;

	/**
	 * Kostruktor
	 * 
	 * @param file
	 */
	public BaseLexer(FileReader file) {
		this.symbol = new BufferedReader(file);
		this.isEOF = false;
	}

	@Override
	public ArrayList<IToken> getToken() {
		
//		System.out.println("\n\n**************** Token-Ausgabe ****************\n");

		int symbolValue = 0;
		LexerState oldState = LexerState.READY;
		String line = "";
		ArrayList<IToken> tokens = new ArrayList<IToken>();
		IToken actualToken;
		
		while(!isEOF) {
			try {
				if(overlap != 0) {
					if(keepComma != 0) {
						line = line + (char) keepComma;
						oldState = getLexerState(keepComma);
						keepComma = 0;
						
						actualToken = new Token(oldState, line);
						tokens.add(actualToken);
//						printToken(actualToken);
						
						line = ""+ (char)overlap;
						oldState = lexerStateIs;
					}
					else {
						lexerStateIs = getLexerState(overlap);
						oldState = lexerStateIs;
						line = line+(char)overlap;
					}
				}
			
				while((symbolValue = symbol.read()) != -1) {
				
					lexerStateIs = getLexerState(symbolValue);

					if(checkLexerChageState(oldState, line)) {
						overlap = symbolValue;
						
						toGetLexerState = line.charAt(line.length()-1);
						intToGetLexerState = toGetLexerState;
						
						if(isDigit(toGetLexerState) && keepComma != 0) {
							oldState = getLexerState(toGetLexerState);
							
							actualToken = new Token(oldState, line); 							
							tokens.add(actualToken);
//							printToken(actualToken);
							
						}
						else {
							actualToken = new Token(oldState, line); 							
							tokens.add(actualToken);
//							printToken(actualToken);
						}
						
						line = "";
						break;
					}
					else if(lexerStateIs == LexerState.FLOAT && (isComma(symbolValue) || isColon(symbolValue))) {
						keepComma = symbolValue;
						oldState = lexerStateIs; 
					}
					else if((lexerStateIs == LexerState.INT || lexerStateIs == LexerState.FLOAT) && 
							isDigit(symbolValue) && (isComma(keepComma) || isColon(keepComma))) {
						line = line + (char)keepComma + (char)symbolValue;
						keepComma = 0;
						oldState = lexerStateIs;
					}
					else {
						line = line+(char)symbolValue;
						oldState = lexerStateIs;
					}
				
				}
			
				if(symbolValue == -1) {
					if(keepComma != 0) {
						
						toGetLexerState = line.charAt(line.length()-1);
						intToGetLexerState = toGetLexerState;
						lexerStateIs = getLexerState(intToGetLexerState);
						
						actualToken = new Token(lexerStateIs, line); 						
						tokens.add(actualToken);
//						printToken(actualToken);
												
						lexerStateIs = getLexerState(keepComma);
						line = "" + (char)keepComma;
						
						actualToken = new Token(lexerStateIs, line); 
						tokens.add(actualToken);
//						printToken(actualToken);

					}
					else {
						actualToken = new Token(lexerStateIs, line); 						
						tokens.add(actualToken);
//						printToken(actualToken);
					}
					
					isEOF = true;
				}
		
			}
			catch(IllegalLexerException e) {
				System.out.println("Zeichen "+(char)symbolValue+ " konnte nicht zugewiesen werden!");
			}
			catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tokens;
	}

	private void printToken(IToken actualToken) {
		
		System.out.print("(\"");
		
		
		if(actualToken.getValue().equals("\n")) {
			System.out.println("\\n\", " +actualToken.getType()+ ")\n");
		}
		else {
			System.out.print(actualToken.getValue()+ "\", " +actualToken.getType()+ ") ");
		}
		
		if(tokenCounter == 5) {
			System.out.println();
			tokenCounter = 0;
		}
		else {
			tokenCounter++;
		}
	}

	private boolean checkLexerChageState(LexerState oldState, String line) {
		if(oldState == LexerState.READY)  {
			return false;
		}
		else if(oldState == LexerState.INT && (lexerStateIs == LexerState.COMMA || lexerStateIs == LexerState.COLON)) {
			lexerStateIs = LexerState.FLOAT;
			return false;
		}
		else if(oldState == LexerState.FLOAT && lexerStateIs == LexerState.INT) {
			lexerStateIs = LexerState.FLOAT;
			return false;
		}
		else if(oldState == LexerState.FLOAT
				&& (lexerStateIs == LexerState.COMMA || lexerStateIs == LexerState.COLON)) {
			lexerStateIs = LexerState.DATE;
			return false;
		}
		else if(oldState == LexerState.DATE && lexerStateIs == LexerState.INT) {
			if(line.length() == 10) {
				return true;
			}
			else {
				lexerStateIs = LexerState.DATE;
				return false;
			}
		}
		else if(oldState != lexerStateIs) {
			return true;
		}
		else {
			return false;
		}
	}

	private LexerState getLexerState(int value) throws IllegalLexerException {
		if(isLetter(value)) {
			return LexerState.ID;
		}
		else if(isColon(value)) {
			return LexerState.COLON;
		}
		else if(isComma(value)) {
			return LexerState.COMMA;
		}
		else if(isWhitSpace(value)) {
			return LexerState.WS;
		}
		else if(isDigit(value)) {
			return LexerState.INT;
		}
		else if(isSpecialCharacter(value)) {
			return LexerState.SPECIALCHAR;
		}
		else {
			throw new IllegalLexerException();
		}
	}

	private boolean isColon(int value) {
		if(value == 46) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isSpecialCharacter(int value) {
		if(value >= 33 && value <= 64) {
			return true;
		}
		else if(value >= 91 && value <= 96) {
			return true;
		}
		else if(value >= 123 && value <= 126) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isDigit(int value) {
		if(value >= 48 && value <= 57) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isWhitSpace(int value) {
		char sign = (char) value;

		if(sign == ' ' || sign == '\n' || sign == '\t' || value == 13) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isComma(int value) {
		if(value == 44) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isLetter(int value) {
		// Großbuchstaben
		if(value >= 65 && value <= 90) {
			return true;
		}
		// Kleinbuchstaben
		else if(value >= 97 && value <= 122) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isEOF() {
		return isEOF;
	}

}
