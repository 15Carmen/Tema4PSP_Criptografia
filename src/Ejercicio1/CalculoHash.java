package Ejercicio1;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalculoHash {

    public static boolean compararPasswords(byte[] resumenPassword, byte[] resumen2Password){
        return MessageDigest.isEqual(resumenPassword, resumen2Password);
    }

    public static byte[] getDigest(String mensajeACodificar){

        //Declaramos las variables
        MessageDigest algoritmo;            //Algoritmo de codificación
        byte[] byteMensaje;                 //Array de bytes del mensaje
        byte[] resumen = new byte[0];       //Array de bytes del resumen

        try {
            //Saco los bytes del mensaje
            byteMensaje = mensajeACodificar.getBytes(StandardCharsets.UTF_8);

            //Obtengo el algoritmo de codificación
            algoritmo = MessageDigest.getInstance("SHA-256");

            //Reseteo el algoritmo
            algoritmo.reset();

            //Actualizo el algoritmo con el mensaje
            algoritmo.update(byteMensaje);

            //Guardo el resumen obtenido
            resumen = algoritmo.digest();

        } catch (NoSuchAlgorithmException e) {
            System.err.println("El algoritmo seleccionado no existe");
            e.printStackTrace();
        }

        //Devuelvo el resumen
        return resumen;
    }
}
