package com.barba.utils;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.OutputStream;

public final class Writer {
    private PrintStream ps;

    public Writer() {
        ps = System.out;
    }

    public Writer(OutputStream os) {
        ps = new PrintStream(os);
    }

    public Writer(File f) {
        this(f.toString());
    }

    public Writer(String s) {
        ps = null;
        try {
            ps = new PrintStream(s);
        }
        catch (IOException e) {
            System.out.println("Non è stato possibile creare l'oggetto Writer");
        }
    }

    public void print(String s) {
        print(s, true);
    }

    public void print(String s, Boolean nl) {
        ps.print(s);
        if (nl)
            ps.print("\n");
    }

    public void print(Object o) {
        print(o.toString(), true);
    }

    public void print(Object o, Boolean nl) {
        print(o.toString(), nl);
    }

    public void close() {
        ps.flush();
        ps.close();
    }
}
