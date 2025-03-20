/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

/**
 *
 * @author Alumno
 */
class LoboSalvaje extends Enemigo {

    public LoboSalvaje() {
        super("Lobo Salvaje", 80, 12, 5, 10);
    }

    @Override
    public void ataqueEspecial(Personaje jugador) {
        System.out.println(nombre + " usa Mordida Rápida!");
        jugador.recibirDaño(ataque + 2);
    }
}
