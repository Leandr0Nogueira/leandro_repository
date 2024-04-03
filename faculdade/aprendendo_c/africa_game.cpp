#include <iostream>
#include <stdlib.h>
#include <string.h>

using namespace std;

typedef struct{
    char Players[20];
}Jogadores;

typedef struct{
    char Palavra[20];
}Palavras;

int main()
{
    int N_Players, N_Palavras, k = 0, Pass;
    cout << "Escolha quantos participantes e palavras por pessoa: ";
    scanf("%d %d", &N_Players, &N_Palavras);

    Palavras Words[N_Palavras];
    Jogadores Jogadores[N_Players];

    for(int i = 0; i < N_Players; i++){
        cout << "Digite o nome do jogador e as " << N_Palavras << " palavras: ";
        scanf("%s", Jogadores[i].Players);
        for(int j = i * N_Palavras; k < N_Palavras; j++){
            scanf("%s", Words[j].Palavra);
            k++;
        }
        k = 0;
    }

    for(int i = 0; i < N_Players * N_Palavras; i++){
        while(strcmp(Words[k].Palavra, "Vazio") != 0){
            printf("%s", Words[k].Palavra);
            strcpy(Words[k].Palavra, "Vazio");
            k = rand() % (N_Players * N_Palavras);
            printf("%d", k);
            scanf("%d", &Pass);
        }
    }

    return 0;
}
