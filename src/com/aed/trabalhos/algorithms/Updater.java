package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;

public class Updater extends Algorithm {
    @Override
    public Btree run(Btree tree) {
        System.out.println("updated");
        return tree;
    }
}
