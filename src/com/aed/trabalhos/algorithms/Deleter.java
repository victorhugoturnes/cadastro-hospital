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
//        System.out.println("confirm the registry");
//        System.out.println(new Searcher().find(key, tree));
//        System.out.println("(Y)Delete\n(N)Cancel");
//        if (scan.next().charAt(0) == 'Y') {
        delete(key, tree);
        System.out.println("deleted register " + key);
//        }
        return tree;
    }

    private boolean delete(int key, Btree tree) {
        if (tree.keys.contains(key)) {
            if (tree.child.isEmpty()) {
                tree.keys.remove(tree.keys.indexOf(key));
                tree.updateData();
                return tree.keys.size() < 2;
            } else {
                deleteNode(key, tree);
                return tree.keys.size() < 2;
            }
        } else {
            if (delete(key, tree.findPos(key))) {
//                underflow(tree);
            }
        }
        return false;
    }

    private void underflow(Btree parent) {
        for (int i = 0; i < parent.child.size(); i++) {
            if(parent.child.get(i).keys.size() < 2){
                if(i > 0 && parent.child.get(i-1).keys.size() > 2){
//                    borrowPrev(parent.child.get(i-1), parent.child.get(i), parent);
                } else if( i < parent.child.size() && parent.child.get(i+1).keys.size() > 2){
//                    borrowNext(parent.child.get(i+1), parent.child.get(i), parent);
                } else{

                }
            }
        }
    }

    private void deleteNode(int key, Btree tree) {
        int index = tree.keys.indexOf(key);
        int movedKey = tree.child.get(index+1).keys.get(0);
        tree.keys.remove(tree.keys.indexOf(key));
        tree.keys.add(movedKey);
        delete(movedKey, tree.child.get(index+1));
        Collections.sort(tree.keys);
    }
}
