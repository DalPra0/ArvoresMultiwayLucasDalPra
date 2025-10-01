public class Main {
    public static void main(String[] args) {
        Arvore23 arvore = new Arvore23();
        
        System.out.println("=== ARVORE 2-3 - DEMONSTRACAO ===\n");
        
        System.out.println("--- INSERCAO ---");
        int[] valores = {10, 20, 30, 40, 50, 60, 70};
        
        for (int valor : valores) {
            System.out.println("\nInserindo: " + valor);
            arvore.inserir(valor);
            arvore.imprimirArvore();
        }
        
        System.out.println("\n--- BUSCA ---");
        int[] buscas = {30, 45, 70};
        for (int valor : buscas) {
            boolean encontrou = arvore.buscar(valor);
            System.out.println("Buscar " + valor + ": " + (encontrou ? "ENCONTRADO" : "NAO ENCONTRADO"));
        }
        
        System.out.println("\n--- IMPRESSAO EM ORDEM ---");
        arvore.imprimirEmOrdem();
        
        System.out.println("\n--- REMOCAO ---");
        int[] remocoes = {20, 50};
        for (int valor : remocoes) {
            System.out.println("\nRemovendo: " + valor);
            boolean removeu = arvore.remover(valor);
            System.out.println("Resultado: " + (removeu ? "REMOVIDO" : "NAO ENCONTRADO"));
            arvore.imprimirArvore();
        }
        
        System.out.println("\n--- ARVORE FINAL ---");
        arvore.imprimirEmOrdem();
    }
}
