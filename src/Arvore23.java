public class Arvore23 {
    private No23 raiz;
    
    public Arvore23() {
        this.raiz = null;
    }
    
    public boolean estaVazia() {
        return raiz == null;
    }
    
    public boolean buscar(int chave) {
        return buscarRecursivo(raiz, chave);
    }
    
    private boolean buscarRecursivo(No23 no, int chave) {
        if (no == null) {
            return false;
        }
        
        if (chave == no.getChave1()) {
            return true;
        }
        
        if (no.temDuasChaves() && chave == no.getChave2()) {
            return true;
        }
        
        if (no.ehFolha()) {
            return false;
        }
        
        if (chave < no.getChave1()) {
            return buscarRecursivo(no.getEsquerdo(), chave);
        } else if (!no.temDuasChaves() || chave < no.getChave2()) {
            return buscarRecursivo(no.getMeio(), chave);
        } else {
            return buscarRecursivo(no.getDireito(), chave);
        }
    }
    
    public void inserir(int chave) {
        if (estaVazia()) {
            raiz = new No23(chave);
            return;
        }
        
        ResultadoInsercao resultado = inserirRecursivo(raiz, chave);
        
        if (resultado.houveDivisao()) {
            No23 novaRaiz = new No23(resultado.getChavePromovida());
            novaRaiz.setEsquerdo(raiz);
            novaRaiz.setMeio(resultado.getNovoNo());
            raiz = novaRaiz;
        }
    }
    
    private ResultadoInsercao inserirRecursivo(No23 no, int chave) {
        if (no.ehFolha()) {
            return inserirEmFolha(no, chave);
        }
        
        ResultadoInsercao resultado;
        
        if (chave < no.getChave1()) {
            resultado = inserirRecursivo(no.getEsquerdo(), chave);
            
            if (resultado.houveDivisao()) {
                return tratarDivisaoFilho(no, resultado, 0);
            }
        } else if (!no.temDuasChaves() || chave < no.getChave2()) {
            resultado = inserirRecursivo(no.getMeio(), chave);
            
            if (resultado.houveDivisao()) {
                return tratarDivisaoFilho(no, resultado, 1);
            }
        } else {
            resultado = inserirRecursivo(no.getDireito(), chave);
            
            if (resultado.houveDivisao()) {
                return tratarDivisaoFilho(no, resultado, 2);
            }
        }
        
        return new ResultadoInsercao();
    }
    
    private ResultadoInsercao inserirEmFolha(No23 folha, int chave) {
        if (!folha.temDuasChaves()) {
            folha.adicionarChave(chave);
            return new ResultadoInsercao();
        }
        
        return dividirFolha(folha, chave);
    }
    
    private ResultadoInsercao dividirFolha(No23 folha, int novaChave) {
        int val1 = folha.getChave1();
        int val2 = folha.getChave2();
        int val3 = novaChave;
        
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
        
        folha.setChave1(val1);
        folha.setChave2(0);
        folha.setTemDuasChaves(false);
        
        No23 novoNo = new No23(val3);
        
        return new ResultadoInsercao(val2, novoNo);
    }
    
    private ResultadoInsercao tratarDivisaoFilho(No23 pai, ResultadoInsercao divisaoFilho, int posicaoFilho) {
        int chaveSubindo = divisaoFilho.getChavePromovida();
        No23 novoFilho = divisaoFilho.getNovoNo();
        
        if (!pai.temDuasChaves()) {
            return incorporarChaveNoPai(pai, chaveSubindo, novoFilho, posicaoFilho);
        }
        
        return dividirNoInterno(pai, chaveSubindo, novoFilho, posicaoFilho);
    }
    
    private ResultadoInsercao incorporarChaveNoPai(No23 pai, int chave, No23 novoFilho, int posicaoFilho) {
        if (chave < pai.getChave1()) {
            pai.setChave2(pai.getChave1());
            pai.setChave1(chave);
            pai.setDireito(pai.getMeio());
            pai.setMeio(novoFilho);
        } else {
            pai.setChave2(chave);
            if (posicaoFilho == 0) {
                pai.setDireito(pai.getMeio());
                pai.setMeio(novoFilho);
            } else {
                pai.setDireito(novoFilho);
            }
        }
        pai.setTemDuasChaves(true);
        
        return new ResultadoInsercao();
    }
    
    private ResultadoInsercao dividirNoInterno(No23 no, int novaChave, No23 novoFilho, int posicaoFilho) {
        int[] chaves = new int[3];
        No23[] filhos = new No23[4];
        
        chaves[0] = no.getChave1();
        chaves[1] = no.getChave2();
        chaves[2] = novaChave;
        
        filhos[0] = no.getEsquerdo();
        filhos[1] = no.getMeio();
        filhos[2] = no.getDireito();
        
        if (posicaoFilho == 0) {
            filhos[3] = filhos[2];
            filhos[2] = filhos[1];
            filhos[1] = novoFilho;
        } else if (posicaoFilho == 1) {
            filhos[3] = filhos[2];
            filhos[2] = novoFilho;
        } else {
            filhos[3] = novoFilho;
        }
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 - i; j++) {
                if (chaves[j] > chaves[j + 1]) {
                    int temp = chaves[j];
                    chaves[j] = chaves[j + 1];
                    chaves[j + 1] = temp;
                }
            }
        }
        
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
    
    public boolean remover(int chave) {
        if (estaVazia()) {
            return false;
        }
        
        boolean removeu = removerRecursivo(raiz, null, chave, -1);
        
        if (raiz != null && raiz.getChave1() == 0 && !raiz.temDuasChaves()) {
            if (!raiz.ehFolha()) {
                raiz = raiz.getEsquerdo();
            } else {
                raiz = null;
            }
        }
        
        return removeu;
    }
    
    private boolean removerRecursivo(No23 no, No23 pai, int chave, int posicaoNoFilho) {
        if (no == null) {
            return false;
        }
        
        if (chave == no.getChave1() || (no.temDuasChaves() && chave == no.getChave2())) {
            if (no.ehFolha()) {
                return removerDeFolha(no, pai, chave, posicaoNoFilho);
            } else {
                return removerDeNoInterno(no, pai, chave, posicaoNoFilho);
            }
        }
        
        if (no.ehFolha()) {
            return false;
        }
        
        if (chave < no.getChave1()) {
            return removerRecursivo(no.getEsquerdo(), no, chave, 0);
        } else if (!no.temDuasChaves() || chave < no.getChave2()) {
            return removerRecursivo(no.getMeio(), no, chave, 1);
        } else {
            return removerRecursivo(no.getDireito(), no, chave, 2);
        }
    }
    
    private boolean removerDeFolha(No23 folha, No23 pai, int chave, int posicao) {
        if (folha.temDuasChaves()) {
            if (chave == folha.getChave1()) {
                folha.setChave1(folha.getChave2());
            }
            folha.setChave2(0);
            folha.setTemDuasChaves(false);
            return true;
        } else {
            if (pai == null) {
                folha.setChave1(0);
                return true;
            }
            
            return rebalancearAposRemocao(folha, pai, posicao);
        }
    }
    
    private boolean removerDeNoInterno(No23 no, No23 pai, int chave, int posicao) {
        No23 subArvore;
        
        if (chave == no.getChave1()) {
            subArvore = no.getEsquerdo();
        } else {
            subArvore = no.getMeio();
        }
        
        int predecessora = encontrarMaximo(subArvore);
        
        if (chave == no.getChave1()) {
            no.setChave1(predecessora);
        } else {
            no.setChave2(predecessora);
        }
        
        return removerRecursivo(subArvore, no, predecessora, posicao);
    }
    
    private int encontrarMaximo(No23 no) {
        while (!no.ehFolha()) {
            if (no.temDuasChaves() && no.getDireito() != null) {
                no = no.getDireito();
            } else {
                no = no.getMeio();
            }
        }
        
        return no.temDuasChaves() ? no.getChave2() : no.getChave1();
    }
    
    private boolean rebalancearAposRemocao(No23 folha, No23 pai, int posicao) {
        if (posicao == 0) {
            No23 irmao = pai.getMeio();
            if (irmao != null && irmao.temDuasChaves()) {
                folha.setChave1(pai.getChave1());
                pai.setChave1(irmao.getChave1());
                irmao.setChave1(irmao.getChave2());
                irmao.setChave2(0);
                irmao.setTemDuasChaves(false);
                return true;
            }
        } else if (posicao == 1) {
            No23 irmaoEsq = pai.getEsquerdo();
            if (irmaoEsq != null && irmaoEsq.temDuasChaves()) {
                folha.setChave1(pai.getChave1());
                pai.setChave1(irmaoEsq.getChave2());
                irmaoEsq.setChave2(0);
                irmaoEsq.setTemDuasChaves(false);
                return true;
            }
            
            if (pai.temDuasChaves()) {
                No23 irmaoDir = pai.getDireito();
                if (irmaoDir != null && irmaoDir.temDuasChaves()) {
                    folha.setChave1(pai.getChave2());
                    pai.setChave2(irmaoDir.getChave1());
                    irmaoDir.setChave1(irmaoDir.getChave2());
                    irmaoDir.setChave2(0);
                    irmaoDir.setTemDuasChaves(false);
                    return true;
                }
            }
        }
        
        return fundirNos(folha, pai, posicao);
    }
    
    private boolean fundirNos(No23 folha, No23 pai, int posicao) {
        if (posicao == 0) {
            No23 irmao = pai.getMeio();
            folha.setChave2(irmao.getChave1());
            folha.setTemDuasChaves(true);
            
            if (pai.temDuasChaves()) {
                pai.setChave1(pai.getChave2());
                pai.setChave2(0);
                pai.setTemDuasChaves(false);
                pai.setMeio(pai.getDireito());
                pai.setDireito(null);
            } else {
                pai.setChave1(0);
            }
        } else {
            No23 irmao = pai.getEsquerdo();
            irmao.setChave2(folha.getChave1());
            irmao.setTemDuasChaves(true);
            
            if (pai.temDuasChaves()) {
                pai.setChave1(pai.getChave2());
                pai.setChave2(0);
                pai.setTemDuasChaves(false);
                pai.setMeio(pai.getDireito());
                pai.setDireito(null);
            } else {
                pai.setChave1(0);
            }
        }
        
        return true;
    }
    
    public No23 getRaiz() {
        return raiz;
    }
    
    public void imprimirEmOrdem() {
        if (estaVazia()) {
            System.out.println("Arvore vazia!");
            return;
        }
        System.out.print("Arvore em ordem: ");
        imprimirEmOrdemRecursivo(raiz);
        System.out.println();
    }
    
    private void imprimirEmOrdemRecursivo(No23 no) {
        if (no == null) {
            return;
        }
        
        imprimirEmOrdemRecursivo(no.getEsquerdo());
        System.out.print(no.getChave1() + " ");
        imprimirEmOrdemRecursivo(no.getMeio());
        
        if (no.temDuasChaves()) {
            System.out.print(no.getChave2() + " ");
            imprimirEmOrdemRecursivo(no.getDireito());
        }
    }
    
    public void imprimirArvore() {
        if (estaVazia()) {
            System.out.println("Arvore vazia!");
            return;
        }
        System.out.println("Estrutura da arvore:");
        imprimirArvoreRecursivo(raiz, "", true);
    }
    
    private void imprimirArvoreRecursivo(No23 no, String prefixo, boolean ehUltimo) {
        if (no == null) {
            return;
        }
        
        System.out.println(prefixo + (ehUltimo ? "└── " : "├── ") + no.toString());
        
        String novoPrefixo = prefixo + (ehUltimo ? "    " : "│   ");
        
        if (!no.ehFolha()) {
            if (no.temDuasChaves()) {
                imprimirArvoreRecursivo(no.getEsquerdo(), novoPrefixo, false);
                imprimirArvoreRecursivo(no.getMeio(), novoPrefixo, false);
                imprimirArvoreRecursivo(no.getDireito(), novoPrefixo, true);
            } else {
                imprimirArvoreRecursivo(no.getEsquerdo(), novoPrefixo, false);
                imprimirArvoreRecursivo(no.getMeio(), novoPrefixo, true);
            }
        }
    }
}
