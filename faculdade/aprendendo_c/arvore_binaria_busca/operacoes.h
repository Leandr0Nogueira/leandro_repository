#include <iostream>

using namespace std;

//Nó para cada elemento da árvore
struct TreeNode{
    int Info;
    TreeNode *Dir;
    TreeNode *Esq;
};

//Cria nó para cada elemento da árvore
void Cria(TreeNode *R, int X, bool Ok){
    R = new TreeNode;
    R->Info = X;
    R->Dir = NULL;
    R->Esq = NULL;
    Ok = true;
}

//Verifica se árvore está vazia
bool Vazia(TreeNode *R){
    if(R == NULL)
        return true;
    else
        return false;
}

//Insere elemento na árvore
void Insere(TreeNode *R, int X, bool Ok){
    if(R == NULL){
        Cria(R, X, Ok);
        Ok = true;
        return;
    }

    if(X < (R)->Info){
        Insere(R->Esq, X, Ok);
        Ok = true;
    }
    else if(X > R->Info){
        Insere(R->Dir, X, Ok);
        Ok = true;
    }
    else{
        cout<<"Elemento ja contido na arvore"<<endl;
        Ok = false;
    }
}

//Verifica se há certo elemento na árvore
bool Esta_Na_Arvore(TreeNode *R, int X){
    if(R == NULL){
        return false;
    }

    if(X == R->Info){
        return true;
    }

    if(X > R->Info){
        Esta_Na_Arvore(R->Dir, X);
    }

    if(X < R->Info){
        Esta_Na_Arvore(R->Esq, X);
    }
}

//Deleta árvore
void Destroi_Arvore(TreeNode *R){
    if(R){
        Destroi_Arvore(R->Dir);
        Destroi_Arvore(R->Esq);
        delete R;
    }
}

//Pega o menor valor da árvore
int Menor_Valor(TreeNode *R){
    while(R->Esq != NULL){
        R = R->Esq;
    return R->Info;
    }
}

//Retira um elemento da árvore
void Retira(TreeNode *R, int X){
    bool LeftChild;
    TreeNode *Anterior, *Atual;
    int ValorMinimo;

    Anterior = NULL;
    Atual = R;

    while(X != Atual->Info){ //Percorre árvore até achar o elemento a ser retirado
        Anterior = Atual;
        if(X < Atual->Info){
            Atual = Atual->Esq;
            LeftChild = true;
        }
        else{
            Atual = Atual->Dir;
            LeftChild = false;
        }
    }//while

    //Casos
    if(Atual->Esq == NULL  && Atual->Dir == NULL){ //Sem filhos
        if(LeftChild)
            Anterior->Esq = NULL;
        else
            Anterior->Dir = NULL;
        delete(Atual);
    }
    else if(Atual->Esq == NULL && Atual->Dir != NULL){ //Filho na direita
        if(LeftChild)
            Anterior->Esq = Atual->Dir;
        else
            Anterior->Dir = Atual->Esq;
        delete(Atual);
    }
    else if(Atual->Esq != NULL && Atual->Dir == NULL){ //Filho na esquerda
        if(LeftChild)
            Anterior->Esq = Atual->Esq;
        else
            Anterior->Dir = Atual->Dir;
        delete(Atual);
    }
    else{ //Filfo na direira e na esquerda
        ValorMinimo = Menor_Valor(Atual->Dir);
        Retira(Atual->Dir, ValorMinimo);
        Atual->Info = ValorMinimo;
    }
}

void Remove(ABB *R, int X, bool *Ok){
    NodePtr P = new Node; //Ponteiro para nó
    NodePtr PMin = new Node;//Ponteiro para nó com menor valor
    P = R;
    int MenorValor;

    //Percorre árvore para encontrar elemento a ser retirado
    while(X != P->Info){
        if(X < P->Info)
            P = P->FEsq;
        else if(X > P->Info)
            P = P->FDir;
        else if(P == NULL) //Caso não tenha X na árvore
            *Ok = false;
    }

    //Folhas (nós sem filhos)
    if(P->FEsq == NULL && P->FDir == NULL){
        Deletenode(P);
        *Ok = true;
    }

    //Apenas um filho direito
    if(P-> FEsq == NULL && P->FDir != NULL){
        P->Pai->FDir = P->FDir;
        Deletenode(P);
        *Ok = true;
    }

    //Apenas uma filho esquerdo
    if(P-> FEsq != NULL && P->FDir == NULL){
        P->Pai->FDir = P->FEsq;
        Deletenode(P);
        *Ok = true;
    }

    //Dois filhos
    if(P-> FEsq != NULL && P->FDir != NULL){
        PMin = P;
        while(P->FEsq != NULL){
            PMin = PMin->FEsq;
        }
        MenorValor = PMin->Info; //Armazena o menor valor a partir do nó P
        Remove(P->FDir, MenorValor, &Ok); //Remove a folha com menor valor à direita de P
        P->Info = MenorValor; //Armazena novo valor do nó P
        *Ok = true;
    }

}









