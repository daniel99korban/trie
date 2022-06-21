package aed.trie.atv05_tecempire;

import java.io.IOException;


public class ATV05_TecEmpire {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        if(args.length > 1 || args.length < 1) {
            System.out.println("Argumentos invalidos.");
            System.out.println("Quantidade de asgumentos esperados: 1, quantidade de argumentos passados: "+args.length+".");
            return;
        }
        String tipo = args[0];
        switch(tipo) {
            case "Integer":
                RunInteger.main();
                break;
            case "String":
                RunString.main();
                break;
            case "Double":
                RunDouble.main();
                break;
            default:
                System.out.println("O tipo \""+tipo+"\" é invalido.");
        }
    }
}
