#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#define SIZE 10

int array[SIZE];

void * arrayThread(void *arg){
    int *value = (int *)(arg);
    int i;

    if(*value == 1){
        printf("Running Thread One...\n");
        for(i = 0; i < SIZE / 2; i++){
            array[i] = 1;
        }
    }
    else{
        printf("Running Thread Two...\n");
        for(i = SIZE / 2; i < SIZE; i++){
            array[i] = 2;
        }
    }

}

int main(){
    pthread_t t1, t2;
    int arg1 = 1;
    int arg2 = 2;
    int i;

    pthread_create(&t1, NULL, arrayThread, (void *)(&arg1));
    pthread_create(&t2, NULL, arrayThread, (void *)(&arg2));

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    for(i = 0; i < SIZE; i++){
        printf("%d ", array[i]);
    }
    printf("\n");

    return 0;
}