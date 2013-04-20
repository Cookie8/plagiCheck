package edu.hm.cs.triePackage;

import java.util.HashMap;
import java.util.Map;

class TrieReference implements ITrieReference {
	
	static final boolean traceFlag = false;
	
	final private boolean found;
	final private Object value;
	final int depth;
	
	HashMap data = new HashMap<Integer, Object>();
	
	/**
	 * Konstruktor
	 * 
	 * @param value
	 * @param depth
	 * @param found
	 */
	public TrieReference(Object value, int depth, boolean found) {
		this.value = value;
		this.depth = depth;
		this.found = found;
		
		data.put(this.depth, this.value);
	}
	
	
	@Override
	public boolean getFound() {
		return this.getFound();
	}

	@Override
	public Object getValue() {
		
		return data.get(this.getDepth());
	}


	@Override
	public int getDepth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
