/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ifmg.prog4.tp1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String diretorioAtual = System.getProperty("user.dir");
        Leitor leitor = new Leitor(diretorioAtual + "\\spotify-2023.csv");
        ListaMusicas lista = leitor.lerArquivoCSV();
        
        Scanner in = new Scanner(System.in);

        System.out.println("Escolha o tipo de ordenação: ");
        System.out.println("1. Ordenação por seleção");
        System.out.println("2. Ordenação por inserção");
        System.out.println("3. Ordenação por shellSort");
        System.out.println("4. Ordenação por quickSort");
        System.out.println("5. Ordenação por bubbleSort");
        System.out.println("6. Ordenação por mergeSort");
        System.out.println("7. Ordenação por heapSort");
        int opcaoOrdenacao = in.nextInt();
        
        System.out.println("Escolha o campo de ordenação: ");
        System.out.println("1. Nome do música");
        System.out.println("2. Nome da artista");
        int opcaoCampo = in.nextInt();
        
        long tempoInicial = 0, tempoFinal = 0;

        tempoInicial = System.currentTimeMillis();
        switch (opcaoOrdenacao) {
            case 1 -> {
                // Ordenação por seleção
                switch (opcaoCampo) {
                    case 1 -> lista.selectionSort("nome");
                    case 2 -> lista.selectionSort("artista");
                    default -> System.out.println("Opção inválida.");
                }
            }
            case 2 -> {
                // Ordenação por inserção
                switch (opcaoCampo) {
                    case 1 -> lista.insertionSort("nome");
                    case 2 -> lista.insertionSort("artista");
                    default -> System.out.println("Opção inválida.");
                }
            }
            case 3 -> {
                // Ordenação por shellSort
                switch (opcaoCampo) {
                    case 1 -> lista.shellSort("nome");
                    case 2 -> lista.shellSort("artista");
                    default -> System.out.println("Opção inválida.");
                }
            }
            case 4 -> {
                // Ordenação por quickSort
                switch (opcaoCampo) {
                    case 1 -> lista.quickSort("nome", 0, (lista.getMusicas().size()-1));
                    case 2 -> lista.quickSort("artista", 0, (lista.getMusicas().size()-1));
                    default -> System.out.println("Opção inválida.");
                }
            }
            case 5 -> {
                // Ordenação por bubbleSort
                tempoInicial = System.currentTimeMillis();
                switch (opcaoCampo) {
                    case 1 -> lista.bubbleSort("nome");
                    case 2 -> lista.bubbleSort("artista");
                    default -> System.out.println("Opção inválida.");
                }
            }
            case 6 -> {
                // Ordenação por mergeSort
                tempoInicial = System.currentTimeMillis();
                switch (opcaoCampo) {
                    case 1 -> lista.mergeSort("nome");
                    case 2 -> lista.mergeSort("artista");
                    default -> System.out.println("Opção inválida.");
                }
            }
            case 7 -> {
                //ordenação por heapSort
                tempoInicial = System.currentTimeMillis();
                switch (opcaoCampo) {
                    case 1 -> lista.heapSort("nome");
                    case 2 -> lista.heapSort("artista");
                    default -> System.out.println("Opção inválida.");
                }
                
            }
            default -> System.out.println("Opção de ordenação inválida.");
        }
        
        tempoFinal = System.currentTimeMillis();

        for (Musica musica : lista.getMusicas()) {
            System.out.println(musica);
        }
        
        long tempoExecucao = tempoFinal - tempoInicial;
        System.out.println("Tempo de execução (milissegundos): " + tempoExecucao);
    }
}
