#include <stdio.h>
#include <stdlib.h>
#define TRUE 0
#define FALSE 1

int qarray[10];

struct queue{
    int length;
    int begin;
    int end;
};

struct queue Qinit(){
    struct queue queue_init;
    queue_init.length = sizeof qarray / sizeof qarray[0];
    queue_init.begin = 0;
    queue_init.end = -1;
    
    return queue_init;
}

int Qisempty(struct queue qarg){
    if(qarg.end == TRUE){
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

struct queue Enqueue(struct queue qarg, int num){
    if(Qisfull(qarg) == TRUE){
        qarg.end = 0;
    }else{
        qarg.end++;
    }
    
    qarray[qarg.end] = num;
    
    return qarg;
}

struct queue Dequeue(struct queue qarg){
    if(Qisempty(qarg) == TRUE){
        printf("There's not element to remove. Empty queue.");
    }else{
        printf("%d\n", qarray[qarg.begin]);
        qarg.begin++;
    }
    
    return qarg;
}
    

int main(){
    struct queue my_queue = Qinit();
    
    for(int i = 0; i < 5; i++){
        my_queue = Enqueue(my_queue, 6);
    }

    my_queue = Dequeue(my_queue);

    printf("Length %d, Begin: %d, End: %d", my_queue.length, my_queue.begin, my_queue.end);
 
    return 0;
}