/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifmg.prog4.tp1;

import java.util.ArrayList;
import java.util.List;

public class ListaMusicas {
    private List<Musica> musicas;
    
    public ListaMusicas() {
        musicas = new ArrayList<>();
    }

    public void add(Musica musica) {
        musicas.add(musica);
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
    
    public List<Musica> selectionSort(String atributo) {
        int tamanho = musicas.size();
        int comparacoes = 0, trocas = 0;
        
        for (int i = 0; i < tamanho - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tamanho; j++) {
                comparacoes++;
                
                if("nome".equals(atributo)) {
                    if (musicas.get(j).compareToTrackName(musicas.get(minIndex)) < 0) {
                        minIndex = j;
                    } 
                }else if("artista".equals(atributo)) {
                    if (musicas.get(j).compareToArtistName(musicas.get(minIndex)) < 0) {
                        minIndex = j;
                    }
                }
                    
                
            }
            trocas++;
            Musica temp = musicas.get(minIndex);
            musicas.set(minIndex, musicas.get(i));
            musicas.set(i, temp);
        }
        
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Número de trocas: " + trocas);
        return musicas;
    }
    
    public List<Musica> insertionSort(String atributo) {
        int comparacoes = 0, trocas = 0;
                
        for (int i = 1; i < musicas.size(); i++) {
            Musica chave = musicas.get(i);
            int j = i - 1;
            
            if("nome".equals(atributo)) {
                while (j >= 0 && musicas.get(j).compareToTrackName(chave) > 0) {
                    musicas.set(j + 1, musicas.get(j));

                    j--;
                    comparacoes++;
                    trocas++;
                }
                musicas.set(j + 1, chave);
            }else if("artista".equals(atributo)) {
                while (j >= 0 && musicas.get(j).compareToArtistName(chave) > 0) {
                    musicas.set(j + 1, musicas.get(j));

                    j--;
                    comparacoes++;
                    trocas++;
                }
                musicas.set(j + 1, chave);
            }
        }
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Número de trocas: " + trocas);
        return musicas;
    }
   
    public List<Musica> shellSort(String atributo) {
        int comparacoes = 0, trocas = 0;
        
        int size = musicas.size();
        
        int h = 1;
        
        while (h < size/3)
            h = h * 3 + 1;
        
        while(h >= 1) {
            for(int i = h; i < size; i++) {
                Musica aux = musicas.get(i);
                int j = i;
                
                if(atributo.equals("nome")) {
                    while(j >= h && musicas.get(j-h).compareToTrackName(aux) > 0) {
                        musicas.set(j, musicas.get(j-h));
                        j = j - h;
                        comparacoes++;
                        trocas++;
                    }
                }else if(atributo.equals("artista")) {
                    while(j >= h && musicas.get(j-h).compareToArtistName(aux) > 0) {
                        musicas.set(j, musicas.get(j-h));
                        j = j - h;
                        comparacoes++;
                        trocas++;
                    }
                }
                
                musicas.set(j, aux);
            }
            
            h = (h-1)/3;
        }
        
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Número de trocas: " + trocas);
        return musicas;
    }
    
    public List<Musica> quickSort(String atributo, int inicio, int fim) {
        int[] counts = {0, 0};
        quickSort(atributo, inicio, fim, counts);
        
        System.out.println("Número de comparações: " + counts[0]);
        System.out.println("Número de trocas: " + counts[1]);
    
        return musicas;
    }
    
    public void quickSort(String atributo, int inicio, int fim, int[] counts) {
        if (inicio < fim) {
            int pivo = partition(atributo, inicio, fim, counts);
            quickSort(atributo, inicio, pivo - 1, counts);
            quickSort(atributo, pivo + 1, fim, counts);
        }
    }
    
    private int partition(String atributo, int inicio, int fim, int[] counts) {
        Musica pivo = musicas.get(fim);
        int i = inicio;
        
        for (int j = inicio; j < fim; j++) {
            counts[0]++;
            if("nome".equals(atributo)) {
                if(musicas.get(j).compareToTrackName(pivo) < 0) {  
                    counts[1]++;
                    
                    Musica temp = musicas.get(i);

                    musicas.set(i, musicas.get(j));
                    musicas.set(j, temp);
                    
                    i++;
                }
            }else if("artista".equals(atributo)) {
                if(musicas.get(j).compareToArtistName(pivo) < 0) {   
                    counts[1]++;
                    
                    Musica temp = musicas.get(i);

                    musicas.set(i, musicas.get(j));
                    musicas.set(j, temp);
                    
                    i++;
                }
            }
        }
        
        counts[1]++;
        Musica temp = musicas.get(i);
        musicas.set(i, musicas.get(fim));
        musicas.set(fim, temp);
        
        return i;
    }
    
