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
public class Mundo {

    public static Enemigo generarEnemigoAleatorio() {
        int enemigo = (int) (Math.random() * 3) + 1;
        switch (enemigo) {
            case 1:
                return new LoboSalvaje(80, 12, 5, 12, "Mordida rápida (+2 ataque)", 30);
            case 2:
                return new GuerreroOscuro(130, 20, 10, 4, "Furia maldita (+5 ataque)", 50);
            case 3:
                return new NoMuerto(100, 15, 8, 9, "Regeneración (cura 10 vida por turno)", 40);
            default:
                return null;
        }
    }

    public static void iniciarCombate(Personaje Jugador, Enemigo enemigo) {
   
            if(Jugador.velocidad > enemigo.velocidad){
               Juego.realizarAccion(Jugador,enemigo);
            }else{
                Juego.realizarAccion(enemigo, Jugador);
            }
        
    }
}
