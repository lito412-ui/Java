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
    
    public static void main(String[] args) {
        Personaje jugador = seleccionarClase();
        System.out.println(jugador.vida);
        Enemigo enemigo = Mundo.generarEnemigoAleatorio();
        System.out.println(enemigo.vida);
        Mundo.iniciarCombate(jugador, enemigo);
    }
    
    public static void realizarAccion(Personaje jugador, Personaje enemigo) {
        int accion;
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        do {
            System.out.println("Acciones posibles");
            System.out.println("1- Atacar");
            System.out.println("2- Defender");
            System.out.println("3- Habilidad especial");
            System.out.println("4- Huir");
            accion = leer.nextInt();
            switch (accion) {
                case 1:
                    jugador.atacar(enemigo);
                    break;
                case 2:
                    jugador.vida = jugador.vida - (enemigo.ataque - jugador.defensa);
                    break;
                case 3:

                    break;

                case 4:
                    int huir = (int) (Math.random() * 5) + 1;
                    System.out.println("Intentando huir....");
                    if (huir == 2) {
                        salir = true;
                    } else {
                        System.out.println("No has podido huir, te has visto atraido por el alma del enemigo");
                    }
                    break;

                default:
                    System.out.println("Intentalo de nuevo");
            }
        } while (jugador.vida <= 0 || enemigo.vida <= 0 || !salir);
    }

    public static Personaje seleccionarClase() {
        Personaje jugador = null;
        boolean salir = false;
        Scanner leer = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("Elige tu Personaje");
            System.out.println("-Ninja");
            System.out.println("-Chaman");
            System.out.println("-Guerrero");
            opcion = leer.nextLine().toUpperCase();
            switch (opcion) {
                case "NINJA":
                    jugador = new Ninja(100, 15, 8, 15, "Ataque sigiloso (+5 de daño)");
                    salir = true;
                    break;

                case "CHAMAN":
                    jugador = new Chaman(120, 12, 10, 10, "Curación mística (+20 vida)");
                    salir = true;
                    break;

                case "GUERRERO":
                    jugador = new Guerrero(150,18,12,6,"Golpe devastador (doble daño)");
                    salir = true;
                    break;
                default:
                    System.out.println("Error.....Personaje no valido");
            }
        } while (!salir);
        return jugador;
    }
}
