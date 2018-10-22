package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

import java.util.Scanner;

// Classe para os metodos de Busca
public class Searcher extends Algorithm {

    // Sobreposição do metodo run
    // Método generico pra execução da função base da classe
    // É chamado pela superclasse para generalização do main
    @Override
    public Btree run(Btree tree) {
        System.out.println(find(tree)); // Busca e imprime uma Arvore B
        return tree;
    }

    // Solicita um codigo do registro que sera buscado na Arvore B
    Register find(Btree tree) {
        System.out.println("please insert register to be found");
        return find(new Scanner(System.in).nextInt(), tree);

    }

    // Retorna o registro
    Register find(int key, Btree tree){
        Btree find = tree.findPos(key);
        return find == null ? new Register() : find.getRegister(key);
    }
}
