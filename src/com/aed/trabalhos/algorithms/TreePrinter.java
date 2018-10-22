package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

public class TreePrinter extends Algorithm {
    public static void printRegister(Register register) {
        System.out.println(register);
    }

    @Override
    public Btree run(Btree tree) {
        printTree(tree);
        System.out.println("\n");
//        System.out.println(tree);
        return tree;
    }
    
    private void printTree(Btree tree){
        int i = 0;
        while(printTree(tree, i)){
            i++;
//            System.out.println(i);
        }
    }

    private boolean printTree(Btree tree, int i) {
        Boolean continuum = true;
        if(i == 0){
            System.out.print(tree);
        } else if(tree.child.isEmpty()){
            return false;
        } else {
            System.out.println();
            for (Btree k : tree.child) {
                continuum = printTree(k, i-1);
            }
        }
        return continuum;
    }
}
