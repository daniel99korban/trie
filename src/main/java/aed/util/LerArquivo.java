
package aed.util;


import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

public class LerArquivo {
    public static List<String> readFileInList(String filePath, String fileName) throws FileNotFoundException {

        List<String> lines = Collections.emptyList();
        try {
            lines =
                    Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            //System.out.println("Arquivo "+fileName + " não encontrado.");
            //e.printStackTrace();
            throw new FileNotFoundException("Arquivo "+fileName+" não encontrado.");
        }
        return lines;
    }
    public static String[] ler(String arquivo) throws FileNotFoundException {
        File directory = new File("");
        String caminho = (String) directory.getAbsolutePath();
        caminho += "\\entradadados\\";
        caminho += arquivo;


        List l = readFileInList(caminho, arquivo);
        String[] dados = new String[l.size()];
        Iterator<String> itr = l.iterator();
        int i=0;
        while(itr.hasNext()) {
            dados[i] = itr.next();
            i++;
        }
        return dados;
    }
}

