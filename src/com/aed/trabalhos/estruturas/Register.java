package com.aed.trabalhos.estruturas;

import java.io.Serializable;

// Classe para os dados dos doutores
public class Register implements Serializable {

    // Atributos para registro dos doutores
    private int codigo;
    private String nome, sexo, cpf, crm, especialidade, rg, telefone, celular, email, endereco, dataNascimento;


    // Getters e Setters para os atributos de registro
    // - Getters retornam o valor do atributo
    // - Setters atribuem um valor passado por parametro para o atributo

    // <- Inicio Getters e Setters ->
    // retorna o codigo de um doutor
    int getCodigo() {
        return codigo;
    }

    // atribui um codigo a um doutor
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // retorna o nome de um doutor
    public String getNome() {
        return nome;
    }

    // atribui um nome a um doutor
    public void setNome(String nome) {
        this.nome = nome;
    }

    // retorna o sexo de um doutor
    public String getSexo() {
        return sexo;
    }

    // atribui um sexo a um doutor
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // retorna o CPF de um doutor
    public String getCpf() {
        return cpf;
    }

    // atribui um CPF a um doutor
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // retorna o CRM de um doutor
    public String getCrm() {
        return crm;
    }

    // atribui um CRM a um doutor
    public void setCrm(String crm) {
        this.crm = crm;
    }

    // retorna a especialidade de um doutor
    public String getEspecialidade() {
        return especialidade;
    }

    // atribui uma especialidade a um doutor
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    // retorna o RG de um doutor
    public String getRg() {
        return rg;
    }

    // atribui um RG a um doutor
    public void setRg(String rg) {
        this.rg = rg;
    }

    // retorna o telefone de um doutor
    public String getTelefone() {
        return telefone;
    }

    // atribui um telefone a um doutor
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // retorna o celular de um doutor
    public String getCelular() {
        return celular;
    }

    // atribui um celular a um doutor
    public void setCelular(String celular) {
        this.celular = celular;
    }

    // retorna o e-mail de um doutor
    public String getEmail() {
        return email;
    }

    // atribui um e-mail a um doutor
    public void setEmail(String email) {
        this.email = email;
    }

    // retorna o endereco de um doutor
    public String getEndereco() {
        return endereco;
    }

    // atribui um endereço a um doutor
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // retorna a data de nascimento de um doutor
    public String getDataNascimento() {
        return dataNascimento;
    }

    // atribui uma data de nascimento a um doutor
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
    // <- Final Getters e Setters ->


    // Sobreposição do metodo toString
    // - Retorna uma string formatada contendo os valores dos atributos
    @Override
    public String toString() {
        return "Register{" +
                "\ncodigo=" + codigo +
                "\nnome='" + nome + '\'' +
                "\nsexo='" + sexo + '\'' +
                "\ncpf='" + cpf + '\'' +
                "\ncrm='" + crm + '\'' +
                "\nespecialidade='" + especialidade + '\'' +
                "\nrg='" + rg + '\'' +
                "\ntelefone='" + telefone + '\'' +
                "\ncelular='" + celular + '\'' +
                "\nemail='" + email + '\'' +
                "\nendereco='" + endereco + '\'' +
                "\ndataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
