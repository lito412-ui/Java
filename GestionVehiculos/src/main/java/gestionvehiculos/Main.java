/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionvehiculos;

import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author 1ª DAW
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean salir = false;
        int menu = 0;
        do {
            System.out.println();
            System.out.println("Elija una opción");
            System.out.println("1. Agregar un vehiculo.");
            System.out.println("2. Listar todos los vehículos.");
            System.out.println("3. Eliminar un vehículo por ID.");
            System.out.println("4. Filtrar vehículos por tipo (Coche/Moto).");
            System.out.println("5. Guardar Vehiculos en .TXT.");
            System.out.println("6. Cargar Vehiculos.");
            System.out.println("7. Salir del programa.");
            if (leer.hasNextInt()) {
                menu = leer.nextInt();
            } else {
                System.out.println("Escribe solo números");
                leer.next();
            }

            switch (menu) {
                case 1:
                    VehiculoCRUD.agregarVehiculo();
                    break;
                case 2:
                    VehiculoCRUD.listarVehiculos();
                    break;
                case 3:
                    eliminarVehiculo();
                    break;
                case 4:
                    VehiculoCRUD.listarPorTipo();
                    break;

                case 5:
                    VehiculoCRUD.guardarVehiculos();
                    break;
                case 6:
                    VehiculoCRUD.cargarVehiculos();
                    break;
                case 7:
                    System.out.println("SALIENDO ...... ");
                    salir = true;
                    break;
                default:
                    System.out.println("A ver si aprendemos a leer, intentalo de nuevo");
            }
        } while (!salir);

    }

    private static void eliminarVehiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el ID del vehículo a eliminar: ");
        String idTexto = scanner.nextLine();

        try {
            UUID id = UUID.fromString(idTexto);
            VehiculoCRUD.eliminarVehiculo(id);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: ID no válido.");
        }
    }

}
