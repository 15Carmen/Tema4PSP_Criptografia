package Ejercicio2;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CifradoDescifrado {
    static final int LONGITUD_BLOQUE = 16;

    /*
    public void obtenerClave() {
        // 1 - Crear la clave. Al ser el algoritmo AES tenemos que indicarle la longitud del bloque
        // La longitud puede ser 16, 24 ó 32 bytes
        // La longitud de la contraseña tiene que coincidir con la longitud indicada
        Key clave = new SecretKeySpec(PASSWORD.getBytes(), 0, LONGITUD_BLOQUE, "AES");

        try {
            // 2 - Crear un Cipher
            Cipher cipher = Cipher.getInstance(ALGORITMO);

            // 3 - Iniciar el descifrado con la clave
            cipher.init(Cipher.DECRYPT_MODE, clave);

            // 4 - Llevar a cabo el descifrado
            byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(TEXTO_CIFRADO));

            // Imprimimos el mensaje descifrado:
            System.out.println(new String(plainText));

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
    }

     */

    public static void cifrar(){

    }

    public static  void descifrar(){

    }
}

