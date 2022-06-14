#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

int main(){
    char gender;
    float height, ideal_weight;

    printf("Type height(m): ");
    scanf("%f", &height);
    printf("\n Select a gender: \n [M] - Male \n [F] - Female \n");
    gender = getch();

    switch(gender){
        case 'm':
            ideal_weight = 72.7 * height - 58;
            break;
        case 'f':
            ideal_weight = 62.1 * height - 44.7;
            break;
        default:
            printf("Invalid option.");
            exit(0);
    }

    printf("The ideal weight is: %.1f Kg", ideal_weight);

    return 0;
}
