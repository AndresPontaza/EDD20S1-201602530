#include <QCoreApplication>
#include <iostream>
#include "lista_doble.h"

int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);

    cout << "*******************************************************************************" <<endl;
    cout << "*                                   Tarea #4                                  *" <<endl;
    cout << "*******************************************************************************" <<endl;
    cout << "Valores de la lista:" <<endl;
    cout << "*******************************************************************************" <<endl;
    lista_doble* Prueba = new lista_doble();
    Prueba->Insertar_Primero(201602530, "Andres");
    Prueba->Insertar_Primero(201705478, "Pablo");

    Prueba->Mostrar_lista_primero_a_ultimo();
    cout << "\n";

    cout << "\n -Carné a Buscar: ";
    int carne;
    cin >> carne;
    Prueba->Buscar_por_carnet(carne);

    cout << "\n";
    cout << "-Borrando ultimo nodo... \n";
    Prueba->BorrarUltimo();

    cout << "*******************************************************************************" <<endl;
    cout << "*                           Lista con el Nodo borrado                         *" <<endl;
    cout << "*******************************************************************************" <<endl;

    Prueba->Mostrar_lista_primero_a_ultimo();

    cout << "\n";

    return 0;
}
