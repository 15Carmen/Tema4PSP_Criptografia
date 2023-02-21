package Ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        //Declaramos las variables
        String usuario;
        String password;
        byte[] passwordBytes;
        byte[] resumen = null;
        String resumenHexadecimal;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu nombre de usuario: ");
        usuario = sc.next();
        System.out.println("Introduce tu password: ");
        password = sc.next();

        try {
            // Convierto el mensaje introducido por el usuario en un array de bytes
            passwordBytes = password.getBytes("UTF-8");

            // Creo una instancia de MessageDigest con el algoritmo SHA-256
            MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");

            // Reiniciamos el objeto por si contiene datos
            algoritmo.reset();

            // Añado el mensaje del cual quiero calcular su hash
            algoritmo.update(passwordBytes);

            // Generamos el resumen
            resumen = algoritmo.digest();

            resumenHexadecimal = String.format("%064x", new BigInteger(1, resumen));
            System.out.println(resumenHexadecimal);

            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\cmartin\\eclipse-workspace\\Tema4PSP_Criptografia\\src\\Ejercicio1\\credenciales.cre"));
            bw.write(usuario + " ");
            bw.write(resumenHexadecimal);
            bw.newLine();
            bw.flush();

        } catch (NoSuchAlgorithmException e) {
            System.err.println("El algoritmo seleccionado no existe");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.err.println("No se conoce la codificación especificada");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
