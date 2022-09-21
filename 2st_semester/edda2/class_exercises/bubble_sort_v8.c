#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/edda2/array.h"
#include "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/edda2/resource.h"
#define TAM 10

int main(){
    int *p_array;
    int random_number[TAM];
    int (*bubble_sort)();
    
    srand(time(NULL));
    p_array = fillArray(random_number, TAM);

    bubble_sort = &bubbleSort;
    timer(bubble_sort, p_array, TAM);



    return 0;
}