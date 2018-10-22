package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;

import java.util.Collections;
import java.util.Scanner;

public class Deleter extends Algorithm {
    @Override
    public Btree run(Btree tree) {
        Scanner scan = new Scanner(System.in);
//        new Searcher().find();
        System.out.println("please insert a key to be deleted");
        int key = scan.nextInt();
        System.out.println("confirm the registry");
        new Searcher().find(key, tree);
        System.out.println("(Y)Delete\n(N)Cancel");
        switch (scan.next().charAt(0)) {
            case 'Y':
                tree = delete(key, tree);
            default:
                break;
        }
        return tree;
    }

    private Btree delete(int key, Btree tree) {
        if(tree.child.isEmpty()){
            return deleteLeaf(key, tree);
        } else {
            return deleteNode(key, tree);
        }
//        return null;
    }

    private Btree deleteNode(int key, Btree tree) {
        if(tree.child.size() <= 2){
            return deleteNodeUnderflow(key, tree);
        }else{
            /*black magic everywherre*/
            return tree;
        }
    }

    private Btree deleteNodeUnderflow(int key, Btree tree) {
        return tree;
    }

    private Btree deleteLeaf(int key, Btree tree) {
        if(tree.child.size() <= 2 ){
            return deleteLeafUnderflow(key, tree);
        }else{
            tree.keys.remove(key);
            Collections.sort(tree.keys);
            return tree;
        }
    }

    private Btree deleteLeafUnderflow(int key, Btree tree) {
        /*black magic goes here*/
        return tree;
    }
}
