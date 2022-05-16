#include <stdio.h>
#include <string.h>

int main(){
  int number_one, number_two, i;
  float result;
  char math_operator[5];
  char* math_options[] = {"+", "-", "*", "/", "%"};

  printf("Number one: \n");
  scanf("%d", &number_one);
  printf("Number two: \n");
  scanf("%d", &number_two);
  printf("Math Operator: \n");
  scanf("%s", math_operator);

  for(i = 0; i < 5; i++){
    if(strcmp(math_operator, math_options[i]) == 0){
      if(strcmp(math_operator, "+") == 0){
        result = number_one +number_two;
      }else if(strcmp(math_operator, "-") == 0){
        result = number_one - number_two;
      }else if(strcmp(math_operator, "*") == 0){
        result = number_one * number_two;
      }else if(strcmp(math_operator, "/") == 0){
        if(number_two == 0){
          printf("Division by zero.");
          exit(0);
        }else{
          result = number_one / number_two;
        }
      }else{
        result = number_one % number_two;
      }
      printf("The result is: %f", result);
      exit(0);
    }
  }

  printf("Unrecognized math operation");
  
  return 0;
}