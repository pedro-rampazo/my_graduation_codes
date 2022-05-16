//exerc2
#include <stdio.h>

int main() {
  float grade;

  printf("Enter student grade: \n");
  scanf("%f", &grade);

  if(grade < 4){
    printf("disapproved!!");
  }else if(grade >= 4 && grade < 6){
    printf("recovery!!");
  }else{
    printf("approved");
  }
  
  return 0;
}