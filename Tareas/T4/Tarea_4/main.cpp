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

    Prueba->Insertar_Primero('4');
    Prueba->Insertar_Primero(' ');
    Prueba->Insertar_Primero('a');
    Prueba->Insertar_Primero('e');
    Prueba->Insertar_Primero('r');
    Prueba->Insertar_Primero('a');
    Prueba->Insertar_Primero('T');

    Prueba->Mostrar_lista_primero_a_ultimo();
    cout << "\n";

    cout << "\n -Caracter a busca: ";
    char car;
    cin >> car;
    Prueba->Buscar_por_caracter(car);

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
