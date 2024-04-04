#ifndef ORDENAMENTO_H_INCLUDED
#define ORDENAMENTO_H_INCLUDED

#include <iostream>

using namespace std;

void BubbleSort(int V[], int N){
    int Auxiliar;
    int Vou_Ate_Aqui = N;
    int Last_Position;

    for(int i = 0; i < N; i++){ //Quantidade de ordenações a serem feitas
        Last_Position = 0;
        for(int j = 1; j < Vou_Ate_Aqui; j++){ //N - i representa uma otimização já que compara 1 a menos toda vez
            if(V[j-1] > V[j]){
                Auxiliar = V[j-1];
                V[j-1] = V[j];
                V[j] = Auxiliar;
                Last_Position = j;
            }
        Vou_Ate_Aqui = Last_Position;
        }//For
    }//For
    cout << "Teste";
}//Void


#endif // ORDENAMENTO_H_INCLUDED
