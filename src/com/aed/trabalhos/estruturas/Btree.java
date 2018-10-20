package com.aed.trabalhos.estruturas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public final class Btree implements Serializable {
    private static final int maxSize = 5;
    private static final int overflow = 1;
    private final ArrayList<Integer> keys;
    private final ArrayList<Btree> child;

    public Btree() {
        child = new ArrayList<Btree>();
        keys = new ArrayList<Integer>();
    }

    public void addKeys(int key) {
        keys.add(key);
        Collections.sort(keys);
    }

    public Boolean leaf() {
        return child.size() == 0;
    }

    public boolean overflow() {
        return keys.size() == maxSize + overflow;
    }
}
