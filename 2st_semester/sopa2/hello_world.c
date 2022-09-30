#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#define THREAD 10

int sem;

void *printHelloWorld(){
    printf("\n+1 Thread...\n");
    pthread_exit(NULL);
}

int main(){
    pthread_t thread[THREAD];
    int status, i;

    for(i = 0; i < THREAD; i++){
        printf("Método Main. Criando thread %d\n", i);
        status = pthread_create(&thread[i], NULL, printHelloWorld, NULL);

        if(status != 0){
            printf("Error thread creation");
            exit(-1);
        }
    }
    return 0;
}