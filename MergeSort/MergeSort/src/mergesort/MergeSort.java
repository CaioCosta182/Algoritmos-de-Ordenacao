package mergesort;

import java.util.Random;

/**
 *
 * @author caiocosta
 */
public class MergeSort {

    public static void main(String[] args) {
        int tamanhoVetor = 500000;
        int vetor[] = new int[tamanhoVetor];
        int intervaloMin = 1; // VALOR MINIMO DOS NUMEROS ALEATORIOS
        int intervaloMax = 500000; // VALOR MAXIMO DOS NUMEROS ALEATORIOS
        Random random = new Random(12345);
        for (int i = 0; i < tamanhoVetor; i++) {
// GERA UM NUMERO ALEATORIO ENTRE INTERVALO MIN E MAX (inclusive) 
            vetor[i] = random.nextInt(intervaloMax - intervaloMin + 1) + intervaloMin;
        }
// TEMPO DE EXECUCAO INICIA AQUI 
        long startTime = System.nanoTime();
// CHAMA A FUNCAO MERGESORT PARA ORDENAR O VETOR 
        mergeSort(vetor, 0, tamanhoVetor - 1);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime); // TEMPO DE EXECUCAO EM NANOSSEGUNDOS 
        double milliseconds = (double) duration / 1_000_000.0; // CONVERTE EM MILISEGUNDOS 
        System.out.println("Tempo de execucao: " + milliseconds + " milisegundos.");

// IMPRIME O VETOR ORDENADO 
//        for (int i = 0; i < tamanhoVetor; i++) {
//            System.out.print(vetor[i] + " ");
 //       }
    }

    public static void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
// CHAMA O MERGESORT RECURSIVAMENTE PARA A METADE ESQUERDA E DIREITA DO VETOR 
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
// CHAMA A FUNCAO MERGE PARA COMBINAR E ORDENAR AS DUAS METADES
            merge(vetor, inicio, meio, fim);
        }
    }

    public static void merge(int[] vetor, int inicio, int meio, int fim) {
        int indiceEsquerdo = inicio, indiceDireito = meio + 1, indiceAuxiliar = 0;
// CRIA UM VETOR AUXILIAR PARA ARMAZENAR OS VALORES ORDENADOS 
        int[] vetorAuxiliar = new int[fim - inicio + 1];
        while (indiceEsquerdo <= meio && indiceDireito <= fim) {
            if (vetor[indiceEsquerdo] <= vetor[indiceDireito]) {
                vetorAuxiliar[indiceAuxiliar] = vetor[indiceEsquerdo];
                indiceEsquerdo++;
            } else {
                vetorAuxiliar[indiceAuxiliar] = vetor[indiceDireito];
                indiceDireito++;
            }
            indiceAuxiliar++;
        }
// COPIA OS ELEMENTOS RESTANTES DA PRIMEIRA METADE (SE HOUVER) 
        while (indiceEsquerdo <= meio) {
            vetorAuxiliar[indiceAuxiliar] = vetor[indiceEsquerdo];
            indiceAuxiliar++;
            indiceEsquerdo++;
        }
// COPIA OS ELEMENTOS RESTANTES DA SEGUNDA METADE (SE HOUVER) 
        while (indiceDireito <= fim) {
            vetorAuxiliar[indiceAuxiliar] = vetor[indiceDireito];
            indiceAuxiliar++;
            indiceDireito++;
        }
// MOVE OS ELEMENTOS ORDENADOS DE VOLTA PARA O VETOR ORIGINAL 
        for (indiceAuxiliar = inicio; indiceAuxiliar <= fim; indiceAuxiliar++) {
            vetor[indiceAuxiliar] = vetorAuxiliar[indiceAuxiliar - inicio];
        }
    }
}
