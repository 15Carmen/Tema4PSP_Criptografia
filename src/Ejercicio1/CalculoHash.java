package Ejercicio1;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalculoHash {
    public static byte[] getDigest(String input) {
        //Algoritmo de codificación
        MessageDigest algoritmo;
        //Array de bytes del mensaje
        byte[] byteinput;
        //Array de bytes del resumen
        byte[] resumen = new byte[0];
        try {
            //Saco los bytes del mensaje
            byteinput = input.getBytes(StandardCharsets.UTF_8);
            //Obtengo el algoritmo de codificación
            algoritmo = MessageDigest.getInstance("SHA-256");
            //Reseteo el algoritmo
            algoritmo.reset();
            //Actualizo el algoritmo con el mensaje
            algoritmo.update(byteinput);
            //Guardo el resumen obtenido
            resumen = algoritmo.digest();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("El algoritmo seleccionado no existe");
            e.printStackTrace();
        }
        //Devuelvo el resumen
        return resumen;
    }

    public static boolean compararResumenes(byte[] resumen1, byte[] resumen2) {
        //Uso el método de la clase MessageDigest para comparar los resúmenes de bytes si son iguales y devuelvo el resultado.
        return MessageDigest.isEqual(resumen1, resumen2);
    }

    public static boolean compararHash (byte[] resumen1, byte[] resumen2) {
        //Transformo los resúmenes en hash hexadecimal
        String hash1 = String.format("%064x", new BigInteger(1, resumen1));
        String hash2 = String.format("%064x", new BigInteger(1, resumen2));
        //Devuelvo el resultado de la comparación pero en formato hexadecimal
        return hash1.equals(hash2);
    }
}
