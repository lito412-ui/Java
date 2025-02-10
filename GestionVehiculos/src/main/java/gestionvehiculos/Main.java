/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionvehiculos;

import java.util.ArrayList;
import java.util.List;
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
        Vehiculo v = null;
        Scanner leer = new Scanner(System.in);
        ArrayList<Vehiculo> veh = new ArrayList<>();

        boolean salir = false;
        int menu = 0;
        do {
            System.out.println("Elija una opción");
            System.out.println("1. Agregar un vehiculo.");
            System.out.println("2. Listar todos los vehículos.");
            System.out.println("3. Eliminar un vehículo por ID.");
            System.out.println("4. Filtrar vehículos por tipo (Coche/Moto).");
            System.out.println("5. Salir del programa.");
            menu = leer.nextInt();

            switch (menu) {
                case 1:
                    veh = VehiculoCRUD.agregarVehiculo(v);
                    break;
                case 2:
                    VehiculoCRUD.listarVehiculos(veh);
                    break;
                case 3:
                    System.out.println("SALIENDO ...... ");
                    salir = true;
            }
        } while (!salir);

    }

}
