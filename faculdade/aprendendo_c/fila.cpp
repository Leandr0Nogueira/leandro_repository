#include <iostream>

#define tamanho 4

using namespace std;

typedef struct f{
    int inicio, fim, nmr_elem;
    int elementos[tamanho];
}fila;

void cria(fila *f){
    f->inicio = 0;
    f->fim = 0;
    f->nmr_elem = 0;
}

bool vazia(fila *f){
    if(f->nmr_elem <= 0){
        return true;
    }
    else{
        return false;
    }
}

bool cheia(fila *f){
    if(f->nmr_elem >= tamanho){
        return true;
    }
    else{
        return false;
    }
}

void insere(fila *f, int x, bool *ok){
    if(cheia(f) == true){
        *ok = false;
        cout<<"Falha...(Fila ja esta cheia)"<<endl;
    }
    else{
        f->nmr_elem++;
        f->elementos[f->fim] = x;
        f->fim++;
        *ok = true;
    }
}

void retira(fila *f, int *x, bool *ok){
    if(vazia(f) == true){
        *ok = false;
        cout<<"Falha...(Fila ja esta vazia)"<<endl;
    }
    else{
        f->nmr_elem--;
        *ok = true;
        *x = f->elementos[f->inicio];
        if(f->inicio == tamanho){
            f->inicio = 0;
        }
        else{
            f->inicio++;
        }
    }
}

void imprime(fila *f){
    int x;
    fila faux;
    bool ok;
    cria(&faux);
    while(vazia(f) == false){
        retira(f, &x, &ok);
        if(ok == true){
            insere(&faux, x, &ok);
        }
    }
    cout<<"Sua fila esta assim:"<<endl;
    while(vazia(&faux) == false){
        retira(&faux, &x, &ok);
        if(ok == true){
            cout<<" "<<x;
            insere(f, x, &ok);
        }
    }
    cout<<endl;
}

int main()
{
    fila f;
    cria(&f);
    bool ok;
    int op;
    int y;
    cout<<"Deseja inserir elementos na fila? (1)Sim  (2)Nao: ";
    cin>>op;
    while(op == 1){
        cout<<"Qual elemento deseja inserir?: "; cin>>y;
        insere(&f, y, &ok);
        if(ok){
            cout<<"Elemento inserido"<<endl<<endl;
        }
        cout<<"Deseja inserir mais um elemento? (1)Sim  (2)Nao: "; cin>>op;
    }
    imprime(&f);


    return 0;
}
