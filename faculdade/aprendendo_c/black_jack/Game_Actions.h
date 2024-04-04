#define GAME_ACTIONS_H_INCLUDED
#define GAME_ACTIONS_H_INCLUDED

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

//N� para m�o
struct Node{
    int Hand;
    Node *Dir;
    Node *Esq;
};

typedef struct Node *NodePtr;

//Estrutura para mesa online
struct Mesa{
    Node *Primeiro;
    Node *Atual;
    int Players = 0;
};

//Inicia o jogo
void Start_Game(Mesa *M){
    M->Atual = new Node();
    M->Atual->Dir = M->Atual;
    M->Atual->Esq = M->Atual;
    M->Atual->Hand = 0;
    M->Primeiro = M->Atual;
    M->Players++;
}

//Verifica se Mesa est� vazia
bool Vazia(Mesa *M){
    if(M->Players == 0)
        return true;
    else
        return false;
}

//Adiciona novo jogador ao jogo
void New_Player(Mesa *M, bool *Ok){
    NodePtr PAux = new Node();
    PAux->Hand = 0;
    PAux->Dir = M->Atual->Dir;
    M->Atual->Dir = PAux;
    PAux->Esq = M->Atual;
    M->Primeiro = PAux;
    M->Atual = PAux;
    M->Players++;
    delete(PAux);
    *Ok = true;
}

//Remove jogador do jogo
void Retira_Player(Mesa *M, bool *Ok){
    NodePtr P;
    if(Vazia(M))
        *Ok = false;
    else{
        P = M->Atual->Dir;
        M->Atual->Esq->Dir = M->Atual->Dir;
        M->Atual->Dir->Esq = M->Atual->Esq;
        M->Atual = P;
        M->Players--;
        delete(P);
        *Ok = true;
    }
}

//Pega o primeiro jogador do jogo
void Primeiro(Mesa *M){
    M->Atual = M->Primeiro;
}

//Pega o proximo jogador
void Proximo(Mesa *M){
    M->Atual = M->Atual->Dir;
}

//Acrescenta n�mero aleat�rio entre (1 - 10) � m�o do jogador
void Acrescenta_Hand(Mesa *M){
    unsigned seed = time(0);
    srand(seed);

    M->Atual->Hand += 1+rand()%10;
}

void Verifica_21(Mesa *M, bool *Ok){
    bool Deu_Certo;
    if(M->Atual->Hand > 21){
        Retira_Player(M, &Deu_Certo);
        *Ok = true;
        cout << "Jogador retirado, mao ultrapassou 21" << endl;
    }
    else
        *Ok = false;
}

void Imprime_Game(Mesa *M){
    Primeiro(M);
    for(int i = 0; i < M->Players; i++){
        cout << "Player[" << i+1 << "]: " << M->Atual->Hand << endl;
        Proximo(M);
    }
}
