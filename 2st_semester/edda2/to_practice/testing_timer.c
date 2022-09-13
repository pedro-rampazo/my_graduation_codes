#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define TAM 10000

void timer(void (*p_function)()){
    double time_spent = 0.0;

    clock_t begin = clock();

    p_function();

    clock_t end = clock();
    time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
    printf("\nTime: %f\n", time_spent);
}

void helloWorld(){
    printf("Hello World");
}

int main(){
    void (*p_hello_world)();
    p_hello_world = &helloWorld;

    timer(p_hello_world);

    return 0;
}
