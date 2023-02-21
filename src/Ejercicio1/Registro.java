package Ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        //Declaramos las variables
        String usuario;
        String password;

        //Declaramos el scanner
        Scanner sc = new Scanner(System.in);

        //Le pedimos al usuario que introduzca su nombre de usuario y contraseña
        System.out.println("Introduce tu nombre de usuario: ");
        usuario = sc.next();
        System.out.println("Introduce tu password: ");
        password = sc.next();

        //Guardamos en un fichero los datos introducidos por el usuario
        guardarCredenciales(usuario, password);

    }

    private static void guardarCredenciales(String nombre, String password) {

        //Obtenemos el resumen de la contraseña
        byte[] resumen = CalculoHash.getDigest(password);

        //Convertimos el resumen a hexadecimal
        String resumenHexadecimal = String.format("%064x", new BigInteger(1, resumen));

        try {
            //Preparo el fichero para escribir
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\cmnbo\\IntelliJ\\Tema4PSP_Criptografia\\src\\Ejercicio1\\credenciales.cre"));

            //Escribo el fichero
            bw.write(nombre + " " + resumenHexadecimal);
            bw.newLine();
            bw.flush();

            //Cierro el fichero
            bw.close();
        } catch (IOException e) {
            System.err.println("Error al registrar el usuario");
            e.printStackTrace();
        }
    }
}
