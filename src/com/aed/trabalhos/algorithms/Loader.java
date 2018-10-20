package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Btree;
import com.aed.trabalhos.estruturas.Register;

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader extends Algorithm {

    private String directory = System.getProperty("user.dir") + "\\inputs\\";
    private String line;
    private Matcher matcher;
    private Btree tree;

    @Override
    public Btree run(Btree tree) {
        this.tree = tree;
        File folder = new File(directory);
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            parse(file);
        }
        return this.tree;
    }

    private void parse(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                tree = Inserter.insert(parseLine(), tree);
//                System.out.println(tree);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Register parseLine() {
        matcher = Pattern.compile("([^:]*:?)").matcher(line);
        Register doc = new Register();
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
        return doc;
    }

    private String parameter() {
        return matcher.find() ? matcher.group().replace(":", " ").trim() : "";
    }
}
