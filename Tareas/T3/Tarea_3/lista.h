#ifndef LISTA_H
#define LISTA_H

#endif // LISTA_H

#include <iostream>

using namespace std;

class nodo
{
    public:
    int Id;
    string Nombre;
    nodo* Siguiente;
    nodo ()
    {
    }
    nodo (int id, string nombre)
    {
        Id = id;
        Nombre = nombre;
        Siguiente;
    }
};


class lista
{
    nodo* Inicio = new nodo();
    nodo* Fin = new nodo();
    nodo* aux = new nodo();
    int size = 0;

    public:
    lista ()
    {
        Fin;
        Inicio;
    }

    void Insertar (int id, string nombre)
    {
        nodo* nuevo = new nodo(id, nombre);
        if (size == 0){
            Inicio = nuevo;
            Fin = nuevo;
            aux = nuevo;
            size++;
        } else {
            aux->Siguiente = nuevo;
            Fin = nuevo;
            aux = nuevo;
            size++;
        }
    }

    void Eliminar(nodo* n)
    {
        nodo* aux1;
        aux1 = Inicio;
        bool band = true;
        if (n == NULL){
            cout << "No se puede eliminar un elemento vacío" << endl;
        } else if (n == Inicio) {
            Inicio = NULL;
        } else {
            do{
                if (aux1->Siguiente != NULL ){
                    if (n == aux1->Siguiente){
                        aux1->Siguiente = NULL;
                        cout << "Nodo eliminado" << endl;
                        band= false;
                    } else {
                        aux1 = aux1->Siguiente;
                    }

                } else {
                    band = false;

                }
            } while (band);
        };

    }

    void Imprimir() {
        nodo* aux2 = Inicio;
        int cont = 0;
        do{
            cout << aux2->Nombre << endl;
            cout << aux2->Id << endl;
            cout << "****************************************" <<endl;
            aux2 = aux2->Siguiente;
            cont++;
        } while (cont < size);
    }

    nodo* Buscar(int n)
    {
        nodo* bus = Inicio;
        bool encontrado = false;

        while (bus != 0)
        {
            if (bus->Id == n){
                encontrado = true;
                cout << "Coincide con "; cout<< bus->Nombre <<endl;
                return bus;
            } else {
                bus = bus->Siguiente;
            }
        }
        cout << "No se encontro nada "<< endl;
        return bus;
    }

};
