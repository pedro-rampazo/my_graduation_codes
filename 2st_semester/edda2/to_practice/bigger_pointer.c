#include <stdlib.h>
#include <stdio.h>

int main(){
    int x = 32;
    int y = 14;

    if(&x > &y){
        printf("Bigger Pointer: %p - %d", &x, x);
    }else{
        printf("Bigger Pointer: %p - %d", &y, y);
    }

    printf("Memory Adress X: %p \n Memory Adress Y: %p", &x, &y);

    return 0;
}