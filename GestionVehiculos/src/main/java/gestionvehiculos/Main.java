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
        List<Coche> coches = new ArrayList<>();
        List<Moto> motos = new ArrayList<>();
        VehiculoCRUD.agregarVehiculo(coches, motos);
        VehiculoCRUD.listarVehiculos();

        //pedir al usuario si es coche o moto
        // crear objeto coche o moto
        //añadir
        // vCRUD.agregarVehiculo();
    }

}
