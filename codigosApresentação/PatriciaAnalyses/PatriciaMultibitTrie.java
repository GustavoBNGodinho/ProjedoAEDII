package PatriciaAnalyses;

public class PatriciaMultibitTrie {

    protected static class PatriciaNode {
        private String prefix;
        private boolean isEndOfWord;
        private PatriciaNode[] children;

        public PatriciaNode(String prefix) {
            this.prefix = prefix;
            this.isEndOfWord = false;
            this.children = new PatriciaNode[4];
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        public PatriciaNode[] getChildren() {
            return children;
        }

        public void setChildren(PatriciaNode[] children) {
            this.children = children;
        }
    }

    private final PatriciaNode root;

    public PatriciaMultibitTrie() {
        root = new PatriciaNode("");
    }

    public PatriciaNode getRoot() {
        return root;
    }

    public void insert(String key) {
        insertRecursive(getRoot(), key);
    }

    private void insertRecursive(PatriciaNode node, String key) {
        int commonLength = commonPrefixLength(node.getPrefix(), key);

        if (commonLength < node.getPrefix().length()) {
            // Split atual
            String remainingPrefix = node.getPrefix().substring(commonLength);
            PatriciaNode split = new PatriciaNode(remainingPrefix);
            split.setChildren(node.getChildren());
            split.setEndOfWord(node.isEndOfWord());

            node.setPrefix(node.getPrefix().substring(0, commonLength));
            node.setChildren(new PatriciaNode[4]);
            node.getChildren()[bitPairToIndex(getNextBitPair(remainingPrefix))] = split;
            node.setEndOfWord(false);
        }

        key = key.substring(commonLength);

        if (key.isEmpty()) {
            node.setEndOfWord(true);
            return;
        }

        String nextBits = getNextBitPair(key);
        int index = bitPairToIndex(nextBits);
        PatriciaNode child = node.getChildren()[index];

        if (child == null) {
            PatriciaNode newNode = new PatriciaNode(key);
            newNode.setEndOfWord(true);
            node.getChildren()[index] = newNode;
        } else {
            insertRecursive(child, key);
        }
    }

    public boolean search(String key) {
        return searchRecursive(getRoot(), key);
    }

    private boolean searchRecursive(PatriciaNode node, String key) {
        if (!key.startsWith(node.getPrefix())) return false;

        key = key.substring(node.getPrefix().length());

        if (key.isEmpty()) return node.isEndOfWord();

        String nextBits = getNextBitPair(key);
        int index = bitPairToIndex(nextBits);
        PatriciaNode child = node.getChildren()[index];

        if (child == null) return false;

        return searchRecursive(child, key);
    }

    public String longestPrefixMatch(String ipBin) {
        return longestPrefixMatchRecursive(getRoot(), ipBin, "", "");
    }

    private String longestPrefixMatchRecursive(PatriciaNode node, String ipBin, String matchedSoFar, String bestMatch) {
        String nodePrefix = node.getPrefix();

        if (!ipBin.startsWith(matchedSoFar + nodePrefix)) {
            return bestMatch;
        }

        matchedSoFar += nodePrefix;

        if (node.isEndOfWord()) {
            bestMatch = matchedSoFar;
        }

        if (matchedSoFar.length() >= ipBin.length()) {
            return bestMatch;
        }

        String nextBits = getNextBitPair(ipBin.substring(matchedSoFar.length()));
        int index = bitPairToIndex(nextBits);
        PatriciaNode child = node.getChildren()[index];

        if (child == null) {
            return bestMatch;
        }

        return longestPrefixMatchRecursive(child, ipBin, matchedSoFar, bestMatch);
    }

    // Utils

    private int commonPrefixLength(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) return i;
        }
        return len;
    }

    private String getNextBitPair(String s) {
        if (s.length() >= 2) return s.substring(0, 2);
        else return s + "0"; // completa com zero à direita
    }

    private int bitPairToIndex(String pair) {
        switch (pair) {
            case "00": return 0;
            case "01": return 1;
            case "10": return 2;
            case "11": return 3;
            default: throw new IllegalArgumentException("Invalid bit pair: " + pair);
        }
    }
}
