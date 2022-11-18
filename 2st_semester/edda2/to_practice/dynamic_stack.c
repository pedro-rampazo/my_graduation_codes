#include <stdio.h>
#include <stdlib.h>

typedef struct nodeStack{
    int data;
    struct nodeStack *next;
}nodeStack;

nodeStack *createStack(void){
    nodeStack *head = malloc(sizeof(nodeStack));
    head -> next = NULL;
    return head;
}

void push(nodeStack *head, int value){
    if(head){
        nodeStack *new_node = malloc(sizeof(nodeStack));
        new_node -> data = value;
        new_node -> next = head -> next;
        head -> next = new_node;
    }
}

int pop(nodeStack *head){
    if(head){
        nodeStack *following = head -> next;
        if(following){
            int value = following -> data;
            head -> next = following -> next;
            free(following);
            return value;
        }
    }
    return -1;
}

void deleteStack(nodeStack * *stack){
    nodeStack *aux = *stack;
    nodeStack *temp;
    while(aux){
        temp = aux;
        aux = aux -> next;
        free(temp);
    }
    *stack = NULL;
}

void printStack(nodeStack *stack){
    stack = stack -> next;
    while(stack){
        printf("[%d]->", stack -> data);
        stack = stack -> next;
    }
    printf("NULL\n");
}

int main(){
    int seq[] = {5, 6, 7, 8, 9, 10, 11};
    int size = sizeof(seq)/sizeof(seq[0]);

    printf("SEQ SIZE = %d\n", size);

    nodeStack *stack = createStack();
    printf("STACK INITIALIZED...\n");

    for(int i = 0; i < size; i++){
        push(stack, seq[i]);
    }

    printf("STACK:\n");
    printStack(stack);

    for(int i = 0; i < size-3; i++){
        int removed_element = pop(stack);
        printf("POP: %d\nSTACK:", removed_element);
        printStack(stack);
    }

    printf("DELETING THE STACK...\nSTACK:\n");
    deleteStack(&stack);
    printStack(stack);

    return 0;
}