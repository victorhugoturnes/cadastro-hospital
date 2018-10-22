package com.aed.trabalhos.estruturas;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BinFile implements Serializable {
    private Header cabecalho;
    public static Map<Integer, Register> registerMap = new HashMap<>();

    public BinFile() {
    }

    public static Register getRegister(Integer key) {
        return registerMap.get(key);
    }

    public void newListingFile(String filename) {
        Header cabecalho = new Header();
        cabecalho.write(cabecalho, filename);
    }

    public static void addRegister(Register doc) {
        registerMap.put(doc.getCodigo(), doc);
    }

    public static void deleteRegister(Register doc) {
        registerMap.remove(doc.getCodigo());
    }

    public void saveRegister(){
        saveObject(registerMap, System.getProperty("user.dir") + "\\savedFiles\\");
    }

    public void saveObject(Object object, String filename) {
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream obj = new ObjectOutputStream(fout);
            obj.writeObject(object);
            obj.close();
            System.out.println("Salvado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar.");
        }
    }


    public Register loadRegister(int code, String filename) {
        Register doc = new Register();
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream obj = new ObjectInputStream(fin);
            registerMap = (HashMap) obj.readObject();
            obj.close();
            System.out.println("Carregado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao carregar.");
        }
        doc = registerMap.get(code);
        return doc;
    }

    public Btree loadTree(String filename) {
        Btree btree = new Btree();
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream obj = new ObjectInputStream(fin);
            btree = (Btree) obj.readObject();
            obj.close();
            System.out.println("Carregado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao carregar.");
        }
        return btree;
    }
}


