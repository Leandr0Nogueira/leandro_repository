#include <iostream>
using namespace std;

struct node{
    int idade;
    struct node *next;
};

typedef struct node *NodePtr;

struct fila{
    NodePtr header;
    NodePtr atual;
};

void cria(fila *FV){
    FV->header = new node;
    FV->header->next = FV->header;
    FV->atual = FV->header;
}

bool vazia(fila *FV){
    if(FV->header->next == FV->header)
        return true;
    else
        return false;
}

void insere(fila *FV, int idade){
    FV->atual = FV->header->next;
    NodePtr PAux = new node;
    PAux->idade = idade;
    if(vazia(FV)){
        PAux->next = FV->header;
        FV->header->next = PAux;
    }
    else{
        while(PAux->idade <= FV->atual->idade){
            FV->atual = FV->atual->next;
        }
        FV->atual = PAux;
    }
}

void primeiro(fila *FV, int *age, bool *ok){
    FV->atual = FV->header->next;
    if(FV->atual != FV->header){
        *ok = true;
        *age = FV->atual->idade;
    }
    else{
        *ok = false;
    }
}

void proximo(fila *FV, int *age, bool *ok){
    FV->atual = FV->atual->next;
    if(FV->atual == FV->header){
        *ok = false;
    }
    else{
        *ok = true;
        *age = FV->atual->idade;
    }
}

void imprime(fila *FV){
    bool ok;
    int age;
    cout<<"Sua lista esta assim: ";
    if(vazia(FV) == false){
        primeiro(FV, &age, &ok);
        while(ok){
            cout<<" "<<age;
            proximo(FV, &age, &ok);
        }
        cout<<" "<<endl;
    }
}
