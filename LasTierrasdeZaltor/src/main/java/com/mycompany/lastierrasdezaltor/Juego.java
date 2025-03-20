/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Juego {

    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido a Zaltor. Elige tu clase: 1. Guerrero ||| 2. Ninja ||| 3. Chamán");
        int opcion = leer.nextInt();
        leer.nextLine();
        System.out.println("Introduce tu nombre: ");
        String nombre = leer.nextLine();

        Personaje jugador;
        switch (opcion) {
            case 1:
                jugador = new Guerrero(nombre);
                break;
            case 2:
                jugador = new Ninja(nombre);
                break;
            default:
                jugador = new Chaman(nombre);
                break;
        }

        System.out.println("¡¡" + jugador.nombre + " ha comenzado su aventura!!");

        while (jugador.nivel < 5) {
            Enemigo enemigo = Mundo.generarEnemigoAleatorio();
            System.out.println("¡Un " + enemigo.nombre + " aparece!");
            Mundo.iniciarCombate(jugador, enemigo);
            if (!jugador.estaVivo()) {
                System.out.println("Has sido derrotado. Fin del juego.");
                return;
            }
        }

        System.out.println("¡Has alcanzado el nivel 5! Es hora de enfrentar a Malenia, la Espada de Miquella.");
        JefeFinal jefe_final = new JefeFinal();
        Mundo.iniciarCombate(jugador, jefe_final);

        if (jugador.estaVivo()) {
            System.out.println("¡Has derrotado a Malenia y restaurado la paz en Zaltor! Eres un héroe legendario.");
        } else {
            System.out.println("Malenia&& ha vencido. Zaltor sigue en la oscuridad...");
        }
    }
}
