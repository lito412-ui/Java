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
        Logger.registrarLog("Enemigo aleatorio generado correctamente");
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

    static void iniciarCombate(Personaje jugador, Enemigo enemigo) throws JuegoException {
        Logger.registrarLog(jugador.nombre + " ha iniciado un combate contra " + enemigo.nombre);
        boolean jugadorDefendiendo = false; // Indica si el jugador está defendiéndose
        boolean enemigoDefendiendo = false; // Indica si el enemigo está defendiéndose

        while (jugador.estaVivo() && enemigo.estaVivo()) {
            // Turno del jugador
            System.out.println("¿Qué quieres hacer? 1. Atacar |||| 2. Defender |||| 3. Ataque Especial");
            int opcion = leer.nextInt();

            if (opcion == 1) {
                // Jugador ataca al enemigo
                Logger.registrarLog(jugador.nombre + " ataca a " + enemigo.nombre);
                int daño = jugador.getAtaque();
                if (enemigoDefendiendo) {
                    // Si el enemigo se está defendiendo, reduce el daño
                    daño = Math.max(daño - enemigo.getDefensa(), 0);
                    enemigoDefendiendo = false; // Restablece la defensa del enemigo
                }
                System.out.println(jugador.getNombre() + " ataca a " + enemigo.nombre + " y le causa " + daño + " de daño.");
                Logger.registrarLog(enemigo.nombre + " ha recibido " + jugador.ataque + " de daño");
                enemigo.recibirDaño(daño);
            } else if (opcion == 2) {
                // Jugador se defiende
                Logger.registrarLog(jugador.nombre + " se defiende");
                jugador.defender();
                jugadorDefendiendo = true; // Activa la defensa del jugador
            } else if (opcion == 3) {
                // Jugador usa su ataque especial
                Logger.registrarLog(jugador.nombre + " ha usado su ataque especial");
                jugador.ataqueEspecial(enemigo);
            }

            // Verificar si el enemigo sigue vivo después del ataque del jugador
            if (!enemigo.estaVivo()) {
                System.out.println("¡Has derrotado a " + enemigo.nombre + "!");
                Logger.registrarLog(jugador.nombre + "ha derrotado a " + enemigo.nombre);
                int experienciaGanada = 50; // Experiencia base por derrotar a un enemigo
                Logger.registrarLog(jugador.nombre + " ha recibido 50 de experiencia");
                jugador.ganarExperiencia(experienciaGanada);
                break; // Salir del bucle si el enemigo ha sido derrotado
            }

            // Turno del enemigo
            if (enemigo.estaVivo()) {
                System.out.println("¡Es el turno de " + enemigo.nombre + "!");
                int accionEnemigo = random.nextInt(2); // 0: Atacar, 1: Defender

                if (accionEnemigo == 0) {
                    Logger.registrarLog(enemigo.nombre + " ataca a " + jugador.nombre);
                    // Enemigo ataca al jugador
                    int daño = enemigo.getAtaque();
                    if (jugadorDefendiendo) {
                        // Si el jugador se está defendiendo, reduce el daño
                        daño = Math.max(daño - jugador.getDefensa(), 0);
                        jugadorDefendiendo = false; // Restablece la defensa del jugador
                    }
                    System.out.println(enemigo.nombre + " ataca a " + jugador.getNombre() + " y le causa " + daño + " de daño.");
                    jugador.recibirDaño(daño);
                    Logger.registrarLog(jugador.nombre + " ha recibido " + enemigo.ataque + " de daño");
                } else {
                    // Enemigo se defiende
                    Logger.registrarLog(enemigo.nombre + " se ha defendido de los ataques de " + jugador.nombre);
                    System.out.println(enemigo.nombre + " se defiende y reduce el daño en " + enemigo.getDefensa() + " puntos.");
                    enemigoDefendiendo = true; // Activa la defensa del enemigo
                }
            }
        }

        if (!jugador.estaVivo()) {
            System.out.println("Has sido derrotado por " + enemigo.nombre + ". Fin del juego.");
            Logger.registrarLog(jugador.nombre + " ha sido derrotado por " + enemigo.nombre);
        }
    }

    public static void explorarZona(String zona) throws ZonaBloqueadaException {
        if (zona.equalsIgnoreCase("Mazmorra")) {
            throw new ZonaBloqueadaException("No puedes entrar a la mazmorra sin la Llave de las Tinieblas.");
            
        }
        System.out.println("Explorando la zona: " + zona);
    }
}
