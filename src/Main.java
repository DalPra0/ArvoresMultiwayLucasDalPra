public class Main {
    public static void main(String[] args) {
        Arvore23 arvore = new Arvore23();
        
        System.out.println("========================================");
        System.out.println("   ARVORE 2-3 - DEMONSTRACAO COMPLETA");
        System.out.println("   Autor: Lucas Dal Pra Brascher");
        System.out.println("========================================\n");
        
        System.out.println("--- PARTE 1: INSERCAO PASSO A PASSO ---\n");
        int[] valores = {10, 20, 30, 40, 50, 60, 70};
        
        for (int valor : valores) {
            System.out.println(">>> Inserindo: " + valor);
            arvore.inserir(valor);
            arvore.imprimirArvore();
            System.out.println();
        }
        
        System.out.println("\n--- PARTE 2: VISUALIZACAO EM ORDEM ---");
        arvore.imprimirEmOrdem();
        
        System.out.println("\n--- PARTE 3: OPERACOES DE BUSCA ---\n");
        int[] buscas = {10, 30, 45, 60, 70, 100};
        for (int valor : buscas) {
            boolean encontrou = arvore.buscar(valor);
            System.out.println("Buscar " + valor + ": " + (encontrou ? "ENCONTRADO ✓" : "NAO ENCONTRADO ✗"));
        }
        
        System.out.println("\n--- PARTE 4: ESTRUTURA ATUAL ---");
        arvore.imprimirArvore();
        
        System.out.println("\n--- PARTE 5: REMOCAO COM REBALANCEAMENTO ---\n");
        
        System.out.println(">>> Removendo: 20 (no interno)");
        boolean removeu20 = arvore.remover(20);
        System.out.println("Resultado: " + (removeu20 ? "REMOVIDO ✓" : "NAO ENCONTRADO ✗"));
        arvore.imprimirArvore();
        System.out.println();
        
        System.out.println(">>> Removendo: 50 (folha)");
        boolean removeu50 = arvore.remover(50);
        System.out.println("Resultado: " + (removeu50 ? "REMOVIDO ✓" : "NAO ENCONTRADO ✗"));
        arvore.imprimirArvore();
        System.out.println();
        
        System.out.println(">>> Removendo: 100 (nao existe)");
        boolean removeu100 = arvore.remover(100);
        System.out.println("Resultado: " + (removeu100 ? "REMOVIDO ✓" : "NAO ENCONTRADO ✗"));
        System.out.println();
        
        System.out.println("\n--- PARTE 6: ARVORE FINAL ---");
        System.out.println("\nEstrutura:");
        arvore.imprimirArvore();
        System.out.println("\nEm ordem:");
        arvore.imprimirEmOrdem();
        
        System.out.println("\n========================================");
        System.out.println("   DEMONSTRACAO CONCLUIDA");
        System.out.println("   Todas as operacoes executadas!");
        System.out.println("========================================");
    }
}
