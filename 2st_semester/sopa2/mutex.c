#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#define THREADS 40

long shared = 0;
pthread_mutex_t mutex_var; // MUTEX VARIABLE DEClARATION

void *threadFunc(void *arg){
    int a, b;
    for(long j = 0; j < 100000; j++){
        pthread_mutex_lock(&mutex_var); // ENTER CRITICAL SESSION
        a = shared;
        b = 1;
        shared = a + b;
        pthread_mutex_unlock(&mutex_var); // EXIT CRITICAL SESSION
    }
}

int main(){
    pthread_t t[THREADS];
    int s;

    for(int i = 0; i < THREADS; i++){
        s = pthread_create(&t[i], NULL, threadFunc, NULL);
    }

    for(int i = 0; i < THREADS; i++){
        s = pthread_join(t[i], NULL);
    }

    printf("Shared = %ld\n", shared);

    return 0;
}