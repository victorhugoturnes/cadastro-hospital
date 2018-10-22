package com.aed.trabalhos;


import com.aed.trabalhos.algorithms.Algorithm;
import com.aed.trabalhos.algorithms.Loader;
import com.aed.trabalhos.estruturas.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Boolean loop = true;
        BinFile file = new BinFile();
        Btree tree = file.loadTree(System.getProperty("user.dir") + File.separator + "savedTree");
        file.loadRegister();
        while (loop) {
            Menu.printMenu();
            Algorithm algorithm = Menu.ParseInput();
            if (algorithm != null) tree = algorithm.run(tree);
            else loop = false;
        }
        file.saveTree(tree);
        file.saveRegister();
    }
}
