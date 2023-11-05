package insertionsort;

import java.util.Random;

/**
 *
 * @author caiocosta
 */
public class InsertionSort {

    public static void main(String[] args) {
        int tamanhoVetor = 500000;
        int vetor[] = new int[tamanhoVetor];
        int intervaloMin = 1; // VALOR MINIMO DOS NUMEROS ALEATORIOS
        int intervaloMax = 500000; // VALOR MAXIMO DOS NUMEROS ALEATORIOS 
        int ponteiro = 1; // INICIALIZA MARCADOR DE POSICoES
        int indice = 0;
        Random random = new Random(12345);
        for (int i = 0; i < tamanhoVetor; i++) {
// GERA UM NUMERO ALEATORIO ENTRE INTERVALO MIN E MAX (inclusive) 
vetor[i] = random.nextInt(intervaloMax - intervaloMin + 1) + intervaloMin;
        }
// TEMPO DE EXECUCAO INICIA AQUI 
long startTime = System.nanoTime(); while (ponteiro < tamanhoVetor) {
        int aux = vetor[ponteiro]; // ARMAZENA VALOR ATUAL EM AXILIAR
        indice = ponteiro - 1; // INICIALIZA O INDICE COM O VALOR DO MARCADOR DE POSICOES COM DECREMENT
        while ((indice >= 0) && (vetor[indice] > aux)) {
            vetor[indice + 1] = vetor[indice]; // MOVE ELEMENTOS MAIORES PARA A DIREITA 
            indice=indice-1; //DECREMENTAOINDICE
        }
        vetor[indice + 1] = aux; // INSERE O VALOR AUX NA POSICAO CORRETA
        ponteiro = ponteiro + 1;
    }
    long endTime = System.nanoTime();
    long duration = (endTime - startTime); // TEMPO DE EXECUCAO EM NANOSSEGUNDOS 
    double milliseconds = (double) duration / 1_000_000.0; // CONVERTE EM MILISEGUNDOS 
    System.out.println("Tempo de execucao: " + milliseconds + " milisegundos.");
    for (int i = 0;
    i< tamanhoVetor ;
    i

    
        ++) {
System.out.print(vetor[i] + " "); //Imprimeovetorordenado }
    }
}
}
    

