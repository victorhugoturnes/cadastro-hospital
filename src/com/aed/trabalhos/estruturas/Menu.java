package com.aed.trabalhos.estruturas;

import com.aed.trabalhos.algorithms.*;

import java.util.Scanner;

public class Menu {
    public static void printMenu() {
        System.out.println("(1)Carregar arquivo de inicializacao:\n"
                + "(2)Inserir Medico:\n"
                + "(3)Alterar Medico:\n"
                + "(4)Buscar dados de Medico:\n"
                + "(5)Remover Medico:\n"
                + "(6)Imprimir Cadastro:\n"
                + "(7)Imprimir Arvore B:\n");
    }

    public static Algorithm ParseInput() {
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()) {
            case 1:
                return new Loader();
            case 2:
                return new Inserter();
            case 3:
                return new Updater();
            case 4:
                return new Searcher();
            case 5:
                return new Deleter();
            case 6:
//                TreePrinter.printRegister(new Searcher().find());
                return null;
            case 7:
                return new TreePrinter();
            default:
                return null;
        }

    }
}
