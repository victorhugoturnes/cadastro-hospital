package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;

public class Deleter extends Algorithm {
    @Override
    public Btree run(Btree tree) {
        System.out.println("Deleted+");
        return tree;
    }
}
