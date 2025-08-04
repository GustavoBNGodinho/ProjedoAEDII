package PatriciaAnalyses;

public interface PatriciaTrieInterface {
    void insert(String binaryString);
    String longestMatchingPrefix(String binaryString);
    int contarNos();
    int altura();
    double tempoMedioDeBusca(String[] consultas);
    long tempoDeConstrucao(String[] prefixos);
}
