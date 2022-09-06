#include <stdlib.h>
#include <stdio.h>

int sum(int value_one, int value_two){
    return value_one + value_two;
}

int multiplication(int multiplier, int multiplicand){
    if(multiplicand == 1){
        return multiplier;
    }
    return sum(multiplier, multiplication(multiplier, multiplicand - 1));
}

int potentiation(int base, int exponent){
    if(exponent == 1){
        return base;
    }
    return multiplication(base, potentiation(base, exponent - 1));
}

int main(){
    int num1, num2;
    printf("Type two numbers: ");
    scanf("%d %d", &num1, &num2);
    printf("Sum: %d + %d = %d\n", num1, num2, sum(num1, num2));
    printf("Multiplication: %d * %d = %d\n", num1, num2, multiplication(num1, num2));
    printf("Potentiation: %d ^ %d = %d\n", num1, num2, potentiation(num1, num2));
    return 0;
}