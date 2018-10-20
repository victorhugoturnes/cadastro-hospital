package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Register;

public class Searcher extends Algorithm {
    @Override
    public void run() {
        System.out.println("Searched");
    }

    public Register find() {
        return new Register();
    }
}
