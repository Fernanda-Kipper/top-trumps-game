package supertrunfodareciclagem;

import java.util.ArrayList;

public class Jogador {
    private String nome;
    public ArrayList<Carta> playerDeck;

    public Jogador(String nome) {
        this.nome = nome;
        playerDeck = new ArrayList<>();
    }
    
    public String nome() {
        return this.nome;
    }
    
    public int numeroDeCartas(){
        return this.playerDeck.size();
    }

    public void incluir (Carta carta){
        this.playerDeck.add(carta);
    }
    
    public void excluir () {
        this.playerDeck.remove(playerDeck.get(0));
    }
    
    public Carta getCarta() {
        return this.playerDeck.get(0);
    }
    
    public boolean temCarta() {
        if (this.playerDeck.size() == 0)
            return false;
        else
            return true;
    }
}