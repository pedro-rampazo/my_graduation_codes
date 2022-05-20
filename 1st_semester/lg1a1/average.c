#include <stdio.h>
#include <stdlib.h>

float test_1, test_2, coursework, average;

int main()
{
    printf("AVERAGE\nTest Score 1: ");
    scanf("%f", &test_1);
    printf("Test Score 2: ");
    scanf("%f", &test_2);
    printf("Coursework Score: ");
    scanf("%f", &coursework);

    average = (test_1 + test_2 + coursework) / 3;

    printf("The student's average is: %.1f", average);

    return 0;
}

