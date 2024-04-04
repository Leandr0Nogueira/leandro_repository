#include <iostream>
#include <string.h>
#include "classe.h"

using namespace std;

int main()
{
    agenda a;
    int op;
    char n[30];
    char c[15];
    int i;
    int y = a.getIdade();

    cout<<"Deseja registrar um empregado? (1)Sim  (2)Nao: "; cin>>op;
    while(op == 1){
        cout<<endl;
        cout<<"Insira o nome, cpf e idade do empregado: "<<endl;
        cin>>n; cin>>c; cin>>i;

        a.insere_nome(n);
        a.insere_cpf(c);
        a.insere_idade(i);

        a.imprime();

        cout<<"Deseja registrar outro empregado? (1)Sim  (2)Nao: "; cin>>op;
    }
    cout<<y;

    return 0;
}
