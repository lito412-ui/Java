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
class Chaman extends Personaje {

    public Chaman(String nombre) {
        super(120, 12, 10, 10, nombre);
    }

    @Override
    public void ataqueEspecial(Enemigo enemigo) {
        try {
            usarHabilidadEspecial();
            System.out.println(nombre + " usa Tormenta Arcana!");
            int dañoEspecial = ataque + 30;
            enemigo.recibirDaño(dañoEspecial);
            vida += 15; // El chamán se cura un poco
            System.out.println(nombre + " recupera 15 puntos de vida.");
        } catch (EnergiaInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (JuegoException ex) {
            Logger.getLogger(Chaman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
