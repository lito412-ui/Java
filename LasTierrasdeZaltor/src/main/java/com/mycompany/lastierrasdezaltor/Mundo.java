/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Mundo {

    private static Scanner leer = new Scanner(System.in);
    private static Random random = new Random();

    static Enemigo generarEnemigoAleatorio() {
        int opcion = random.nextInt(3);
        return switch (opcion) {
            case 0 ->
                new LoboSalvaje();
            case 1 ->
                new GuerreroOscuro();
            default ->
                new NoMuerto();
        };
    }

    /**
     *
     * @param jugador
     * @param enemigo
     */
    static void iniciarCombate(Personaje jugador, Enemigo enemigo) {
        while (jugador.estaVivo() && enemigo.estaVivo()) {
            System.out.println("¿Qué quieres hacer? 1. Atacar |||| 2. Defender");
            int opcion = leer.nextInt();

            if (opcion == 1) {
                jugador.atacar(enemigo);
            } else if (opcion == 2) {
                System.out.println(jugador.getNombre() + " se defiende y reduce el daño.");
                jugador.defender();
            }

            if (enemigo.estaVivo()) {
                int danioRecibido = Math.max(enemigo.ataque - jugador.defensa, 1);
                jugador.recibirDaño(danioRecibido);
                System.out.println(jugador.getNombre() + " ha recibido " + danioRecibido + " de daño. Vida restante: " + jugador.vida);
            }
        }
    }
}
