#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define TRUE 0
#define FALSE 1
#define MAX 10

int queue_array[MAX];

struct queue{
    int length;
    int begin;
    int end;
};

struct queue Qinit(){
    struct queue queue_init;
    queue_init.length = MAX;
    queue_init.begin = -1;
    queue_init.end = -1;

    return queue_init;
}

int Qisempty(struct queue qarg){
    if(qarg.end == qarg.begin){
        return TRUE;
    }else{
        return FALSE;
    }
}

int Qisfull(struct queue qarg){
    if(qarg.end == qarg.length - 1){
        return TRUE;
    }else{
        return FALSE;
    }
}

struct queue Enqueue(struct queue qarg, int quantity){
    srand(time(NULL));
    for(int i = 0; i < quantity; i++){
        if(Qisfull(qarg) == TRUE){
            qarg.end = 0;
        }else{
            qarg.end++;
        }
        if(qarg.end == qarg.begin){
            if(qarg.begin == MAX-1){
                qarg.begin = 0;
            }
            else{
                qarg.begin++;
            }
        }
        queue_array[qarg.end] = rand() % (MAX*10);
    }
    return qarg;
}

struct queue Dequeue(struct queue qarg){
    if(Qisempty(qarg) == TRUE){
        printf("EMPTY QUEUE!");
    }else{
        printf("%d\n", queue_array[qarg.begin]);
        qarg.begin++;
    }
    return qarg;
}

printBoolValue(int bool_value){
    if(bool_value == TRUE){
        printf("TRUE");
    }else{
        printf("FALSE");
    }
}

int main(){
    int opt, qtt;
    struct queue my_queue = Qinit();

    printf("CIRCULAR QUEUE INITIALIZED.\n");
    printf("CIRCULAR QUEUE OPTIONS:\n[1] QUEUE IS EMPTY\n[2] QUEUE IS FULL\n[3] ENQUEUE\n[4] DEQUEUE\n[5] PRINT QUEUE\n[0] EXIT\n");
    scanf("%d", &opt);

    while(opt != 0){
        switch(opt){
            case 1:
                printBoolValue(Qisempty(my_queue));
                break;
            case 2:
                printBoolValue(Qisfull(my_queue));
                break;
            case 3:
                printf("HOW MANY NUMBERS TO ADD? ");
                scanf("%d", &qtt);
                my_queue = Enqueue(my_queue, qtt);
                break;
            case 4:

                break;
            case 5:
                break;
            case 6:
                break;
            default:
        }

        printf("\n\nCIRCULAR QUEUE OPTIONS:\n[1] QUEUE IS EMPTY\n[2] QUEUE IS FULL\n[3] ENQUEUE\n[4] DEQUEUE\n[5] PRINT QUEUE\n[0] EXIT\n");
        scanf("%d", &opt);
    }
    

    return 0;
}