#include <iostream>

using namespace std;

class time{
public:
    time();
    void set_time(int, int, int);
    void imprime();
    int getHora();
    int getMinuto();
    int getSegundo();

private:
    int hora, minuto, segundo;
};

time::time(){
    hora = 0;
    minuto = 0;
    segundo = 0;
}

//Métodos Get
int time::getHora(){
    return hora;
}
int time::getMinuto(){
    return minuto;
}
int time::getSegundo(){
    return segundo;
}

void time::set_time(int h, int m, int s){
    if(h >= 0 && h <= 24){
        hora = h;
    }
    else{
        cout<<"Hora inexistente"<<endl;
    }
    if(m >= 0 && m <= 60){
        minuto = m;
    }
    else{
        cout<<"Minuto inexistente"<<endl;
    }
    if(s >= 0 && s <= 60){
        segundo = s;
    }
    else{
        cout<<"Segundo inexistente"<<endl;
    }
}

void time::imprime(){
    if(getHora() < 10 && getMinuto() < 10 && getSegundo() < 10){
        cout << "0" << hora<<" : "<< "0" << minuto <<" : "<< "0" << segundo << endl;
    }
    else
        cout << hora<<" : "<< minuto <<" : "<< segundo << endl;
}
