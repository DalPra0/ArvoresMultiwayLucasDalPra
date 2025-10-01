/**
 * Classe auxiliar para retornar informações sobre divisão de nós
 * Quando um nó é dividido durante a inserção, esta classe armazena
 * as informações necessárias para propagar a divisão para o nó pai
 * 
 * @author Lucas Dal Pra Brascher
 */
public class ResultadoInsercao {
    private boolean houveDivisao;  // Indica se houve divisão
    private int chavePromovida;     // Chave que sobe para o pai
    private No23 novoNo;            // Novo nó criado pela divisão
    
    /**
     * Construtor para quando NÃO houve divisão
     */
    public ResultadoInsercao() {
        this.houveDivisao = false;
        this.chavePromovida = 0;
        this.novoNo = null;
    }
    
    /**
     * Construtor para quando HOUVE divisão
     */
    public ResultadoInsercao(int chavePromovida, No23 novoNo) {
        this.houveDivisao = true;
        this.chavePromovida = chavePromovida;
        this.novoNo = novoNo;
    }
    
    public boolean houveDivisao() {
        return houveDivisao;
    }
    
    public int getChavePromovida() {
        return chavePromovida;
    }
    
    public No23 getNovoNo() {
        return novoNo;
    }
}
