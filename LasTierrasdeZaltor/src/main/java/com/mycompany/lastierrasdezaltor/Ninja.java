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

    public int ataqueSigiloso;

    public Ninja(int vida, int ataque, int defensa, int velocidad, String habilidad_especial) {
        super(vida, ataque, defensa, velocidad, habilidad_especial);
        ataqueSigiloso = ataque;
    }

    public void ataqueSigiloso(Enemigo enemigo) {
        ataqueSigiloso = ataqueSigiloso + 5;
        enemigo.vida = enemigo.vida - ataqueSigiloso;
    }
}
