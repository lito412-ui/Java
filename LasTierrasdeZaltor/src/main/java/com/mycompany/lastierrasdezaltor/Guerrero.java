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

    public Guerrero(String nombre) {
        super(150, 18, 12, 6, nombre);

    }

    public void golpeDevastador(Enemigo enemigo) {
        System.out.println(nombre + " usa Golpe Devastador!");
        enemigo.recibirDaño(ataque * 2);
    }
}
