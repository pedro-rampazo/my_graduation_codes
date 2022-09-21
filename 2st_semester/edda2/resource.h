#include <time.h>
#include <stdio.h>


void timer(int (*p_function)(int *arr, int len), int *p_array, int length){
    double time_spent = 0.0;
    clock_t begin = clock();
    
    p_function(p_array, length)

    clock_t end = clock();
    time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
    printf("\nTimer: %f\n", time_spent);
}