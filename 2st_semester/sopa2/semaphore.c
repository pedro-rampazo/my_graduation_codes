#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <semaphore.h>
#define THREADS 40

long shared = 0;
sem_t semaphore_var; // SEMAPHORE VARIABLE DECLARATION

void *threadFunc(void *arg){
    int a, b;
    for(long j = 0; j < 100000; j++){
        sem_wait(&semaphore_var); // ENTER CRITICAL SESSION
        a = shared;
        b = 1;
        shared = a + b;
        sem_post(&semaphore_var); // EXIT CRITICAL SESSION
    }
}

int main(){
    pthread_t t[THREADS];
    int s;
    sem_init(&semaphore_var, 0, 1); // STARTUP SEMAPHORE
    for(int i = 0; i < THREADS; i++){
        s = pthread_create(&t[i], NULL, threadFunc, NULL);
    }
    for(int i = 0; i < THREADS; i++){
        s = pthread_join(t[i], NULL);
    }
    printf("Shared = %ld\n", shared);
    return 0;
}
