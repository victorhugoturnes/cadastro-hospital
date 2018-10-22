package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

import java.util.Scanner;

public class Searcher extends Algorithm {
    @Override
    public Btree run(Btree tree) {
        System.out.println(find(tree));
        return tree;
    }

    Register find(Btree tree) {
        System.out.println("please insert register to be found");
        return find(new Scanner(System.in).nextInt(), tree);

    }

    Register find(int key, Btree tree){
        Btree find = tree.findPos(key);
        return find == null ? new Register() : find.getRegister(key);
    }
}
