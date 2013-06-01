package edu.hm.cs.triePackage;

import java.util.HashMap;

class TrieReference implements ITrieReference {

	static final boolean traceFlag = false;

	final private boolean found;
	final private Object value;
	final private int depth;

	HashMap<Integer, Object> data = new HashMap<Integer, Object>();

	/**
	 * Konstruktor
	 * 
	 * @param inValue
	 *            der Value des Wortes
	 * @param inDepth
	 *            die Tiefe im Baum
	 * @param inFound
	 *            <code>true</code> falls das Wort gefunden wurde,
	 *            <code>false</code> sonst
	 */
	public TrieReference(Object inValue, int inDepth, boolean inFound) {
		this.value = inValue;
		this.depth = inDepth;
		this.found = inFound;

		data.put(this.depth, this.value);
	}

	@Override
	public boolean getFound() {
		return this.found;
	}

	@Override
	public Object getValue() {
		return this.value;
	}

	@Override
	public int getDepth() {
		return this.depth;
	}
}
