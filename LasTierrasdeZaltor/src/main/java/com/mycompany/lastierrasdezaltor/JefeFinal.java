/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

/**
 *
 * @author LITO
 */
class JefeFinal extends Enemigo {

    public JefeFinal() {
        super("Malenia, la Espada de Miquella", 320, 48, 27, 23);
    }

    @Override
    public void ataqueEspecial(Personaje jugador) throws JuegoException {
        System.out.println("Malenia desata su poder oscuro (+20 ataque)");
        this.ataque += 20;
        System.out.println("Malenia ataca con su poder oscuro!");
        jugador.recibirDaño(ataque + 15);
    }

    @Override
    public void ataqueEspecial(Enemigo enemigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
