/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Johan
 */
public class Encriptador {
    
    /**
     * Encripta MD5
     */
    public static String encriptar(String text) throws Exception{
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte [] message = md.digest(text.getBytes());
            BigInteger num = new BigInteger(1, message);
            String hashMD5 = num.toString(16);
            while(hashMD5.length()<32){
                hashMD5 = "0" + hashMD5;
            }
            return hashMD5;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    /**
     * Valida si una cadena coincide con un hash dado
     * @param text
     * @param hash
     * @return
     * @throws Exception 
     */
    public static boolean validar(String text, String hash) throws Exception{
        try{
            return encriptar(text).equals(hash);
        }catch(Exception ex){
            throw ex;
        }
    }
}
