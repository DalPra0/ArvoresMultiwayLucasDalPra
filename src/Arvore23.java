/**
 * Implementação de uma Árvore 2-3
 * 
 * Propriedades:
 * - Todo nó tem 1 ou 2 chaves
 * - Todo nó tem 2 ou 3 filhos (se não for folha)
 * - Todas as folhas estão no mesmo nível
 * - Árvore sempre balanceada
 * 
 * @author Lucas Dal Pra Brascher
 */
public class Arvore23 {
    private No23 raiz;
    
    /**
     * Construtor: cria uma árvore vazia
     */
    public Arvore23() {
        this.raiz = null;
    }
    
    /**
     * Verifica se a árvore está vazia
     */
    public boolean estaVazia() {
        return raiz == null;
    }
    
    /**
     * Busca uma chave na árvore
     * Retorna true se encontrou, false caso contrário
     */
    public boolean buscar(int chave) {
        return buscarRecursivo(raiz, chave);
    }
    
    /**
     * Busca recursiva na árvore
     */
    private boolean buscarRecursivo(No23 no, int chave) {
        // Caso base: nó vazio
        if (no == null) {
            return false;
        }
        
        // Verifica se a chave está no nó atual
        if (chave == no.getChave1()) {
            return true;
        }
        
        if (no.temDuasChaves() && chave == no.getChave2()) {
            return true;
        }
        
        // Se é folha e não encontrou, não existe
        if (no.ehFolha()) {
            return false;
        }
        
        // Decide qual filho visitar
        if (chave < no.getChave1()) {
            // Busca no filho esquerdo
            return buscarRecursivo(no.getEsquerdo(), chave);
        } else if (!no.temDuasChaves() || chave < no.getChave2()) {
            // Busca no filho do meio
            return buscarRecursivo(no.getMeio(), chave);
        } else {
            // Busca no filho direito
            return buscarRecursivo(no.getDireito(), chave);
        }
    }
    
    /**
     * Retorna a raiz da árvore
     */
    public No23 getRaiz() {
        return raiz;
    }
    
    /**
     * Imprime a árvore em ordem (in-order traversal)
     */
    public void imprimirEmOrdem() {
        if (estaVazia()) {
            System.out.println("Árvore vazia!");
            return;
        }
        System.out.print("Árvore em ordem: ");
        imprimirEmOrdemRecursivo(raiz);
        System.out.println();
    }
    
    /**
     * Imprime recursivamente em ordem
     */
    private void imprimirEmOrdemRecursivo(No23 no) {
        if (no == null) {
            return;
        }
        
        // Visita filho esquerdo
        imprimirEmOrdemRecursivo(no.getEsquerdo());
        
        // Imprime primeira chave
        System.out.print(no.getChave1() + " ");
        
        // Visita filho do meio
        imprimirEmOrdemRecursivo(no.getMeio());
        
        // Se tem segunda chave, imprime e visita filho direito
        if (no.temDuasChaves()) {
            System.out.print(no.getChave2() + " ");
            imprimirEmOrdemRecursivo(no.getDireito());
        }
    }
    
    /**
     * Imprime a estrutura da árvore (visualização hierárquica)
     */
    public void imprimirArvore() {
        if (estaVazia()) {
            System.out.println("Árvore vazia!");
            return;
        }
        System.out.println("Estrutura da árvore:");
        imprimirArvoreRecursivo(raiz, "", true);
    }
    
    /**
     * Imprime recursivamente a estrutura da árvore
     */
    private void imprimirArvoreRecursivo(No23 no, String prefixo, boolean ehUltimo) {
        if (no == null) {
            return;
        }
        
        System.out.println(prefixo + (ehUltimo ? "└── " : "├── ") + no.toString());
        
        String novoPrefixo = prefixo + (ehUltimo ? "    " : "│   ");
        
        if (!no.ehFolha()) {
            if (no.temDuasChaves()) {
                // Nó com 3 filhos
                imprimirArvoreRecursivo(no.getEsquerdo(), novoPrefixo, false);
                imprimirArvoreRecursivo(no.getMeio(), novoPrefixo, false);
                imprimirArvoreRecursivo(no.getDireito(), novoPrefixo, true);
            } else {
                // Nó com 2 filhos
                imprimirArvoreRecursivo(no.getEsquerdo(), novoPrefixo, false);
                imprimirArvoreRecursivo(no.getMeio(), novoPrefixo, true);
            }
        }
    }
}
