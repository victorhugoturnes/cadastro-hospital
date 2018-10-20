package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

public class Searcher extends Algorithm {
    @Override
    public Btree run(Btree tree) {
        System.out.println("Searched");
        return tree;
    }

    public Register find() {
        return new Register();
    }
}
