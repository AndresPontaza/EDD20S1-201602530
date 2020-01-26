package edd.tarea_1;
  
import java.util.Scanner;

    
public class EDDTAREA_1 {

        static int band;
        
        public static void main(String[] args) {

        do{    
        try {
            
            System.out.println("******************** TAREA #1 ********************");
            System.out.println("**************************************************"+"\n");
            System.out.print("Ingresar el tamaño de la Matriz Cuadrada: ");
            Scanner entrada = new Scanner (System.in);
            
            int m = entrada.nextInt();    
            int[][]  matriz= new int[m][m];
            int f=0; //Filas
            
            //Llena el arreglo parte superior
             for (int n = 0; n < matriz.length;n++) //Columnas
                matriz[f][n]= 1;
             
            //Llena el arreglo parte izquierda
            for (int n = 0; n < matriz.length;n++) //Columnas
                matriz[n][f]= 1;
            
            //Llena el arreglo parte derecha
            f=m-1; //Filas
            for (int n = 0; n < matriz.length;n++) //Columnas
                matriz[n][f]= 1;
            
            //Llena el arreglo parte inferior
             for (int n = 0; n < matriz.length;n++) //Columnas
                matriz[f][n]= 1;
            
             System.out.println();
                         
            //Muestra el arreglo
            for(int i = 0; i < matriz.length; i++){
                for(int j = 0; j < matriz[i].length; j++){
                    System.out.print(matriz[i][j] + " ");   // Imprime elemento
            }
            System.out.println();  // Imprime salto de línea
            }
        
            System.out.println();
            
            } catch (Exception ex) {
                System.out.println("Caracter no valido!!");
            }
        
            System.out.print("Desea volver a utilizar el programa [s/n]? ");
            Scanner r = new Scanner (System.in);
            
            if(r.next().equals("s")){
            band=1;
            }
            else{
            band=0;
            }
            
            System.out.println();
                              
        } while ( band ==1);    
        
                                                }

}