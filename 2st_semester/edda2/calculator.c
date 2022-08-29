#include <stdlib.h>
#include <stdio.h>

int sum(int value_one, int value_two){
    return value_one + value_two;
}

int multiplication(int multiplier, int multiplicand){
    int result;
    if(multiplicand % 2 != 0){
        result = multiplier;
    }else{
        result = 0;
    }
    for(int i = 1; i < multiplicand; i+=2){
        result += sum(multiplier, multiplier);
    }
    return result;
}

int potentiation(int base, int exponent){
    int result;
    if(exponent % 2 != 0){
        result = base;
    }else{
        result = 1;
    }
    for(int i = 1; i < exponent; i+=2){
        result *= multiplication(base, base);
    }
    return result;
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