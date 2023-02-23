package Ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CifrarClave {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Declaramos las variables
        String texto;
        String clave;
        //Le pedimos al usuario que introduzca el texto a cifrar y la clave
        System.out.println("Introduce el texto a cifrar");
        texto = sc.nextLine();
        System.out.println("Introduce la clave de cifrado. Recuerde que debe ser de 16 caracteres");
        clave = sc.nextLine();

        try {
            //Llamamos al método que cifra el texto y lo guarda en el archivo
            guardarTextCifrado(texto, clave);
            //Mostramos un mensaje de éxito
            System.out.println("Texto cifrado y guardado con éxito");
        } catch (Exception e) {
            //Si la clave no es correcta, mostramos un mensaje de error
            System.err.println("Clave no válida");
            e.printStackTrace();
        }
        //Cerramos el scanner
        sc.close();
    }

    /**
     * Método que recibe un
     * @param texto y una
     * @param clave de 16 caracteres, cifra el texto y lo guarda en el txt textoCifrado.txt
     */
    public static void guardarTextCifrado(String texto, String clave) {
        //Declaramos las variables
        BufferedWriter bw;

        try {
            //Ciframos el texto y lo guardamos en el archivo
            bw = new BufferedWriter(new FileWriter("src/Ejercicio2/textoCifrado.txt"));
            bw.write(Utilidades.cifrar(texto, Utilidades.obtenerClave(clave)));
            bw.newLine();
            //Cerramos el buffer
            bw.close();
        } catch (IOException e) {
            //Si no se ha podido guardar el texto, mostramos un mensaje de error
            System.err.println("No se ha podido guardar el texto");
            e.printStackTrace();
        }
    }
}

