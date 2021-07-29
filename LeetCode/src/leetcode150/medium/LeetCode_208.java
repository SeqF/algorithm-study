package leetcode150.medium;

/**
 * 实现 Trie (前缀树)
 *
 * @author ps
 * <p>
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class LeetCode_208 {

    private final TireNode root;

    /**
     * Initialize your data structure here.
     */
    public LeetCode_208() {
        this.root = new TireNode('/');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TireNode p = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TireNode(chars[i]);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TireNode p = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TireNode p = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return !p.isEndingChar;
    }

    /**
     * 每个节点保存一个26长度的数组，对应26个字母，同时标记这个节点是否为最后一个节点
     */
    private class TireNode {
        private final char data;
        private final TireNode[] children = new TireNode[26];
        private boolean isEndingChar = false;

        public TireNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LeetCode_208 code208 = new LeetCode_208();
        code208.insert("apple");
    }
}
