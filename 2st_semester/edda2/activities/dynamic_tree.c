#include <stdio.h>
#include <stdlib.h>

typedef struct treeNode{
    int value;
    struct treeNode *left;
    struct treeNode *right;
    struct treeNode *father;
}treeNode;

treeNode *createTree(int root_value){
    treeNode *root = malloc(sizeof(treeNode));
    root -> value = root_value;
    root -> left = NULL;
    root -> right = NULL;
    root -> father = NULL;
    return root;
}

void addNode(treeNode *tree, int node_value){
    treeNode *new_node = malloc(sizeof(treeNode));
    new_node -> value = node_value;
    if(tree -> value <= node_value){
        if(tree -> left){
            addNode(tree -> left, new_node -> value);
        }
        else{
            tree -> left = new_node;
        }
    }else{
        if(tree -> right){
            addNode(tree -> right, new_node -> value);
        }
        else{
            tree -> right = new_node;
        }
    }

}

int main(){
    treeNode *my_tree = createTree(5);


    return 0;
}