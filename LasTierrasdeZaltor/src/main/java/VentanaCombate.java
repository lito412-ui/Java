/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LITO
 */
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class VentanaCombate extends JFrame {

    private JPanel panelPrincipal;
    private JTextArea logBatalla;
    private JButton btnCombate, btnBolsa, btnHuir, btnSalir, btnBoss;
    private JLabel lblJugador, lblEnemigo, lblNivel, lblExperiencia;
    private JProgressBar barraVidaJugador, barraVidaEnemigo;
    private Personaje jugador;
    private Enemigo enemigo;
    private boolean elixirActivo = false;
    private int experiencia = 0;
    private int nivel = 1;

    public VentanaCombate() {
        setTitle("Las Tierras de Zaltor - Combate");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        String nombreJugador = JOptionPane.showInputDialog(this, "Ingresa tu nombre:");
        String[] clases = {"Chamán", "Ninja", "Guerrero"};
        int claseElegida = JOptionPane.showOptionDialog(this, "Elige tu personaje:", "Personaje",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, clases, clases[0]);

        switch (claseElegida) {
            case 0 ->
                jugador = new Chaman(nombreJugador);
            case 1 ->
                jugador = new Ninja(nombreJugador);
            case 2 ->
                jugador = new Guerrero(nombreJugador);
            default ->
                jugador = new Chaman(nombreJugador);
        }

        generarEnemigoAleatorio();
        inicializarInterfaz();
    }

    private void generarEnemigoAleatorio() {
        Random rand = new Random();
        int enemigoAleatorio = rand.nextInt(3);
        enemigo = switch (enemigoAleatorio) {
            case 0 ->
                new GuerreroOscuro("Guerrero Oscuro");
            case 1 ->
                new NoMuerto("NoMuerto");
            default ->
                new LoboSalvaje("Lobo Salvaje");
        };
    }

    private void inicializarInterfaz() {
        panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelCombate = new JPanel(null);
        panelCombate.setPreferredSize(new Dimension(900, 300));
        panelCombate.setBackground(new Color(210, 255, 210));

        lblJugador = new JLabel(jugador.getNombre() + " (" + jugador.getClass().getSimpleName() + ")", JLabel.CENTER);
        lblJugador.setBounds(100, 150, 200, 30);
        lblJugador.setFont(new Font("Arial", Font.BOLD, 16));

        File archivoJugador = new File("personaje.png");
        if (!archivoJugador.exists()) {
            System.out.println("La imagen personaje.png no se encuentra.");
        } else {
            System.out.println("Imagen personaje.png encontrada.");
        }

        File archivoEnemigo = new File("enemigo.png");
        if (!archivoEnemigo.exists()) {
            System.out.println("La imagen enemigo.png no se encuentra.");
        } else {
            System.out.println("Imagen enemigo.png encontrada.");
        }

        barraVidaJugador = new JProgressBar(0, jugador.getVida());
        barraVidaJugador.setValue(jugador.getVida());
        barraVidaJugador.setStringPainted(true);
        barraVidaJugador.setBounds(100, 120, 200, 20);

        
        ImageIcon imagenJugador = new ImageIcon("personaje.png");
        Image imgJugador = imagenJugador.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imagenJugador = new ImageIcon(imgJugador);
        
        JLabel circuloJugador = new JLabel(imagenJugador);
        circuloJugador.setBounds(140, 180, 180, 180);
        circuloJugador .setOpaque(true);
        circuloJugador.setBackground(Color.LIGHT_GRAY);
        circuloJugador.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        lblEnemigo = new JLabel(enemigo.getNombre(), JLabel.CENTER);
        lblEnemigo.setBounds(550, 30, 150, 30);
        lblEnemigo.setFont(new Font("Arial", Font.BOLD, 16));

        barraVidaEnemigo = new JProgressBar(0, enemigo.getVida());
        barraVidaEnemigo.setValue(enemigo.getVida());
        barraVidaEnemigo.setStringPainted(true);
        barraVidaEnemigo.setBounds(550, 60, 200, 20);

        ImageIcon imagenEnemigo = new ImageIcon("enemigo.png");
        Image imagenEnemigoEscalada = imagenEnemigo.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        imagenEnemigo = new ImageIcon(imagenEnemigoEscalada);

        JLabel circuloEnemigo = new JLabel(imagenEnemigo);
        circuloEnemigo.setBounds(580, 90, 180, 180);
        circuloEnemigo.setOpaque(true);
        circuloEnemigo.setBackground(Color.GRAY);
        circuloEnemigo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panelCombate.add(lblJugador);
        panelCombate.add(barraVidaJugador);
        panelCombate.add(circuloJugador);
        panelCombate.add(lblEnemigo);
        panelCombate.add(barraVidaEnemigo);
        panelCombate.add(circuloEnemigo);

        panelPrincipal.add(panelCombate, BorderLayout.CENTER);

        logBatalla = new JTextArea(8, 20);
        logBatalla.setEditable(false);
        logBatalla.setLineWrap(true);
        logBatalla.setWrapStyleWord(true);
        JScrollPane scrollLog = new JScrollPane(logBatalla);
        JPanel panelLog = new JPanel(new BorderLayout());
        panelLog.add(scrollLog, BorderLayout.CENTER);
        panelLog.setPreferredSize(new Dimension(250, 150));

        JPanel panelMenu = new JPanel(new GridLayout(2, 3, 10, 10));
        btnCombate = new JButton("Combate");
        btnSalir = new JButton("Salir");
        btnBolsa = new JButton("Bolsa");
        btnHuir = new JButton("Huir");
        btnBoss = new JButton("Jefe Final");

        btnCombate.addActionListener(e -> mostrarSubmenuCombate());
        btnSalir.addActionListener(e -> System.exit(0));
        btnBolsa.addActionListener(e -> mostrarSubmenuBolsa());
        btnHuir.addActionListener(e -> intentarHuir());
        btnBoss.addActionListener(e -> combatirJefeFinal());

        panelMenu.add(btnCombate);
        panelMenu.add(btnBolsa);
        panelMenu.add(btnHuir);
        panelMenu.add(btnBoss);
        panelMenu.add(btnSalir);

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelInferior.add(panelMenu, BorderLayout.CENTER);
        panelInferior.add(panelLog, BorderLayout.EAST);

        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        // Panel de nivel y experiencia
        JPanel panelNivel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblNivel = new JLabel("Nivel: " + nivel);
        lblNivel.setFont(new Font("Arial", Font.BOLD, 16));
        lblExperiencia = new JLabel("Experiencia: " + experiencia + "/100");
        panelNivel.add(lblNivel);
        panelNivel.add(lblExperiencia);

        panelPrincipal.add(panelNivel, BorderLayout.NORTH);
        add(panelPrincipal);

    }

    private void mostrarSubmenuCombate() {
        Object[] opciones = {"Ataque", "Defensa", "Habilidad Especial"};
        int eleccion = JOptionPane.showOptionDialog(this, "Elige tu acción", "Menú de Combate",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        switch (eleccion) {
            case 0 ->
                realizarAtaque();
            case 1 ->
                logBatalla.append("Te pones en posición defensiva. (Reduce daño recibido)\n");
            case 2 ->
                usarHabilidadEspecial();
        }
    }

    private void realizarAtaque() {
        int daño = jugador.getAtaque();
        if (elixirActivo) {
            daño += 15;
            elixirActivo = false;
            logBatalla.append("Elixir activado. ¡Ataque potenciado!\n");
        }
        enemigo.vida -= daño;
        logBatalla.append("Usaste un Ataque y causaste " + daño + " de daño.\n");
        barraVidaEnemigo.setValue(Math.max(0, enemigo.vida));

        if (enemigo.vida <= 0) {
            logBatalla.append("\n¡Has derrotado a " + enemigo.getNombre() + "!\n");
            experiencia += 50;
            verificarSubidaNivel();
            generarEnemigoAleatorio();
            lblEnemigo.setText(enemigo.getNombre());
            barraVidaEnemigo.setMaximum(enemigo.getVida());
            barraVidaEnemigo.setValue(enemigo.getVida());
        } else {
            turnoEnemigo();
        }
    }

    private void usarHabilidadEspecial() {
        logBatalla.append("Usas tu habilidad especial: ... (efecto específico del personaje)\n");
        turnoEnemigo();
    }

    private void verificarSubidaNivel() {
        if (experiencia >= 100) {
            experiencia -= 100;
            nivel++;
            jugador.vida += 10;
            jugador.ataque += 5;
            jugador.defensa += 3;
            barraVidaJugador.setMaximum(jugador.getVida());
            barraVidaJugador.setValue(jugador.getVida());
            lblNivel.setText("Nivel: " + nivel);
            lblExperiencia.setText("Experiencia: " + experiencia + "/100");
            logBatalla.append("¡Has subido al nivel " + nivel + "! Estadísticas mejoradas.\n");
        }
    }

    private void combatirJefeFinal() {
        enemigo = new Enemigo("Malenia", 300, 35, 20) {
        };
        lblEnemigo.setText("Malenia");
        barraVidaEnemigo.setMaximum(enemigo.getVida());
        barraVidaEnemigo.setValue(enemigo.getVida());
        logBatalla.append("¡Te enfrentas al jefe final: Malenia!\n");
    }

    private void turnoEnemigo() {
        int daño = enemigo.getAtaque() - jugador.getDefensa() / 2;
        if (daño < 0) {
            daño = 0;
        }
        jugador.vida -= daño;
        logBatalla.append(enemigo.getNombre() + " ataca y causa " + daño + " de daño.\n");
        barraVidaJugador.setValue(Math.max(0, jugador.vida));

        if (jugador.vida <= 0) {
            logBatalla.append("\n¡Has sido derrotado por " + enemigo.getNombre() + "!\n");
            JOptionPane.showMessageDialog(this, "Has sido derrotado por " + enemigo.getNombre() + "\n\"Tu viaje termina aquí...\"");
            System.exit(0);
        }
    }

    private void intentarHuir() {
        int probabilidad = 30 + new Random().nextInt(71 - enemigo.getDefensa());
        if (new Random().nextInt(100) < probabilidad) {
            logBatalla.append("Has huido con éxito del combate.\n");
            generarEnemigoAleatorio();
            lblEnemigo.setText(enemigo.getNombre());
            barraVidaEnemigo.setMaximum(enemigo.getVida());
            barraVidaEnemigo.setValue(enemigo.getVida());
        } else {
            logBatalla.append("No pudiste huir.\n");
            turnoEnemigo();
        }
    }

    private void mostrarSubmenuBolsa() {
        Object[] objetos = {"Poción (+30 Vida)", "Elixir de Sangre (+15 daño siguiente ataque)"};
        int eleccion = JOptionPane.showOptionDialog(this, "Selecciona un objeto", "Bolsa",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, objetos, objetos[0]);

        switch (eleccion) {
            case 0 -> {
                jugador.vida = Math.min(jugador.vida + 30, barraVidaJugador.getMaximum());
                barraVidaJugador.setValue(jugador.vida);
                logBatalla.append("Usaste una poción. +30 de vida.\n");
                turnoEnemigo();
            }
            case 1 -> {
                elixirActivo = true;
                logBatalla.append("Usaste un Elixir de Sangre. ¡Tu próximo ataque será más fuerte!\n");
                turnoEnemigo();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaCombate ventana = new VentanaCombate();
            ventana.setVisible(true);
        });
    }

    abstract class Personaje {

        protected String nombre;
        protected int vida, ataque, defensa;

        public Personaje(String nombre, int vida, int ataque, int defensa) {
            this.nombre = nombre;
            this.vida = vida;
            this.ataque = ataque;
            this.defensa = defensa;
        }

        public String getNombre() {
            return nombre;
        }

        public int getVida() {
            return vida;
        }

        public int getAtaque() {
            return ataque;
        }

        public int getDefensa() {
            return defensa;
        }
    }

    class Chaman extends Personaje {

        public Chaman(String nombre) {
            super(nombre, 120, 30, 15);
        }
    }

    class Ninja extends Personaje {

        public Ninja(String nombre) {
            super(nombre, 120, 40, 10);
        }
    }

    class Guerrero extends Personaje {

        public Guerrero(String nombre) {
            super(nombre, 150, 18, 12);
        }
    }

    abstract class Enemigo {

        protected String nombre;
        protected int vida, ataque, defensa;

        public Enemigo(String nombre, int vida, int ataque, int defensa) {
            this.nombre = nombre;
            this.vida = vida;
            this.ataque = ataque;
            this.defensa = defensa;
        }

        public String getNombre() {
            return nombre;
        }

        public int getVida() {
            return vida;
        }

        public int getAtaque() {
            return ataque;
        }

        public int getDefensa() {
            return defensa;
        }
    }

    class GuerreroOscuro extends Enemigo {

        public GuerreroOscuro(String nombre) {
            super(nombre, 130, 20, 10);
        }
    }

    class NoMuerto extends Enemigo {

        public NoMuerto(String nombre) {
            super(nombre, 100, 15, 8);
        }
    }

    class LoboSalvaje extends Enemigo {

        public LoboSalvaje(String nombre) {
            super(nombre, 80, 12, 5);
        }
    }
}
