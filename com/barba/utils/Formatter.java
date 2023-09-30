package com.barba.utils;


public final class Formatter {

    public static String format(Number num) throws NumberFormatException {
        if (!(num instanceof Double) && !(num instanceof Float))
            throw new NumberFormatException("Numero non in virgola mobile");
        String s = num.toString();
        if (s.substring(s.indexOf(".")).length() != 3)
            s += "0";
        return s.replace(".", ",");
    }

    public static String capitalize(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w.substring(0, 1).toUpperCase());
            sb.append(w.substring(1).toLowerCase());
            sb.append(" ");
        }
        return sb.toString();
    }
}
