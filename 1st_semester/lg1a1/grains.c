#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <math.h>

int main(){
    int i, result = 0, total_price;

    for(i = 0; i < 8; i++){
        result = result + pow(2, i);
    }

    total_price = result * 8;
    printf("The amount paid to the monk is: %d Grains", total_price);

    return 0;
}
