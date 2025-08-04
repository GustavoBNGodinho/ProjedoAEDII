package PatriciaAnalyses;

public class PatriciaMultibitTrieTest {
    public static void main(String[] args) {
        PatriciaMultibitTrie trie = new PatriciaMultibitTrie();

       /* trie.insert("0001");
        trie.insert("0010");
        trie.insert("0011");
        trie.insert("1011");
        trie.insert("0000");

        System.out.println(trie.search("0001")); // true
        System.out.println(trie.search("0010")); // true
        System.out.println(trie.search("0011")); // true
        System.out.println(trie.search("1011")); // true
        System.out.println(trie.search("0000")); // true

        System.out.println(trie.search("1111")); // false
        System.out.println(trie.search("001"));  // false

        */
        trie.insert("11000000"); // 192
        trie.insert("1100000010101000"); // 192.168
        trie.insert("110000001010100000000000"); // 192.168.0

        String ip = "11000000101010000000000000000001"; // 192.168.0.1
        String match = trie.longestPrefixMatch(ip);

        System.out.println("Longest prefix match: " + match); // Deve imprimir 192.168.0 em binário
    }
}

