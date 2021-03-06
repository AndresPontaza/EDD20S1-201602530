#ifndef LISTA_DOBLE_H
#define LISTA_DOBLE_H

#endif // LISTA_DOBLE_H

#include <iostream>

using namespace std;

class nodo{
    public:

    char Car;
    nodo* sig;
    nodo* ant;

    nodo(){
          }

    nodo (char car){
        Car=car;
        sig;
        ant;
    }
};

class lista_doble
{
    nodo* primero = new nodo();
    nodo* ultimo = new nodo();
    nodo* aux = new nodo();
    int size =0;

    public:
    lista_doble() {
        primero = NULL;
        ultimo = NULL;
    }

    void Insertar_Inicio(nodo* n, char car){
        nodo* aux = new nodo(car); //Reserva memoria

        if (primero == NULL){
            //Lista vacia
            primero = aux;
            ultimo = aux;
        }

        else if (n == primero) {
            //Insertar al inicio
            aux->sig = primero;
            primero->ant = aux;
            primero = aux;
        }

        else {
            //Insertar antes de un nodo dado
            n->ant->sig = aux;
            aux->ant = n->ant;
            n->ant = n;
            aux->sig = n;
        }
    }

    void Insertar_Primero(char car){
        Insertar_Inicio(primero, car);
    }

    void Mostrar_lista_primero_a_ultimo(){
        nodo* actual = new nodo();
        actual = primero;

        if(primero!=NULL){
            while(actual!=NULL){
            cout << "\n " << actual->Car;
            actual = actual->sig;
            }
        }
            else{
                cout<< "\n La lista esta vacia\n \n";
        }
    }



    void Borrar(nodo* n){
        if(primero == NULL){
            cout << "Lista vacía, acción no posible";
        }

        else if (primero == ultimo) {
           //Lista de un solo nodo
            ultimo = NULL;
            primero = NULL;
        }

        else if (n == primero) {
           //Eliminar Primero
            primero = primero->sig;
            primero->ant = NULL;
        }

        else if (n == ultimo) {
           //ELiminar Ultimo
            ultimo = ultimo->ant;
            ultimo->sig = NULL;
        }

        else {
           n->ant->sig = n->sig;
           n->sig->ant = n->ant;
        }
    }

    void BorrarUltimo(){
        Borrar(ultimo);
    }

    nodo* Buscar_por_caracter(char car)
    {
        nodo* busc = primero;
        bool encontrado = false;
        while (busc != 0)
        {
            if (busc->Car == car){
                encontrado = true;
                cout << "Coincide con "; cout<< busc->Car <<endl;
                return busc;
            } else {
                busc = busc->sig;
            }
        }
        cout << "No se encontro nada "<< endl;
        return busc;
    }

};
