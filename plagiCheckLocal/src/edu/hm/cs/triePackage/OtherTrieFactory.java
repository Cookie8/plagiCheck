package edu.hm.cs.triePackage;

public class OtherTrieFactory implements ITrieFactory {

	@Override
	public ITrie createTrie() {
		return new Trie();
	}

}
