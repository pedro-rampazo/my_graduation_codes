#include <stdlib.h>
#include <stdio.h>
#define TAM 100

int printArray(int *arr, int len){
    for(int x = 0; x < len; x++){
        printf("%d ", arr[x]);
    }
}

int bubbleSort(int *arr, int len){
    int counter;

    do{
        counter = 0;
        
        for(int i = 0; i < len; i++){
            int aux = arr[i];
            
            if(arr[i] > arr[i+1] && i+1 < len){
                arr[i] = arr[i+1];
                arr[i+1] = aux;
                counter++;
            }

        }
        
    }while(counter != 0);

    printf("Array with Bubble Sort:\n");
    printArray(arr, len);

}

int main(){
    int arr[TAM];

    for(int i = 0; i < TAM; i++){
        arr[i] = rand() % TAM;
    }

    printArray(arr, TAM);
    printf("----------\n");

    bubbleSort(arr, TAM);


    return 0;
}