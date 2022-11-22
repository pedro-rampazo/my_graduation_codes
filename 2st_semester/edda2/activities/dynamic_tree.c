/*
ÁRVORE BINÁRIA DINÂMICA:
- ESSE ALGORITMO REPRESENTA UMA ÁRVORE BINÁRIA COM ALOCAÇÃO DINÂMICA RECURSIVA.
- O USUÁRIO INFORMA O NÚMERO DE NÓS PARA A MONTAGEM DA ÁRVORE.
- A ÁRVORE É CONSTRUÍDA PELA ORDEM DE SORTEIO DOS NÚMEROS, ONDE SERÃO ADICIONADOS A ESQUERDA,
QUANDO O NÓ-PAI FOR MAIOR QUE O VALOR, OU A DIREITA, QUANDO O NÓ-PAI FOR MENOR DO QUE O VALOR.

AUTOR: PEDRO MARCOLINO RAMPAZO (SP3100065)
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// ESTRUTURA DO NÓ DA ÁRVORE
typedef struct treeNode{
    int value;
    struct treeNode *left;
    struct treeNode *right;
}treeNode;

// CRIAÇÃO DA ÁRVORE, RETORNANDO A RAIZ
treeNode *createTree(int root_value){
    treeNode *root = malloc(sizeof(treeNode));
    root -> value = root_value;
    root -> left = NULL;
    root -> right = NULL;
    return root;
}

// ADIÇÃO DO NÓ
treeNode * addNode(treeNode *tree, int node_value){
    if(tree -> value >= node_value){
        if(tree -> left){
            tree -> left = addNode(tree -> left, node_value);
        }
        else{
            treeNode *new_node = malloc(sizeof(treeNode));
            new_node -> value = node_value;
            tree -> left = new_node;
        }
    }else{
        if(tree -> right){
            tree -> right = addNode(tree -> right, node_value);
        }
        else{
            treeNode *new_node = malloc(sizeof(treeNode));
            new_node -> value = node_value;
            tree -> right = new_node;
        }
    }
    return tree;
}

// PERCORRIMENTO DA ÁRVORE EM PRÉ-ORDEM
void preOrder(treeNode *tree){
    printf("[%d] ", tree -> value);
    if(tree -> left){
        preOrder(tree -> left);
    }
    if(tree -> right){
        preOrder(tree -> right);
    }
}

// PERCORRIMENTO DA ÁRVORE EM-ORDEM
void inOrder(treeNode *tree){
    if(tree -> left){
        inOrder(tree -> left);
    }
    printf("[%d] ", tree -> value);
    if(tree -> right){
        inOrder(tree -> right);
    }
}

// PERCORRIMENTO DA ÁRVORE EM PÓS-ORDEM
void postOrder(treeNode *tree){
    if(tree -> left){
        postOrder(tree -> left);
    }
    if(tree -> right){
        postOrder(tree -> right);
    }
    printf("[%d] ", tree -> value);
}

int main(){
    int number_nodes, rand_node;

    srand(time(NULL));
    treeNode *my_tree = createTree(rand() % 100);

    printf("TREE INITIALIZED!\nNUMBER OF NODES: ");
    scanf("%d", &number_nodes);

    printf("\n%d ", my_tree -> value);

    for(int i = 1; i < number_nodes; i++){
        rand_node = rand() % 100;
        my_tree = addNode(my_tree, rand_node);
        printf("%d ", rand_node);
    }

    printf("\nPREORDER:\n");
    preOrder(my_tree);
    printf("\nINORDER:\n");
    inOrder(my_tree);
    printf("\nPOSTORDER:\n");
    postOrder(my_tree);

    return 0;
}