package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.BinFile;
import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

import java.util.Scanner;

public class Inserter extends Algorithm {
    private static int i = 0;

    static Btree insert(Register doc, Btree tree) {
//        System.out.println(doc);
//        System.out.println(i++);
        if (new Searcher().find(doc.getCodigo(), tree).getCodigo() == 0) {
            BinFile.addRegister(doc);
            tree = tree.addKey(doc);
        }
//        System.out.println(tree);
        return tree;
    }

    @Override
    public Btree run(Btree tree) {
        try {
            insert(grab(), tree);
        } catch (Exception e) {
            System.out.println("operacao invalida");
        }
        return tree;
    }

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

        return doc;
    }
}
