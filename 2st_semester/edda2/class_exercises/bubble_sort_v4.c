#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/edda2/array.h"
#define TAM 1000

int main(){
    int *p_array;
    int random_number[TAM];

    srand(time(NULL));

    p_array = fillArray(random_number, TAM);

    printArray(bubbleSort(p_array, TAM), TAM); 
    
    return 0;
}
