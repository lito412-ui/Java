/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

/**
 *
 * @author Alumno
 */
class NoMuerto extends Enemigo {

   public NoMuerto() {
        super("No_Muerto", 100, 15, 8, 5);
    }
   @Override
    public void ataqueEspecial(Personaje jugador) {
        System.out.println(nombre + " usa Regeneración y recupera 10 de vida!");
        vida += 10;
    }
}
