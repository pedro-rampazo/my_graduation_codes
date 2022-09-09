#include <stdlib.h>
#include <stdio.h>

int printArray(int *array, int length_array){
    for(int x = 0; x < length_array; x++){
        printf("%d ", array[x]);
    }
}

int main(){
    int number_array[] = {32, 44, 17, 9, 11, 47, 95, 116, 34};
    int length = sizeof number_array / sizeof number_array[0];
    int counter;

    printf("Default Array:\n");
    printArray(number_array, length);
    printf("\n-----------\n");

    do{
        counter = 0;
        
        for(int i = 0; i < length; i++){
            int aux = number_array[i];

            if(number_array[i] > number_array[i + 1] && i+1 < length){
                number_array[i] = number_array[i + 1];
                number_array[i + 1] = aux;
                counter++;
            }
        }

    }while(counter != 0);
    
    printf("Array with Bubble Sort:\n");
    printArray(number_array, length);

    return 0;
}