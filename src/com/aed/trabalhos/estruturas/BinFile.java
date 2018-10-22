package com.aed.trabalhos.estruturas;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BinFile implements Serializable {
    private Header cabecalho;
    private static Map<Integer, Register> registerMap = new HashMap<>();

    public BinFile() {
    }

    static Register getRegister(Integer key) {
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

    public void saveRegister() {
        saveObject(registerMap, System.getProperty("user.dir") + File.separator + "savedRegisters" + File.separator);
    }

    public void saveTree(Btree tree) {
        saveObject(tree, System.getProperty("user.dir") + File.separator + "savedTree" + File.separator);
    }

    private void saveObject(Object object, String filename) {
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


    public void loadRegister() {
        String filename = System.getProperty("user.dir") + File.separator + "savedRegisters";
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream obj = new ObjectInputStream(fin);
            registerMap = (Map<Integer, Register>) obj.readObject();
            obj.close();
            System.out.println("Carregado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao carregar.");
        }
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
            System.out.println("Erro ao carregar arquivo, gerando nova arvore");
            return new Btree();
        }
        return btree;
    }
}


