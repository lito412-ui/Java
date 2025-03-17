/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

/**
 *
 * @author Alumno
 */
public class Personaje {

    public int vida;
    public int ataque;
    public int defensa;
    public int velocidad;
    public String habilidad_especial;

    /*
    Constructor
     */
    public Personaje(int vida, int ataque, int defensa, int velocidad, String habilidad_especial) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.habilidad_especial = habilidad_especial;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getHabilidad_especial() {
        return habilidad_especial;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setHabilidad_especial(String habilidad_especial) {
        this.habilidad_especial = habilidad_especial;
    }

    public void recibirDaño(int cantidad) {
        vida = vida - cantidad;
    }

    public void atacar(Personaje enemigo) {
        enemigo.vida = enemigo.vida - ataque;
    }

    public boolean estaVivo() {
        boolean vivo;
        if (vida <= 0) {
            vivo = false;
        } else {
            vivo = true;
        }
        return vivo;
    }

}
