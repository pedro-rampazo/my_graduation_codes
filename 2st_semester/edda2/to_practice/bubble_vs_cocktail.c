#include <stdio.h>
#include <stdlib.h>
// Bubble Sort: 8
// Cocktail Sort: 4

int main(){
    int array[] = {7, 3, 9, 1, 6, 2, 8, 0, 4, 5};
    int counter, aux;

    for(int i = 0; i < 10; i++){
        printf("%d ", array[i]);
    }
    
    printf("\n");

    do{
        counter = 0;
        
        for(int c = 0; c < 10; c++){
            aux = array[c];
            if(array[c] > array[c+1] && c+1 < 10){
                array[c] = array[c+1];
                array[c+1] = aux;
                counter++;
            }
        }

        for(int x = 9; x > -1; x--){
            aux = array[x];

            if(array[x] < array[x-1] && x-1 > -1){
                array[x] = array[x-1];
                array[x-1] = aux;
                counter++;
            }            
        }
        printf("+1");
    }while(counter != 0);

    printf("\n");

    for(int x = 0; x < 10; x++){
        printf("%d ", array[x]);
    }
    
    return 0;
}