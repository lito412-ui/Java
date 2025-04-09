/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

import java.util.Random;

/**
 *
 * @author Alumno
 */
public abstract class Personaje {

    public String nombre;
    public int vida;
    public int ataque;
    public int defensa;
    public int velocidad;
    public String habilidad_especial;
    public int nivel;
    public int experiencia;
    public int energia;

    /*
    Constructor
     */
    public Personaje(int vida, int ataque, int defensa, int velocidad, String nombre) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.nivel = 1;
        this.experiencia = 0;
        this.energia = 60;
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

    public String getNombre() {
        return nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void recibirDaño(int cantidad) throws JuegoException {
        vida -= cantidad; // El daño se aplica directamente sin restar la defensa
        System.out.println(nombre + " ha recibido " + cantidad + " de daño. Vida restante: " + vida);
        if (vida <= 0) {
            throw new JuegoException(nombre + " ha sido derrotado.");
        }
    }

    public void atacar(Personaje enemigo) throws JuegoException {
        int daño = this.ataque - enemigo.defensa;
        if (daño < 0) {
            daño = 0;
        }
        enemigo.recibirDaño(daño);
        System.out.println(enemigo.getNombre() + " ha recibido " + daño + " de daño. Vida restante: " + enemigo.vida);
    }

    public void subirNivel() {
        while (experiencia >= 100) {
            experiencia -= 100;
            nivel++;
            vida += 20;
            ataque += 7;
            defensa += 5;
            System.out.println("¡" + nombre + " subió al nivel " + nivel + "!!!!");
            Logger.registrarLog(nombre + " sube de nivel");
        }
    }

    public void defender() {
        System.out.println(nombre + " se defiende y reduce el daño en " + defensa + " puntos.");
    }

    public void ganarExperiencia(int exp) {
        experiencia = experiencia + exp;
        System.out.println(nombre + " ganó " + exp + " de experiencia.");
        subirNivel();
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
    public void usarHabilidadEspecial() throws EnergiaInsuficienteException {
        if (energia < 20) {
            throw new EnergiaInsuficienteException(nombre + " no tiene suficiente energía para usar su habilidad especial.");
        }
        energia -= 20;
        System.out.println(nombre + " usa una habilidad especial.");
    }
    public abstract void ataqueEspecial(Enemigo enemigo);
}
