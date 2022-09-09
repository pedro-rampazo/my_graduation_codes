#include <stdlib.h>
#include <stdio.h>

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
    int number_array[] = {32, 44, 17, 9, 11, 47, 95, 116, 34};
    int length = sizeof number_array / sizeof number_array[0];
    int counter;

    printf("Default Array:\n");
    printArray(number_array, length);
    printf("\n-----------\n");
    
    bubbleSort(number_array, length);

    return 0;
}