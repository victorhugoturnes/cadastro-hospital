package com.aed.trabalhos.estruturas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Btree implements Serializable {

    private final int maxSize = 5;
    private final int overflow = 1;
    private final ArrayList<Integer> keys;
    private final ArrayList<Btree> child;

    public Btree() {
        this.keys = new ArrayList<>();
        this.child = new ArrayList<>();
    }

    public Btree addKey(Register doc){
        if(addKey(doc.getCodigo())){
            Btree root = new Btree();
            split(root, this);
//            System.out.println(root);
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
        System.err.println("splitting");
        Btree right = new Btree();
        Btree left = new Btree();
        for (int i = 0; i < keys.size(); i++) {
            if (i < maxSize / 2) {
                right.keys.add(split.keys.get(i));
                if(!right.child.isEmpty())right.child.add(split.child.get(i));
            } else if (i == maxSize / 2 + 1) parent.keys.add(split.keys.get(i));
            else {
                left.keys.add(split.keys.get(i));
                if(!right.child.isEmpty())left.child.add(split.child.get(i));
            }
        }
        parent.child.add(left);
        parent.child.add(right);
    }

    private Btree findPos(int key) {
        for (int i = 0; i < keys.size(); i++) {
            if (key < keys.get(i)) return child.get(i);
        }
        return child.get(child.size()-1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(!child.isEmpty()){
            builder.append("\n");
            for (Btree c: this.child) {
                builder.append(c.toString());
            }
        }
        System.out.println("keys: " + keys.size());
        System.out.println("childs: " + child.size());
        return keys.toString() + builder;
    }
}


