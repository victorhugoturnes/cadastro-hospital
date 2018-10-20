package com.aed.trabalhos.estruturas;

import java.io.*;

public class Header {
    private int cabeca;
    private int topo;
    private int livre;

    public Header(){
        cabeca = -1;
        topo = 0;
        livre = -1;
    }

    public void write(Header cabecalho, String filename){
        ObjectOutputStream obj = new ObjectOutputStream(FileOutputStream(filename));
        obj.writeObject(cabecalho);
        obj.close();
    }

    public Header read(String filename){
        ObjectInputStream obj = new ObjectInputStream(FileInputStream(filename));
        Header cabecalho = (Header) obj.readObject();
        obj.close();

        return cabecalho;
    }
}
