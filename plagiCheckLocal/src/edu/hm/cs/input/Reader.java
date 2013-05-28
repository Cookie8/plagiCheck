package edu.hm.cs.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.hm.cs.lexer.BaseLexer;
import edu.hm.cs.token.IToken;

public class Reader implements IReader {
	
	String pfad;

	public Reader(String inPfad) {
		this.pfad = inPfad;
	}
	
	@Override
	public ArrayList<IToken> readFile(String pfad) {
		
		BaseLexer lexer;
		ArrayList<IToken> tokens = new ArrayList<IToken>();
		
		try {
			lexer = new BaseLexer(new FileReader(pfad));
			
			tokens = lexer.getToken();
				
		}
		catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tokens;
		
		
		
//		ArrayList<String> lines = new ArrayList<String>();
//		
//		try {
//			FileReader file = new FileReader(pfad);
//			
//			BufferedReader br = new BufferedReader(file);
//			String stringLine;
//
//			while ((stringLine = br.readLine()) != null) {
//				lines.add(stringLine);
//			}
//			br.close();
//		}
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return getWords(lines);
	}

	private ArrayList<String> getWords(ArrayList<String> lines) {
		ArrayList<String> words = new ArrayList<String>();
		Iterator<String> itr = lines.iterator();
		
		while(itr.hasNext()) {
			String string = itr.next().toString();
			String[] wordString = string.split(" ");
			
			for(int i=0; i<wordString.length; i++) {
				words.add(wordString[i]);
				
//				if(wordString[i].contains(".")) {
//					String s = wordString[i].substring(0, wordString[i].length() -1);
//					words.add(s);
//				}
//				else {
//					words.add(wordString[i]);
//				}
			}
		}
		
		Iterator<String> itr2 = words.iterator();
		while(itr2.hasNext()) {
			String s = itr2.next();
//			System.out.println(s);
		}
		return words;
	}

	public String getPfad() {
		return pfad;
	}

}
