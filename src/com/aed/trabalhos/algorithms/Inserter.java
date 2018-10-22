package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.BinFile;
import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

import java.util.Scanner;

// Classe para os metodos de Inserção
public class Inserter extends Algorithm {
    private static int i = 0;

    // Insere registro de medico na Arvore B
    // - Recebe um objeto Registro e Arvore B
    // - Retorna Arvore B com o registro inserido
    static Btree insert(Register doc, Btree tree) {
//        System.out.println(doc);
//        System.out.println(i++);

        // Busca o registro
        if (new Searcher().find(doc.getCodigo(), tree).getCodigo() == 0) {   // Se o registro ainda não foi adicionado, insere
            BinFile.addRegister(doc);
            tree = tree.addKey(doc);
        }
//        System.out.println(tree);
        return tree;    // Retorna Arvore B
    }

    // Sobreposição do metodo run
    // Método generico pra execução da função base da classe
    // É chamado pela superclasse para generalização do main
    @Override
    public Btree run(Btree tree) {
        try {
            insert(grab(), tree);  // Insere novo registro de medico na Arvore B
        } catch (Exception e) {
            System.out.println("operacao invalida");
        }
        return tree;  // Retorna Arvore B
    }

    // Metodo que solicita e atribui valores do registro de medico
    // - Atribui valores a partir do input do usuario
    private Register grab() {
        Register doc = new Register();
        System.out.println("Por favor insira o codigo (somente numeros):");
        Scanner scan = new Scanner(System.in);
        doc.setCodigo(scan.nextInt());
        scan.nextLine();
        System.out.println("Por favor insira o nome");
        doc.setNome(scan.nextLine());
        System.out.println("Por favor insira o sexo");
        doc.setSexo(scan.nextLine());
        System.out.println("Por favor insira o cpf");
        doc.setCpf(scan.nextLine());
        System.out.println("Por favor insira o crm");
        doc.setCrm(scan.nextLine());
        System.out.println("Por favor insira a especialidade");
        doc.setEspecialidade(scan.nextLine());
        System.out.println("Por favor insira o rg");
        doc.setRg(scan.nextLine());
        System.out.println("Por favor insira o telefone");
        doc.setTelefone(scan.nextLine());
        System.out.println("Por favor insira o celular");
        doc.setCelular(scan.nextLine());
        System.out.println("Por favor insira o email");
        doc.setEmail(scan.nextLine());
        System.out.println("Por favor insira o endereco");
        doc.setEndereco(scan.nextLine());
        System.out.println("Por favor insira a data de nascimento");
        doc.setDataNascimento(scan.nextLine());

        return doc;  // Retorna registro com os dados atribuidos
    }
}
