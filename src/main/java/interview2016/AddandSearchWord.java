package interview2016;

public class AddandSearchWord {
	private TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			p.putIfAbsent(ch);
			p = p.getChild(ch);
		}
		p.setEnd(true);
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return root.search(word);
	}

	public boolean searchString(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length() && p != null; i++) {
			p = p.getChild(word.charAt(i));
		}
		return p != null && p.isEnd();
	}

	private class TrieNode {
		static final char BASE = 'a';
		static final int MAX = 'z' - 'a' + 1;
		final char DOT = '.';
		
		TrieNode[] childs;
		boolean isEnd;

		TrieNode() {
			childs = new TrieNode[MAX];
		}

		public boolean search(String word) {
			if(word.length() == 0) return isEnd();
			char ch = word.charAt(0);
			String remain = word.substring(1);
			if(ch == DOT){
				for(TrieNode e : childs){
					if(e != null && e.search(remain)) return true;
				}
				return false;
			}else{
				TrieNode p = getChild(ch);
				return p != null && p.search(remain);
			}
		}

		public void putIfAbsent(char ch) {
			if (getChild(ch) == null) childs[char2index(ch)] = new TrieNode();
		}

		public boolean isEnd() {
			return isEnd;
		}

		public void setEnd(boolean end) {
			isEnd = end;
		}

		public TrieNode getChild(char ch) {
			return childs[char2index(ch)];
		}

		private int char2index(char ch) {
			int res = ch - BASE;
			assert (res >= 0 && res < MAX);
			return res;
		}
	}
}
