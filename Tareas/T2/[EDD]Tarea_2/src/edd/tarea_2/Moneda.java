
package edd.tarea_2;


public final class Moneda {
    private String Nombre;
    private Float Cantidad;

    public Moneda(String Nombre, Float Cantidad){
        Crear_Moneda(Nombre, Cantidad);        
    }
  
    public Float Obtener_Cantidad() {
        return Cantidad;
    }

    public String Obtener_Nombre() {
        return Nombre;
    }

    public void Crear_Moneda(String Nombre, Float Cantidad) {
        this.Nombre = Nombre;
        this.Cantidad = Cantidad;
    } 

    public void Colocar_Cantidad(Float Cantidad) {
        this.Cantidad = Cantidad;
    }
    
}
