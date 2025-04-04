/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionvehiculos;


/**
 *
 * @author 1ª DAW
 */
class Moto extends Vehiculo {

    boolean tieneSidecar;

    public Moto(String marca, String modelo, int año, boolean tieneSidecar) {
        super(marca, modelo, año);
        this.tieneSidecar = tieneSidecar;

    }

    public boolean getTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
    }

    @Override
    void mostrarInfo() {
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Año : " + this.año);
        System.out.println("Sidecar : " + this.tieneSidecar);
        System.out.println("ID: " + this.id);
    }

}
