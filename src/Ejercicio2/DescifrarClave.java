package Ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DescifrarClave {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //Declaramos las variables
        String clave;

        //Le pedimos al usuario que introduzca la clave de descifrado
        System.out.println("Introduce la clave de descifrado. Recuerde que debe ser de 16 caracteres");
        clave = sc.nextLine();
        try {
            //Llamamos al método que descifra el texto y lo mostramos por pantalla
            System.out.println(leerTextCifrado(clave));
        } catch (Exception e) {
            //Si la clave no es correcta, mostramos un mensaje de error
            System.err.println("Clave incorrecta");
            e.printStackTrace();
        }
        sc.close();
    }

    /**
     * Método que recibe una
     * @param clave y descifra el texto cifrado que hay en el archivo textoCifrado.txt y lo muestra por pantalla.
     * @return Texto descifrado String
     */
    public static String leerTextCifrado(String clave){
        //Declaramos las variables
        String textoCifrado = null;
        BufferedReader br;

        try {
            //Leemos el texto cifrado del archivo y lo guardamos en la variable
            br = new BufferedReader(new FileReader("src/Ejercicio2/textoCifrado.txt"));
            textoCifrado = br.readLine();
            //Cerramos el buffer
            br.close();
        } catch (IOException e) {
            //Si no se ha podido leer el texto, mostramos un mensaje de error
            System.err.println("No se ha podido recuperar el texto");
            e.printStackTrace();
        }
        //Devolvemos el texto descifrado
        return Utilidades.descifrar(textoCifrado, Utilidades.obtenerClave(clave));
    }
}
