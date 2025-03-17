/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

/**
 *
 * @author Alumno
 */
class Enemigo extends Personaje {

    public int exp;

    public Enemigo(int vida, int ataque, int defensa, int velocidad, String habilidad_especial, int exp) {
        super(vida, ataque, defensa, velocidad, habilidad_especial);
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void ataqueEspecial() {

    }
}
