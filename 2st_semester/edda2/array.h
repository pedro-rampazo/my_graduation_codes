int printArray(int *array, int length){
    for(int x = 0; x < length; x++){
        printf("%d ", array[x]);
    }
}

int *fillArray(int *array, int length){
    for(int r = 0; r < length; r++){
        array[r] = rand() % length*10;
    }
    return array;
}

int *bubbleSort(int *array, int length){
    int counter;
    do{
        counter = 0;
        for(int i = 0; i < length; i++){
            int aux = array[i];
            if(array[i] > array[i + 1] && i+1 < length){
                array[i] = array[i+1];
                array[i+1] = aux;
                counter++;
            }
        }
    }while(counter != 0);
    return array;
}

/*int *bubbleSort(int *p_array, int length){
    int counter, b, aux;
    bubble_sort:
        counter = 0;
        b = 0;
        aux_loop:
            aux = p_array[b];
            if(p_array[b] > p_array[b+1] && b+1 < length){
                p_array[b] = p_array[b+1];
                p_array[b+1] = aux;
                counter++;
            }
            if(b+1 < length){
                b++;
                goto aux_loop;
            }
        if(counter > 0){
            goto bubble_sort;
        }
    return p_array;
}*/