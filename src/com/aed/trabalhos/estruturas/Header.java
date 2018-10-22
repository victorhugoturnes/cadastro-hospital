package com.aed.trabalhos.estruturas;

import java.io.*;

// Classe para cabecalho de arquivo
public class Header implements Serializable{

    // Atributos para cabecalho de arquivo
    public int posCabeca;   // cabeca da lista
    public int posTopo;     // topo da lista
    public int posLivre;    // posicao livre na lista

    // Construtor do cabecalho
    // - Atribui valores iniciais ao cabecalho
    public Header(){
        posCabeca = -1;
        posTopo = 0;
        posLivre = -1;
    }

    // Le um cabecalho no arquivo
    // - Recebe um cabecalho e um nome de arquivo
    // - Retorna o cabecalho
    public Header read(Header cabecalho, String filename) {
        try {
            // Abre o arquivo para leitura
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream obj = new ObjectInputStream(fin);

            cabecalho = (Header) obj.readObject();  // le o cabecalho
            obj.close();    // fecha o arquivo
            System.out.println("Lido com sucesso");
        }catch (Exception e){
            System.out.println("Falha ao ler");
        }
        return cabecalho;   // retorna cabecalho
    }

    // Escreve um cabecalho no arquivo
    // - Recebe um cabecalho e um nome de arquivo
    // - Insere o cabecalho no inicio do arquivo
    public void write(Header cabecalho, String filename) {
        try {
            // Abre o arquivo para escrita
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream obj = new ObjectOutputStream(fout);

            obj.writeObject(cabecalho); // escreve o cabecalho
            obj.close();    // fecha o arquivo
            System.out.println("Escrito com sucesso");
        }catch (Exception e){
            System.out.println("Falha ao escrever");
        }
    }

    // Sobreposição do metodo toString
    // - Retorna uma string formatada contendo os valores dos atributos
    @Override
    public String toString() {
        return "Cabeca:" + posCabeca + "\nTopo:" + posTopo + "\nPos livre: " + posLivre;
    }
}
