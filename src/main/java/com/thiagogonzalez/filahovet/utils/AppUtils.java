package com.thiagogonzalez.filahovet.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AppUtils {

    public static String generateMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            // Converte o array de bytes para representação hexadecimal
            BigInteger number = new BigInteger(1, messageDigest);
            String md5String = number.toString(16);

            // Preenche zeros à esquerda, se necessário
            while (md5String.length() < 32) {
                md5String = "0" + md5String;
            }

            return md5String;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
