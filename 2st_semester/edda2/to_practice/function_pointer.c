#include <stdlib.h>
#include <stdio.h>

void callFunction(int (*p_function)(int x, int y), int num_one, int num_two){
    printf("%d ", p_function(num_one, num_two));
}

int Sum(int x, int y){
    return x + y;
}

int main(){
    int (*p_sum)();
    p_sum = &Sum;
    callFunction(p_sum, 4, 10);

    return 0;    
}