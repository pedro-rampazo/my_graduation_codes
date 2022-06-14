#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

int main(){
    int number, multiplier = 1;

    printf("Enter with a number: ");
    scanf("%d", &number);

    do{
        printf("%d X %d = %d\n", number, multiplier, multiplier*number);
        multiplier++;
    }
    while(multiplier <= 10);

    return 0;
}
