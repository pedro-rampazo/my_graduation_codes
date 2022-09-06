#include <stdlib.h>
#include <stdio.h>

int main(){
    int number[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int length = sizeof number / sizeof number[0];

    for(int i = 0; i < length; i++){
        if(number[i] % 2 == 0){
            printf("Number: %d | Memory Adress: %p\n", number[i], &number[i]);
        }
    }

    return 0;
}