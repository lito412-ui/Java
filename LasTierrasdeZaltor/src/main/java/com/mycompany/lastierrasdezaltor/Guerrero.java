/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

/**
 *
 * @author Alumno
 */
class Guerrero extends Personaje {

    public int golpeDevastador;

    public Guerrero(int vida, int ataque, int defensa, int velocidad, String habilidad_especial) {
        super(vida, ataque, defensa, velocidad, habilidad_especial);
        golpeDevastador = ataque;

    }

    public void golpeDevastador(Enemigo enemigo) {
        golpeDevastador = golpeDevastador * 2;
        enemigo.vida = enemigo.vida - golpeDevastador;
    }
}
