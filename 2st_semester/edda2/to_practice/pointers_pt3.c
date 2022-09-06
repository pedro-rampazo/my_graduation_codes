#include <stdlib.h>
#include <stdio.h>

int main(){
    int x = 5;
    int *px = &x;

    printf("%p\n", &x);
    printf("%p\n", px);
    printf("%d\n", *px);

    return 0;
}