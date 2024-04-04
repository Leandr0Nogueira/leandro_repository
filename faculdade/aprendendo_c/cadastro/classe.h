#include <iostream>
#include <string.h>

using namespace std;

class agenda{
public:
    agenda();
    int getIdade();
    void insere_nome(char[]);
    void insere_cpf(char[]);
    void insere_idade(int);
    void imprime();
private:
    char nome[30];
    char cpf[15];
    int idade;
};

agenda::agenda(){
    strcpy(nome, "Sem nome");
    strcpy(cpf, "Sem cpf");
    idade = 69;
}

void agenda::insere_nome(char name[30]){
    strcpy(nome, name);
}

void agenda::insere_cpf(char c[15]){
    strcpy(cpf, c);
}

void agenda::insere_idade(int age){
    idade = age;
}

void agenda::imprime(){
    cout<<endl;
    cout<<nome<<endl;
    cout<<cpf<<endl;
    cout<<idade<<endl;
    cout<<endl;
}

int agenda::getIdade(){
    return idade;
}


