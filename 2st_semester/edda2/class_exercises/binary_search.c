#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0

int array_number[] = {5, 23, 27, 30, 39, 45, 56, 71, 80, 92};
int length = sizeof array_number / sizeof array_number[0];

int binarySearch(int num){
    int begin = 0;
    int end = length - 1;

    while(begin <= end){
        int i = (begin + end) / 2;

        if(array_number[i] == num){
            return i;
        }

        if(array_number[i] < num){
            begin += 1;
        }else{
            end = i;
        }
    }
    return -1;
}

int main(){
    
    int target = binarySearch(7);

    if(target != -1){
        printf("Index: %d", target);
    }else{
        printf("Invalid Number.");
    }

    return 0;
}