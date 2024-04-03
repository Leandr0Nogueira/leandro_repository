#include <iostream>

using namespace std;

struct Node{
    char Info;
    Node *Dir;
    Node *Esq;
}Arvore;

typedef struct Node NodePtr;

void Cria(Arvore *R){
    R = NULL;
}

bool Vazia(Arvore *R){
    if(R == NULL)
        return true;
    else
        return false;
}

void Insere(Arvore *R, int X, bool Ok){
    NodePtr PAux = new Node();
    PAux = R;

    if(Vazia(R)){
        R = new Node();
        R->Info = X;
        R->Dir = NULL;
        R->Esq = NULL;
        Ok = true;
    }
    else if(X > PAux->Info && PAux->Dir != NULL){
        PAux = PAux->Dir;
    }
    else if(X < PAux->Info && PAux->Esq != NULL){
        PAux = PAux->Esq;
    }
    else if(X > PAux->Info){
         PAux = PAux->Dir;
         PAux->Info = X;
         PAux->Dir = NULL;
         PAux->Esq = NULL;
         Ok = true;
    }
    else if(X < PAux->Info){
         PAux = PAux->Esq;
         PAux->Info = X;
         PAux->Dir = NULL;
         PAux->Esq = NULL;
         Ok = true;
    }
}

bool Esta_Na_Arvore(Arvore *R, int X, bool Ok){

}
