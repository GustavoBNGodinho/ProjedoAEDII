package PatriciaAnalyses;

public class PatriciaTrieComMetricas extends PatriciaTrie implements PatriciaTrieInterface {
    @Override
    public int contarNos() {
        return contarNos(getRoot());
    }

    private int contarNos(Node node) {
        if (node == null) return 0;
        return 1 + contarNos(node.getZero()) + contarNos(node.getOne());
    }

    @Override
    public int altura() {
        return altura(getRoot());
    }

    private int altura(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(altura(node.getZero()), altura(node.getOne()));
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

