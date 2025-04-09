
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

    public static void main(String[] args) throws JuegoException {
        Logger.registrarLog("Inicia el Programa");
        System.out.println("Bienvenido a Zaltor. Elige tu clase: 1. Guerrero ||| 2. Ninja ||| 3. Chamán");
        Logger.registrarLog("Elige Personaje");
        int opcion = leer.nextInt();
        leer.nextLine();
        System.out.println("Introduce tu nombre: ");
        String nombre = leer.nextLine();
        Logger.registrarLog("Se introduce un nombre, Introducido " + nombre);

        Personaje jugador;
        switch (opcion) {
            case 1:
                jugador = new Guerrero(nombre);
                Logger.registrarLog(nombre + " ha elegido un guerrero");
                break;
            case 2:
                jugador = new Ninja(nombre);
                Logger.registrarLog(nombre + " ha elegido un ninja");
                break;
            default:
                jugador = new Chaman(nombre);
                Logger.registrarLog(nombre + " ha elegido un chaman");
                break;
        }
        Logger.registrarLog(nombre + " ha elegido un personaje");
        System.out.println("¡¡" + jugador.nombre + " ha comenzado su aventura!!");

        while (jugador.nivel < 5) {
            System.out.println("¿Qué deseas hacer? 1. Explorar ||| 2. Avanzar");
            int accion = leer.nextInt();
            leer.nextLine();
            Logger.registrarLog(nombre + " elige explorar o avanzar");
            
            if (accion == 1) {
                Logger.registrarLog(nombre + " ha elegido explorar");
                System.out.println("¿Qué zona deseas explorar? (Bosque, Cueva, Mazmorra)");
                String zona = leer.nextLine();
                try {
                    Mundo.explorarZona(zona);
                    System.out.println("Has encontrado un enemigo!");
                } catch (ZonaBloqueadaException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }
            
            Enemigo enemigo = Mundo.generarEnemigoAleatorio();
            System.out.println("¡Un " + enemigo.nombre + " aparece!");
            Mundo.iniciarCombate(jugador, enemigo);
            
            if (!jugador.estaVivo()) {
                System.out.println("Has sido derrotado. Fin del juego.");
                Logger.registrarLog(nombre + " ha sido derrotado, fin del juego");
                return;
            }
        }


        System.out.println("¡Has alcanzado el nivel 5! Es hora de enfrentar a Malenia, la Espada de Miquella.");
        Logger.registrarLog(nombre + " ha alcanzado el nivel 5");
        JefeFinal jefe_final = new JefeFinal();
        Mundo.iniciarCombate(jugador, jefe_final);

        if (jugador.estaVivo()) {
            System.out.println("¡Has derrotado a Malenia y restaurado la paz en Zaltor! Eres un héroe legendario.");
            Logger.registrarLog(nombre + " ha derrotado a Malenia");
        } else {
            System.out.println("Malenia&& ha vencido. Zaltor sigue en la oscuridad...");
            Logger.registrarLog(nombre + " ha sido derrotado por Malenia");
        }
    }
}
