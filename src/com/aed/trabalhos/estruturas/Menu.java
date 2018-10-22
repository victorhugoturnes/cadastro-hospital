package com.aed.trabalhos.estruturas;

import com.aed.trabalhos.algorithms.*;

import java.util.Scanner;

// Classe responsavel por controlar o programa e efetuar chamadas dos algoritmos
public class Menu {

    // Imprime um Menu ao usuario
    // - O menu apresenta as opcoes disponiveis de cadastro de medicos
    public static void printMenu() {
        System.out.println("(1)Carregar arquivo de inicializacao:\n"
                + "(2)Inserir Medico:\n"
                + "(3)Alterar Medico:\n"
                + "(4)Buscar dados de Medico:\n"
                + "(5)Remover Medico:\n"
                + "(6)Imprimir Cadastro:\n"
                + "(7)Imprimir Arvore B:\n"
                + "(Qualquer Outro) Sair");
    }

    // Parser para o Menu
    // - Le um inteiro inserido pelo usuario, de acordo com as opcoes dispostas no metodo printMenu()
    // - Realiza a chamada do metodo equivalente
    public static Algorithm ParseInput() {
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()) {
            case 1:
                return new Loader();    // Carrega arquivo de inicializacao
            case 2:
                return new Inserter();  // Insere um registro de medico
            case 3:
                return new Updater();   // Altera um registro de medico
            case 4:
                return new Searcher();  // Busca um registro de medico
            case 5:
                return new Deleter();   // Remove um registro de medico
            case 6:
                return new Searcher();
            case 7:
                return new TreePrinter();   // Imprime a Arvore B
            default:
                return null;
        }

    }
}
