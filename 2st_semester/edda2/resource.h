#include <time.h>
#include <stdio.h>

// MAIN FUNCTION:
// void (*<pointer_name>)();
// <pointer_name> = &<main_function>;
// timer(<pointer_name>);
void timer(void (*p_function)()){
    double time_spent = 0.0;
    clock_t begin = clock();
    p_function();
    clock_t end = clock();
    time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
    printf("\nTimer: %f\n", time_spent);
}