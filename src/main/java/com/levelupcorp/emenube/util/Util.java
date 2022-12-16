package com.levelupcorp.emenube.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

public class Util {
    public static String getMd5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getSessionCode(Long id, Long restaurantId, String tableStatus, String tableCode) {
        return getMd5(id.toString() + restaurantId.toString() + tableStatus + new Date());
    }

    public static String getTableCode() {
        Random random = new Random();
        return getRandomCharacter() + "-" + random.nextInt(26) + "-" + getRandomCharacter() + "-" + random.nextInt(26);
    }

    public static char getRandomCharacter(){
        Random random = new Random();
        return  (char) ('a' + random.nextInt(26));
    }
}
