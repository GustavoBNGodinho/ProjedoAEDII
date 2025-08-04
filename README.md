# 📘 Projeto: Análise de Árvores Patrícia (Binária vs M-ária)

Projeto realizado durante o curso de **Algoritmos e Estruturas de Dados** na **UFABC**.

Neste trabalho, foi feita uma comparação entre duas implementações de árvores Patrícia:

- 🌳 **Árvore Patrícia Binária**
- 🌲 **Árvore Patrícia M-ária (stride = 2, ou seja, M = 4)**

O código constrói ambas as árvores a partir de uma base de prefixos e realiza testes de busca, exibindo os resultados no terminal para posterior análise.

---

## 📂 Arquivos de Entrada

- **`prefixos.txt`**: Contém **20.000 prefixos de roteamento** utilizados na construção das árvores.  
  Cada prefixo deve estar no formato:
  ```
  xxx.xxx.xxx.xxx/xx
  ```

- **`ips.txt`**: Contém **5.000 endereços IP de destino** para consultas.  
  Cada IP deve estar no formato:
  ```
  xxx.xxx.xxx.xxx
  ```

> ⚠️ Ambos os arquivos podem ser modificados para novos testes, desde que respeitem os formatos acima.

---

## ⚙️ Execução

1. Compile os arquivos `.java`:
   ```bash
   javac *.java
   ```

2. Execute o programa principal:
   ```bash
   java MainTeste
   ```

O programa exibirá:

- Altura da árvore
- Quantidade total de nós
- Tempo de construção
- Tempo médio de busca

Esses dados são úteis para comparação de desempenho e eficiência das estruturas.

---

## 📁 Código-Fonte

Todos os códigos-fonte estão disponíveis neste repositório para consulta, modificação e compilação.

---

## 🧪 Observações

- Os testes foram realizados com foco na **eficiência de busca** e **uso de memória**, utilizando ferramentas como **VisualVM**.
- Caso deseje utilizar o **JMC (Java Mission Control)** para análise de consumo de memória, é possível rodar o código com a flag de gravação JFR:
   ```bash
   java -XX:StartFlightRecording=filename=recording.jfr,dumponexit=true -cp out MainTeste
   ```
- Ou utilizar os comando de terminal para analisar o arquivo recording.jfr disbonibilizado na pasta out
  ```bash
  jfr print recording.jfr
  ```
---

## 🧑‍🎓 Autor

Desenvolvido por estudante da **UFABC** como parte da disciplina **AED II** (Algoritmos e Estruturas de Dados II).

