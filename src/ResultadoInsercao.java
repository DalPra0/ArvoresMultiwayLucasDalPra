public class ResultadoInsercao {
    private boolean houveDivisao;
    private int chavePromovida;
    private No23 novoNo;
    
    public ResultadoInsercao() {
        this.houveDivisao = false;
        this.chavePromovida = 0;
        this.novoNo = null;
    }
    
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
