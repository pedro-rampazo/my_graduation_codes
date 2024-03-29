#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/edda2/array.h"
#include "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/edda2/resource.h"
#define TAM 100000 // Timer: 29.113336

int main(){
    int *p_array;
    int random_array[TAM], counter, aux, c, x;

    srand(time(NULL));
    p_array = fillArray(random_array, TAM);

    printf("Default Array:\n");
    printArray(p_array, TAM);
    printf("\n----------\n");

    double time_spent = 0.0;
    clock_t begin = clock();

    do{
        counter = 0;
        
        for(int c = 0; c < TAM; c++){
            aux = p_array[c];
            if(p_array[c] > p_array[c+1] && c+1 < TAM){
                p_array[c] = p_array[c+1];
                p_array[c+1] = aux;
                counter++;
            }
        }

        for(int x = TAM-1; x > -1; x--){
            aux = p_array[x];

            if(p_array[x] < p_array[x-1] && x-1 > -1){
                p_array[x] = p_array[x-1];
                p_array[x-1] = aux;
                counter++;
            }            
        }

    }while(counter != 0);

    clock_t end = clock();
    time_spent += (double)(end - begin) / CLOCKS_PER_SEC;

    printf("Bubble Sort:\n");
    printArray(p_array, TAM);

    printf("\n\nTimer: %f\n\n", time_spent);

    return 0;    
}