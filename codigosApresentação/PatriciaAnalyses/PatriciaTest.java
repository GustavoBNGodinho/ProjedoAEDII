package PatriciaAnalyses;

public class PatriciaTest {
    public static void main(String[] args) {
        PatriciaTrie trie = new PatriciaTrie();

        // Inserindo prefixos binários simulando IPs em formato binário (simplificados)
        trie.insert("1100");
        trie.insert("1101");
        trie.insert("111");
        trie.insert("0");

        // Testando destinos (prefix match)
        test(trie, "110011"); // Deve bater "1100"
        test(trie, "11101");  // Deve bater "111"
        test(trie, "110");    // Nenhum completo, retorna ""
        test(trie, "0");      // Deve bater "0"
        test(trie, "011");    // Deve bater "0"
        test(trie, "100");    // Nada
    }

    private static void test(PatriciaTrie trie, String binaryInput) {
        String result = trie.longestMatchingPrefix(binaryInput);
        System.out.println("Entrada: " + binaryInput + " -> Prefixo mais longo: " + result);
    }
}
