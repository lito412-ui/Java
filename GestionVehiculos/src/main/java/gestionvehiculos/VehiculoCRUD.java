/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionvehiculos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.Scanner;

/**
 *
 * @author 1ª DAW
 */
public class VehiculoCRUD {

    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static void agregarVehiculo() {
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

    }

    public static void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados");
        } else {
            System.out.println("\nCoches");
            for (Vehiculo v : vehiculos) {
                if (v instanceof Coche) {
                    System.out.println("Marca: " + v.getMarca());
                    System.out.println("Modelo: " + v.getModelo());
                    System.out.println("Año: " + v.getAño());
                    System.out.println("Puertas: " + ((Coche) v).getPuertas());
                    System.out.println("ID: " + v.getId());
                    System.out.println();
                }
            }
            System.out.println("\nMotos");
            for (Vehiculo v : vehiculos) {
                if (v instanceof Moto) {
                    System.out.println("Marca: " + v.getMarca());
                    System.out.println("Modelo: " + v.getModelo());
                    System.out.println("Año: " + v.getAño());
                    System.out.println("Sidecar: " + ((Moto) v).getTieneSidecar());
                    System.out.println("ID: " + v.getId());
                    System.out.println();
                }
            }
        }
    }

    public static boolean eliminarVehiculo(UUID id) {
        Iterator<Vehiculo> iterator = vehiculos.iterator();

        while (iterator.hasNext()) {
            Vehiculo v = iterator.next();
            if (v.getId().equals(id)) {
                iterator.remove();
                System.out.println("Vehiculo con ID: " + id + " eliminado correctamente");
                return true;
            }
        }

        System.out.println("No se encontro un vehiculo con esa ID.");
        return false;
    }

    public static void listarPorTipo() {
        boolean verificar = false;
        Scanner leer = new Scanner(System.in);
        String texto;
        do {

            System.out.println("Que tipo de vehiculos quieres listar -------- COCHE O MOTO");
            if (leer.hasNextLine()) {
                texto = leer.nextLine().toUpperCase();
                if (texto.equals("COCHE")) {
                    System.out.println("\nCoches");
                    for (Vehiculo v : vehiculos) {
                        if (v instanceof Coche) {
                            System.out.println("Marca: " + v.getMarca());
                            System.out.println("Modelo: " + v.getModelo());
                            System.out.println("Año: " + v.getAño());
                            System.out.println("Puertas: " + ((Coche) v).getPuertas());
                            System.out.println("ID: " + v.getId());
                            System.out.println();
                            verificar = true;
                        }
                    }
                } else if (texto.equals("MOTO")) {
                    System.out.println("\nMotos");
                    for (Vehiculo v : vehiculos) {
                        if (v instanceof Moto) {
                            System.out.println("Marca: " + v.getMarca());
                            System.out.println("Modelo: " + v.getModelo());
                            System.out.println("Año: " + v.getAño());
                            System.out.println("Sidecar: " + ((Moto) v).getTieneSidecar());
                            System.out.println("ID: " + v.getId());
                            System.out.println();
                            verificar = true;
                        }
                    }
                }
            } else {
                System.out.println("Escribe solo letras; coche o moto");
            }
        } while (!verificar);

    }

    public static void guardarVehiculos() {
        File archivo = new File("vehiculos.txt");
        try {
            FileWriter escritor = new FileWriter(archivo);
            for (Vehiculo v : vehiculos) {
                if (v instanceof Coche) {
                    escritor.write("COCHE----> " + "Marca: " + v.getMarca() + "\t" + "Modelo: " + v.getModelo() + "\t" + "Año: " + v.getAño() + "\t" + "Puertas: " + ((Coche) v).getPuertas() + "\t" + "ID: " + v.getId() + "\t");
                    escritor.write("\n");
                } else if (v instanceof Moto) {
                    escritor.write("MOTO-----> " + "Marca: " + v.getMarca() + "\t" + "Modelo: " + v.getModelo() + "\t" + "Año: " + v.getAño() + "\t" + "Tiene Sidecar: " + ((Moto) v).getTieneSidecar() + "\t" + "ID: " + v.getId() + "\t");
                    escritor.write("\n");
                }
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }
    }

    public static void cargarVehiculos() {
        File archivo = new File("vehiculos.txt");
        try {
            Scanner leer = new Scanner(archivo);
            while (leer.hasNextLine()) {
                System.out.println(leer.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
