
package edd.tarea_2;

import java.util.LinkedList;
import java.util.Scanner;

public class Dueño {
    
    
    public static LinkedList<Dueño> L_Dueños = new LinkedList<Dueño>();
    private String Nombre;
    private LinkedList<Moneda> L_Monedas;

    public Dueño(String nomb) {
        this.Nombre = nomb;
        L_Monedas = new LinkedList<>();
    }

    public String Obtener_Nombre() {
        return Nombre;
    }
   
    public static LinkedList<Dueño> Obtener_Lista_Dueños() {
        return L_Dueños;
    }

    public LinkedList<Moneda> Obtener_Lista_Monedas() {
        return L_Monedas;
    }

    public void Colocar_Nombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public static void Colocar_Lista_Dueños(LinkedList<Dueño> L_Dueños) {
        Dueño.L_Dueños = L_Dueños;
    }
    
    public void Colocar_Lista_Monedas(LinkedList<Moneda> listaMonedas) {
        this.L_Monedas = listaMonedas;
    }

    public void Agregar_Moneda(Moneda money) {
        boolean band = false;
        
        for (Moneda mone : L_Monedas) {
            if (mone.Obtener_Nombre().equalsIgnoreCase(money.Obtener_Nombre())) {
                band = true;
                System.out.println("Esta Moneda ya existe!");
            }
        }
            if (band == false) {
                this.L_Monedas.add(money);
                System.out.println("Moneda Creada de forma exitosa!");
            }        
    }

    public static Dueño Obtener_Saldo_Por_Nombre(String nombre) {
        for (Dueño D : L_Dueños) {
            if (D.Obtener_Nombre().equalsIgnoreCase(nombre)) {
                return D;
            }
        }
        
        System.out.println("Dueño no existe!");
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese de nuevo el nombre: ");
        String nomb = entrada.nextLine();
        return Obtener_Saldo_Por_Nombre(nomb);
        
    }

    public static boolean Existe(String nombre) {

        for (Dueño D : L_Dueños) {
            if (D.Obtener_Nombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        
        return false;
    }

    public static void Imprime_L_Dueños() {

       int x=0;

        for (Dueño D : L_Dueños) {
            x++;
            System.out.print(x+".");
            if (D.L_Monedas.isEmpty()) {
                 System.out.println(D.Obtener_Nombre()+ " tiene 0 monedas ");
            } else {
                for (Moneda m : D.Obtener_Lista_Monedas()) {
                    System.out.println(D.Obtener_Nombre()+ " tiene " + m.Obtener_Cantidad()+ " monedas de " + m.Obtener_Nombre());
                }
            }
        }
    }

    public void TrasnferenciaFrom(String Nombre_Moneda, float Cantidad, Dueño Destinatario) {
        for (Moneda mon : this.L_Monedas) {
            if (mon.Obtener_Nombre().equalsIgnoreCase(Nombre_Moneda)) {
                if (Cantidad <= mon.Obtener_Cantidad()) {  
                    mon.Colocar_Cantidad(mon.Obtener_Cantidad()- Cantidad);
                    Destinatario.Agregar_Moneda(new Moneda(Nombre_Moneda, Cantidad));
                     System.out.println("+++++ TRANSFERENCIA REALIZADA ++++");
                } else {
                    System.out.println("no se cuenta con la cantidad de monedas suficientes de ese tipo ");
                }
            } else {
                System.out.println("el usuario 1 no tiene ese tipo de moneda");
            }
        }
    }
}
    

