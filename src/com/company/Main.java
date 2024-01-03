package com.company;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
	    // Шифруем с шифром

        String s = "Hi, world!";
        System.out.println("\n\n--------------script--------------\n\n");

        // Объявляем шифр
        Cipher cipher = Cipher.getInstance("AES");

        // Создаём ключь
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        SecretKey key = kgen.generateKey();

        // 2 способ создания ключа
        SecretKeySpec keySpec = new SecretKeySpec("P@ssw0rd".getBytes(), "AES");

        //устанавливаем ключь в наш шифр
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // шифруем текст
        byte[] bytes = cipher.doFinal(s.getBytes());
        for (byte b: bytes){
            System.out.print(b);
        }
        System.out.println("\n\n--------------decriptoin--------------\n\n");

        //расшифровываем текст
        Cipher decriptoin = Cipher.getInstance("AES");
        decriptoin.init(Cipher.DECRYPT_MODE, key);
        byte[] descpBytes = decriptoin.doFinal(bytes);
        for (byte b: descpBytes){
            System.out.print((char) b);
        }
        System.out.println("\n\n--------------end--------------\n\n");

    }
}
