/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Admin
 */
public class LeerArchivo {

    public static String muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        String cadenaTotal = "";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            //  System.out.println(cadena);
            cadenaTotal += cadena ;
        }
        b.close();
        return cadenaTotal;
    }

    public static void convertirArchivo(String mensaje) throws IOException {

        String path = "\\temp\\encriptado.txt";

        // Java 11 , default StandardCharsets.UTF_8
        Files.write(Paths.get(path), mensaje.getBytes());

    }

//    public static void main(String[] args) throws IOException {
//        convertirArchivo("Hola");
//    }
}
