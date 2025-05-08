/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LITO
 */

import java.sql.*;
import java.time.LocalDateTime;
import com.mycompany.lastierrasdezaltor.Personaje;
import com.mycompany.lastierrasdezaltor.Guerrero;
import com.mycompany.lastierrasdezaltor.Ninja;
import com.mycompany.lastierrasdezaltor.Chaman;

public class TierrasDeZaltorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/zaltor";
    private static final String USER = "root";
    private static final String PASS = "changeme";

    private static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Cargar personaje por nombre
    public static Personaje cargarPersonaje(String nombre, String clase) {
        String sql = "SELECT * FROM personajes WHERE nombre = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int vida = rs.getInt("vida");
                int ataque = rs.getInt("ataque");
                int defensa = rs.getInt("defensa");
                int velocidad = rs.getInt("velocidad");
                int nivel = rs.getInt("nivel");
                int experiencia = rs.getInt("experiencia");
                int energia = rs.getInt("energia");

                Personaje personaje = crearInstanciasPersonajes(clase, vida, ataque, defensa, velocidad, nombre);
                personaje.nivel = nivel;
                personaje.experiencia = experiencia;
                personaje.energia = energia;
                return personaje;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Guardar o actualizar personaje
    public static void guardarOActualizar(Personaje p, String clase) {
        String select = "SELECT * FROM personajes WHERE nombre = ?";
        String insert = "INSERT INTO personajes (nombre, clase, nivel, experiencia, vida, ataque, defensa, velocidad, energia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String update = "UPDATE personajes SET nivel=?, experiencia=?, vida=?, ataque=?, defensa=?, velocidad=?, energia=? WHERE nombre=?";

        try (Connection conn = conectar();
             PreparedStatement check = conn.prepareStatement(select)) {

            check.setString(1, p.getNombre());
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                try (PreparedStatement stmt = conn.prepareStatement(update)) {
                    stmt.setInt(1, p.nivel);
                    stmt.setInt(2, p.experiencia);
                    stmt.setInt(3, p.vida);
                    stmt.setInt(4, p.ataque);
                    stmt.setInt(5, p.defensa);
                    stmt.setInt(6, p.velocidad);
                    stmt.setInt(7, p.energia);
                    stmt.setString(8, p.getNombre());
                    stmt.executeUpdate();
                }
            } else {
                try (PreparedStatement stmt = conn.prepareStatement(insert)) {
                    stmt.setString(1, p.getNombre());
                    stmt.setString(2, clase);
                    stmt.setInt(3, p.nivel);
                    stmt.setInt(4, p.experiencia);
                    stmt.setInt(5, p.vida);
                    stmt.setInt(6, p.ataque);
                    stmt.setInt(7, p.defensa);
                    stmt.setInt(8, p.velocidad);
                    stmt.setInt(9, p.energia);
                    stmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Guardar combate
    public static void registrarCombate(String nombreJugador, String enemigo, String resultado, int expGanada) {
        String sql = "INSERT INTO combates (nombre_personaje, enemigo, resultado, experiencia_ganada, fecha) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreJugador);
            stmt.setString(2, enemigo);
            stmt.setString(3, resultado);
            stmt.setInt(4, expGanada);
            stmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Crear instancias de personajes
    private static Personaje crearInstanciasPersonajes(String clase, int vida, int ataque, int defensa, int velocidad, String nombre) {
        switch (clase.toLowerCase()) {
            case "guerrero":
                return new Guerrero(nombre);
            case "ninja":
                return new Ninja(nombre);
            case "chaman":
                return new Chaman(nombre);
            default:
                throw new IllegalArgumentException("Clase de personaje no reconocida: " + clase);
        }
    }
}
