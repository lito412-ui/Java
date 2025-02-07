package gestionvehiculos;


class Coche extends Vehiculo {

    int puertas;

    public Coche(String marca, String modelo, int año, int puertas) {
        super(marca, modelo, año);
        this.puertas = puertas;

    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    @Override
    void mostrarInfo() {

    }

}
