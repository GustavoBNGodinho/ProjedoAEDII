package PatriciaAnalyses;

public class PatriciaTrie {
    private final Node root;
    protected static class Node {
        String label;
        Node zero;
        Node one;
        boolean isEndOfWord;

        Node(String label) {
            this.label = label;
            isEndOfWord = false;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Node getZero() {
            return zero;
        }

        public void setZero(Node zero) {
            this.zero = zero;
        }

        public Node getOne() {
            return one;
        }

        public void setOne(Node one) {
            this.one = one;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }
    }

    public PatriciaTrie() {
        root = new Node("");
    }

    public Node getRoot() {
        return root;
    }

    public void insert(String binaryString) {
        insertRecursive(getRoot(), binaryString);
    }

    private void insertRecursive(Node current, String binaryString) {
        if (binaryString.isEmpty()) {
            current.setEndOfWord(true);
            return;
        }

        char firstBit = binaryString.charAt(0);
        Node child = (firstBit == '0') ? current.getZero() : current.getOne();

        if (child == null) {
            Node newNode = new Node(binaryString);
            newNode.setEndOfWord(true);
            if (firstBit == '0') current.setZero(newNode);
            else current.setOne(newNode);
            return;
        }

        String commonPrefix = longestCommonPrefix(binaryString, child.getLabel());
        if (commonPrefix.length() == child.getLabel().length()) {
            insertRecursive(child, binaryString.substring(commonPrefix.length()));
        } else {
            String childSuffix = child.getLabel().substring(commonPrefix.length());
            String inputSuffix = binaryString.substring(commonPrefix.length());

            Node splitNode = new Node(commonPrefix);
            if (child.getLabel().charAt(commonPrefix.length()) == '0') splitNode.setZero(child);
            else splitNode.setOne(child);
            child.setLabel(childSuffix);

            if (!inputSuffix.isEmpty()) {
                Node newLeaf = new Node(inputSuffix);
                newLeaf.setEndOfWord(true);
                if (inputSuffix.charAt(0) == '0') splitNode.zero = newLeaf;
                else splitNode.setOne(newLeaf);
            } else {
                splitNode.setEndOfWord(true);
            }

            if (firstBit == '0') current.setZero(splitNode);
            else current.setOne(splitNode);
        }
    }

    public String longestMatchingPrefix(String binaryString) {
        Node current = getRoot();
        StringBuilder matched = new StringBuilder();
        StringBuilder lastValid = new StringBuilder();

        while (current != null) {
            if (!binaryString.startsWith(current.getLabel())) break;

            matched.append(current.getLabel());
            binaryString = binaryString.substring(current.getLabel().length());

            if (current.isEndOfWord()) {
                lastValid.setLength(0);
                lastValid.append(matched);
            }

            if (binaryString.isEmpty()) break;

            current = (binaryString.charAt(0) == '0') ? current.getZero() : current.getOne();
        }

        return lastValid.toString();
    }

    private String longestCommonPrefix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < len && s1.charAt(i) ==s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }
}
