#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

int main(){
    char password_character, password[20];
    int i, chance = 3;

    do{
        i = 0;
        strcpy(password, "");
        printf("\nPassword: ");

        for(i = 0; i < 11; i++){
            password_character = getch();
            printf("*");
            strncat(password, &password_character, 1);
        }

        if(strcmp(password, "iron maiden") == 0){
            printf("\nVIP Access!");
            exit(0);
        }else{
            printf("\nBarred at the entrance!");
            chance--;
        }
    }
    while(chance > 0);

    return 0;
}
