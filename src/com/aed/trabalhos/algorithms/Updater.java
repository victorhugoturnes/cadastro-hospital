package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

import java.util.Scanner;

public class Updater extends Algorithm {
    @Override
    public Btree run(Btree tree) {
        Scanner scan = new Scanner(System.in);
        Register doc = new Searcher().find(tree);
        System.out.println("o que deseja atualizar?"
                + "(A)nome\n"
                + "(B)sexo\n"
                + "(C)cpf\n"
                + "(D)crm\n"
                + "(E)especialidade\n"
                + "(F)rg\n"
                + "(G)telefone\n"
                + "(H)celular\n"
                + "(I)email\n"
                + "(I)endereco\n"
                + "(K)data de nascimento"
        );
        char control = scan.next().charAt(0);
        switch (control) {
            case 'A':
                System.out.println("Por favor insira o nome");
                doc.setNome(scan.next());
                break;
            case 'B':
                System.out.println("Por favor insira o sexo");
                doc.setSexo(scan.next());
                break;
            case 'C':
                System.out.println("Por favor insira o cpf");
                doc.setCpf(scan.next());
                break;
            case 'D':
                System.out.println("Por favor insira o crm");
                doc.setCrm(scan.next());
                break;
            case 'E':
                System.out.println("Por favor insira a especialidade");
                doc.setEspecialidade(scan.next());
                break;
            case 'F':
                System.out.println("Por favor insira o rg");
                doc.setRg(scan.next());
                break;
            case 'G':
                System.out.println("Por favor insira o telefone");
                doc.setTelefone(scan.next());
                break;
            case 'H':
                System.out.println("Por favor insira o celular");
                doc.setCelular(scan.next());
                break;
            case 'i':
                System.out.println("Por favor insira o email");
                doc.setEmail(scan.next());
                break;
            case 'J':
                System.out.println("Por favor insira o endereco");
                doc.setEndereco(scan.next());
                break;
            default:
                System.out.println("Por favor insira a data de nascimento");
                doc.setDataNascimento(scan.next());
        }
        return tree;
    }
}
