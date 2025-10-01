/**
 * Classe que representa um nó da Árvore 2-3
 * Um nó pode ter:
 * - 1 ou 2 chaves (valores)
 * - 2 ou 3 filhos (se não for folha)
 * 
 * @author Lucas Dal Pra Brascher
 */
public class No23 {
    // Dados do nó
    private int chave1;           // Primeira chave (sempre presente)
    private int chave2;           // Segunda chave (pode não existir)
    private boolean temDuasChaves; // Flag indicando se tem 2 chaves
    
    // Filhos do nó
    private No23 esquerdo;    // Filho esquerdo (valores < chave1)
    private No23 meio;        // Filho do meio (valores entre chave1 e chave2)
    private No23 direito;     // Filho direito (valores > chave2)
    
    // Construtor: cria nó com uma chave
    public No23(int chave) {
        this.chave1 = chave;
        this.chave2 = 0;
        this.temDuasChaves = false;
        this.esquerdo = null;
        this.meio = null;
        this.direito = null;
    }
    
    // ===== GETTERS E SETTERS =====
    
    public int getChave1() {
        return chave1;
    }
    
    public void setChave1(int chave1) {
        this.chave1 = chave1;
    }
    
    public int getChave2() {
        return chave2;
    }
    
    public void setChave2(int chave2) {
        this.chave2 = chave2;
    }
    
    public boolean temDuasChaves() {
        return temDuasChaves;
    }
    
    public void setTemDuasChaves(boolean temDuasChaves) {
        this.temDuasChaves = temDuasChaves;
    }
    
    public No23 getEsquerdo() {
        return esquerdo;
    }
    
    public void setEsquerdo(No23 esquerdo) {
        this.esquerdo = esquerdo;
    }
    
    public No23 getMeio() {
        return meio;
    }
    
    public void setMeio(No23 meio) {
        this.meio = meio;
    }
    
    public No23 getDireito() {
        return direito;
    }
    
    public void setDireito(No23 direito) {
        this.direito = direito;
    }
    
    // ===== MÉTODOS AUXILIARES =====
    
    /**
     * Verifica se o nó é uma folha (não tem filhos)
     */
    public boolean ehFolha() {
        return esquerdo == null && meio == null && direito == null;
    }
    
    /**
     * Adiciona uma segunda chave ao nó
     * Organiza as chaves em ordem crescente
     */
    public void adicionarChave(int novaChave) {
        if (temDuasChaves) {
            // Nó já tem 2 chaves - isso não deveria acontecer
            return;
        }
        
        // Adiciona e organiza em ordem
        if (novaChave < chave1) {
            // Nova chave é menor que a primeira
            chave2 = chave1;
            chave1 = novaChave;
        } else {
            // Nova chave é maior que a primeira
            chave2 = novaChave;
        }
        
        temDuasChaves = true;
    }
    
    /**
     * Retorna uma representação em String do nó
     */
    public String toString() {
        if (temDuasChaves) {
            return "[" + chave1 + ", " + chave2 + "]";
        } else {
            return "[" + chave1 + "]";
        }
    }
}
