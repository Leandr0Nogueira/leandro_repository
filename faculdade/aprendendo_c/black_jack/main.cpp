#include <iostream>
#include "Game_Actions.h"

using namespace std;

int main()
{
    bool Ok;
    Mesa *M = new Mesa;
    Start_Game(M);
    int Option = 1;
    int Carta = 0;

    while(Option == 1){
        cout << "Atuais jogadores na mesa: " << M->Players << endl;
        cout << "Deseja adicionar mais um jogador? (1)Sim // (2)Nao: "; cin >> Option;
        cout << endl;
        if(Option == 1){
            New_Player(M, &Ok);
        }
    }

    while(M->Players > 1){
        Primeiro(M);
        for(int i =0; i < M->Players; i++){
            Carta = 0;
            cout << "Player[" << i+1 << "]: Deseja pegar 1 carta? (1)Sim // (2)Nao: "; cin >> Carta;
            if(Carta == 1){
                Acrescenta_Hand(M);
            }
            cout << "A soma da sua mao: " << M->Atual->Hand << endl;
            Verifica_21(M, &Ok);
            if(Ok == false)
                Proximo(M);
        }
        cout << endl;
    }
    Imprime_Game(M);

    return 0;
}
