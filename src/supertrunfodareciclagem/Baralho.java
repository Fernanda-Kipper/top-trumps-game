package supertrunfodareciclagem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Baralho {
    private ArrayList<Carta> deck;
    
    public Baralho() throws FileNotFoundException {
        deck = new ArrayList<>();
        this.lerDoArquivo("Super Trunfo da Reciclagem.csv");
    }
    
    public int qtdCartas() {
        return this.deck.size();
    }
    
    public Carta selecionaCarta(int index) {
        return deck.get(index);
    }
    
    private void lerDoArquivo(String info) throws FileNotFoundException {
       File file = new File(info);
       Scanner entrada = null;
       Carta carta = null;
       int contador = 0;
       Cor cor;
       double decomposicao;
       int ataque;
       
       try{
           entrada = new Scanner(file);
           while(entrada.hasNextLine()){
               String[] linha = entrada.nextLine().split(";");
               
               cor = Cor.stringToCor(linha[4]);
               decomposicao = Double.parseDouble(linha[5]);
               ataque = Integer.parseInt(linha[6]);
               
               if(linha[7].equals("sim")) {
                   carta = new Reciclavel (linha[0], linha[1], linha[2], linha[3], cor, decomposicao, ataque);
                   deck.add(carta);
                   contador++;
               }
               else {
                   carta = new NaoReciclavel (linha[0], linha[1], linha[2], linha[3], cor, decomposicao, ataque);
                   deck.add(carta);
                   contador++;
               }
           }
           entrada.close();
       }
       catch(IOException e) {
           System.out.println(e.getMessage());
       }
    }
    
    public void embaralhaBaralho() {
        Collections.shuffle(this.deck);
    }
    
    public Carta comprarCarta(){
        Carta carta = deck.get(0);
        deck.remove(deck.get(0));
        return carta;
    }
}
