#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

int main(){
    float a, b;
    char op;

    printf("\n Select operation [+, -, /, *]: ");
    fflush(stdin);
    scanf("%c", &op);

    if(op != '+' && op != '-' && op != '/' && op != '*'){
        printf("Invalid operation.");
    }else{
        printf("\n Type two numbers: \n");
        scanf("%f %f", &a, &b);
        printf("%.1f %c %.1f = ", a, op, b);
        printf("\n %.1f", op == '+' ? a+b : (op == '-' ? a-b : op == '/' ? a/b : op == '*' ? a*b : 404));
    }
    getch();
    return 0;
}
