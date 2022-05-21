#include <stdio.h>
#include <stdlib.h>

int spendingJanuary = 20000,
    spendingFebuary = 25000,
    spendingMarch = 30000,
    spendingQuarter;

int main()
{
    spendingQuarter = spendingJanuary + spendingFebuary + spendingMarch;

    printf("The total expenses in the quarter are: R$%d", spendingQuarter);

    return 0;
}

