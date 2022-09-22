#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/edda2/array.h"
#include "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/edda2/resource.h"
#define TAM 100000 // Timer: 47.200114 (FOR structure) | Timer: 47.512797 (GOTO structure)

int main(){
    int *p_array;
    int random_number[TAM];
    int * (*p_bubble_sort)(int *, int);
    
    srand(time(NULL));
    p_array = fillArray(random_number, TAM);

    printf("Default Array:\n");
    printArray(p_array, TAM);
    printf("\n----------\n");
    

    p_bubble_sort = &bubbleSort;
    timer(p_bubble_sort, p_array, TAM);

    return 0;
}