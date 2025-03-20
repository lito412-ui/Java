/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

/**
 *
 * @author Alumno
 */
abstract class Enemigo extends Personaje {

    public Enemigo(String nombre, int vida, int ataque, int defensa, int velocidad) {
        super(vida, ataque, defensa, velocidad, nombre);
    }

    public abstract void ataqueEspecial(Personaje jugador);
}
