/*
FILA CIRCULAR:
ESSE ALGORITMO REPRESENTA O FUNCIONAMENTO DE UMA FILA CIRCULAR.
ESSE É UMA DAS SOLUÇÕES PARA RENOVAR TODA A ALOCAÇÃO ESTÁTICA, SEM QUE HAJA PERDAS.

AUTOR: PEDRO MARCOLINO RAMPAZO (SP3100065)
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define TRUE 0
#define FALSE 1
#define MAX 10

int queue_array[MAX];

// ESTRUTURA DA FILA
struct queue{
    int total;
    int begin;
    int end;
};

// INICIALIZAÇÃO DA FILA CIRCULAR
struct queue Qinit(){
    struct queue queue_init;
    queue_init.total = 0;
    queue_init.begin = 0;
    queue_init.end = -1;

    return queue_init;
}

// FUNÇÃO VERIFICADORA DE FILA VAZIA
int Qisempty(struct queue qarg){
    if(qarg.total == 0){
        return TRUE;
    }else{
        return FALSE;
    }
}

// FUNÇÃO VERIFICADORA DE FILA CHEIA
int Qisfull(struct queue qarg){
    if(qarg.total == MAX){
        return TRUE;
    }else{
        return FALSE;
    }
}

// FUNÇÃO QUE RETORNA O PRÓXIMO ÍNDICE A SER USADO NA FILA
int add(int idx){
    idx++;
    if(idx > MAX-1){
        idx = 0;
    }
    return idx;
}

// FUNÇÃO QUE ENFILEIRA NÚMEROS ALEATÓRIOS NA FILA
struct queue Enqueue(struct queue qarg){
    if(Qisfull(qarg) == TRUE){
        printf("FULL QUEUE!");
    }else{
        qarg.end = add(qarg.end);
        srand(time(NULL));
        queue_array[qarg.end] = rand() % (MAX*10);
        printf("[ %d ]", queue_array[qarg.end]);
        qarg.total++;
    }
    return qarg;
}

// FUNÇÃO QUE DESENFILEIRA ELEMENTOS DA FILA
struct queue Dequeue(struct queue qarg){
    if(Qisempty(qarg) == TRUE){
        printf("EMPTY QUEUE!");
    }else{
        printf("[ %d ]", queue_array[qarg.begin]);
        qarg.begin = add(qarg.begin);
        qarg.total--;
    }
    return qarg;
}

// FUNÇÃO QUE IMPRIME VALORES BOOLEANOS
int printBoolValue(int bool_value){
    if(bool_value == TRUE){
        printf("TRUE");
    }else{
        printf("FALSE");
    }
}

int main(){
    int opt, num_element;
    struct queue my_queue = Qinit();

    printf("CIRCULAR QUEUE INITIALIZED.\n");
    printf("CIRCULAR QUEUE OPTIONS:\n[1] QUEUE IS EMPTY\n[2] QUEUE IS FULL\n[3] ENQUEUE\n[4] DEQUEUE\n[0] EXIT\n"); // MENU DE OPÇÕES DA FILA CIRCULAR
    scanf("%d", &opt);

    while(opt != 0){
        switch(opt){
            case 1: // PRIMEIRA OPÇÃO DA FILA CIRCULAR - FUNÇÃO QISEMPTY()
                printBoolValue(Qisempty(my_queue));
                break;
            case 2: // SEGUNDA OPÇÃO DA FILA CIRCULAR - FUNÇÃO QISFULL()
                printBoolValue(Qisfull(my_queue));
                break;
            case 3: // TERCEIRA OPÇÃO DA FILA CIRCULAR - FUNÇÃO ENQUEUE()
                my_queue = Enqueue(my_queue);
                break;
            case 4: // QUARTA OPÇÃO DA FILA CIRCULAR - FUNÇÃO DEQUEUE()
                my_queue = Dequeue(my_queue);
                break;
            default:
                printf("INVALID OPTION");
        }

        printf("\n\nCIRCULAR QUEUE OPTIONS:\n[1] QUEUE IS EMPTY\n[2] QUEUE IS FULL\n[3] ENQUEUE\n[4] DEQUEUE\n[0] EXIT\n");
        scanf("%d", &opt);
    }

    return 0;
}