package aed.trie.atv05_tecempire;

import aed.trie.InvalidCharacterException;
import aed.trie.Trie;
import aed.util.LerArquivo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RunString {

   public static void main() throws IOException, InterruptedException {
       
            Scanner tc = new Scanner(System.in);
            String alfabeto;
            Trie<String> minhaTrie;

        try {
            alfabeto = LerArquivo.ler("alfabeto.txt")[0];
            minhaTrie = new Trie<>(alfabeto);

            String[] dados = LerArquivo.ler("dadosString.txt");

            if (dados != null) {

                for (String dado : dados) {
                    String[] info = dado.split(";");
                    minhaTrie.inserir(info[0], info[1]);
                }
            }

            boolean sair = false;
            while (!sair) {
                limpaTela();
                menu();
                Integer opc = null;
                try {
                    opc = tc.nextInt();
                } catch (Exception e) {
                    tc.nextLine();
                } finally {
                    if (opc == null) {
                        continue;
                    }
                }

                switch (opc) {
                    case 1:
                        limpaTela();
                        imprimir(minhaTrie);
                        break;
                    case 2:
                        inserir(minhaTrie);
                        break;
                    case 3:
                        buscar(minhaTrie);
                        break;
                    case 4:
                        excluir(minhaTrie);
                        break;
                    case 5:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida.\n");
                }
            }
            tc.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void inserir(Trie<String> trie) throws IOException, InterruptedException {
        limpaTela();
        Scanner tc = new Scanner(System.in);
        String chave;
        String valor = null;
        while (true) {
            System.out.print("\nchave: ");
            chave = tc.nextLine();
            if (!chave.isEmpty() && !chave.isBlank()) {
                break;
            }
            limpaTela();
        }
        while (true) {
            System.out.print("valor: ");
            valor = tc.nextLine();
            if (!chave.isEmpty() && !chave.isBlank()) {
                break;
            }
            limpaTela();
        }

        try {
            trie.inserir(chave, valor);
            System.out.println("Chave e valor inseridos com sucesso.\n");
        } catch (InvalidCharacterException e) {
            System.out.println("\n" + e.getMessage());
        }
        tc.nextLine();
        mensagemVoltaParaMenu();
        tc.nextLine();
    }

    public static void buscar(Trie<String> trie) throws IOException, InterruptedException {
        limpaTela();
        Scanner tc = new Scanner(System.in);
        String v = null;
        String chave;
        
        while (true) {
            System.out.print("\nchave: ");
            chave = tc.nextLine();
            if (!chave.isEmpty() && !chave.isBlank()) {
                break;
            }
            limpaTela();
        }
        
        try {
            v = trie.buscar(chave);

            if (v != null) {
                System.out.println("\nValor associado a chave " + chave + ": " + v);
            } else {
                System.out.println("\nNão existe uma chave \"" + chave + "\" inserida na estrutura.\n");
            }
        } catch (InvalidCharacterException e) {
            System.out.println("\n" + e.getMessage());
        }

        mensagemVoltaParaMenu();
        tc.nextLine();
    }

    public static void excluir(Trie<String> trie) throws IOException, InterruptedException {
        limpaTela();
        Scanner tc = new Scanner(System.in);
        String chave;
        
        while (true) {
            System.out.print("\nchave: ");
            chave = tc.nextLine();
            if (!chave.isEmpty() && !chave.isBlank()) {
                break;
            }
            limpaTela();
        }
        
        try {
            if (trie.remover(chave)) {
                System.out.println("Chave e valor removidos com sucesso.");
            } else {
                System.out.println("\nNão existe uma chave \"" + chave + "\" inserida na estrutura.\n");
            }
        } catch (InvalidCharacterException e) {
            System.out.println("\n" + e.getMessage());
        }

        mensagemVoltaParaMenu();
        tc.nextLine();
    }

    public static void imprimir(Trie<String> trie) {
        trie.imprimir();
        Scanner tc = new Scanner(System.in);
        mensagemVoltaParaMenu();
        tc.nextLine();
    }

    public static void mensagemVoltaParaMenu() {
        System.out.println("\nPressione a tecla Enter para voltar.");
    }

    public static void menu() {
        String opcoes = "\nOPÇÕES";
        opcoes += "\n[1] imprimir";
        opcoes += "\n[2] inserir";
        opcoes += "\n[3] buscar";
        opcoes += "\n[4] excluir";
        opcoes += "\n[5] sair";
        opcoes += "\n[]: ";
        System.out.print(opcoes);
    }

    public static void limpaTela() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows")) {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        } else {
            ProcessBuilder pb = new ProcessBuilder("clear");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        }
    }
}
