/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.miempresa.ejercicios.banco;

import java.util.ArrayList;

/**
 *
 * @author 1ª DAW
 */
public class GestionCuentas {
    
    private static final int MAXIMO_TRANSFERENCIA = 900;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         Creando ArrayList de tipo Cuenta Y Añadiendo datos al arraylist
         **/
        ArrayList<Cuenta> Cuentas = new ArrayList<>();
        Cuentas.add(new Cuenta("ES89696926829601866926", 2000));
        Cuentas.add(new Cuenta("ES92769106869306873959", 2800));
        Cuentas.add(new Cuenta("ES46366636363636328943", 900));
        /**
         Mostrar Cuentas
         **/
        mostrarCuentas(Cuentas);
        System.out.println();
        /**
         Modficando saldo por valor solo cambia dentro delmetodo
         **/
        int saldo = Cuentas.get(0).getSaldo();
        System.out.println("Modificar Saldo Por Valor");
        modificarSaldoPorValor(saldo);
        System.out.println(Cuentas.get(0).getNumeroCuenta() + ": " + Cuentas.get(0).getSaldo() + "€ fuera del metodo");
        /**
         Modificar Saldo por referencia
         **/
        Cuenta cuenta = Cuentas.get(0);
        modificarSaldoPorReferencia(cuenta);
        System.out.println("");
        System.out.println("Modificar Saldo Por referecia");
        System.out.println(Cuentas.get(0).getNumeroCuenta() + ": " + cuenta.getSaldo() + "€");
        System.out.println("");
        /**
         Transferencia Bancaria
         **/
        System.out.println("Transferencia de 900€ " + Cuentas.get(0).getNumeroCuenta() + " ----> " + Cuentas.get(2).getNumeroCuenta());
        if (Cuentas.get(0).getSaldo() < MAXIMO_TRANSFERENCIA) {
            System.out.println(Cuentas.get(0).getNumeroCuenta() + " Error..... No tiene dinero suficiente para realizar la transferecia");
        } else {
            realizarTransferencia(Cuentas.get(0), Cuentas.get(2), 900);
        }
        System.out.println();
        /**
         Mostrar Cuentas Final
         **/
        mostrarCuentas(Cuentas);
    }

    /**
     *
     * @param saldo
     */
    public static void modificarSaldoPorValor(int saldo) {
        saldo += 200;
        System.out.println("ES89696926829601866926: " + saldo + "€ dentro del metodo");
    }

    /**
     *
     * @param cuenta
     */
    public static void modificarSaldoPorReferencia(Cuenta cuenta) {
        cuenta.setSaldo(cuenta.getSaldo() + 500);
    }

    /**
     *
     * @param origen
     * @param destino
     * @param cantidad
     */
    public static void realizarTransferencia(Cuenta origen, Cuenta destino, int cantidad) {
        origen.setSaldo(origen.getSaldo() - cantidad);
        destino.setSaldo(destino.getSaldo() + cantidad);
    }

    /**
     *
     * @param Cuentas
     */
    public static void mostrarCuentas(ArrayList<Cuenta> Cuentas) {
        System.out.println("Informacion sobre las cuentas");
        for (int i = 0; i < Cuentas.size(); i++) {
            System.out.println(Cuentas.get(i).getNumeroCuenta() + ": " + Cuentas.get(i).getSaldo() + "€");
        }
    }
}

/**
 *
 * @author 1ª DAW
 */
class Cuenta {

    /**
     * atributo privado numeroCuenta
     */
    private String numeroCuenta;

    /**
     * atributo privado saldo
     */
    private int saldo;

    /**
     * Constructor
     * @param numeroCuenta
     * @param saldo 
     */
    public Cuenta(String numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    /**
     *GetNumeroCuenta, es decir, tomar el valor de el NumerodeCuenta
     * @return Métodos GET Y SET
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     *GetSaldo, es decir, tomar el valor del saldo de la cuenta
     * @return
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     *SetSalgo, es decir, cambiar saldo de la cuenta
     * @param nuevoSaldo
     */
    public void setSaldo(int nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }

    /**
     *SetNumeroCuenta, es decir, cambiar numero cuenta
     * @param numeroCuenta
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
