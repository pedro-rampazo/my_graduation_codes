#include <stdlib.h>
#include <stdio.h>

int factorial(int num){
    if(num == 0){
        return 1;
    }
    return num * factorial(num - 1); // Recursive Function
}

int main(){
    int num;
    printf("Factorial: ");
    scanf("%d", &num);
    printf("%d! = %d\n", num, factorial(num));
    return 0;
}
