/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.core;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import static rsa.core.LeerArchivo.convertirArchivo;
import static rsa.core.LeerArchivo.muestraContenido;
import static rsa.core.VerificadorHash.getSHA;
import static rsa.core.VerificadorHash.toHexString;

/**
 *
 * @author Admin
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        RSA r = new RSA();
        //Leer el archivo
        String cadenaR = muestraContenido("/temp/archivo.txt");
        //Convierte el archivo en un Hash
        String hasOld = toHexString(getSHA(cadenaR));
        System.out.println("Resultado del hash " + hasOld);

        //Lee la llave publica
        r.openFromDiskPublicKey("/temp/rsa.pub");

        String secure = r.Encrypt(cadenaR);
        System.out.println("\nCifrado:");
        System.out.println(secure);
        convertirArchivo(secure);

        //Desencriptar
        RSA r2 = new RSA();
        r2.openFromDiskPublicKey("/temp/rsa.pub");
        r2.openFromDiskPrivateKey("/temp/rsa.pri");
        //Lee el archivo encriptado y lo desencripta
        String textoEnccriptado = muestraContenido("/temp/encriptado.txt");
        String Decrypt = r2.Decrypt(textoEnccriptado);
        String hasNew = toHexString(getSHA(Decrypt));

        
        if (validarHash(hasOld, hasNew)) {
            System.out.println("El texto desenciptado es: "+Decrypt);
        }

    }

    public static boolean validarHash(String hasOld, String hasNew) {
        if (hasOld.equals(hasNew)) {
            return true;
        } else {
            return false;
        }
    }

}
