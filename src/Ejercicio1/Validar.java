package Ejercicio1;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Validar {
    public static void main(String[] args) {

        //Declaramos las variables
        String usuarioValidar;
        String passwordValidar;
        byte[] passwordBytesValidar;
        byte[] resumenValidar = null;
        String resumenHexadecimalValidar;

        //Declaramos el scanner
        Scanner sc = new Scanner(System.in);

        //Le pedimos al usuario que introduzca su nombre y su conntraseña
        System.out.println("Introduce tu nombre de usuario: ");
        usuarioValidar = sc.next();
        System.out.println("Introduce tu password: ");
        passwordValidar = sc.next();

        try {
            // Convierto el mensaje introducido por el usuario en un array de bytes
            passwordBytesValidar = passwordValidar.getBytes("UTF-8");

            // Creo una instancia de MessageDigest con el algoritmo SHA-256
            MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");

            // Reiniciamos el objeto por si contiene datos
            algoritmo.reset();

            // Añado el mensaje del cual quiero calcular su hash
            algoritmo.update(passwordBytesValidar);

            // Generamos el resumen
            resumenValidar = algoritmo.digest();

            resumenHexadecimalValidar = String.format("%064x", new BigInteger(1, resumenValidar));
            System.out.println(resumenHexadecimalValidar);

            CalculoHash.compararPasswords(buscarEnFichero(usuarioValidar, passwordValidar), resumenValidar);

        } catch (NoSuchAlgorithmException e) {
            System.err.println("El algoritmo seleccionado no existe");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.err.println("No se conoce la codificación especificada");
            e.printStackTrace();
        }
    }


    private static byte[] buscarEnFichero(String usuario, String password) {

        //Declaracion de variables
        BufferedReader lecturaFichero;
        String linea;
        byte[] claveCodificada = new byte[0];

        try {
            //Preparo la lectura del fichero
            lecturaFichero = new BufferedReader(new FileReader("C:\\Users\\cmartin\\eclipse-workspace\\Tema4PSP_Criptografia\\src\\Ejercicio1\\credenciales.cre"));
            linea = lecturaFichero.readLine();

            while (linea != null) {      //Mientras se lea una linea en el fichero

                if (linea.split(" ")[0].equals(password)) {
                    claveCodificada = Base64.getDecoder().decode(linea.split(" ")[1]);
                    break;
                } else {
                    System.out.printf("Usuario no encontrado");
                }
                linea = lecturaFichero.readLine();  //Leemos la siguiente línea
            }
        } catch (IOException e) {
            System.err.println("Error, archivo no encontrado");
            e.printStackTrace();
        }

        return claveCodificada;

    }
}
