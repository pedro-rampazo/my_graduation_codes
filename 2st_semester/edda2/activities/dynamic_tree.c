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

treeNode * addNode(treeNode *tree, int node_value){
    if(tree -> value >= node_value){
        if(tree -> left){
            addNode(tree -> left, node_value);
        }
        else{
            treeNode *new_node = malloc(sizeof(treeNode));
            new_node -> value = node_value;
            new_node -> father = tree;
            tree -> left = new_node;
            return tree;
        }
    }else{
        if(tree -> right){
            addNode(tree -> right, node_value);
        }
        else{
            treeNode *new_node = malloc(sizeof(treeNode));
            new_node -> value = node_value;
            new_node -> father = tree;
            tree -> right = new_node;
            return tree;
        }
    }
}
// RETORNAR VALOR

void preOrder(treeNode *tree){
    printf("%d ", tree -> value);
    if(tree -> left){
        preOrder(tree -> left);
    }
    if(tree -> right){
        preOrder(tree -> right);
    }
}


int main(){
    int tree_number[] = {56, 87, 60, 36, 4, 59, 94, 10, 43, 40};

    treeNode *my_tree = createTree(tree_number[0]);

    my_tree = addNode(my_tree, 34);
    my_tree = addNode(my_tree, 60);
    my_tree = addNode(my_tree, 58);
    my_tree = addNode(my_tree, 62);

    preOrder(my_tree);
    


    return 0;
}