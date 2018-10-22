package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.BinFile;
import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

import java.util.Scanner;

public class Searcher extends Algorithm {
    @Override
    public Btree run(Btree tree) {
        System.out.println("please insert register to be found");
        System.out.println(find(new Scanner(System.in).nextInt(), tree));
        return tree;
    }

    public Register find(int key, Btree tree){
        Register doc = tree.findPos(key).getRegister(key);
        return doc;
    }
}
