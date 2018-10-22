package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.BinFile;
import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Classe para os metodos de Inserção
public class Loader extends Algorithm {
    private String directory = System.getProperty("user.dir") + File.separator + "inputs" + File.separator;
    private String line;
    private Matcher matcher;
    private Btree tree;

    // Sobreposição do metodo run
    // Método generico pra execução da função base da classe
    // É chamado pela superclasse para generalização do main
    @Override
    public Btree run(Btree tree) {
        this.tree = tree;
        File folder = new File(directory); // abre o arquivo de input
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            parse(file); // le o arquivc
        }
        return this.tree; // retorna Arvore B com os dados de input
    }

    // Parser para o arquivo de input
    private void parse(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                tree = Inserter.insert(parseLine(), tree);  // Le uma linha do arquivo e insere na arvore
//                System.out.println(tree);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Parser para linha de arquivo
    private Register parseLine() {
        matcher = Pattern.compile("([^:]*:?)").matcher(line);
        Register doc = new Register();
        // Atribuição de valores no novo registro
        doc.setCodigo(Integer.parseInt(parameter()));
        doc.setNome(parameter());
        doc.setSexo(parameter());
        doc.setCpf(parameter());
        doc.setCrm(parameter());
        doc.setEspecialidade(parameter());
        doc.setRg(parameter());
        doc.setTelefone(parameter());
        doc.setCelular(parameter());
        doc.setEmail(parameter());
        doc.setEndereco(parameter());
        doc.setDataNascimento(parameter());
        return doc;     // Retorna registro de medico
    }

    private String parameter() {
        return matcher.find() ? matcher.group().replace(":", " ").trim() : "";
    }
}
