#include <stdio.h>
#include <stdlib.h>

typedef struct nodeStack{
    int data;
    struct nodeStack *next;
}nodeStack;

nodeStack *create_stack(void){
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

int main(){
    nodeStack *my_stack = create_stack();

    return 0;
}