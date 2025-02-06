/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionvehiculos;

import java.util.Scanner;


/**
 *
 * @author 1ª DAW
 */
public class Main {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        cocheMoto();
  
        
        //pedir al usuario si es coche o moto
        // crear objeto coche o moto
        //añadir
        
       // vCRUD.agregarVehiculo();
    }
    public static void cocheMoto(){
        boolean verificar = false;
        do {
            String texto;
            Scanner leer = new Scanner(System.in);
            System.out.println("¿Qué tipo de vehiculo vas a agregar ----- COCHE O MOTO?");
            if (leer.hasNextLine() == true) {
                texto = leer.nextLine().toUpperCase();
                if (texto.equals("COCHE")){
                    System.out.println("COCHE");
                    verificar = true;
                }
                if (texto.equals("MOTO")) {
                    System.out.println("MOTO");
                    verificar = true;
                }
            } else {
                System.out.println("Por favor, introduzca solo texto");
            }
        } while (!verificar);
    }
    
}
