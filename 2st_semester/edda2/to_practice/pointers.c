#include <stdlib.h>
#include <stdio.h>

int funct(int y){
        y++;
        return y;
    }

int main(){
    int x = 5;
    printf("%d\n", x);
    printf("%d\n", funct(x));
    printf("%d\n", x);
    return 0;
}