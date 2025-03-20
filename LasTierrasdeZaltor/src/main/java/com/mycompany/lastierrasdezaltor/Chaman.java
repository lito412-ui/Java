/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

/**
 *
 * @author Alumno
 */
class Chaman extends Personaje {

    public Chaman(String nombre) {
        super(120, 12, 10, 10, nombre);
    }

    public void curar() {
        System.out.println(nombre + " usa Curación! Recupera 20 de vida.");
        vida += 20;
    }
}
