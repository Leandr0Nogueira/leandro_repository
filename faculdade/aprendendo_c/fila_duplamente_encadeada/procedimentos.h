#include <iostream>
#include <stdio.h>

using namespace std;

struct node{
    char info;
    node *dir;
    node *esq;
};

typedef struct node *nodeptr;

struct fila{
    node *header;
    node *atual;
};

void cria(fila *F){
    F->header = new node();
    F->header->dir = F->header;
    F->header->esq = F->header;
    F->atual = F->header;
}

bool vazia(fila *F){
    if(F->header->dir == F->header){
        return true;
    }
    else{
        return false;
    }
}

void insere(fila *F, char x, bool *ok){
        nodeptr paux = new node;
        paux->info = x;
        paux->dir = F->header->dir;
        paux->esq = F->header;
        F->header->dir->esq = paux;
        F->header->dir = paux;
}

void retira(fila *F, char *x, bool *ok){
    nodeptr p;
    if(vazia(F) == true){
        *ok = false;
    }
    else{
        p = F->header->esq;
        *ok = true;
        *x = p->info;
        p->dir->esq = p->esq;
        p->esq->dir = p->dir;
    }
}

void primeiro(fila *F, char *x, bool *ok){
    F->atual = F->header->dir;
    if(F->atual != F->header){
        *ok = true;
        *x = F->atual->info;
    }
    else{
        *ok = false;
    }
}

void proximo(fila *F, char *x, bool *ok){
    F->atual = F->atual->dir;
    if(F->atual == F->header){
        *ok = false;
    }
    else{
        *ok = true;
        *x = F->atual->info;
    }
}
