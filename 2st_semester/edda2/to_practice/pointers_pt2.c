#include <stdlib.h>
#include <stdio.h>

void funct(int *py){
    (*py)++;
    printf("%d\n", *py);
}

int main(){
    int x = 5;
    printf("%d\n", x);
    funct(&x);
    printf("%d\n", x);

    return 0;
}