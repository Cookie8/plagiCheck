package edu.hm.cs.triePackage;

public class TrieFactory implements ITrieFactory {

	@Override
	public ITrie createTrie() {
		return new Trie();
	}

}
