package supertrunfodareciclagem;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
    public class SuperTrunfoDaReciclagem { 
        public static Jogador[] defineRodada(Jogador[] players, Jogador Vencedor, Jogador Perdedor, Carta[] cartasNaMesa, int contCartas){
            //remove as cartas da rodada do topo do baralho de ambos
            Vencedor.excluir();
            Perdedor.excluir();
            
            //atribui ao vencedor todas as cartas que estavam na mesa
            for(int i = 0; i < contCartas; i++){
                Vencedor.incluir(cartasNaMesa[i]);
            }
            
            //retorna jogadores para a atribuição e atualização das cartas
            players[0] = Vencedor;
            players[1] = Perdedor;
            return players;
        }
        
        public static void main(String[] args) throws FileNotFoundException {
            int cont, rodadas=0;
            String nome;
            Scanner ler = new Scanner(System.in);
            
            // inicio do jogo
            System.out.println("\t\tBem vindo ao grande trunfo da reciclagem!!\n\n");
            
            System.out.println("Por favor, insira o nome do 1º jogador: ");
            nome = ler.nextLine();
            Jogador player1 = new Jogador(nome);
            System.out.println("Por favor, insira o nome do 2º jogador: ");
            nome = ler.nextLine();
            Jogador player2 = new Jogador(nome);
            
            System.out.println("Como você deseja jogar?\n\t[0]Simulção\n\t[1]Manual");
            int manual = ler.nextInt();
            
            Baralho gameDeck = new Baralho();
            gameDeck.embaralhaBaralho();
            
            //distribui aleatoriamente todas as cartas para os jogadores
            cont = 0;
            while (gameDeck.qtdCartas() != 0) {
                if (cont%2 == 0) {
                    Carta carta = gameDeck.comprarCarta();
                    player1.incluir(carta);
                }
                else {
                    Carta carta = gameDeck.comprarCarta();
                    player2.incluir(carta);
                }
                cont++;
            }
            
            // escolhe aleatoriamente o jogador que irá iniciar
            Random random = new Random();
            int numero = random.nextInt(9);
            Jogador vencedorDaRodada;
            Jogador perdedorDaRodada;
            
            if (numero%2 == 0){
                vencedorDaRodada = player1;
                perdedorDaRodada = player2;
            }
            else{
                vencedorDaRodada = player2;
                perdedorDaRodada = player1;            
            }
            
            // declara cartas na mesa
            // máximo 32 cartas pois é o tamanho do baralho
            int contCartas = 0;
            Carta[] cartasNaMesa = new Carta[32];
            
            // enquanto o jogo não acabou
            int fimDeJogo = 0;
            while (fimDeJogo < 1) {
                
                System.out.println("\n\n\t\tO jogador: " + vencedorDaRodada.nome() + " tem a vez, sua carta é: \n");
                System.out.println(vencedorDaRodada.getCarta().toString());
                
                int escolha;
                if(manual == 1){
                    System.out.println("Qual atributo o jogador deseja escolher: \n\t[1]Cor\n\t[2]Decomposição\n\t[3]Reciclagem\n\t[4]Ataque\n\t[5]Sair");
                    escolha = ler.nextInt();
                } else {
                    escolha = random.nextInt(5);
                }

                int retorno = -1;
                rodadas++;
               
                
                // pega as cartas de cada jogador e coloca na mesa
                Carta cartaVencedor = vencedorDaRodada.getCarta();
                Carta cartaPerdedor = perdedorDaRodada.getCarta();
                cartasNaMesa[contCartas] = cartaVencedor;
                contCartas++;
                cartasNaMesa[contCartas] = cartaPerdedor;
                contCartas++;
                
                // realiza a comparação de acordo com o atributo escolhido pelo jogador
                switch (escolha) {
                    case 1:
                        retorno = cartaVencedor.comparaCor(cartaPerdedor);
                        break;
                    case 2:
                        retorno = cartaVencedor.comparaDecomposicao(cartaPerdedor);
                        break;
                    case 3: 
                        retorno = cartaVencedor.comparaReciclavel(cartaPerdedor);   
                        break;
                    case 4: 
                        retorno = cartaVencedor.comparaAtaque(cartaPerdedor);    
                        break;
                    case 5:
                        retorno = -1;
                        fimDeJogo = 1;
                    default:
                        System.out.println("Você precisa escolher entre uma das opções válidas!!\n");
                        break;
                }
                
                // mostra a carta do outro jogador apenas depois de ter realizado a comparação
                System.out.println("A carta do jogador " + perdedorDaRodada.nome() + " era: \n");
                System.out.println(perdedorDaRodada.getCarta().toString());
                
                //realiza a atribuição do vencedor e perdedor de acordo com o retorno da comparação
                Jogador[] players = new Jogador[2];
                if(retorno == 1){
                    // vencedor da rodada passada venceu novamente
                    System.out.println(vencedorDaRodada.nome() + " VENCEU NOVAMENTE!"); 
                    players = defineRodada(players, vencedorDaRodada, perdedorDaRodada, cartasNaMesa, contCartas);
                    if(vencedorDaRodada.nome() == player1.nome()){
                        // Jogador 1 era o "vencedorDaRodada", continua sendo vencedor
                        player1 = players[0];
                        player2 = players[1];
                    } else{
                         // Jogador 2 era o "vencedorDaRodada", continua sendo vencedor
                        player1 = players[1];
                        player2 = players[0];
                    }
                    
                    //zera contagem de cartas e cartas na mesa
                    contCartas = 0;
                    Arrays.fill(cartasNaMesa, null);
                }
                else if(retorno == 0){
                    // perdedor da rodada passada venceu
                    System.out.println(perdedorDaRodada.nome() + " VENCEU ESSA RODADA!\n"); 
                    players = defineRodada(players, perdedorDaRodada, vencedorDaRodada, cartasNaMesa, contCartas);
 
                    if(perdedorDaRodada.nome() == player2.nome()){ 
                        // Jogador 2 era o "perdedorDaRodada", agora vencedor
                        player1 = players[1];
                        player2 = players[0];
                        
                        // inverte vencedor e perdedor
                        vencedorDaRodada = player2;
                        perdedorDaRodada = player1;
                    } else{
                        // Jogador 1 era o "perdedorDaRodada", agora vencedor
                        player1 = players[0];
                        player2 = players[1];
                        
                        // inverte vencedor e perdedor
                        vencedorDaRodada = player1;
                        perdedorDaRodada = player2;
                    }

                    //zera contagem de cartas e cartas na mesa
                    contCartas = 0;
                    Arrays.fill(cartasNaMesa, null);
                } else {
                    // caso tenha ocorrido empate
                    //retira a carta de ambos, que já estão na mesa e continua o jogo
                    player1.excluir();
                    player2.excluir();
                    System.out.println("EMPATE\n");
                }
                
                // mostra o número de cartas de cada jogador após a rodada
                System.out.println(player1.nome() + " seu número de cartas: " + player1.numeroDeCartas());
                System.out.println(player2.nome() + " seu número de cartas: " + player2.numeroDeCartas());
                
                // finaliza o jogo quando um dos jogadores não possui mais cartas
                if (player1.numeroDeCartas() == 0 || player2.numeroDeCartas() == 0){
                    fimDeJogo = 1;
                    if (player1.numeroDeCartas() == 32)
                        vencedorDaRodada = player1;
                    else if (player2.numeroDeCartas() == 32)
                        vencedorDaRodada = player2;
                }
            }
            
            //anuncio do vencedor
            System.out.println("O vencedor foi: " + vencedorDaRodada.nome() + ". Após " + rodadas + " rodadas.");
        }
            
    }