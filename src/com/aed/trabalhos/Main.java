package com.aed.trabalhos;

import com.aed.trabalhos.algorithms.Algorithm;
import com.aed.trabalhos.algorithms.Loader;
import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Menu;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
//        Menu.printMenu();
        Btree tree = new Btree();
//        Algorithm algorithm = Menu.ParseInput();
//        Objects.requireNonNull(algorithm).run(tree);
        Loader loader = new Loader();
        loader.run(tree);
//        System.out.println(tree);
    }
}
