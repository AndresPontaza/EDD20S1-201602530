#include <QCoreApplication>
#include <iostream>
#include "lista.h"

using namespace std;
int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);

    cout << "****************************************" <<endl;
    cout << "*              Tarea #3                *" <<endl;
    cout << "****************************************" <<endl;
    cout << "Valores de la lista:" <<endl;
    cout << "****************************************" <<endl;
    lista* Prueba = new lista();
    nodo* elim = new nodo();
    Prueba->Insertar(201602530, "Andres");
    Prueba->Insertar(201705478, "Pablo");
    Prueba->Insertar(201452926, "Junior");
    Prueba->Insertar(201252428, "Tom");
    Prueba->Insertar(201352458, "Valeria");
    Prueba->Imprimir();
    cout << "-Carné a Buscar: ";
    int carne;
    cin >> carne;
    cout << "****************************************" <<endl;
    cout << "*             Resultados               *" <<endl;
    cout << "****************************************" <<endl;
    Prueba->Buscar(carne);
    cout << "****************************************" <<endl;
    cout << "-Carne a borrar: ";
    cin >> carne;
    elim = Prueba->Buscar(carne);
    Prueba->Eliminar(elim);
    cout << "****************************************" <<endl;
    cout << "*        Lista con nodo borrado        *" <<endl;
    cout << "****************************************" <<endl;
    Prueba->Imprimir();

    return a.exec();
}
