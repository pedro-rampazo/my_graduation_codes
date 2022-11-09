#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX 10

int array[MAX];
int top = 0;
int *p_array;

int printArray(int *array, int length){
    for(int i = 0; i < length; i++){
        printf("%d ", array[i]);
    }
    printf("\n");
}

int push(int quantity_number){
    srand(time(NULL));
    for(int i = 0; i < quantity_number; i++){
        if(top == MAX-1){
            printf("FULL STACK!");
            break;
        }
        else if(top == 0){
            array[top] = rand() % (MAX*10);
            top++;
        }
        else{
            array[top+1] = rand() % (MAX*10);
            top++;
        }
    }
}

int pop(){
    if(top < 0){
        printf("EMPTY STACK!");
    }
    else{
        printf("\n%d\n", array[top]);
        top--;
    }
}

int main(){
    int opt, qtt;

    printf("\n\nSTACK OPTIONS:\n[1] PUSH\n[2] POP\n[3] PRINT STACK\n[0] EXIT\n");
    scanf("%d", &opt);

    while(opt != 0){
        
        switch(opt){
            case 1:
                printf("HOW MANY NUMBERS TO ADD?\n");
                scanf("%d", &qtt);
                push(qtt);
                break;
            case 2:
                pop();
                break;
            case 3:
                printArray(array, top);
                break;
            default:
                printf("INVALID OPTION.");
        }

        printf("STACK OPTIONS:\n[1] PUSH\n[2] POP\n[3] PRINT STACK\n[0] EXIT\n");
        scanf("%d", &opt);
    }

    return 0;
}