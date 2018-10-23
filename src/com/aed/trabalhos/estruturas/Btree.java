package com.aed.trabalhos.estruturas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// Classe para implementar Arvore B
public class Btree implements Serializable, Comparable<Btree> {

    // Atributos da Arvore B
    protected final int maxSize = 4;            // Quantidade maxima de chaves
    private final int overflow = 1;             // Atributo auxiliar para indicar overflow
    public final ArrayList<Integer> keys;       // Array para chaves
    public final ArrayList<Btree> child;        // Array para os nos filhos
    private transient HashMap<Integer, Register> data;  // Atributo para armazenar os registros de medicos

    // Construtor da Arvore B
    public Btree() {
        this.keys = new ArrayList<>();
        this.child = new ArrayList<>();
        data = new HashMap<>();
    }


    // Insere um registro de medico a Arvore B
    // - Recebe um registro
    // - Retorna a Arvore B atualizada, contendo o registro inserido
    public Btree addKey(Register doc) {
        // Chama o metodo sobrecarregado e retorna um booleano
        if (addKey(doc.getCodigo())) {  // Caso 1: true -> houve overflow e eh feito o split
            Btree root = new Btree(); // Cria uma nova instancia de Arvore B para nova raiz
//            System.out.println("PreSplit " + this);
            split(root, this);
//            System.out.println("PosSplit " + root);
            child.forEach(k -> k.updateData());
            updateData();
            return root; // Retorna a nova raiz, contendo a Arvore B atualizada
        }
        updateData(); // Caso 2: false -> adiciona o registro normalmente
        return this;  // Retorna a mesma raiz
    }

    // Getter para Registro de Medico
    // - Recebe um codigo de registro de medico
    // - Retorna um Registro de medico, contendo todos os atributos de um medico
    public Register getRegister(int key) {
        updateData();
        return data.containsKey(key)
                ? data.get(key)
                : new Register();
    }

    // Atualiza o atributo que contem os registros de medicos
    public void updateData() {
        data = new HashMap<>();
        keys.forEach(key -> data.put(key, BinFile.getRegister(key)));
    }

    // Metodo addKey Sobrecarregado
    // Retorna um booleano, indicando se ha ou nao overflow no node
    // - Caso retorne verdadeiro, ha overflow
    // - Caso retorne falso, nao ha overflow
    public Boolean addKey(int key) {
//        System.out.println("adding " + key + " to " + this);
        if (child.size() == 0) {
            keys.add(key);
            Collections.sort(keys);
        } else if (findPos(key) != this) {
            if (findPos(key).addKey(key))
                split(this, findPos(key));
        }
        return keys.size() >= maxSize + overflow;
    }

    // Realiza a divisão de um node de Arvore B
    private void split(Btree parent, Btree split) {
//        System.out.println("splitting");
        Btree right = new Btree();
        Btree left = new Btree();
//        System.out.println("parent: " + parent);
//        System.out.println("Split " + split);
        for (int i = 0; i < split.keys.size(); i++) {
            if (i < maxSize / 2) {
//                System.out.println(split.keys.get(i));
                right.keys.add(split.keys.get(i));
                if (!split.child.isEmpty()) {
                    right.child.add(split.child.get(i));
                }
            } else if (i == maxSize / 2) {
//                System.out.println(split.keys.get(i));
                parent.keys.add(split.keys.get(i));
                if (!split.child.isEmpty()) right.child.add(split.child.get(i));
            } else {
//                System.out.println(split.keys.get(i));
                left.keys.add(split.keys.get(i));
                if (!split.child.isEmpty()) left.child.add(split.child.get(i));
            }
        }
        if (!split.child.isEmpty()) left.child.add(split.child.get(split.child.size() - 1));
        parent.child.remove(split);
        parent.child.add(right);
        parent.child.add(left);
        right.updateData();
        left.updateData();
        parent.updateData();
        Collections.sort(parent.keys);
        Collections.sort(parent.child);
    }

    public Btree findPos(int key) {
        for (int i = 0; i < keys.size(); i++) {
            if (key < keys.get(i)) return child.isEmpty() ? null : child.get(i);
            else if (key == keys.get(i)) return this;
        }
        return child.isEmpty() ? null : child.get(child.size() - 1);
    }

    // Sobreposição do metodo toString
    // - Retorna uma string formatada contendo os valores dos atributos
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (!child.isEmpty()) {
//            builder.append("\n");
            for (int i = 0; i < child.size(); i++) {
                Btree c = child.get(i);
                builder.append(" " + i + " [" + c.toString() + "]");
            }
/*
            for (Btree c : this.child) {
                builder.append(c.toString());
            }
*/
        } else builder.append("[]");
        return keys.toString();// + " childs:" + child.size() + builder;

    }

    @Override
    public int compareTo(Btree o) {
        return Integer.compare(this.keys.get(0), o.keys.get(0));
    }

}


