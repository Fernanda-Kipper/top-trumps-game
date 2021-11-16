package supertrunfodareciclagem;
public class NaoReciclavel extends Carta{

    NaoReciclavel(String string, String string0, String string1, String string2, Cor cor, double decomposicao, int ataque) {
        super.codigo = string;
        super.nome = string0;
        super.descricao = string1;
        super.tipo = string2;
        super.cor = cor;
        super.decomposicao = decomposicao;
        super.ataque = ataque;
    }
    
    @Override
    public boolean ehReciclavel(){
        return false;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
