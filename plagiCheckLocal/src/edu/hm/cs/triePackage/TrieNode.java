package edu.hm.cs.triePackage;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class TrieNode implements ITrieNode {

	static final boolean traceFlag = false;

	/** Der (End-)Wert eines Knotens */
	Object value;

	/** Der Eltern-Knoten (Vorg�nger) des aktuellen Knotens */
	ITrieNode parent;

	/** Symbol (Character) der Kante */
	Comparable ingoingSymbol;

	/** Map mit den Symbolen (Character), welche aufgenommen werden sollen */
	Map<Comparable, ITrieNode> partOfKeyToTrieNode;

	/** Tiefe in der Baumstruktur */
	int depth;

	int counter;

	/**
	 * Konstruktor
	 * 
	 * @param parent
	 * @param depth
	 */
	public TrieNode(ITrieNode parent, int depth) {
		this.parent = parent;
		this.depth = depth;
		this.partOfKeyToTrieNode = new TreeMap<Comparable, ITrieNode>();
	}

	@Override
	public ITrieReference recursiveInsert(Iterator itr, Object value) {

		/* Tiefe für den nächsten Knoten */
		int inDepth = this.getDepth();

		/* Ziel, für rekursiven Aufruf */
		ITrieNode target;

		if (itr.hasNext()) {

			this.ingoingSymbol = (Comparable) itr.next();
			String convertString = this.ingoingSymbol.toString();
			Integer integerToPut = (int) convertString.charAt(0);
			
			// System.out.println(integerToPut);

			if (!partOfKeyToTrieNode.containsKey(integerToPut)) {

				inDepth++;

				this.partOfKeyToTrieNode.put(integerToPut, new TrieNode(this,
						inDepth));

				// System.out.println("Dieser Buchstabe war noch nicht drinnen: "
				// +integerToPut+" wurde eingefügt, in der " +
				// "Tiefe von " + this.getDepth());

				target = partOfKeyToTrieNode.get(integerToPut);
				return target.recursiveInsert(itr, value);
			} else {
				target = partOfKeyToTrieNode.get(integerToPut);

				// System.out.println("Der Buchstabe war schon drinnen "
				// +integerToPut+ " in der Tiefe von " +inDepth);

				return target.recursiveInsert(itr, value);
			}
		} else {
			if (this.getValue() != null) {

				/*
				 * Hier sollte noch der alte Value in der Reference gespeichert
				 * werden, bevor dieser dann überschrieben wird.
				 */

				this.value = value;
			} else {
				this.value = value;
			}
		}
		// System.out.print("Der Value ist: "+this.getValue());
		return new TrieReference(this.getValue(), this.getDepth(), true);
	}

	public void printTrieNode() {

		System.out.print("Value: " + (Integer) value + " Tiefe: " + getDepth()
				+ " Buchstaben: ");

		for (int i = 0; i < getDepth(); i++) {
			System.out.print("   ");
		}

		Iterator key = partOfKeyToTrieNode.keySet().iterator();
		while (key.hasNext()) {
			int inInteger = (Integer) key.next();
			Character buchstabe = (char) inInteger;
			System.out.print(buchstabe + ", ");
		}
		System.out.println("");

		Iterator it = partOfKeyToTrieNode.values().iterator();
		while (it.hasNext()) {
			ITrieNode temp = (TrieNode) it.next();
			temp.printTrieNode();
		}
	}

	@Override
	public Object recursiveLookUp(Iterator itr) {
		
		ITrieNode target;
		
		if (itr.hasNext()) {

			this.ingoingSymbol = (Comparable) itr.next();
			String convertString = this.ingoingSymbol.toString();
			Integer integerToPut = (int) convertString.charAt(0);
			
			// System.out.println(integerToPut);

			if (!partOfKeyToTrieNode.containsKey(integerToPut)) {
				
				return null;
				
			} else {
				target = partOfKeyToTrieNode.get(integerToPut);
				return target.recursiveLookUp(itr);
			}
		} else {
//			System.out.println(this.getValue());
			return this.getValue();
		}
	}

	public Object getValue() {
		return this.value;
	}

	public ITrieNode getParent() {
		return this.parent;
	}

	public Comparable getIngoingSymbol() {
		return this.ingoingSymbol;
	}

	public Map<Comparable, ITrieNode> getPartOfKeyToTrieNode() {
		return this.partOfKeyToTrieNode;
	}

	public int getDepth() {
		return this.depth;
	}

}