    public List<Musica> mergeSort(String atributo) {
        int[] counts = {0, 0};
        List<Musica> merge = mergeSort(atributo, musicas, counts);
        System.out.println("Número de comparações: " + counts[0]);
        System.out.println("Número de trocas: " + counts[1]);
        return merge;  
    }
    
    public List<Musica> mergeSort(String atributo, List<Musica> lista, int[] counts) {
        if (lista.size() <= 1) {
            return lista;
        }

        int meio = lista.size() / 2;
        List<Musica> listaEsquerda = new ArrayList<>(lista.subList(0, meio));
        List<Musica> listaDireita = new ArrayList<>(lista.subList(meio, lista.size()));

        listaEsquerda = mergeSort(atributo, listaEsquerda, counts);
        listaDireita = mergeSort(atributo, listaDireita, counts);

        merge(listaEsquerda, listaDireita, lista, atributo, counts);
        return lista;
    }

    private void merge(List<Musica> listaEsquerda, List<Musica> listaDireita, List<Musica> lista, String atributo, int[] counts) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < listaEsquerda.size() && j < listaDireita.size()) {
            counts[0]++;
            if (atributo.equals("nome")) {
                if (listaEsquerda.get(i).compareToTrackName(listaDireita.get(j)) <= 0) {
                    lista.set(k++, listaEsquerda.get(i++));
                    counts[1]++;
                } else {
                    lista.set(k++, listaDireita.get(j++));
                    counts[1]++;
                }
            } else if (atributo.equals("artista")) {
                if (listaEsquerda.get(i).compareToArtistName(listaDireita.get(j)) <= 0) {
                    lista.set(k++, listaEsquerda.get(i++));
                    counts[1]++;
                } else {
                    lista.set(k++, listaDireita.get(j++));
                    counts[1]++;
                }
            }
        }

        while (i < listaEsquerda.size()) {
            counts[0]++;
            lista.set(k++, listaEsquerda.get(i++));
            counts[1]++;
        }

        while (j < listaDireita.size()) {
            counts[0]++;
            lista.set(k++, listaDireita.get(j++));
            counts[1]++;
        }

    }

    public List<Musica> bubbleSort(String atributo) {
        int comparacoes = 0, trocas = 0;
        int size = musicas.size();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size-i-1); j++) {
                comparacoes++;
                if(atributo.equals("nome")) {
                    if(musicas.get(j).compareToTrackName(musicas.get(j+1)) > 0) {
                        trocas++;
                        Musica temp = musicas.get(j);
                        musicas.set(j, musicas.get(j+1));
                        musicas.set(j+1, temp);
                    }
                }else if(atributo.equals("artista")) {
                    if(musicas.get(j).compareToArtistName(musicas.get(j+1)) > 0) {
                        trocas++;
                        Musica temp = musicas.get(j);
                        musicas.set(j, musicas.get(j+1));
                        musicas.set(j+1, temp);
                    }
                }
            }
        }
        System.out.println("Número de comparações: " + comparacoes);
        System.out.println("Número de trocas: " + trocas);
        return musicas;
    }
    
    public List<Musica> heapSort(String atributo) {
        int n = musicas.size();
        int[] counts = {0, 0};
        

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i, atributo, counts);
        }

        for (int i = n - 1; i > 0; i--) {
            Musica temp = musicas.get(0);
            musicas.set(0, musicas.get(i));
            musicas.set(i, temp);

            heapify(i, 0, atributo, counts);
        }
        
        System.out.println("Número de comparações: " + counts[0]);
        System.out.println("Número de trocas: " + counts[1]);
        return musicas;
    }

    private void heapify(int n, int raiz, String atributo, int[] counts) {
        int maior = raiz;
        int esquerda = 2 * raiz + 1;
        int direita = 2 * raiz + 2;

        if (atributo.equals("nome")) {
            if (esquerda < n && musicas.get(esquerda).compareToTrackName(musicas.get(maior)) > 0) {
                maior = esquerda;
                counts[0]++;
            }

            if (direita < n && musicas.get(direita).compareToTrackName(musicas.get(maior)) > 0) {
                maior = direita;
                counts[0]++;
            }
        } else if (atributo.equals("artista")) {
            if (esquerda < n && musicas.get(esquerda).compareToArtistName(musicas.get(maior)) > 0) {
                maior = esquerda;
                counts[0]++;
            }

            if (direita < n && musicas.get(direita).compareToArtistName(musicas.get(maior)) > 0) {
                maior = direita;
                counts[0]++;
            }
        }

        if (maior != raiz) {
            counts[1]++;
            Musica temp = musicas.get(raiz);
            musicas.set(raiz, musicas.get(maior));
            musicas.set(maior, temp);

            heapify(n, maior, atributo, counts);
        }
    }
  
}

