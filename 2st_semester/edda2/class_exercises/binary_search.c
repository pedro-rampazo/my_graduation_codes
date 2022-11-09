#include <stdio.h>
#include <stdlib.h>
#define TAM 10

int number_array[TAM] = {5, 23, 27, 30, 39, 45, 56, 71, 80, 92};

int binary_search(int num){
    int begin = 0;
    int end = TAM - 1;
    int mid = (begin + end) / 2;
    
    while(begin != end || number_array[mid] == num){
        
        if(number_array[mid] == num){
            return mid;
        }
        
        if(number_array[mid] < num){
            begin = mid + 1;
        }else{
            end = mid;
        }
        
        mid = (begin + end) / 2;
    }
    
    return -1;
}

int main(){
    int index = binary_search(92);
    
    if(index != -1){
        printf("Index: %d", index);
    }else{
        printf("Invalid Number.");
    }
    
    return 0;
}