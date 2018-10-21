package com.aed.trabalhos;

import com.aed.trabalhos.algorithms.Algorithm;
import com.aed.trabalhos.algorithms.Loader;
import com.aed.trabalhos.estruturas.BinFile;
import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Header;
import com.aed.trabalhos.estruturas.Menu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BinFile binfile = new BinFile();
        Header cabecalho = new Header();

        binfile.newListingFile("cabecalho.txt");

        cabecalho = cabecalho.read(cabecalho, "cabecalho.txt");
        System.out.println(cabecalho.toString());

        Btree tree = new Btree();

        Btree child1 = new Btree();
        Btree child2 = new Btree();
        Btree child3 = new Btree();

        tree.addKey(50);
        tree.addKey(100);
        tree.addKey(150);

        tree.child.add(child1);
        tree.child.add(child2);
        tree.child.add(child3);

        child1.addKey(200);
        child1.addKey(250);
        child1.addKey(300);

        child2.addKey(350);
        child2.addKey(400);
        child2.addKey(450);

        child3.addKey(500);
        child3.addKey(550);
        child3.addKey(600);

        binfile.saveNode(binfile, tree, "node.txt");

        binfile.loadNode(binfile, "node.txt");

        /*
        BinFile binfile = new BinFile();
        tree = binfile.loadTree("arvoreB.txt");
        System.out.println(tree.toString());
        */

        /*
        try {
            Btree tree = new Btree();
            while (true) {
                Menu.printMenu();
                Algorithm algorithm = Menu.ParseInput();
                tree = Objects.requireNonNull(algorithm).run(tree);
            }
        } catch (Exception e) {

        }
        */


//        Btree tree = new Btree();
//        Loader loader = new Loader();
//        System.out.println(loader.run(tree));
    }
}
