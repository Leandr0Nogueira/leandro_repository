#include <iostream>
#include "operacoes.h"

using namespace std;

int main()
{
    fila *FV = new fila;
    cria(FV);
    int idade;
    int op = 1;

    while(op == 1){
        cin>>idade;
        insere(FV, idade);
        cin>>op;
    }

    imprime(FV);

    return 0;
}
