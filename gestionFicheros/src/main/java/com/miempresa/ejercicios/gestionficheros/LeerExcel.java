package com.miempresa.ejercicios.gestionficheros;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

class LeerExcel {

    private static String RUTA = "alumnos.xls";

    public static void leer() throws IOException {
        try {
            /*Codigo para leer el excel y la hoja creada*/
            FileInputStream file = new FileInputStream(new File(RUTA));
            HSSFWorkbook libro = new HSSFWorkbook(file);
            HSSFSheet hoja = libro.getSheetAt(0);
            int numeroFilas = hoja.getLastRowNum();
            /*Bucle for para recorrer todo el excel y leer todas las celdas para luego representarlas*/
            for (int i = 0; i <= numeroFilas; i++) {
                Row fila = hoja.getRow(i);
                if (fila != null) {
                    int numeroColumnas = fila.getLastCellNum();
                    for (int a = 0; a < numeroColumnas; a++) {
                        Cell celda = fila.getCell(a);
                        if (celda != null) {
                            switch (celda.getCellType().toString()) {
                                case "NUMERIC":
                                    System.out.print(celda.getNumericCellValue() + " ");
                                    break;
                                case "STRING":
                                    System.out.print(celda.getStringCellValue() + " ");
                                    break;
                            }
                        }
                    }
                    System.out.println("");
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static double media() throws FileNotFoundException, IOException {
        double media = 0;
        try {
            /*Codigo para leer el excel y la hoja creada*/
            FileInputStream file = new FileInputStream(new File(RUTA));
            HSSFWorkbook libro = new HSSFWorkbook(file);
            HSSFSheet hoja = libro.getSheetAt(0);
            int numeroFilas = hoja.getLastRowNum();

            double suma = 0;
            int count = 0;

            int gradeColumnIndex = 2;
            /*Hacemos un bucle for para recorrer la columna nota y sumar todas las notas y hacer la media*/
            for (int i = 1; i <= numeroFilas; i++) {
                Row fila = hoja.getRow(i);
                if (fila != null && fila.getCell(gradeColumnIndex) != null) {
                    double nota = fila.getCell(gradeColumnIndex).getNumericCellValue();
                    suma += nota;
                    count++;
                }
            }
            /*Redondeo de la media a dos decimales y calculo de la media*/
            if (count > 0) {
                media = suma / count;
                media = Math.round(media * 100.0) / 100.0;
                System.out.println("La nota media es: " + media);
            } else {
                System.out.println("No se encontraron notas para calcular el promedio.");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return media;
    }

    public static void MaximoMinimo() throws IOException {
        try {
            /*Codigo para leer el excel y la hoja creada*/
            FileInputStream file = new FileInputStream(new File(RUTA));
            HSSFWorkbook libro = new HSSFWorkbook(file);
            HSSFSheet hoja = libro.getSheetAt(0);
            int numeroFilas = hoja.getLastRowNum();

            double notaMaxima = Double.MIN_VALUE;
            double notaMinima = Double.MAX_VALUE;
            int gradeColumnIndex = 2;
            /*Bucle for para tomar el valor maximo y minimo de la columna notas*/
            for (int i = 1; i <= numeroFilas; i++) {
                Row fila = hoja.getRow(i);
                if (fila != null && fila.getCell(gradeColumnIndex) != null) {
                    double nota = fila.getCell(gradeColumnIndex).getNumericCellValue();
                    notaMaxima = Math.max(notaMaxima, nota);
                    notaMinima = Math.min(notaMinima, nota);
                }
            }

            System.out.println("La nota máxima es: " + notaMaxima);
            System.out.println("La nota mínima es: " + notaMinima);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int contarAprobados() throws IOException {
        /*Codigo para leer el excel y la hoja creada*/
        FileInputStream file = new FileInputStream(new File(RUTA));
        HSSFWorkbook libro = new HSSFWorkbook(file);
        HSSFSheet hoja = libro.getSheetAt(0);
        int numeroFilas = hoja.getLastRowNum();

        int aprobados = 0;
        int gradeColumnIndex = 2;
        /*Bucle for para recorrer la columna nota y si la nota es mayor o igual que 5 esta aprobado*/
        for (int i = 1; i <= numeroFilas; i++) {
            Row fila = hoja.getRow(i);
            if (fila != null && fila.getCell(gradeColumnIndex) != null) {
                double nota = fila.getCell(gradeColumnIndex).getNumericCellValue();
                if (nota >= 5.0) {
                    aprobados++;
                }
            }
        }

        System.out.println("El número de  aprobados es : " + aprobados);
        return aprobados;
    }

    public static int contarSuspensos() throws IOException {
        /*Codigo para leer el excel y la hoja creada*/
        FileInputStream file = new FileInputStream(new File(RUTA));
        HSSFWorkbook libro = new HSSFWorkbook(file);
        HSSFSheet hoja = libro.getSheetAt(0);
        int numeroFilas = hoja.getLastRowNum();

        int suspensos = 0;
        int gradeColumnIndex = 2;
        /*Bucle for para recorrer toda la columna nota y si la nota es menor que 5 esta suspenso*/
        for (int i = 1; i <= numeroFilas; i++) {
            Row fila = hoja.getRow(i);
            if (fila != null && fila.getCell(gradeColumnIndex) != null) {
                double nota = fila.getCell(gradeColumnIndex).getNumericCellValue();
                if (nota < 5.0) {
                    suspensos++;
                }
            }
        }

        System.out.println("El numero de suspensos  es : " + suspensos);
        return suspensos;
    }

    public static double promedioEdades() throws FileNotFoundException, IOException {
        double media_edad = 0;
        try {
            FileInputStream file = new FileInputStream(new File(RUTA));
            HSSFWorkbook libro = new HSSFWorkbook(file);
            HSSFSheet hoja = libro.getSheetAt(0);
            int numeroFilas = hoja.getLastRowNum();

            double suma = 0;
            int count = 0;
            int gradeColumnIndex = 3;

            for (int i = 1; i <= numeroFilas; i++) {
                Row fila = hoja.getRow(i);
                if (fila != null && fila.getCell(gradeColumnIndex) != null) {
                    double edad = fila.getCell(gradeColumnIndex).getNumericCellValue();
                    suma += edad;
                    count++;
                }
            }
            /*Redondeo de la media de edades y calculo de la media*/
            if (count > 0) {
                media_edad = suma / count;
                media_edad = Math.round(media_edad * 100.0) / 100.0;
                System.out.println("La edad media es: " + media_edad);
            } else {
                System.out.println("No se encontraron edades para calcular el promedio.");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return media_edad;
    }

    public static int porcentajeEdad() throws FileNotFoundException, IOException {
        /*Codigo para leer el excel y la hoja creada*/
        FileInputStream file = new FileInputStream(new File(RUTA));
        HSSFWorkbook libro = new HSSFWorkbook(file);
        HSSFSheet hoja = libro.getSheetAt(0);
        int numeroFilas = hoja.getLastRowNum();

        int viejos = 0;
        int gradeColumnIndex = 3;
        /*Bucle for para recorrer la columna edad y calcular el porcentaje, de los mayores de 30 años*/
        for (int i = 1; i <= numeroFilas; i++) {
            Row fila = hoja.getRow(i);
            if (fila != null && fila.getCell(gradeColumnIndex) != null) {
                double edad = fila.getCell(gradeColumnIndex).getNumericCellValue();
                if (edad > 30.0) {
                    viejos++;
                }
            }
        }
        viejos = (viejos * 100) / 1000;
        return viejos;
    }
}
