package aed.trie.atv05_tecempire;

import aed.trie.InvalidCharacterException;
import aed.trie.Trie;
import aed.util.LerArquivo;
import java.io.IOException;
import java.util.Scanner;

public class ATV05_TecEmpire {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner tc = new Scanner(System.in);
        String alfabeto;
        int tipo = 0;
        Trie<Integer> minhaTrie;

        alfabeto = LerArquivo.ler("alfabeto.txt")[0];
        minhaTrie = new Trie<>(alfabeto);
        
        String[] dados = LerArquivo.ler("dados.txt");
        
        if (dados != null) {
            for (String dado : dados) {
                String[] info = dado.split(";");
                minhaTrie.inserir(info[0], Integer.parseInt(info[1]));
            }
        }

        boolean sair = false;
        while (!sair) {
            limpaTela();
            menu();
            int opc = tc.nextInt();

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
    }

    public static void inserir(Trie<Integer> trie) throws IOException, InterruptedException {
        limpaTela();
        Scanner tc = new Scanner(System.in);
        System.out.print("\nchave: ");
        String chave = tc.nextLine();
        System.out.print("\nvalor: ");
        Integer valor = tc.nextInt();
        try {
            trie.inserir(chave, valor);
        } catch(InvalidCharacterException e) {
            System.out.println("\n"+e.getMessage());
        }
        tc.nextLine();
        System.out.println("\nPressione qualquer tecla para voltar.");
        tc.nextLine();
        //tc.close();
    }
    
    public static void buscar(Trie<Integer> trie) throws IOException, InterruptedException {
        limpaTela();
        Scanner tc = new Scanner(System.in);
        System.out.print("\nchave: ");
        String chave = tc.nextLine();
        Integer v = null;
        try {
           v = trie.buscar(chave);
        } catch(InvalidCharacterException e) {
            System.out.println("\n"+e.getMessage());
        }
       /* 
        if(v!=null) {
            System.out.println("\nValor associado a chave "+chave+": "+v);
        } else {
            System.out.println("\nNão existe uma chave \""+chave+"\" inserida na estrutura.\n");
        }
        */
        System.out.println("\nPressione qualquer tecla para voltar.");
        tc.nextLine();
        //tc.close();
    }
    
    public static void excluir(Trie<Integer> trie) throws IOException, InterruptedException {
        limpaTela();
        Scanner tc = new Scanner(System.in);
        System.out.print("\nchave: ");
        String chave = tc.nextLine();
        if(trie.contemChave(chave)) {
            trie.remover(chave);
            System.out.println("Valor removido com sucesso.");
        } else {
            System.out.println("\nNão existe uma chave \""+chave+"\" inserida na estrutura.\n");
        }
        
        System.out.println("\nPressione qualquer tecla para voltar.");
        tc.nextLine();
        //tc.close();
    }

    public static void imprimir(Trie<Integer> trie) {
        trie.imprimir();
        Scanner tc = new Scanner(System.in);
        System.out.println("\nPressione qualquer tecla para voltar.");
        tc.nextLine();
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
            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            //Runtime.getRuntime().exec("cls");
            ProcessBuilder pb= new ProcessBuilder("cmd","/c","cls");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        } else {
            ProcessBuilder pb = new ProcessBuilder("clear");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
            //Runtime.getRuntime().exec("clear");
        }
    }
}
