#include <iostream>
#include "ordenamento.h"

using namespace std;

int main()
{
    int Tam;
    cout << "Escolha o tamanho do vetor e preencha-o: ";
    cin >> Tam;
    int Vetor[Tam];
    cout << endl;

    for(int i = 0; i < Tam; i++){
        cout << "Vetor[" << i << "]: ";
        cin >> Vetor[i];
    }

    BubbleSort(Vetor, Tam);
    cout << endl;

    for(int j = 0; j < Tam; j++){
        cout << Vetor[j] << "   ";
    }

    return 0;
}
