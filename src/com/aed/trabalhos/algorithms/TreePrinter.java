package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

public class TreePrinter extends Algorithm {
    public static void printRegister(Register register) {
        System.out.println(register);
    }

    @Override
    public Btree run(Btree tree) {
        System.out.println(tree);
        return tree;
    }
}
