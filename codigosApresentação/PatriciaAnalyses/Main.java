package PatriciaAnalyses;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String caminhoPrefixos = "prefixos.txt"; // Substitua pelo caminho correto
        String caminhoConsultas = "ips.txt";     // Substitua pelo caminho correto

        String[] prefixos = Utils.lerPrefixosDeArquivo(caminhoPrefixos);
        String[] consultas = Utils.lerIpsDeArquivo(caminhoConsultas);

        PatriciaTrieInterface arvBin = new PatriciaTrieComMetricas();
        PatriciaTrieInterface arvM4 = new PatriciaMultibitTrieComMetricas();

        long tempoBin = arvBin.tempoDeConstrucao(prefixos);
        long tempoM4 = arvM4.tempoDeConstrucao(prefixos);
	
        System.out.println("=== RESULTADOS ===");
        System.out.println("\n[Árvore Patrícia Binária]");
        System.out.println("Altura: " + arvBin.altura());
        System.out.println("Nós: " + arvBin.contarNos());
        System.out.println("Tempo de construção: " + tempoBin + " ns");
        System.out.println("Tempo médio de busca: " + arvBin.tempoMedioDeBusca(consultas) + " ns");
	
        System.out.println("\n[Árvore Patrícia M=4]");
        System.out.println("Altura: " + arvM4.altura());
        System.out.println("Nós: " + arvM4.contarNos());
        System.out.println("Tempo de construção: " + tempoM4 + " ns");
        System.out.println("Tempo médio de busca: " + arvM4.tempoMedioDeBusca(consultas) + " ns");
        
        System.out.println("pressione ENTER para sair...");
        System.in.read();
    }
}
