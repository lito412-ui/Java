/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

/**
 *
 * @author Alumno
 */
class Ninja extends Personaje {

    public Ninja(String nombre) {
        super(100, 15, 8, 15, nombre);
    }

    public void ataqueSigiloso(Personaje enemigo) {
        System.out.println(nombre + " usa Ataque Sigiloso!");
        enemigo.recibirDaño(ataque + 5);
    }
}
