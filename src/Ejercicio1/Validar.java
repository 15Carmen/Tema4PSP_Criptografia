package Ejercicio1;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Validar {
    public static void main(String[] args) {
        //Declaramos las variables
        String usuario;
        String password;
        byte[] passwordBytes;
        byte[] resumen = null;
        String resumenHexadecimal;

        //Declaramos el scanner
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

            //TODO: comprobar si los resumenes de las contraseñas son iguales

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
    

    private String comprobarPassword(String password){

        //Declaracion de variables
        BufferedReader lecturaFichero;
        String mensajeSalida = null;
        String linea;

        try {
            //Preparo la lectura del fichero
            lecturaFichero = new BufferedReader(new FileReader("C:\\Users\\cmartin\\eclipse-workspace\\Tema4PSP_Criptografia\\src\\Ejercicio1\\credenciales.cre"));
            linea = lecturaFichero.readLine();

            while (linea != null){      //Mientras se lea una linea en el fichero

                if (linea.split(" ")[1].equals(password)){   //Si la dirección introducida es igual a la del fichero
                    //Indicamos la ip de la dirección web
                    mensajeSalida = "La password es " + linea.split(" ")[1];
                    break;
                } else {    //Si no encontramos la dirección en el fichero
                    //Indicamos que la dirección no está registrada en el fichero
                    mensajeSalida = "Lo sentimos, password no registrada";
                }
                linea = lecturaFichero.readLine();  //Leemos la siguiente línea
            }
        } catch (IOException e) {
            System.err.println("Error, archivo no encontrado");
            e.printStackTrace();
        }
        return mensajeSalida;
    }
}
