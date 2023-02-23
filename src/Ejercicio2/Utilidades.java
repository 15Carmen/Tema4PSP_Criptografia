package Ejercicio2;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class Utilidades {
    //Variables de clase
    private static final int LONGITUD_BLOQUE = 16;
    private static final String ALGORITMO = "AES/ECB/PKCS5Padding";

    /**
     * Precondiciones: La clave introducida por el usuario debe tener 16 caracteres.
     * Método que recibe
     * @param claveUsuario y la convierte en una Key para cifrar el mensaje.
     * @return Key con la clave para codificar un mensaje
     */
    public static Key obtenerClave (String claveUsuario){
        return new SecretKeySpec(claveUsuario.getBytes(), 0, LONGITUD_BLOQUE, "AES");
    }

    /**
     * Método que recibe el
     * @param texto a cifrar y la
     * @param clave para cifrarlo mediante la clase Cipher.
     * @return El texto cifrado String
     */
    public static String cifrar (String texto, Key clave){
        //Declaramos las variables
        byte[] cifrado = new byte[0];
        Cipher cipher;

        try {
            //Creamos un Cipher
            cipher = Cipher.getInstance(ALGORITMO);

            //Iniciamos el cifrado con la clave
            cipher.init(Cipher.ENCRYPT_MODE, clave);

            //Llevamos a cabo el cifrado
            cifrado = cipher.doFinal(texto.getBytes());

        } catch (NoSuchAlgorithmException e) {
            System.err.println("No existe el algoritmo especificado");
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            System.err.println("El padding seleccionado no existe");
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.err.println("La clave utilizada no es válida");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("El tamaño del bloque elegido no es correcto");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            System.err.println("El padding seleccionado no es correcto");
            e.printStackTrace();
        }

        //Devolvemos el mensaje cifrado en Base64
        return Base64.getEncoder().encodeToString(cifrado);
    }


    /**
     * Método que recibe el
     * @param mensajeCifrado a descifrar y la
     * @param clave para descifrarlo mediante la clase Cipher.
     * @return El texto descifrado String
     */
    public static String descifrar (String mensajeCifrado, Key clave){

        //Declaramos las variables
        byte[] descifrar = new byte[0];
        Cipher cipher;

        try{
            //Creamos un Cipher
            cipher = Cipher.getInstance(ALGORITMO);

            //Iniciamos el descifrado con la clave
            cipher.init(Cipher.DECRYPT_MODE, clave);

            //Llevamos a cabo el descifrado
            descifrar = cipher.doFinal(Base64.getDecoder().decode(mensajeCifrado));
        } catch (NoSuchPaddingException e) {
            System.err.println("No existe el algoritmo especificado");
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("El padding seleccionado no existe");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("La clave utilizada no es válida");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            System.err.println("El tamaño del bloque elegido no es correcto");
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.err.println("El padding seleccionado no es correcto");
            e.printStackTrace();
        }

        //Devolvemos el mensaje descifrado
        return new String(descifrar);
    }
}
