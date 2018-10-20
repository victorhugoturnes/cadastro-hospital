package com.aed.trabalhos.estruturas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Btree implements Serializable, Comparable<Btree> {

    private final int maxSize = 4;
    private final int overflow = 1;
    private final ArrayList<Integer> keys;
    private final ArrayList<Btree> child;
    private static int k = 0;

    public Btree() {
        this.keys = new ArrayList<>();
        this.child = new ArrayList<>();
    }

    public Btree addKey(Register doc) {
        if (addKey(doc.getCodigo())) {
            Btree root = new Btree();
//            System.out.println("PreSplit " + this);
            split(root, this);
//            System.out.println("PosSplit " + root);
            return root;
        }
        return this;
    }

    private Boolean addKey(int key) {
//        System.out.println("adding " + key + " to " + this);
        if (child.size() == 0) {
            keys.add(key);
            Collections.sort(keys);
        } else if (findPos(key).addKey(key)) {
//            System.out.println("PreSplit " + this);
            split(this, findPos(key));
//            System.out.println("PosSplit " + this);
        }
        return keys.size() >= maxSize + overflow;
    }

    private void split(Btree parent, Btree split) {
//        System.out.println("splitting");
        Btree right = new Btree();
        Btree left = new Btree();
//        System.out.println("parent: " + parent);
//        System.out.println("Split " + split);
        for (int i = 0; i < split.keys.size(); i++) {
            if (i < maxSize / 2) {
//                System.out.println(split.keys.get(i));
                right.keys.add(split.keys.get(i));
                if (!split.child.isEmpty()) {
                    right.child.add(split.child.get(i));
                }
            } else if (i == maxSize / 2) {
//                System.out.println(split.keys.get(i));
                parent.keys.add(split.keys.get(i));
                if (!split.child.isEmpty()) right.child.add(split.child.get(i));
            } else {
//                System.out.println(split.keys.get(i));
                left.keys.add(split.keys.get(i));
                if (!split.child.isEmpty()) left.child.add(split.child.get(i));
            }
        }
        if (!split.child.isEmpty()) left.child.add(split.child.get(split.child.size() - 1));
        parent.child.remove(split);
        parent.child.add(right);
        parent.child.add(left);
        Collections.sort(parent.keys);
        Collections.sort(parent.child);
//        System.out.println("parent: " + parent);
//        System.out.println("right: " + right);
//        System.out.println("left: " + left);
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
//            builder.append("\n");
            for (int i = 0; i < child.size(); i++) {
                Btree c = child.get(i);
                builder.append(" " + i + " [" + c.toString() + "]");
            }
/*
            for (Btree c : this.child) {
                builder.append(c.toString());
            }
*/
        } else builder.append("[]");
        return keys.toString() + " childs:" + child.size() + builder;

    }

    @Override
    public int compareTo(Btree o) {
        return Integer.compare(this.keys.get(0), o.keys.get(0));
    }
}


