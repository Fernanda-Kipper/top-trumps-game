package supertrunfodareciclagem;
public enum Cor {
    VERDE("verde"), CINZA("cinza"), LARANJA("laranja"), VERMELHO("vermelho"),
    AZUL("azul"), AMARELO("amarelo"), MARROM("marrom"), ROXO("roxo"),
    BRANCO("branco"), PRETO("preto"), MAIOR("maior"), MENOR("menor"),
    INDEFINIDA("indefinida");
    
    // The string com o nome da cor.
    private final String cor;
    
    Cor(String cor)
    {
        this.cor = cor;
    }
    
    @Override
    public String toString()
    {
        return cor;
    }
    
    public static Cor stringToCor(String strCor) {
        if (strCor.equals(VERDE.toString()))
            return VERDE;
        if (strCor.equals(CINZA.toString()))
            return CINZA;
        if (strCor.equals(LARANJA.toString()))
            return LARANJA;
        if (strCor.equals(VERMELHO.toString()))
            return VERMELHO;
        if (strCor.equals(AZUL.toString()))
            return AZUL;
        if (strCor.equals(AMARELO.toString()))
            return AMARELO;
        if (strCor.equals(MARROM.toString()))
            return MARROM;
        if (strCor.equals(ROXO.toString()))
            return ROXO;
        if (strCor.equals(BRANCO.toString()))
            return BRANCO;
        if (strCor.equals(PRETO.toString()))
            return PRETO;
        if (strCor.equals(MAIOR.toString()))
            return MAIOR;
        if (strCor.equals(MENOR.toString()))
            return MENOR;
        return INDEFINIDA;
    }

}