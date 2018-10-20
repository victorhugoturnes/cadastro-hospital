package com.aed.trabalhos.estruturas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Btree implements Serializable {

    private final int maxSize = 4;
    private final int overflow = 1;
    private final ArrayList<Integer> keys;
    private final ArrayList<Btree> child;

    public Btree() {
        this.keys = new ArrayList<>();
        this.child = new ArrayList<>();
    }

    public Btree addKey(Register doc) {
        if (addKey(doc.getCodigo())) {
            Btree root = new Btree();
            split(root, this);
            return root;
        }
        return this;
    }

    private Boolean addKey(int key) {
        if (child.size() == 0) {
            keys.add(key);
            Collections.sort(keys);
        } else if (findPos(key).addKey(key)) {
            split(this, findPos(key));
        }
        return keys.size() >= maxSize + overflow;
    }

    private void split(Btree parent, Btree split) {
//        System.out.println("splitting");
        Btree right = new Btree();
        Btree left = new Btree();
//        System.out.println("Split " + split);
        for (int i = 0; i < keys.size(); i++) {
            if (i < maxSize / 2) {
                right.keys.add(split.keys.get(i));
                if (!right.child.isEmpty()){
                    right.child.add(split.child.get(i));
                }
            } else if (i == maxSize / 2) parent.keys.add(split.keys.get(i));
            else {
                left.keys.add(split.keys.get(i));
                if (!right.child.isEmpty()) left.child.add(split.child.get(i));
            }
        }
        parent.child.add(right);
        parent.child.add(left);
    }

    private Btree findPos(int key) {
        for (int i = 0; i < keys.size(); i++) {
            if (key < keys.get(i)) return child.get(i);
        }
        return child.get(child.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (!child.isEmpty()) {
            builder.append("\n");
            for (Btree c : this.child) {
                builder.append(c.toString());
            }
        }
        return keys.toString() + builder;
    }
}


