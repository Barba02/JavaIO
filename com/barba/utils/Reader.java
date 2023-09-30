package com.barba.utils;


import java.io.*;

public final class Reader {
    private final BufferedReader br;
    private InputStreamReader isr;

    public Reader() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
    }

    public Reader(InputStream ir) {
        isr = new InputStreamReader(ir);
        br = new BufferedReader(isr);
    }

    public Reader(String s) {
        isr = null;
        try {
            isr = new FileReader(s);
        }
        catch (FileNotFoundException e) {
            System.out.println("Non è stato possibile creare l'oggetto Reader");
        }
        br = new BufferedReader(isr);
    }

    public String readString() {
        String s = null;
        try {
            s = br.readLine();
        }
        catch (IOException e) {
            System.out.println("Non è stato possibile leggere una stringa");
        }
        return s;
    }

    public Integer readInteger() {
        Integer i = null;
        String s = readString();
        try {
            i = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            System.out.println("Non è stato possibile leggere un numero intero");
        }
        return i;
    }

    public Double readDouble() {
        Double d = null;
        String s = readString();
        try {
            d = Double.parseDouble(s);
        }
        catch (NumberFormatException e) {
            System.out.println("Non è stato possibile leggere un numero reale");
        }
        return d;
    }

    public void close() {
        try {
            br.close();
            isr.close();
        }
        catch (IOException e) {
            System.out.println("Non è stato possibile chiudere l'oggetto Reader");
        }
    }
}
