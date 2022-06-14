#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

int main(){
    int cont;
    float base, height, area;

    cont = 0;
    base = 0;
    height = 0;
    area = 0;

    do{
        printf("\n Base: ");
        scanf("%f", &base);

        printf("\n Height: ");
        scanf("%f", &height);

        if(base == 0 || height == 0){
            printf("\n Impossible to calculate the area of the triangle!");
        }else{
            area = base * height / 2;
            printf("\n Area: %5.2f", area);
        }
        cont++;
    }
    while(cont < 3);
    printf("\n");


    return 0;
}
