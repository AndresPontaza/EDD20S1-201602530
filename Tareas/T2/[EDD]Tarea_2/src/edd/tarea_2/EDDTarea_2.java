package edd.tarea_2;

import java.util.LinkedList;
import java.util.Scanner;

public class EDDTarea_2 {
     public static LinkedList<Moneda> monedero = new LinkedList<Moneda>();

    public static void main(String[] args) {
     Opciones();
     }
     
    public static void Opciones() {
        int opcion = 0;

        do {
            System.out.println("----------------------------------------");
            System.out.println("                Menu                ");
            System.out.println("----------------------------------------");
            System.out.println("1) Crear Dueño");
            System.out.println("2) Crear Moneda");
            System.out.println("3) Ver Dueños de Monedas");
            System.out.println("4) Transferencias");
            System.out.println("5) TransferenciasFrom");
            System.out.println("6) Mostrar Cantidad de Monedas Disponibles");
            System.out.println("7) Salir");
            System.out.println("----------------------------------------");
            System.out.print("Ingresar numero de opcion: ");
            Scanner in = new Scanner(System.in);
            opcion = in.nextInt();
            System.out.println("----------------------------------------");

            switch (opcion) {
                
                case 1:
                    Crear_Dueño();
                    break;
                    
                case 2:
                    Crear_Moneda();
                    break;

                case 3:
                    System.out.println("----------------------------------------");
                    System.out.println("                Dueños                  ");
                    System.out.println("----------------------------------------");
                    Dueño.Imprime_L_Dueños();
                    System.out.println("----------------------------------------");
                    break;

                case 4:
                    Transaccion_Enviar_Moneda();
                    break;

                case 5:
                    TransferenciasFrom();
                    break;
                    
                case 6:
                    Mostrar_Estado();
                    break;

                case 7:
                    System.out.println("Ejecucion Finalizada");
                    break;

                default:
                    System.out.println("Ingrese Numero de Opción: ");
                    break;
            }

        } while (opcion != 7);
    }

    public static void Crear_Moneda() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingresar nombre de la moneda:");
        String nombre = in.nextLine();
        Scanner en = new Scanner(System.in);
        System.out.print("Ingresar la cantidad de monedas: ");
        Float can = en.nextFloat();
        AgregarMonedas(new Moneda(nombre, can));
    }

    public static void AgregarMonedas(Moneda mon) {
        boolean band = false;
        for (Moneda m : monedero) {
            if (m.Obtener_Nombre()== mon.Obtener_Nombre()) {
                band = true;
                m.Colocar_Cantidad(m.Obtener_Cantidad()+ mon.Obtener_Cantidad());
            }
        }

        if (band == false) { 
            monedero.add(mon);
        }
    }

    public static void Transaccion_Enviar_Moneda() {
        System.out.print("Ingrese el nombre del Dueño: ");
        Scanner snomb = new Scanner(System.in);
        String nomb = snomb.nextLine();
        Dueño Due = Dueño.Obtener_Saldo_Por_Nombre(nomb);
        System.out.print("Ingrese nombre de la moneda: ");
        Scanner sc2 = new Scanner(System.in); 
        String nomMoneda = sc2.nextLine();
        System.out.print("Ingrese la cantidad de monedas que desea asignar de ese tipo: ");
        Scanner sc3 = new Scanner(System.in);
        Float cantidad = sc3.nextFloat();
        if(Existe_Moneda(nomMoneda) && Validar_Transaccion( nomMoneda ,  cantidad) ){
        Transferir(Due, nomMoneda, cantidad);
        }else{
        System.out.print("Transaccion no valida!");
        }
    }

    public static void Transferir(Dueño dueño, String nombre, Float cantidad) {
        for (Moneda mon : monedero) {
            if (mon.Obtener_Nombre().equalsIgnoreCase(nombre)) {
                mon.Colocar_Cantidad(mon.Obtener_Cantidad()- cantidad);
                dueño.Agregar_Moneda(new Moneda(nombre, cantidad));
            }
        }
    }

    public static boolean Validar_Transaccion(String nombre, Float cantidad) {
        for (Moneda mon : monedero) {
            if (mon.Obtener_Nombre().equalsIgnoreCase(nombre)) {
                if (cantidad <= mon.Obtener_Cantidad()) {
                    return true;
                }
            }
        }
        System.out.println("No hay suficientes monedas!");
        return false;
    }

    public static boolean Existe_Moneda(String nombre) {
        for (Moneda mon : monedero) {
            if (mon.Obtener_Nombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        System.out.println("Moneda no existe! ");
        return false;

    }

    public static void Crear_Dueño() {
        Scanner in1 = new Scanner(System.in);
        System.out.print("Ingrese el nombre del nuevo Dueño: ");
        String nombre = in1.nextLine();
        
        if (Dueño.Existe(nombre)) {
            System.out.print("Ese Dueño ya esta creado ingresar otro nombre: ");
            Crear_Dueño();
        } else {
            Dueño.L_Dueños.add(new Dueño(nombre));
            System.out.println("Dueño Creado");
        }
    }

    public static void TransferenciasFrom() {
        Scanner in1 = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner entrada1 = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);
        
        System.out.print("Ingresar Remitente: ");
        String nomr = in1.nextLine();
        Dueño Remitente = Dueño.Obtener_Saldo_Por_Nombre(nomr);
        System.out.print("Ingrese el nombre de la moneda que desea trasferir:  ");
        String nombreMoneda = entrada1.nextLine();
        System.out.print("Ingrese la cantidad de monedas que desea transferir: ");
        int cantidad = entrada2.nextInt();
        System.out.print("ingrese el nombre del Destinatario: ");
        String nomd = in2.nextLine();
        Dueño Destinatario = Dueño.Obtener_Saldo_Por_Nombre(nomd);

        Remitente.TrasnferenciaFrom(nombreMoneda, cantidad, Destinatario);
    }

    public static void Mostrar_Estado() {

        System.out.println("---------------------------------");
        for (Moneda m : monedero) {
            System.out.println(m.Obtener_Cantidad()+ " " + m.Obtener_Nombre());
        }
        System.out.println("---------------------------------"+"\n");
    }
   
}