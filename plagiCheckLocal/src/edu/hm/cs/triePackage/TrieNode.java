package edu.hm.cs.triePackage;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import edu.hm.cs.actionAtInsert.IActionAtInsert;

class TrieNode implements ITrieNode {

	static final boolean traceFlag = false;

	/** Der (End-)Wert eines Knotens. */
	Object value;

	/** Der Eltern-Knoten (Vorg√§nger) des aktuellen Knotens. */
	ITrieNode parent;

	/** Symbol (Character) der Kante. */
	Comparable symbol;

	/** Map mit den Symbolen (Characters), welche aufgenommen werden sollen. */
	Map<Comparable, ITrieNode> partOfKeyToTrieNode;

	/** Tiefe in der Baumstruktur. */
	int depth;

	/**
	 * Konstruktor, erzeugt einen neuen TrieNode mit der dazugeh√∂rigen TreeMap.
	 * 
	 * @param inParent
	 *            der Vorg√§nger-Knoten
	 * @param inDepth
	 *            Tiefe in der Baumstruktur
	 */
	public TrieNode(ITrieNode inParent, int inDepth) {
		this.parent = inParent;
		this.depth = inDepth;

		this.partOfKeyToTrieNode = new TreeMap<Comparable, ITrieNode>();
	}

	@Override
	public ITrieReference recursiveInsert(Iterator itr, IActionAtInsert valueAddingStrategy) {

		// Tiefe für den nächsten Knoten.
		int treeDepth = this.getDepth();

		// Ziel für rekursiven Aufruf.
		ITrieNode target;

		if(itr.hasNext()) {
			this.symbol = (Comparable) itr.next();
			String convertString = this.symbol.toString();
			Integer integerToTrieNode = (int) convertString.charAt(0);

			if(!(partOfKeyToTrieNode.containsKey(integerToTrieNode))) {
				treeDepth++;
					
				this.partOfKeyToTrieNode.put(integerToTrieNode, new TrieNode(
						this, treeDepth));
				target = partOfKeyToTrieNode.get(integerToTrieNode);
				return target.recursiveInsert(itr, valueAddingStrategy);
			}
			else {
				
				target = partOfKeyToTrieNode.get(integerToTrieNode);
				return target.recursiveInsert(itr, valueAddingStrategy);
			}
		}
		else {
			if(this.getValue() != null) {
				// TODO Hier sollte noch der alte Value in der Reference
				// gespeichert werden, bevor dieser dann überschrieben wird.

				this.value = valueAddingStrategy.actionInCaseOfFoundKey(this.value);
			}
			else {
				this.value = valueAddingStrategy.actionInCaseOfNotFoundKey();
			}
		}
		return new TrieReference(this.getValue(), this.getDepth(), true);
	}

	@Override
	public void printTrieNode() {
		Iterator key = partOfKeyToTrieNode.keySet().iterator();

		while(key.hasNext()) {
			int inInteger = (int) key.next();
			Character buchstabe = (char) inInteger;

			System.out.print(einrueckung(this.getDepth()));
			
			if(inInteger == 10 ) {
				System.out.print("Enter");
			}
			else if(inInteger == 32) {
				System.out.print("Whitespace");
			}
			else if(inInteger == 9) {
				System.out.print("Tab");
			}
			else {
				System.out.print(buchstabe);
			}

			if(partOfKeyToTrieNode.get(inInteger).getValue() != null) {
				System.out.println(" -> Value = "
						+ (Integer) partOfKeyToTrieNode.get(inInteger)
								.getValue());
			}
			else
				System.out.println("");
			partOfKeyToTrieNode.get(inInteger).printTrieNode();
		}
	}

	/**
	 * Gibt an, wie weit in der Konsolenausgabe eingerückt werden muss.
	 * 
	 * @param inDepth
	 *            Für die Anzahl der Leerzeichen, um die eingerückt werden soll
	 * @return die Einrückungen als String
	 */
	private String einrueckung(int inDepth) {
		String einrueckung = "";

		for(int i = 0; i < inDepth; i++) {
			einrueckung += " ";
		}

		return einrueckung;
	}

	@Override
	public Object recursiveLookUp(Iterator itr) {
		ITrieNode target;

		if(itr.hasNext()) {
			this.symbol = (Comparable) itr.next();
			String convertString = this.symbol.toString();
			Integer integerToGet = (int) convertString.charAt(0);

			if(!partOfKeyToTrieNode.containsKey(integerToGet)) {
				return null;
			}
			else {
				target = partOfKeyToTrieNode.get(integerToGet);
				return target.recursiveLookUp(itr);
			}
		}
		else {
			return this.getValue();
		}
	}

	@Override
	public Object getValue() {
		return this.value;
	}

	@Override
	public int getDepth() {
		return this.depth;
	}

	@Override
	public ITrieNode getParent() {
		return this.parent;
	}

	@Override
	public Comparable getSymbol() {
		return this.symbol;
	}

	@Override
	public Map<Comparable, ITrieNode> getPartOfKeyToTrieNode() {
		return this.partOfKeyToTrieNode;
	}
}
