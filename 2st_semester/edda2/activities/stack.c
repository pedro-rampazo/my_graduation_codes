/*
PILHA:
ESSE ALGORITMO REPRESENTA O FUNCIONAMENTO DE UMA PILHA.
POSSUI OS CONCEITOS DE FIFO (FIRST-IN FIRST-OUT)

AUTOR: PEDRO MARCOLINO RAMPAZO (SP3100065)
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX 10

int array[MAX];
int top = -1;
int *p_array;

// FUNÇÃO DE IMPRESSÃO DA PILHA
int printArray(int *array, int length){
    printf("[ ");
    for(int i = 0; i < length; i++){
        printf("%d ", array[i]);
    }
    printf("]\n");
}

// FUNÇÃO DE ADIÇÃO DE ELEMENTOS NA PILHA
int push(int quantity_number){
    srand(time(NULL));
    for(int i = 0; i < quantity_number; i++){
        if(top == MAX-1){
            printf("FULL STACK!");
            break;
        }
        else{
            top++;
            array[top] = rand() % (MAX*10);
        }
    }
    printArray(array, top+1);
}

// FUNÇÃO DE SUBTRAÇÃO DE UM ELEMNTO DA PILHA
int pop(){
    if(top < 0){
        printf("EMPTY STACK!");
    }
    else{
        printf("[ %d ]\n", array[top]);
        top--;
    }
}

int main(){
    int opt, qtt;

    printf("STACK OPTIONS:\n[1] PUSH\n[2] POP\n[3] PRINT STACK\n[0] EXIT\n"); // MENU DE OPÇÕES DA PILHA
    scanf("%d", &opt);

    while(opt != 0){
        switch(opt){
            case 1: // PRIMEIRA OPÇÃO DO MENU - FUNÇÃO PUSH
                printf("HOW MANY NUMBERS TO ADD? "); // PERGUNTA AO USUÁRIO QUANTOS ELEMENTO DESEJA ADICIONAR NA PILHA
                scanf("%d", &qtt);
                push(qtt);
                break;
            case 2: // SEGUNDA OPÇÃO DO MENU - FUNÇÃO POP (ELIMINA APENAS UM ELEMENTO POR VEZ)
                pop();
                break;
            case 3: // TERCEIRA OPÇÃO DO MENU - IMPRESSÃO DA PILHA
                printArray(array, top+1);
                break;
            default:
                printf("INVALID OPTION.");
        }
        printf("\n\nSTACK OPTIONS:\n[1] PUSH\n[2] POP\n[3] PRINT STACK\n[0] EXIT\n"); // MENU DE OPÇÕES DA PILHA
        scanf("%d", &opt);
    }
    return 0;
}