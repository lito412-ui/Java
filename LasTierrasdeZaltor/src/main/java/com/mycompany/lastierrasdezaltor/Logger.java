/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lastierrasdezaltor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Alumno
 */
public class Logger {
    private static final String ARCHIVO_LOG = "logs.txt";
    public static void registrarLog(String mensaje){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_LOG, true))) {
            bw.write(new Date() + " - " + mensaje + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
