/*
COCKTAIL SORT:
ESSE ALGORITMO REPRESENTA UM TIPO DE ORDENAÇÃO CHAMADO 'COCKTAIL SORT'.
ELE É CONHECIDO COMO UM 'BUBBLE SORT BIDIRECIONAL', ISSO SE DEVE AO FATO
DE APLICAR A ORDENAÇÃO PERCORRENDO O ARRAY NA IDA E NA VOLTA

AUTOR: PEDRO MARCOLINO RAMPAZO (SP3100065)
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define TAM 100

// FUNÇÃO PARA IMPRESSÃO DO ARRAY
int printArray(int *array, int length){
    int i;
    for(i = 0; i < length; i++){
        printf("%d ", array[i]);
    }
}

// FUNÇÃO DE PREENCHIMENTO DE VALORES ALEATÓRIOS NO ARRAY
int *fillArray(int *array, int length){
    int i;
    for(i = 0; i < length; i++){
        array[i] = rand() % length * 10;
    }
    return array;
}

int main(){
    int *p_array;
    int random_array[TAM], counter, aux, c, x;

    srand(time(NULL));
    p_array = fillArray(random_array, TAM); // PREENCHENDO O ARRAY

    printf("DEFAULT ARRAY:\n");
    printArray(p_array, TAM); // IMPRIMINDO O ARRAY SEM ORDENAÇÃO
    printf("\n----------\n");

    // INICIANDO TEMPO
    double time_spent = 0.0;
    clock_t begin = clock();

    // NÚCLEO DA ORDENAÇÃO COCKTAIL SORT
    cocktail_sort:
        counter = 0;
        c = 0;
        x = TAM - 1;

        // ORDENAÇÃO DE IDA
        going_loop:
            aux = p_array[c];
            if(p_array[c] > p_array[c+1] && c+1 < TAM){
                p_array[c] = p_array[c+1];
                p_array[c+1] = aux;
                counter++;
            }
            if(c+1 < TAM){
                c++;
                goto going_loop;
            }

        // ORDENAÇÃO DE VOLTA
        back_loop:
            aux = p_array[x];
            if(p_array[x] < p_array[x-1] && x-1 > -1){
                p_array[x] = p_array[x-1];
                p_array[x-1] = aux;
                counter++;
            }
            if(x-1 > -1){
                x--;
                goto back_loop;
            }

        if(counter > 0){
            goto cocktail_sort;
        }
    
    // FINALIZAÇÃO DO TEMPO
    clock_t end = clock();
    time_spent += (double)(end - begin) / CLOCKS_PER_SEC;

    printf("COCKTAIL SORT:\n");
    printArray(p_array, TAM); // IMPRESSÃO DO ARRAY COM ORDENAÇÃO
    printf("\n\nTIMER: %f\n\n", time_spent); // IMPRESSÃO DO TEMPO DE EXECUÇÃO

    return 0;
}