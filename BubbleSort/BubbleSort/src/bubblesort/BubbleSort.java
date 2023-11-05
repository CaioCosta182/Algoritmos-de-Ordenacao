package bubblesort;

import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {

        int tamanhoVetor = 400000;
        int vetor[] = new int[tamanhoVetor];
        int intervaloMin = 1; // VALOR MINIMO DOS NUMEROS ALEATORIOS
        int intervaloMax = 400000; // VALOR MAXIMO DOS NUMEROS ALEATORIOS
        Random random = new Random(12345);
        for (int i = 0; i < tamanhoVetor; i++) {
//GERA UM NUMERO ALEATORIO ENTRE INTERVALO MIN E MAX (inclusive) 
            vetor[i] = random.nextInt(intervaloMax - intervaloMin + 1) + intervaloMin;
        }
        int indice, fim, aux;
// TEMPO DE EXECUCAO INICIA AQUI 
        long startTime = System.nanoTime();
        for (fim = tamanhoVetor - 1; fim > 0; --fim) {
            for (indice = 0; indice < fim; ++indice) {
                if (vetor[indice] > vetor[indice + 1]) {
                    aux = vetor[indice];
                    vetor[indice] = vetor[indice + 1];
                    vetor[indice + 1] = aux;
                }
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime); // TEMPO DE EXECUCAO EM NANOSSEGUNDOS 
        double milliseconds = (double) duration / 1_000_000.0; // CONVERTE EM MILISEGUNDOS 
        System.out.println("Tempo de execucao: " + milliseconds + " milisegundos.");
        for (int i = 0; i < tamanhoVetor; i++) {
            System.out.print(vetor[i] + ""); //IMPRIME O VETOR ORDENADO
        }
    }
}

