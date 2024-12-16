package com.ensat.Security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
    private static final String HASH_ALGORITHM = "MD5";
    private static final String CHARSET_NAME = "UTF-8";

    public static String encode(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        byte[] passBytes = pass.getBytes(CHARSET_NAME);
        byte[] hashedBytes = md.digest(passBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}
