/*
BUSCA BINÁRIA:
ESSE ALGORITMO REPRESENTA O FUNCIONAMENTO DOS CONCEITOS DA BUSCA BINÁRIA.
NELE, USA-SE O CONCEITO DE 'DIVIDIR E CONQUISTAR'.

AUTOR: PEDRO MARCOLINO RAMPAZO (SP3100065)
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define TAM 10

int *p_array;
int array_search[TAM];

// FUNÇÃO DE IMPRESSÃO DO ARRAY
int printArray(int *array, int length){
    for(int i = 0; i < length; i++){
        printf("%d ", array[i]);
    }
}

// FUNÇÃO PARA O PREENCHIMENTO DO ARRAY COM VALORES
int *fillArray(int *array, int length){
    srand(time(NULL));
    for(int i = 0; i < length; i++){
        array[i] = rand() % (length*10);
    }
    return array;
}

// MÉTODO BUBBLE SORT DE ORDENAÇÃO - USADO PARA ORDENAÇÃO DO ARRAY ANTES DA BUSCA BINÁRIA
int *bubbleSort(int *array, int length){
    int counter;
    do{
        counter = 0;
        for(int i = 0; i < length; i++){
            int aux = array[i];
            if(array[i] > array[i + 1] && i+1 < length){
                array[i] = array[i+1];
                array[i+1] = aux;
                counter++;
            }
        }
    }while(counter != 0);
    return array;
}

// FUNÇÃO QUE POSSUI A LÓGICA DA BUSCA BINÁRIA
int binarySearch(int num){
    int begin = 0;
    int end = TAM - 1;
    int mid = (begin + end) / 2;
    
    while(begin != end || p_array[mid] == num){
        if(p_array[mid] == num){
            return mid;
        }
        if(p_array[mid] < num){
            begin = mid + 1;
        }else{
            end = mid;
        }
        mid = (begin + end) / 2;
    }
    return -1;
}

int main(){
    int target_number; // VARIÁVEL QUE REPRESENTA O VALOR A SER BUSCADO NO ARRAY
    int index; // VARIÁVEL QUE ARMAZENARÁ O ÍNDICE QUE SE ENCONTRA O VALOR BUSCADO NO ARRAY
    int opt; // VARIÁVEL QUE CONTROLA A EXECUÇÃO DO PROGRAMA

    do{
        p_array = fillArray(array_search, TAM); // PREENCHENDO O ARRAY COM NÚMEROS ALEATÓRIOS

        printf("ARRAY:\n");
        p_array = bubbleSort(p_array, TAM); // ORDENANDO O ARRAY
        printArray(p_array, TAM);

        printf("\n\nTYPE A ARRAY NUMBER: "); // SOLICITANDO O NÚMERO A SER BUSCADO NO ARRAY
        scanf("%d", &target_number);

        // INICIALIZANDO O TEMPO
        double time_spent = 0.0;
        clock_t begin = clock();

        index = binarySearch(target_number); // BUSCA BINÁRIA SENDO CHAMADA E RETORNANDO O SEU ÍNDICE

        // FINALIZANDO O TEMPO
        clock_t end = clock();
        time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
    
        if(index != -1){
            printf("INDEX: %d", index); // IMPRESSÃO DO ÍNDICE
        }else{
            printf("INVALID NUMBER.");
        }

        printf("\nTIMER: %f\n", time_spent); // IMPRESSÃO DO TEMPO DE EXECUÇÃO

        printf("\nOPTIONS:\n[1] CONTINUE\n[0] EXIT\n"); // SOLICITAÇÃO DA CONTINUAÇÃO OU INTERRUPÇÃO DO PROGRAMA
        scanf("%d", &opt);

    }while(opt != 0);

    return 0;
}