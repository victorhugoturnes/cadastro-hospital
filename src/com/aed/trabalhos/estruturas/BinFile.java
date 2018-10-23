package com.aed.trabalhos.estruturas;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// Classe para os metodos de manipulação de arquivo binario
public class BinFile implements Serializable {
    private Header cabecalho;   // Atributo para um cabeçalho
    private static Map<Integer, Register> registerMap = new HashMap<>();    // Atributo para armazenar registros

    // Construtor da classe
    public BinFile() {
    }

    // Getter de Registro de médico
    // - Recebe codigo de um médico
    // - Retorna o registro do médico contendo seus atributos
    static Register getRegister(Integer key) {
        return registerMap.get(key);
    }

    // Cria um novo arquivo
    // - Recebe o nome para um arquivo
    // - Cria o arquivo e insere um cabeçalho no início
    public void newListingFile(String filename) {
        Header cabecalho = new Header();
        cabecalho.write(cabecalho, filename);
    }

    // Salva um registro em memória
    public static void addRegister(Register doc) {
        registerMap.put(doc.getCodigo(), doc);
    }

    // Deleta um registro em memória
    public static void deleteRegister(Register doc) {
        registerMap.remove(doc.getCodigo());
    }

    // Salva um registro em arquivo
    public void saveRegister() {
        saveObject(registerMap, System.getProperty("user.dir") + File.separator + "savedRegisters" + File.separator);
    }

    // Salva uma Arvore B em arquivo
    public void saveTree(Btree tree) {
        saveObject(tree, System.getProperty("user.dir") + File.separator + "savedTree" + File.separator);
    }

    // Salva um objeto em arquivo
    private void saveObject(Object object, String filename) {
        try {
            // Abre arquivo para escrita
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream obj = new ObjectOutputStream(fout);
            obj.writeObject(object);
            obj.close(); // Fecha arquivo
            System.out.println("Salvado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar.");
        }
    }

    // Carrega um registro de médico de um arquivo
    public void loadRegister() {
        String filename = System.getProperty("user.dir") + File.separator + "savedRegisters";
        try {
            // Abre arquivo para leitura
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream obj = new ObjectInputStream(fin);
            registerMap = (Map<Integer, Register>) obj.readObject();
            obj.close(); // Fecha arquivo
            System.out.println("Carregado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao carregar.");
        }
    }

    // Carrega um node de Arvore B de um arquivo
    public Btree loadTree(String filename) {
        Btree btree = new Btree();
        try {
            // Abre arquivo para leitura
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream obj = new ObjectInputStream(fin);
            btree = (Btree) obj.readObject();
            obj.close(); // Fecha arquivo
            System.out.println("Carregado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao carregar arquivo, gerando nova arvore");
            return new Btree();
        }
        return btree; // Retorna Arvore B
    }
}


