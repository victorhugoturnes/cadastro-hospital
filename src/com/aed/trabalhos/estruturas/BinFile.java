package com.aed.trabalhos.estruturas;

import java.io.*;

public class BinFile {
    private Header cabecalho;

    // Falta fazer funcionar com o cabecalho
    public void saveTree(Btree btree, String filename){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream obj = new ObjectOutputStream(fout);
            obj.writeObject(btree);
            obj.close();
            System.out.println("Salvado com sucesso!");
        } catch(Exception e){
            System.out.println("Erro ao salvar.");
        }
    }

    // Falta fazer funcionar com o cabecalho
    public Btree loadTree(String filename){
        Btree btree = new Btree();
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream obj = new ObjectInputStream(fin);
            btree = (Btree) obj.readObject();
            obj.close();
            System.out.println("Carregado com sucesso!");
        } catch(Exception e){
            System.out.println("Erro ao carregar.");
        }
        return btree;
    }
}
