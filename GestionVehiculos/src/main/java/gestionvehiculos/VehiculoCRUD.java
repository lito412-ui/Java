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
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import java.util.Scanner;

/**
 *
 * @author 1ª DAW
 */
public class VehiculoCRUD {

    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static final String ARCHIVO_JSON = "vehiculos.json";
    private static final String ARCHIVO_LOG = "log.txt";

    public static void agregarVehiculo() {
        boolean verificar = false;
        String marca = "";
        String modelo = "";
        do {
            boolean tieneSidecar = false;
            boolean numero_año = false;
            boolean numero_puertas = false;
            String sidecar;
            int año = 0;
            int puertas = 0;
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
                    do {
                        System.out.println("AÑO: ");
                        if (leer.hasNextInt()) {
                            año = leer.nextInt();
                            numero_año = true;
                        } else {
                            leer.next();
                        }
                    } while (!numero_año);
                    do {
                        System.out.println("PUERTAS: ");
                        if (leer.hasNextInt()) {
                            puertas = leer.nextInt();
                            numero_puertas = true;
                        } else {
                            leer.next();
                        }
                    } while (!numero_año);

                    vehiculos.add(new Coche(marca, modelo, año, puertas));
                    verificar = true;
                } else if (texto.equals("MOTO")) {
                    System.out.println("MARCA: ");
                    marca = leer.nextLine();
                    System.out.println("MODELO: ");
                    modelo = leer.nextLine();
                    do {
                        System.out.println("AÑO: ");
                        if (leer.hasNextInt()) {
                            año = leer.nextInt();
                            numero_año = true;
                        } else {
                            leer.next();
                        }
                    } while (!numero_año);

                    System.out.println("¿Tiene Sidecar? ");
                    sidecar = leer2.nextLine().toUpperCase();
                    if (sidecar.equals("SI") || sidecar.equals("TRUE")) {
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
        registrarLog("Vehículo agregado: " + marca + " " + modelo);
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
        registrarLog("Lista de vehículos mostrada.");
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
        registrarLog("Intento de eliminar vehículo no encontrado: " + id);
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

    public static void modificarVehiculo() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Introduce el ID del vehículo a modificar: ");
        UUID id = UUID.fromString(leer.nextLine());

        for (Vehiculo v : vehiculos) {
            if (v.getId().equals(id)) {
                System.out.print("Nueva marca: ");
                v.setMarca(leer.nextLine());
                System.out.print("Nuevo modelo: ");
                v.setModelo(leer.nextLine());
                System.out.print("Nuevo año: ");
                v.setAño(leer.nextInt());
                registrarLog("Vehículo modificado: " + v.getId());

                return;
            }
        }
        System.out.println("Vehículo no encontrado.");
        registrarLog("Intento de modificar vehículo no encontrado: " + id);
    }

    public static void ordenarPorAño() {
        vehiculos.sort(Comparator.comparingInt(Vehiculo::getAño));
        System.out.println("Vehiculos Ordenados por Año");
    }

    private static void registrarLog(String mensaje) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_LOG, true))) {
            bw.write(new Date() + " - " + mensaje + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
