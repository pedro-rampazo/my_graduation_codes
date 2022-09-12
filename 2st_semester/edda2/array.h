int printArray(int *array, int length){
    for(int x = 0; x < length; x++){
        printf("%d ", array[x]);
    }
}

int *fillArray(int *array, int length){
    
    for(int r = 0; r < length; r++){
        array[r] = rand() % 1000;
    }

    return array;
}