/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

/**
 *
 * @author LITO
 */
public class JefeFinal extends Enemigo{

    public JefeFinal() {
        super("Malenia, la Espada de Miquella", 320, 28, 17, 13);
    }
    public void ataqueEspecial() {
        System.out.println("Malenia desata su poder oscuro (+10 ataque)");
        this.ataque += 10;
    }

    @Override
    public void ataqueEspecial(Personaje jugador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

