package com.aed.trabalhos;

import com.aed.trabalhos.algorithms.Algorithm;
import com.aed.trabalhos.algorithms.Loader;
import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Menu;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        try {
            Btree tree = new Btree();
            while (true) {
                Menu.printMenu();
                Algorithm algorithm = Menu.ParseInput();
                tree = Objects.requireNonNull(algorithm).run(tree);
            }
        } catch (Exception e) {

        }

//        Btree tree = new Btree();
//        Loader loader = new Loader();
//        System.out.println(loader.run(tree));
    }
}
