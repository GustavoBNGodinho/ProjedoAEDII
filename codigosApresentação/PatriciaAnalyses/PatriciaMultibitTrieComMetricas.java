package PatriciaAnalyses;

public class PatriciaMultibitTrieComMetricas extends PatriciaMultibitTrie implements PatriciaTrieInterface{
    @Override
    public void insert(String binaryString) {
        super.insert(binaryString);
    }

    @Override
    public String longestMatchingPrefix(String binaryString) {
        return super.longestPrefixMatch(binaryString);
    }

    @Override
    public int contarNos() {
        return contarNos(getRoot());
    }

    private int contarNos(PatriciaNode node) {
        if (node == null) return 0;
        int total = 1;
        for (PatriciaNode filho : node.getChildren()) {
            total += contarNos(filho);
        }
        return total;
    }

    @Override
    public int altura() {
        return altura(getRoot());
    }

    private int altura(PatriciaNode node) {
        if (node == null) return -1;
        int max = -1;
        for (PatriciaNode filho : node.getChildren()) {
            max = Math.max(max, altura(filho));
        }
        return 1 + max;
    }

    @Override
    public double tempoMedioDeBusca(String[] consultas) {
        long total = 0;
        for (String ip : consultas) {
            long ini = System.nanoTime();
            longestMatchingPrefix(ip);
            total += System.nanoTime() - ini;
        }
        return total / (double) consultas.length;
    }

    @Override
    public long tempoDeConstrucao(String[] prefixos) {
        long ini = System.nanoTime();
        for (String p : prefixos) {
            insert(p);
        }
        return System.nanoTime() - ini;
    }
}
