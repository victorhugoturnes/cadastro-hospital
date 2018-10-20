package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Register;

public class Inserter extends Algorithm{
    static void insert(Register doc) {
        System.out.println(doc);
    }

    @Override
    public void run() {
        System.out.println("Inserted");
    }
}
