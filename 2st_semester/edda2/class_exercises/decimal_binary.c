#include <stdio.h>
#include <stdlib.h>

int counter = 0;
int binary_array[] = {};

int push(int num){
    binary_array[counter] = num;
    counter++;
}

int main(){
    int decimal;

    printf("Decimal Number: ");
    scanf("%d", &decimal); 

    while(decimal >= 2){
        push(decimal%2);
        decimal /= 2;
        if(decimal == 1){
            push(decimal);
        }
    }

    for(int i = counter-1; i > -1; i--){
        printf("%d", binary_array[i]); 
    }

    return 0;
}