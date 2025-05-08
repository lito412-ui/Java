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
public class Ninja extends Personaje {

    public Ninja(String nombre) {
        super(100, 15, 8, 15, nombre);
    }

    @Override
    public void ataqueEspecial(Enemigo enemigo) {
        try {
            usarHabilidadEspecial();
            System.out.println(nombre + " usa Ataque Sigiloso!");
            int dañoEspecial = ataque + 40;
            enemigo.recibirDaño(dañoEspecial);
        } catch (EnergiaInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (JuegoException ex) {
            Logger.getLogger(Ninja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
