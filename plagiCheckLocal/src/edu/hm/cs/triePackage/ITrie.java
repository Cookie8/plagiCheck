package edu.hm.cs.triePackage;

import java.util.Iterator;
import java.util.Set;

import edu.hm.cs.actionAtInsert.IActionAtInsert;

/**
 * Erzeugt einen neuen Trie und bearbeitet diesen.
 * 
 * @author Cookie
 *
 */
public interface ITrie {
	
	/**
	 * Fügt ein neues Wort in den Trie ein.
	 * 
	 * @param itr
	 * 			Iterator über das einzutragende Wort
	 * @param value
	 * 			der Value über das Wort
	 * @return
	 * 			den Value des eingetragenen Wortes
	 */
	Object put(Iterator itr, IActionAtInsert valueAddingStrategy);
	
	/**
	 * Fügt ein neues Wort in den Trie ein.
	 * 
	 * @param str
	 * 			das einzutragende Wort
	 * @param value
	 * 			der Value für das Wort
	 * @return
	 * 			den Value des eingetragenen Wortes
	 */
	Object put(String str, IActionAtInsert valueAddingStrategy);
	
	/**
	 * Fügt ein neues Wort in den Trie ein.
	 * 
	 * @param set
	 * 			Set mit dem einzutragenden Wort
	 * @param value
	 * 			der Value über das Wort
	 * @return
	 * 			den Value des eingetragenen Wortes
	 */
	Object put(Set set, Object value);
	
	/**
	 * Liefert den Value zu dem übergebenen Wort.
	 * 
	 * @param itr
	 * 			Iterator über das übergebene Wort
	 * @return
	 * 			den Value des übergebenen Wortes
	 */
	Object get(Iterator itr);
	
	/**
	 * Liefert den Value zu dem übergebenen Wort.
	 * 
	 * @param str
	 * 			das übergebene Wort
	 * @return
	 * 			den Value des übergebenen Wortes
	 */
	Object get(String str);
	
	/**
	 * Liefert den Value zu dem übergebenen Wort.
	 * 
	 * @param set
	 * 			Set mit dem übergebenen Wort
	 * @return
	 * 			den Value des übergebenen Wortes
	 */
	Object get(Set set);
	
	/**
	 * Prüft, ob der Schlüssel im Trie vorhanden ist.
	 * 
	 * @param itr
	 * 			Iterator über den Schlüssel
	 * @return
	 * 			<code>true</code> falls der Schlüssel enthalten ist
	 * 			<code>false</code> andernfalls
	 */
	boolean hasKey(Iterator itr);
	
	/**
	 * Prüft, ob der Schlüssel im Trie vorhanden ist.
	 * 
	 * @param str
	 * 			der übergebene Schlüssel
	 * @return
	 * 			<code>true</code> falls der Schlüssel enthalten ist
	 * 			<code>false</code> andernfalls
	 */
	boolean hasKey(String str);
	
	/**
	 * Prüft, ob der Schlüssel im Trie vorhanden ist.
	 * 
	 * @param set
	 * 			Set mit dem Schlüssel
	 * @return
	 * 			<code>true</code> falls der Schlüssel enthalten ist
	 * 			<code>false</code> andernfalls.
	 */
	boolean hasKey(Set set);
	
	/**
	 * Gibt den Trie auf der Konsole aus.
	 */
	void printTrie();
	
	Object insert(Iterator itr, IActionAtInsert valueAddingStrategy);
	
	boolean rootHasValue();
}
