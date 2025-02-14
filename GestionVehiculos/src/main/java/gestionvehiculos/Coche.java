package gestionvehiculos;


class Coche extends Vehiculo {

    int puertas;

    public Coche(String marca, String modelo, int año, int puertas) {
        super(marca,modelo,año);
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
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Año : " + this.año);
        System.out.println("Puertas : " + this.puertas);
        System.out.println("ID: " + this.id);
    }

}
