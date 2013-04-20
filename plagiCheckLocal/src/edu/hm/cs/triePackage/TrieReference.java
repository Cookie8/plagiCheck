package edu.hm.cs.triePackage;

class TrieReference implements ITrieReference {
	
	static final boolean traceFlag = false;
	
	final private boolean found;
	final private Object value;
	final int depth;
	
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
	}
	
	
	@Override
	public boolean getFound() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getDepth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
