package interview2016;

public class ImplementTrie {

}

class TrieNode {

	// Initialize your data structure here.
	// All little case with no check
	private static final int BASE = 'a';
	private static final int MAX = 26;

	TrieNode[] childs;
	boolean[] isEnds;

	public TrieNode() {
		childs = new TrieNode[MAX];
		isEnds = new boolean[MAX];
	}

	public void putIfAbsent(char ch) {
		if (get(ch) == null) set(ch);
	}

	public TrieNode get(char ch) {
		return childs[char2index(ch)];
	}

	private int char2index(char ch) {
		assert (ch - BASE >= 0 && ch - BASE < 26);
		return ch - BASE;
	}

	public TrieNode set(char ch) {
		return childs[char2index(ch)] = new TrieNode();
	}

	public void setEnd(char ch) {
		isEnds[char2index(ch)] = true;
	}

	public boolean isEnd(char ch) {
		return isEnds[char2index(ch)];
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			current.putIfAbsent(ch);
			current = current.get(ch);
		}
		if (word.length() > 0) current.setEnd(word.charAt(word.length() - 1));
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length() && current != null; current = current.get(word.charAt(i)), i++);
		return current != null && word.length() > 0 && current.isEnd(word.charAt(word.length() - 1));
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode current = root;
		for (int i = 0; i < prefix.length() && current != null; current = current.get(prefix.charAt(i)), i++);
		return current != null;
	}
}
