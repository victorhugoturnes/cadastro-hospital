package com.aed.trabalhos.estruturas;

import java.io.Serializable;

public class Register implements Serializable {
    private int codigo;
    private String nome, sexo, cpf, crm, especialidade, rg, telefone, celular, email, endereco, dataNascimento;

    int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

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
