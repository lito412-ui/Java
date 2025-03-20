/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

/**
 *
 * @author Alumno
 */
class GuerreroOscuro extends Enemigo {

    public GuerreroOscuro() {
        super("Guerrero Oscuro", 130, 20, 10, 8);
    }
    @Override
    public void ataqueEspecial(Personaje jugador) {
        System.out.println(nombre + " usa Furia Maldita!");
        jugador.recibirDaño(ataque + 5);
    }}
