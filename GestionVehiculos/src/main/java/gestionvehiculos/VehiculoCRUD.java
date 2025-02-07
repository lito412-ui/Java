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

    public static void agregarVehiculo(List<Coche> coches, List<Moto> motos) {
        boolean verificar = false;
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
                    coches.add(new Coche(marca, modelo, año, puertas));
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

                    motos.add(new Moto(marca, modelo, año, tieneSidecar));
                    verificar = true;
                }
            } else {
                System.out.println("Por favor, introduzca solo texto");
            }
        } while (!verificar);
    }

    public static void listarVehiculos() {
        List<Coche> coches = new ArrayList<>();
        List<Moto> motos = new ArrayList<>();
        for (int i = 0; i < coches.size(); i++) {
            System.out.println("Marca: " + coches.get(i).getMarca());
            System.out.println("Modelo: " + coches.get(i).getModelo());
            System.out.println("Año: " + coches.get(i).getAño());
            System.out.println("Puertas: " + coches.get(i).getPuertas());
            System.out.println("ID: " + coches.get(i).getId());
        }
        for (int j = 0; j < motos.size(); j++) {
            System.out.println("Marca: " + motos.get(j).getMarca());
            System.out.println("Modelo: " + motos.get(j).getModelo());
            System.out.println("Año: " + motos.get(j).getAño());
            System.out.println("Sidecar: " + motos.get(j).getTieneSidecar());
            System.out.println("ID: " + motos.get(j).getId());
        }
    }
}
