#include <stdio.h>
#include <stdlib.h>
#include "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/edda2/array.h"
#define TAM 3

int main(){
    int *p_array;
    int random_number[TAM];

    p_array = fillArray(random_number, TAM);

    printArray(p_array, TAM);
    
    return 0;
}
