/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            jugador.recibirDaño(ataque + 5);
        } catch (JuegoException ex) {
            Logger.getLogger(GuerreroOscuro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ataqueEspecial(Enemigo enemigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
