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
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream obj = new ObjectOutputStream(fout);
            obj.writeObject(cabecalho);
            obj.close();
        }catch(Exception e){

        }
    }

    public Header read(String filename){
        Header cabecalho = new Header();
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream obj = new ObjectInputStream(fin);
            cabecalho = (Header) obj.readObject();
            obj.close();

        }catch(Exception e){

        }
        return cabecalho;
    }
}
