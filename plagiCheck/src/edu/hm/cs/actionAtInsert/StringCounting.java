package edu.hm.cs.actionAtInsert;

public class StringCounting {
	
	private int counter;
	private int seite;
	private int zeile;
	private int position;
	
	public StringCounting(int inCounter, int inSeite, int inZeile, int inPosition) {
		this.counter = inCounter;
		this.seite = inSeite;
		this.zeile = inZeile;
		this.position = inPosition;
	}

	public int getCounter() {
		return counter;
	}

	public int getSeite() {
		return seite;
	}

	public int getZeile() {
		return zeile;
	}

	public int getPosition() {
		return position;
	}
	
	

}
