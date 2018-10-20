package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

import java.util.Scanner;

public class Inserter extends Algorithm {
    static Btree insert(Register doc, Btree tree) {


        return tree;
    }

    @Override
    public void run(Btree tree) {
        insert(grab(), tree);
    }

    private Register grab() {
        Register doc = new Register();
        System.out.println("Por favor insira o codigo (somente numeros):");
        Scanner scan = new Scanner(System.in);
        doc.setCodigo(scan.nextInt());
        System.out.println("Por favor insira o nome");
        doc.setNome(scan.next());
        System.out.println("Por favor insira o sexo");
        doc.setSexo(scan.next());
        System.out.println("Por favor insira o cpf");
        doc.setCpf(scan.next());
        System.out.println("Por favor insira o crm");
        doc.setCrm(scan.next());
        System.out.println("Por favor insira a especialidade");
        doc.setEspecialidade(scan.next());
        System.out.println("Por favor insira o rg");
        doc.setRg(scan.next());
        System.out.println("Por favor insira o telefone");
        doc.setTelefone(scan.next());
        System.out.println("Por favor insira o celular");
        doc.setCelular(scan.next());
        System.out.println("Por favor insira o email");
        doc.setEmail(scan.next());
        System.out.println("Por favor insira o endereco");
        doc.setEndereco(scan.next());
        System.out.println("Por favor insira a data de nascimento");
        doc.setDataNascimento(scan.next());

        return doc;
    }
}
