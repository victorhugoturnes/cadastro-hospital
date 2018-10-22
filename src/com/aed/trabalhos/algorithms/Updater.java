package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

import java.util.Scanner;

// Classe para o metodo de Atualização
// Classe para o metodo de Atualização
public class Updater extends Algorithm {

    // Sobreposição do metodo run
    // Metodo generico pra execucao da funcao base da classe
    // Eh chamado pela superclasse para generalizacao do main
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
        char control = scan.nextLine().charAt(0);   // Recolhe opção selecionada pelo usuario
        switch (control) {
            case 'A':
                System.out.println("Por favor insira o nome");
                doc.setNome(scan.nextLine());                   // Alteração de NOME
                break;
            case 'B':
                System.out.println("Por favor insira o sexo");
                doc.setSexo(scan.nextLine());                   // Alteração de SEXO
                break;
            case 'C':
                System.out.println("Por favor insira o cpf");
                doc.setCpf(scan.nextLine());                    // Alteração de CPF
                break;
            case 'D':
                System.out.println("Por favor insira o crm");
                doc.setCrm(scan.nextLine());                    // Alteração de CRM
                break;
            case 'E':
                System.out.println("Por favor insira a especialidade");
                doc.setEspecialidade(scan.nextLine());          // Alteração de ESPECIALIDADE
                break;
            case 'F':
                System.out.println("Por favor insira o rg");
                doc.setRg(scan.nextLine());                     // Alteração de RG
                break;
            case 'G':
                System.out.println("Por favor insira o telefone");
                doc.setTelefone(scan.nextLine());               // Alteração de TELEFONE
                break;
            case 'H':
                System.out.println("Por favor insira o celular");
                doc.setCelular(scan.nextLine());                // Alteração de CELULAR
                break;
            case 'i':
                System.out.println("Por favor insira o email");
                doc.setEmail(scan.nextLine());                  // Alteração de E-MAIL
                break;
            case 'J':
                System.out.println("Por favor insira o endereco");
                doc.setEndereco(scan.nextLine());               // Alteração de ENDEREÇO
                break;
            default:
                System.out.println("Por favor insira a data de nascimento");
                doc.setDataNascimento(scan.nextLine());         // Alteração de DATA DE NASCIMENTO
        }
        return tree;    // Retorna Arvore B atualizada
    }
}
