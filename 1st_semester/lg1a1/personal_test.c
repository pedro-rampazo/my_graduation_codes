#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

int main(){
    char day[10], month[4], complete_month[] = "0", str_result[5];
    int year, day_month, sum_birthday, sum_split, final_result;

    printf("Birth Date DD/MM/YYYY: ");
    scanf("%s %s %d", &day, &month, &year);

    if(strlen(month) == 1){
        strcat(complete_month, month);
        strcpy(month, complete_month);
    }

    strcat(day, month);
    day_month = atoi(day);
    sum_birthday = day_month + year;

    sum_split = (sum_birthday / 100) + (sum_birthday % 100);

    final_result = sum_split % 5;

    printf("Final Result: %s", final_result == 0 ? "Timido" : (final_result == 1 ? "Sonhador" : final_result == 2 ? "Paquerador" : final_result == 3 ? "Atraente" : final_result == 4 ? "Irresistivel" : "Error"));

    return 0;
}
