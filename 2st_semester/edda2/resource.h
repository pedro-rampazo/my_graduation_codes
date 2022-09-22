#include <time.h>
#include <stdio.h>


void timer(int * (*p_function)(int *arr, int len), int *p_array, int length){
    int *p_sort_array;
    double time_spent = 0.0;
    clock_t begin = clock();
    p_sort_array = p_function(p_array, length);
    clock_t end = clock();
    time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
    printArray(p_sort_array, length);
    printf("\nTimer: %f\n", time_spent);
}