package com.aed.trabalhos.estruturas;

import java.io.*;

public class Header implements Serializable{
    public int posCabeca;
    public int posTopo;
    public int posLivre;

    public Header(){
        posCabeca = -1;
        posTopo = 0;
        posLivre = -1;
    }

    public Header read(Header cabecalho, String filename) {
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream obj = new ObjectInputStream(fin);
            cabecalho = (Header) obj.readObject();
            obj.close();
            System.out.println("Lido com sucesso");
        }catch (Exception e){
            System.out.println("Falha ao ler");
        }
        return cabecalho;
    }

    public void write(Header cabecalho, String filename) {
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream obj = new ObjectOutputStream(fout);
            obj.writeObject(cabecalho);
            obj.close();
            System.out.println("Escrito com sucesso");
        }catch (Exception e){
            System.out.println("Falha ao escrever");
        }
    }

    @Override
    public String toString() {
        return "Cabeca:" + posCabeca + "\nTopo:" + posTopo + "\nPos livre: " + posLivre;
    }
}
