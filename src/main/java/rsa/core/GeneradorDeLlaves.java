/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.core;

import java.io.File;
import static rsa.core.LeerArchivo.muestraContenido;

public class GeneradorDeLlaves {

    public static void main(String[] args) throws Exception {

        //Instanciamos la clase
        RSA rsa = new RSA();

        //Generamos un par de claves
        //Admite claves de 512, 1024, 2048 y 4096 bits
        rsa.genKeyPair(512);

        //Las guardamos asi podemos usarlas despues
        //a lo largo del tiempo
        File directorio = new File("/temp");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }

        }

        rsa.saveToDiskPrivateKey("/temp/rsa.pri");
        rsa.saveToDiskPublicKey("/temp/rsa.pub");

        System.out.println("Se crearon las llaves en la ruta /tmp/rsa.pri y /tmp/rsa.pub");

    }

}
