package interview2016;

import java.util.Arrays;

public class ImplementTrieWithParent {

}

class TrieNodeWithParent {

	// Initialize your data structure here.
	// All little case with no check
	private static final int BASE = 'a';
	private static final int MAX = 26;

	TrieNodeWithParent[] childs;
	boolean[] isEnds;
	TrieNodeWithParent parent;

	public TrieNodeWithParent() {
		childs = new TrieNodeWithParent[MAX];
		isEnds = new boolean[MAX];
	}

	public void putIfAbsent(char ch) {
		if (get(ch) == null) set(ch);
		get(ch).parent = this;
	}

	public TrieNodeWithParent get(char ch) {
		return childs[char2index(ch)];
	}

	private int char2index(char ch) {
		assert (ch - BASE >= 0 && ch - BASE < 26);
		return ch - BASE;
	}

	public TrieNodeWithParent set(char ch) {
		return childs[char2index(ch)] = new TrieNodeWithParent();
	}

	public void setEnd(char ch) {
		isEnds[char2index(ch)] = true;
	}

	public void resetEnd(char ch) {
		isEnds[char2index(ch)] = false;
	}

	public boolean isEnd(char ch) {
		return isEnds[char2index(ch)];
	}

	public boolean canBeDelete() {
		boolean isEnd = false;
		for (boolean e : isEnds) {
			if (e) {
				isEnd = true;
				break;
			}
		}
		return !isEnd && Arrays.asList(childs).stream().allMatch(e -> e == null);
	}

	public void delete(TrieNodeWithParent current) {
		if (current == null || current.parent != this) return;
		for (int i = 0; i < MAX; i++) {
			if (childs[i] == current) deleteChild(i);
		}
	}

	private void deleteChild(int i) {
		childs[i] = null;
	}

	public void deleteChild(char ch) {
		deleteChild(char2index(ch));
	}
}

class TrieWithParent {
	private TrieNodeWithParent root;

	public TrieWithParent() {
		root = new TrieNodeWithParent();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNodeWithParent current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			current.putIfAbsent(ch);
			current = current.get(ch);
		}
		if (word.length() > 0) current.setEnd(word.charAt(word.length() - 1));
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNodeWithParent current = findTargetNode(word);
		return current != null && word.length() > 0 && current.isEnd(word.charAt(word.length() - 1));
	}

	private TrieNodeWithParent findTargetNode(String word) {
		TrieNodeWithParent current = root;
		for (int i = 0; i < word.length() && current != null; current = current.get(word.charAt(i)), i++);
		return current;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		return null != findTargetNode(prefix);
	}

	public boolean delete(String word) {
		TrieNodeWithParent current = findTargetNode(word);
		if (current == null || word.length() <= 0 || !current.isEnd(word.charAt(word.length() - 1))) return false;
		current.resetEnd(word.charAt(word.length() - 1));
		while (current.parent != null && current.canBeDelete()) {
			current.parent.delete(current);
		}
		return true;
	}
}
