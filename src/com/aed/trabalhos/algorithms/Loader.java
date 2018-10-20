package com.aed.trabalhos.algorithms;

import com.aed.trabalhos.estruturas.Register;

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader extends Algorithm {

    private String directory = System.getProperty("user.dir") + "\\inputs\\";
    private String line;

    @Override
    public void run() {
        File folder = new File(directory);
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            parse(file);
        }

    }

    private void parse(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                Inserter.insert(parseLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Register parseLine(){
        Register doc = new Register();
        Matcher matcher = Pattern.compile("([^:]*:?)").matcher(line);
        if(matcher.find()){
            doc.setCodigo(Integer.parseInt(matcher.group().replace(":", " ").trim()));
            doc.setNome(matcher.group().replace(":", " ").trim());
            doc.setSexo(matcher.group().replace(":", " ").trim());
            doc.setCpf(matcher.group().replace(":", " ").trim());
            doc.setCrm(matcher.group().replace(":", " ").trim());
            doc.setEspecialidade(matcher.group().replace(":", " ").trim());
            doc.setRg(matcher.group().replace(":", " ").trim());
            doc.setTelefone(matcher.group().replace(":", " ").trim());
            doc.setCelular(matcher.group().replace(":", " ").trim());
            doc.setEmail(matcher.group().replace(":", " ").trim());
            doc.setEndereco(matcher.group().replace(":", " ").trim());
            doc.setDataNascimento(matcher.group().replace(":", " ").trim());
        }
        return doc;
    }
}
