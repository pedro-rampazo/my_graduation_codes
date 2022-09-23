#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define TAM 100000 // Timer: 44.189399

int printArray(int *array, int length_array){
    for(int i = 0; i < length_array; i++){
        printf("%d ", array[i]);
    }
}

int main(){
    int array[TAM];
    int counter;

    srand(time(NULL));

    for(int n = 0; n < TAM; n++){
        array[n] = rand() % TAM * 10;
    }

    printf("Default Array:\n");
    printArray(array, TAM);
    printf("\n----------\n");

    double time_spent = 0.0;
    clock_t begin = clock();

    do{
        counter = 0;

        for(int b = 0; b < TAM; b++){
            int aux = array[b];

            if(array[b] > array[b+1] && b+1 < TAM){
                array[b] = array[b+1];
                array[b+1] = aux;
                counter++;
            }
        }
    }while(counter != 0);

    clock_t end = clock();
    time_spent += (double)(end - begin) / CLOCKS_PER_SEC;

    printf("\nBubble Sort:\n");
    printArray(array, TAM);

    printf("\n\nTimer: %f\n\n", time_spent);

    return 0;
}