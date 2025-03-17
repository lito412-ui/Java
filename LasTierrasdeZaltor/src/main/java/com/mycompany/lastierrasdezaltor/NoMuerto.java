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

    public NoMuerto(int vida, int ataque, int defensa, int velocidad, String habilidad_especial, int exp) {
        super(vida, ataque, defensa, velocidad, habilidad_especial, exp);
    }

    @Override
    public void ataqueEspecial() {
        regeneracion();
    }
    void regeneracion(){
    vida = vida +10;
    }
}
