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
class Guerrero extends Personaje {

    public Guerrero(String nombre) {
        super(150, 18, 12, 6, nombre);

    }
    @Override
    public void ataqueEspecial(Enemigo enemigo) {
        try {
            usarHabilidadEspecial();
            System.out.println(nombre + " usa golpe devastador");
            int dañoEspecial = ataque * 2;
            enemigo.recibirDaño(dañoEspecial);
        } catch (EnergiaInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (JuegoException ex) {
            Logger.getLogger(Guerrero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
