package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

// Classe para metodos de impressão de dados da Arvore B
public class TreePrinter extends Algorithm {

    // Imprime um registro de medico
    public static void printRegister(Register register) {
        System.out.println(register);
    }

    // Sobreposição do metodo run
    // Metodo generico pra execucao da funcao base da classe
    // Eh chamado pela superclasse para generalizacao do main
    @Override
    public Btree run(Btree tree) {
        printTree(tree);
        System.out.println("\n");
//        System.out.println(tree);
        return tree;
    }

    // Imprime uma Arvore B
    private void printTree(Btree tree){
        int i = 0;
        while(printTree(tree, i)){
            i++;
//            System.out.println(i);
        }
    }

    // Verifica se existem mais niveis na arvore para serem printados
    private boolean printTree(Btree tree, int i) {
        Boolean continuum = true;
        if(i == 0){
            System.out.print(tree);
        } else if(tree.child.isEmpty()){
            return false;
        } else {
            System.out.println();
            for (Btree k : tree.child) {
                continuum = printTree(k, i-1);
            }
        }
        return continuum;
    }
}
