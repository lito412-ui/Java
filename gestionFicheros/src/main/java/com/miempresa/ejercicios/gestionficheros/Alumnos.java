package com.miempresa.ejercicios.gestionficheros;

import java.util.ArrayList;
import java.util.Random;

/**
 * Representa a un alumno con atributos inmutables (DNI, nombre y nota).
 */
public final class Alumnos {

    private final String dni;
    private final String nombre;
    private final double nota;
    private final int edad;
    
    private static final int NUMERO_MAXIMO_ALUMNOS = 1000;

    /**
     * Constructor que crea un alumno con un DNI y nota aleatorios, y el nombre
     * proporcionado.
     *
     * @param nombre El nombre del alumno.
     */
    public Alumnos(String nombre) {
        this.dni = generarDNIAleatorio();
        this.nombre = nombre;
        this.nota = generarNotaAleatoria();
        this.edad = generarEdad();
    }

    /**
     * Genera un DNI aleatorio en formato XXXXXXXXX-X.
     *
     * @return El DNI generado aleatoriamente.
     */
    private String generarDNIAleatorio() {
        Random random = new Random();
        // Parte numérica del DNI
        String numeros = String.format("%08d", random.nextInt(90000000) + 10000000);
        // Letra aleatoria (mayúscula)
        char letra = (char) (random.nextInt(26) + 'A');
        // Combinamos la parte numérica y la letra
        return numeros + letra;
    }

    /**
     * Genera una nota aleatoria entre 0 y 10 con un decimal.
     *
     * @return La nota generada aleatoriamente.
     */
    private double generarNotaAleatoria() {
        Random random = new Random();
        // Genera un número aleatorio entre 0 y 10 con muchos decimales
        double nota = random.nextDouble() * 10;
        // Redondea el número a 2 decimales
        nota = Math.round(nota * 100.0) / 100.0;
        return nota;
    }
    private int generarEdad(){
        int edades = (int)(Math.random() * (60-18)+18);
        return edades;
    }

    // Getters para acceder a los atributos de forma inmutable
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }
    public int getEdad(){
        return edad;
    }

    /**
     * Crea una lista de alumnos con nombres numéricos consecutivos y atributos
     * aleatorios.
     *
     * @param numeroAlumnos El número de alumnos a generar.
     * @return Una lista de objetos Alumnos.
     */
    public static ArrayList<Alumnos> crearListaAlumnos(int numeroAlumnos) {
        ArrayList<Alumnos> listaAlumnos = new ArrayList<>();
        
     //   if(numeroAlumnos > NUMERO_MAXIMO_ALUMNOS ) return listaAlumnos;
        
        for (int i = 0; i <= numeroAlumnos; i++) {
            listaAlumnos.add(new Alumnos("Alumno " + i));
        }
        return listaAlumnos;
    }
}
