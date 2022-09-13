#include <stdio.h>
#include <stdlib.h>
#include "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/edda2/array.h"
#include "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/edda2/resource.h"
#define TAM 10000

void bubbleSortV5(){
    int *p_array;
    int random_number[TAM];
    srand(time(NULL));
    p_array = fillArray(random_number, TAM);
    printArray(bubbleSort(p_array, TAM), TAM); 
}

int main(){
    void (*p_function)();
    p_function = &bubbleSortV5;
    timer(p_function);
    return 0;
}