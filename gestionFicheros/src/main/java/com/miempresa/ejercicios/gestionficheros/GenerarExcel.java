/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.ejercicios.gestionficheros;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.File;

/**
 *
 * @author 1ª DAW
 */
public class GenerarExcel {

    /*Nombre archivo variable global*/
    private static final String NOMBRE_ARCHIVO = "alumnos.xls";
    private static final int alumnos = 1000;

    /*Retorna si el archivo existe*/
    public static boolean comprobarArchivo(File file) {
        return file.exists() && !file.isDirectory();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*Condicion para saber si existe el archivo, si existe te dice q existe*/
        File directorio = new File(NOMBRE_ARCHIVO);
        if (directorio.exists()) {
            System.out.println("Directorio  \"" + NOMBRE_ARCHIVO + "\" existe.\n");
        } else {
            System.out.println("Directorio  \"" + NOMBRE_ARCHIVO + "\" no existe.\n");
        }
        boolean comprobar = comprobarArchivo(directorio);
        System.out.println("Es \"" + directorio + "\" un archivo valido? " + comprobar);
        /*Comprobar permisos del archivo*/
        if (directorio.exists()) {
            System.out.println();
            System.out.println("Permiso de lectura " + directorio.canRead());
            System.out.println("Permiso de escritura " + directorio.canWrite());
            System.out.println("Permiso de ejecución " + directorio.canExecute());
        }

        String filePath = NOMBRE_ARCHIVO;
        File file = new File(filePath);
        comprobar = comprobarArchivo(file);
        System.out.println("");
        /*Creamos el archivo  y la hoja*/
        ArrayList<Alumnos> listaAlumnos = Alumnos.crearListaAlumnos(alumnos);
        Workbook libro = new HSSFWorkbook();
        Sheet hoja = libro.createSheet("Datos");
        


        /*Creamos una fila y 3 columnas en la hoja datos*/
        Row row = hoja.createRow(0);
        row.createCell(0).setCellValue("DNI      ");
        row.createCell(1).setCellValue("Nombre  ");
        row.createCell(2).setCellValue("Nota ");
        row.createCell(3).setCellValue("Edad");
        /*Creamos una hoja y en la misma, una fila y 4 columnas*/
        Sheet hoja1 = libro.createSheet("Estadisticas");
        Row row1 = hoja1.createRow(0);
        row1.createCell(0).setCellValue("Total Alumnos");
        row1.createCell(1).setCellValue("Número de aprobados");
        row1.createCell(2).setCellValue("Número de Suspensos");
        row1.createCell(3).setCellValue("Promedio Notas");

        /*Usamos la clase Alumnos que he creado y hacemos un bucle for para que cree tantas celdas como columnas*/
        for (int i = 1; i < listaAlumnos.size(); i++) {
            
            row = hoja.createRow(i);
            row.createCell(0).setCellValue(listaAlumnos.get(i).getDni());
            row.createCell(1).setCellValue(listaAlumnos.get(i).getNombre());
            row.createCell(2).setCellValue(listaAlumnos.get(i).getNota());
            row.createCell(3).setCellValue(listaAlumnos.get(i).getEdad());
        }

        /*Guardamos el archivo usando un try y en caso de q de error tenemos el ctach que nos dira si algo no va bien*/
        try {
            try (FileOutputStream fileout = new FileOutputStream(NOMBRE_ARCHIVO)) {
                libro.write(fileout);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenerarExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerarExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

        LeerExcel.leer();
        double media = LeerExcel.media();
        LeerExcel.MaximoMinimo();

        /*Vaiables que reciben datos de LeerExcel*/
        int aprobados = LeerExcel.contarAprobados();
        int suspensos = LeerExcel.contarSuspensos();

        
        
        int viejos = LeerExcel.porcentajeEdad();
        
        row1 = hoja1.createRow(1);
        row1.createCell(0).setCellValue(alumnos);
        row1.createCell(1).setCellValue(aprobados);
        row1.createCell(2).setCellValue(suspensos);
        row1.createCell(3).setCellValue(media);

        try (FileOutputStream fileout = new FileOutputStream(NOMBRE_ARCHIVO)) {
            libro.write(fileout);
        }
        double media_edad =  LeerExcel.promedioEdades();
        System.out.println("El porcentaje mayores que 30 es : " + viejos + "%");
    }
}
