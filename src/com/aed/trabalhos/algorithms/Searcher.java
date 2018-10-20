package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

public class Searcher extends Algorithm {
    @Override
    public void run(Btree tree) {
        System.out.println("Searched");
    }

    public Register find() {
        return new Register();
    }
}
