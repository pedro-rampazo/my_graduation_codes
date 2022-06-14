#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

int main(){
    char password_character, options, password[4];
    int i;

    printf("Bank Account Password: ");

    for(i = 0; i < 4; i++){
        password_character = getch();
        printf("*");
        strncat(password, &password_character, 1);
    }

    if(strcmp(password, "1310") == 0){
        printf("\n ============= \n a = balance \n b = deposit \n c = payment \n d = transfer \n e = exit \n ============= \n");
        options = getch();

        switch(options){
            case 'a':
                printf("Operation: Balance");
                break;
            case 'b':
                printf("Operation: Deposit");
                break;
            case 'c':
                printf("Operation: Payment");
                break;
            case 'd':
                printf("Operation: Transfer");
                break;
            case 'e':
                printf("Closing operations...");
                exit(0);
            default:
                printf("Invalid option.");
        }

    }else{
        printf("Invalid Password.");
    }

    return 0;
}
