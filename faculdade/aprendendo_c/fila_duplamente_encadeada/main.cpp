#include <iostream>
#include <stdio.h>
#include "procedimentos.h"

using namespace std;

void imprime(fila *F){
    bool ok;
    char x;
    cout<<"Sua fila esta assim: ";
    if(vazia(F) == false){
        primeiro(F, &x, &ok);
        while(ok){
            cout<<" "<<x;
            proximo(F, &x, &ok);
        }
        cout<<" <-Inicio da fila"<<endl;
    }
}

int main()
{
    fila *F = new fila;
    cria(F);
    bool ok;
    char x;
    int op = 1;

    while(op == 1 || op == 2){
        cout<<"Deseja (1)Inserir // (2)Retirar // (3)Finalizar programa: ";
        cin>>op;

        if(op == 1){
            cout<<"Qual elemento deseja inserir?: ";
            cin>>x;
            insere(F, x, &ok);
            imprime(F);
            cout<<endl;
        }
        else if(op == 2){
            if(vazia(F) == true){
                cout<<"Erro, fila vazia"<<endl;
            }
            else{
                retira(F, &x, &ok);
                imprime(F);
                cout<<endl;
            }
        }
    }
    imprime(F);

    return 0;
}

