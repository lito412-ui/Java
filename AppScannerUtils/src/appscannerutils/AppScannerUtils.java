/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appscannerutils;

import com.miempresa.utils.ScannerUtils;



/**
 *
 * @author 1ª DAW
 */
public class AppScannerUtils {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero = ScannerUtils.leerEntero("Introduce un número entero: ");
        System.out.println("Número introducido: " + numero);
        
        double decimal = ScannerUtils.leerDecimal("Introduce un número decimal: ");
        System.out.println("Número decimal introducido: " + decimal);
        
        String texto = ScannerUtils.leerCadena("Introduce un texto: ");
        System.out.println("Texto introducido : " + texto);
        
        boolean respuesta = ScannerUtils.leerBooleano("¿Es verdadero?: ");
        System.out.println("Respuesta booleana :" + respuesta);
    }
    
}
