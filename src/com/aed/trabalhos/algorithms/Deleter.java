package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;

import java.util.Collections;
import java.util.Scanner;

// Classe para os metodos de Remoção
public class Deleter extends Algorithm {

    // Sobreposição do metodo run
    // Método generico pra execução da função base da classe
    // É chamado pela superclasse para generalização do main
    @Override
    public Btree run(Btree tree) {
        Scanner scan = new Scanner(System.in);
        System.out.println("please insert a key to be deleted");
        int key = scan.nextInt();   // le input do usuario
        System.out.println("confirm the registry");
        System.out.println(new Searcher().find(key, tree)); // procura o registro na Arvore B
        System.out.println("(Y)Delete\n(Outro)Cancel");
        if (scan.next().charAt(0) == 'Y') {
            delete(key, tree);  // exclui o registro da Arvore B
            System.out.println("deleted register " + key);
        }
        return tree; // retorna a Arvore B atualizada
    }

    // Remove um registro da Arvore B
    private boolean delete(int key, Btree tree) {
        if(tree == null) return false;

        if (tree.keys.contains(key)) {
            if (tree.child.isEmpty()) {
                tree.keys.remove(tree.keys.indexOf(key));
                tree.updateData();
                return tree.keys.size() < 2;
            } else {
                deleteNode(key, tree);
                return tree.keys.size() < 2;
            }
        } else {
            if (delete(key, tree.findPos(key))) {
//                underflow(tree);
            }
        }
        return false;
    }

    // Metodo para lidar com underflow
    private void underflow(Btree parent) {
        for (int i = 0; i < parent.child.size(); i++) { // laco para checar os nos filhos
            if (parent.child.get(i).keys.size() < 2) {  // checa se o numero de chaves eh menor que o minimo (2)
                if (i > 0 && parent.child.get(i - 1).keys.size() > 2) {
//                    borrowPrev(parent.child.get(i-1), parent.child.get(i), parent);
                } else if (i < parent.child.size() && parent.child.get(i + 1).keys.size() > 2) {
//                    borrowNext(parent.child.get(i+1), parent.child.get(i), parent);
                } else {

                }
            }
        }
    }

    // Deleta um node da Arvore B
    // - Recebe o valor da chave e um node de Arvore B
    // - Retorna node atualizado
    private void deleteNode(int key, Btree tree) {
        int index = tree.keys.indexOf(key);     // index recebe a posicao da chave no vetor de chaves
        int movedKey = tree.child.get(index + 1).keys.get(0);   // movedKey recebe valor da chave que ira substituir a chave excluida
        tree.keys.remove(tree.keys.indexOf(key));   // remove chave
        tree.keys.add(movedKey);    // substitui a chave
        delete(movedKey, tree.child.get(index + 1));    // deleta a chave substituta do seu node anterior
        Collections.sort(tree.keys);    // sort no vetor de chaves
    }
}
