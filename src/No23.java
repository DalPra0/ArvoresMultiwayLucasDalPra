public class No23 {
    private int chave1;
    private int chave2;
    private boolean temDuasChaves;
    
    private No23 esquerdo;
    private No23 meio;
    private No23 direito;
    
    public No23(int chave) {
        this.chave1 = chave;
        this.chave2 = 0;
        this.temDuasChaves = false;
        this.esquerdo = null;
        this.meio = null;
        this.direito = null;
    }
    
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
    
    public boolean ehFolha() {
        return esquerdo == null && meio == null && direito == null;
    }
    
    public void adicionarChave(int novaChave) {
        if (temDuasChaves) {
            return;
        }
        
        if (novaChave < chave1) {
            chave2 = chave1;
            chave1 = novaChave;
        } else {
            chave2 = novaChave;
        }
        
        temDuasChaves = true;
    }
    
    public String toString() {
        if (temDuasChaves) {
            return "[" + chave1 + ", " + chave2 + "]";
        } else {
            return "[" + chave1 + "]";
        }
    }
}
