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

    public Chaman(int vida, int ataque, int defensa, int velocidad, String habilidad_especial) {
        super(vida, ataque, defensa, velocidad, habilidad_especial);
    }

    public void curar() {
        vida = vida + 20;
    }
}
