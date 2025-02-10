/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionvehiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 1ª DAW
 */
public class VehiculoCRUD {

    public static ArrayList agregarVehiculo(Vehiculo v) {
        boolean verificar = false;
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        do {
            String marca;
            boolean tieneSidecar = false;
            String modelo;
            String sidecar;
            int año;
            int puertas;
            Scanner leer2 = new Scanner(System.in);
            String texto;
            Scanner leer = new Scanner(System.in);
            System.out.println("¿Qué tipo de vehículo vas a agregar ----- COCHE O MOTO?");
            if (leer.hasNextLine()) {
                texto = leer.nextLine().toUpperCase();
                if (texto.equals("COCHE")) {
                    System.out.println("MARCA: ");
                    marca = leer.nextLine();
                    System.out.println("MODELO: ");
                    modelo = leer.nextLine();
                    System.out.println("AÑO: ");
                    año = leer.nextInt();
                    System.out.println("PUERTAS: ");
                    puertas = leer.nextInt();
                    vehiculos.add(new Coche(marca, modelo, año, puertas));
                    verificar = true;
                } else if (texto.equals("MOTO")) {
                    System.out.println("MARCA: ");
                    marca = leer.nextLine();
                    System.out.println("MODELO: ");
                    modelo = leer.nextLine();
                    System.out.println("AÑO: ");
                    año = leer.nextInt();
                    System.out.println("¿Tiene Sidecar? ");
                    sidecar = leer2.nextLine().toUpperCase();
                    if (sidecar.equals("SI")) {
                        tieneSidecar = true;
                    } else {
                        tieneSidecar = false;
                    }

                    vehiculos.add(new Moto(marca, modelo, año, tieneSidecar));
                    verificar = true;
                }
            } else {
                System.out.println("Por favor, introduzca solo texto");
            }
        } while (!verificar);
        return vehiculos;
    }

    public static ArrayList listarVehiculos(ArrayList<Vehiculo> vehiculos) {
        System.out.println("\nCoches");
        for (Vehiculo v : vehiculos) {
            if (v instanceof Coche) {
                System.out.println("Marca: " + v.getMarca());
                System.out.println("Modelo: " + v.getModelo());
                System.out.println("Año: " + v.getAño());
                System.out.println("Puertas: " + ((Coche) v).getPuertas());
                System.out.println("ID: " + v.getId());
            }
        }
        System.out.println("\nMotos");
        for (Vehiculo v : vehiculos){
            if (v instanceof Moto){
                System.out.println("Marca: " + v.getMarca());
                System.out.println("Modelo: " + v.getModelo());
                System.out.println("Año: " + v.getAño());
                System.out.println("Sidecar: " + ((Moto) v).getTieneSidecar());
                System.out.println("ID: " + v.getId());
            }
        }
        return vehiculos;
    }
}
