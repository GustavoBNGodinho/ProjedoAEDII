package PatriciaAnalyses;
import java.io.*;
import java.util.*;

public class Utils {
    public static String ipParaBinario(String ip) {
        String[] partes = ip.split("\\.");
        StringBuilder bin = new StringBuilder();
        for (String parte : partes) {
            int val = Integer.parseInt(parte);
            String b = String.format("%8s", Integer.toBinaryString(val)).replace(' ', '0');
            bin.append(b);
        }
        return bin.toString();
    }

    public static String[] lerPrefixosDeArquivo(String caminho) throws IOException {
        List<String> prefixos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue;
                if (linha.contains("/")) {
                    String[] partes = linha.split("/");
                    String bin = ipParaBinario(partes[0]);
                    int tamanho = Integer.parseInt(partes[1]);
                    prefixos.add(bin.substring(0, tamanho));
                } else {
                    prefixos.add(ipParaBinario(linha)); // assume /32
                }
            }
        }
        return prefixos.toArray(new String[0]);
    }

    public static String[] lerIpsDeArquivo(String caminho) throws IOException {
        List<String> ips = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    ips.add(ipParaBinario(linha));
                }
            }
        }
        return ips.toArray(new String[0]);
    }
}
