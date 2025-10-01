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
     * Insere uma nova chave na árvore
     */
    public void inserir(int chave) {
        // Caso especial: árvore vazia
        if (estaVazia()) {
            raiz = new No23(chave);
            return;
        }
        
        // Insere recursivamente e verifica se houve divisão
        ResultadoInsercao resultado = inserirRecursivo(raiz, chave);
        
        // Se a raiz foi dividida, cria nova raiz
        if (resultado.houveDivisao()) {
            No23 novaRaiz = new No23(resultado.getChavePromovida());
            novaRaiz.setEsquerdo(raiz);
            novaRaiz.setMeio(resultado.getNovoNo());
            raiz = novaRaiz;
        }
    }
    
    /**
     * Insere recursivamente uma chave na árvore
     * Retorna informações sobre possível divisão do nó
     */
    private ResultadoInsercao inserirRecursivo(No23 no, int chave) {
        // CASO 1: Nó é folha
        if (no.ehFolha()) {
            return inserirEmFolha(no, chave);
        }
        
        // CASO 2: Nó interno - desce recursivamente
        ResultadoInsercao resultado;
        
        if (chave < no.getChave1()) {
            // Insere no filho esquerdo
            resultado = inserirRecursivo(no.getEsquerdo(), chave);
            
            if (resultado.houveDivisao()) {
                return tratarDivisaoFilho(no, resultado, 0); // filho esquerdo
            }
        } else if (!no.temDuasChaves() || chave < no.getChave2()) {
            // Insere no filho do meio
            resultado = inserirRecursivo(no.getMeio(), chave);
            
            if (resultado.houveDivisao()) {
                return tratarDivisaoFilho(no, resultado, 1); // filho do meio
            }
        } else {
            // Insere no filho direito
            resultado = inserirRecursivo(no.getDireito(), chave);
            
            if (resultado.houveDivisao()) {
                return tratarDivisaoFilho(no, resultado, 2); // filho direito
            }
        }
        
        return new ResultadoInsercao(); // Sem divisão
    }
    
    /**
     * Insere uma chave em um nó folha
     */
    private ResultadoInsercao inserirEmFolha(No23 folha, int chave) {
        // Se a folha tem espaço (apenas 1 chave)
        if (!folha.temDuasChaves()) {
            folha.adicionarChave(chave);
            return new ResultadoInsercao(); // Sem divisão
        }
        
        // Folha está cheia (2 chaves) - precisa dividir
        return dividirFolha(folha, chave);
    }
    
    /**
     * Divide uma folha que está cheia (tem 2 chaves e vai receber mais uma)
     */
    private ResultadoInsercao dividirFolha(No23 folha, int novaChave) {
        // Temos 3 valores para organizar
        int val1 = folha.getChave1();
        int val2 = folha.getChave2();
        int val3 = novaChave;
        
        // Ordena os 3 valores (bubble sort manual)
        int temp;
        if (val1 > val2) {
            temp = val1;
            val1 = val2;
            val2 = temp;
        }
        if (val2 > val3) {
            temp = val2;
            val2 = val3;
            val3 = temp;
        }
        if (val1 > val2) {
            temp = val1;
            val1 = val2;
            val2 = temp;
        }
        
        // Reorganiza: val2 sobe, val1 fica no nó atual, val3 vai pro novo nó
        folha.setChave1(val1);
        folha.setChave2(0);
        folha.setTemDuasChaves(false);
        
        No23 novoNo = new No23(val3);
        
        return new ResultadoInsercao(val2, novoNo);
    }
    
    /**
     * Trata a divisão de um filho, incorporando a chave promovida no nó pai
     * posicaoFilho: 0 = esquerdo, 1 = meio, 2 = direito
     */
    private ResultadoInsercao tratarDivisaoFilho(No23 pai, ResultadoInsercao divisaoFilho, int posicaoFilho) {
        int chaveSubindo = divisaoFilho.getChavePromovida();
        No23 novoFilho = divisaoFilho.getNovoNo();
        
        // Se o pai tem espaço (apenas 1 chave)
        if (!pai.temDuasChaves()) {
            return incorporarChaveNoPai(pai, chaveSubindo, novoFilho, posicaoFilho);
        }
        
        // Pai está cheio - precisa dividir
        return dividirNoInterno(pai, chaveSubindo, novoFilho, posicaoFilho);
    }
    
    /**
     * Incorpora uma chave promovida em um nó pai que tem espaço
     */
    private ResultadoInsercao incorporarChaveNoPai(No23 pai, int chave, No23 novoFilho, int posicaoFilho) {
        if (chave < pai.getChave1()) {
            // Chave vai ser a nova chave1
            pai.setChave2(pai.getChave1());
            pai.setChave1(chave);
            pai.setDireito(pai.getMeio());
            pai.setMeio(novoFilho);
        } else {
            // Chave vai ser a chave2
            pai.setChave2(chave);
            if (posicaoFilho == 0) {
                pai.setDireito(pai.getMeio());
                pai.setMeio(novoFilho);
            } else {
                pai.setDireito(novoFilho);
            }
        }
        pai.setTemDuasChaves(true);
        
        return new ResultadoInsercao(); // Sem divisão
    }
    
    /**
     * Divide um nó interno que está cheio
     */
    private ResultadoInsercao dividirNoInterno(No23 no, int novaChave, No23 novoFilho, int posicaoFilho) {
        // Temos 3 chaves e 4 filhos para redistribuir
        int[] chaves = new int[3];
        No23[] filhos = new No23[4];
        
        // Coleta as chaves existentes
        chaves[0] = no.getChave1();
        chaves[1] = no.getChave2();
        chaves[2] = novaChave;
        
        // Coleta os filhos existentes
        filhos[0] = no.getEsquerdo();
        filhos[1] = no.getMeio();
        filhos[2] = no.getDireito();
        
        // Insere o novo filho na posição correta
        if (posicaoFilho == 0) {
            // Novo filho vem depois do esquerdo
            filhos[3] = filhos[2];
            filhos[2] = filhos[1];
            filhos[1] = novoFilho;
        } else if (posicaoFilho == 1) {
            // Novo filho vem depois do meio
            filhos[3] = filhos[2];
            filhos[2] = novoFilho;
        } else {
            // Novo filho vem depois do direito
            filhos[3] = novoFilho;
        }
        
        // Ordena as chaves (bubble sort manual)
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 - i; j++) {
                if (chaves[j] > chaves[j + 1]) {
                    int temp = chaves[j];
                    chaves[j] = chaves[j + 1];
                    chaves[j + 1] = temp;
                }
            }
        }
        
        // Reorganiza os filhos de acordo com as chaves ordenadas
        // (isso é complexo e depende de como as chaves foram reorganizadas)
        // Por simplicidade, vamos reorganizar baseado nas chaves
        
        // chaves[1] sobe (meio)
        // chaves[0] fica no nó atual
        // chaves[2] vai para o novo nó
        
        no.setChave1(chaves[0]);
        no.setChave2(0);
        no.setTemDuasChaves(false);
        no.setEsquerdo(filhos[0]);
        no.setMeio(filhos[1]);
        no.setDireito(null);
        
        No23 novoNo = new No23(chaves[2]);
        novoNo.setEsquerdo(filhos[2]);
        novoNo.setMeio(filhos[3]);
        
        return new ResultadoInsercao(chaves[1], novoNo);
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
