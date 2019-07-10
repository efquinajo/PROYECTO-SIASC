package com.comvetlp.bo.siasc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {


    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isEmptyOrNull(String valor) {
        if (valor == null) {
            return true;
        }
        if (valor.trim().equals("")) {
            return true;
        }
        return false;
    }

    public static String toTrimUpperCase(String valor) {
        if (valor == null) {
            return null;
        }
        return valor.trim().toUpperCase();

    }

    /**
     * Coloca las primeras letras en mayuscula
     * @param source
     * @return
     */
    public static String capitalize(String source){
        if(isEmptyOrNull(source)){
            return "";
        }
        source=source.toLowerCase().trim();
        StringBuffer res = new StringBuffer();
        String[] strArr = source.split(" ");
        for (String str : strArr) {
            char[] stringArray = str.trim().toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            str = new String(stringArray);

            res.append(str).append(" ");
        }
        return res.toString().trim();
    }

    public static boolean isValidEmail(String mail) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher= pattern.matcher(mail);
        return matcher.matches();

    }
}
