package com.aed.trabalhos.estruturas;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class BinFile {
    //private Header cabecalho;

    private static int MAX = 1000;
    public int ID;
    public ArrayList<Integer> keys;
    public ArrayList<Integer> childID;
    public ArrayList<Integer> ExistingIDs;

    public BinFile() {
        this.keys = new ArrayList<>();
        this.childID = new ArrayList<>();
        this.ExistingIDs = new ArrayList<>();
    }

    public int setID() {
        Random generator = new Random();
        int id = generator.nextInt(MAX+1);
        while(ExistingIDs.contains(id)){
            id = generator.nextInt(MAX+1);
        }
        ExistingIDs.add(id);
        return id;
    }

    public void saveNode(BinFile FileNode, Btree node, String filename){
        if(node.nodeID == -1)
            node.nodeID = setID();
            System.out.println("nodeID = " + node.nodeID);

        if (!node.child.isEmpty()) {
            for (int i = 0; i < node.child.size(); i++) {
                if(node.child.get(i).nodeID == -1)
                    node.child.get(i).nodeID = setID();
                    FileNode.childID.add( node.child.get(i).nodeID );
                    System.out.println("childID = " + node.child.get(i).nodeID);
            }
        }
        System.out.println("childIDS = " + FileNode.childID.toString());
        System.out.println("nodeKeys = " + node.keys.toString());
        FileNode.ID = node.nodeID;
        FileNode.keys = (ArrayList<Integer>) node.keys.clone();

        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream obj = new ObjectOutputStream(fout);
            obj.writeObject(FileNode);
            obj.close();
        } catch(Exception e){
        }
    }

    public void loadNode(BinFile FileNode, String filename){
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream obj = new ObjectInputStream(fin);
            FileNode = (BinFile) obj.readObject();
            obj.close();
        } catch(Exception e){
        }
        System.out.println(FileNode.toString());
    }

    @Override
    public String toString() {
        return "NodeID:" + ID + "\nChaves:" + keys.toString() + "\nChaves dos filhos: " + childID.toString();
    }

    /*
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
    */
}
