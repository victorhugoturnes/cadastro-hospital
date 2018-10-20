package com.aed.trabalhos;

import com.aed.trabalhos.algorithms.Algorithm;
import com.aed.trabalhos.estruturas.Menu;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Menu.printMenu();
        Algorithm algorithm = Menu.ParseInput();
        Objects.requireNonNull(algorithm).run();
    }
}
