//exerc1
#include <stdio.h>

int main(){
    int number, i;
    int higher_number = 0;

    for(i = 0; i < 2; i++){
        printf("Type a number: \n");
        scanf("%d", &number);

        if(number > higher_number){
            higher_number = number;
        }
    }

    printf("The higher number is: %d", higher_number);
  
    return 0;
}

