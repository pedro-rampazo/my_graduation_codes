#include <stdio.h>
#include <stdlib.h>
#include "/home/pedro/Development/Git Space/my_graduation_codes/2st_semester/edda2/array.h"
#define MAX 10

int array[MAX];
int top = MAX - 1;
int *p_array;

int pop(){
    if(top < 0){
        printf("Error");
    }
    else{
        printf("\n%d", array[top]);
        top--;
    }
}

int push(int number){
    if(top >= MAX){
        printf("Error"); 
    }
    else{
        array[top+1] = number;
    }
}

int main(){
    p_array = fillArray(array, MAX);
    
    printArray(p_array, MAX);

    pop();

    push(333);

    printf("\n");

    printArray(p_array, MAX);

    return 0;
}

