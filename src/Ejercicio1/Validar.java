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

        //Declaramos el scanner
        Scanner sc = new Scanner(System.in);

        //Le pedimos al usuario que introduzca su nombre y su contraseña
        System.out.println("Introduce tu nombre de usuario: ");
        usuarioValidar = sc.next();
        System.out.println("Introduce tu password: ");
        passwordValidar = sc.next();

        //Si el usuario y la contraseña son válidos, imprimimos un mensaje de bienvenida
        if (validar(usuarioValidar, passwordValidar)) {
            System.out.println("Acceso validado, bienvenido");
        }else { //En caso contrario se lo informamos al usuario
            System.out.println("Acceso denegado, usuario o password incorrectas");
        }

    }

    /**
     * Método que comprueba si el
     * @param usuario y la
     * @param password son iguales a los sacados del fichero credenciales.cre
     * @return true si son iguales y false si no lo son
     */
    private static boolean validar(String usuario, String password) {

        //Declaracion de variables
        BufferedReader lecturaFichero;
        String linea;
        boolean esValido = false;

        try {
            //Paso la contraseña a resumen con el método getDigest de la clase Coder
            byte[] resumen = CalculoHash.getDigest(password);

            //Paso el resumen a hexadecimal para poder compararlo con el resumen (hash) del fichero
            String passwordHash = String.format("%064x", new BigInteger(1, resumen));

            //Preparo la lectura del fichero
            lecturaFichero = new BufferedReader(new FileReader("C:\\Users\\cmnbo\\IntelliJ\\Tema4PSP_Criptografia\\src\\Ejercicio1\\credenciales.cre"));

            linea = lecturaFichero.readLine();
            while (linea != null) {      //Mientras se lea una linea en el fichero

                if (linea.split(" ")[0].equals(usuario)) {
                    String resumenString = linea.split(" ")[1];
                    if (linea.split(" ")[1].equals(resumenString)) {
                        esValido = true;
                        break;
                    }
                }
                linea = lecturaFichero.readLine();  //Leemos la siguiente línea
            }
        } catch (IOException e) {
            System.err.println("Error, archivo no encontrado");
            e.printStackTrace();
        }

        return esValido;

    }
}
