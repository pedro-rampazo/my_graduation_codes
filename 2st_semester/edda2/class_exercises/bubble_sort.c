#include <stdlib.h>
#include <stdio.h>

int main(){
    int number_array[] = {8, 2, 3, 9, 1, 7, 5, 6, 4};
    int length = sizeof number_array / sizeof number_array[0];
    int counter;

    do{
        counter = 0;
        
        for(int i = 0; i < length; i++){
            int var_x = number_array[i];
            int var_y = number_array[i + 1];

            if(number_array[i] > number_array[i + 1]){
                number_array[i + 1] = var_x;
                number_array[i] = var_y;
                counter++;
            }
        }

    }while(counter != 0);

    for(int z = 0; z < length; z++){
        printf("%d\n", number_array[z]);
    }

    return 0;
}