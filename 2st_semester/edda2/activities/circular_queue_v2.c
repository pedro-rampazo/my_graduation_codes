#include <stdio.h>
#include <stdlib.h>
#define TRUE 0
#define FALSE 1
#define MAX 10

int queue_array[MAX];

struct queue{
    int total;
    int begin;
    int end;
};

struct queue Qinit(){
    struct queue queue_init;
    queue_init.total = 0;
    queue_init.begin = 0;
    queue_init.end = 0;

    return queue_init;
}

int Qisempty(struct queue qarg){
    if(qarg.total == 0){
        return TRUE;
    }else{
        return FALSE;
    }
}

int Qisfull(struct queue qarg){
    if(qarg.total = MAX-1){
        return TRUE;
    }else{
        return FALSE;
    }
}

int add(int idx){
    idx++;
    if(idx > MAX-1){
        idx = 0;
    }
    return idx;
}

int Enqueue(struct queue qarg, int num){
    if(Qisfull == TRUE){
        printf("FULL QUEUE!");
    }else{
        queue_array[qarg.end] = num;
        printf("%d", num);
        qarg.end = add(qarg.end);
        qarg.total++;
    }
}

int Dequeue(struct queue qarg){
    if(Qisempty(qarg) == TRUE){
        printf("EMPTY QUEUE!");
    }else{
        int element = queue_array[qarg.begin];
        qarg.begin = add(qarg.begin);
        qarg.total--;
        return element;
    }
}

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
    printf("CIRCULAR QUEUE OPTIONS:\n[1] QUEUE IS EMPTY\n[2] QUEUE IS FULL\n[3] ENQUEUE\n[4] DEQUEUE\n[0] EXIT\n");
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
                printf("ADD: ");
                scanf("%d", &num_element);
                Enqueue(my_queue, num_element);
                break;
            case 4:
                num_element = Dequeue(my_queue);
                printf("%d", num_element);
                break;
            default:
                printf("INVALID OPTION");
        }

        printf("\n\nCIRCULAR QUEUE OPTIONS:\n[1] QUEUE IS EMPTY\n[2] QUEUE IS FULL\n[3] ENQUEUE\n[4] DEQUEUE\n[0] EXIT\n");
        scanf("%d", &opt);
    }

    return 0;
}