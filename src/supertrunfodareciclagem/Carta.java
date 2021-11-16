package supertrunfodareciclagem;
    public abstract class Carta {
        protected String codigo;
        protected String nome;
        protected String descricao;
        protected String tipo;
        protected Cor cor;
        protected double decomposicao;
        protected int ataque;
        
        public abstract boolean ehReciclavel();

        @Override
        public String toString() {
            return "=======================================================================================================\n\tCarta: " + " codigo: " + codigo + ", nome: " + nome + "\n\tdescricao: " + descricao + " \n=======================================================================================================\n\n\ttipo: " + tipo + ", \tcor: " + cor + ", \tdecomposicao: " + decomposicao + ", \tataque: " + ataque + "\n\n=======================================================================================================\n\n";
        }
        
        public int comparaMegaWinner(Carta carta2){
            if(!"h3".equals(this.codigo)) return -1;
            else if(carta2.codigo.contains("1")) return 0;
            else return 1;
        }

        public int comparaCor(Carta carta2) {
            if(null == this.cor)return 0;
            else switch (this.cor) {
                case AZUL:
                    if(carta2.cor == Cor.MARROM
                            || carta2.cor == Cor.VERMELHO
                            || carta2.cor == Cor.VERDE
                            || carta2.cor == Cor.CINZA
                            || carta2.cor == Cor.AMARELO){
                        return 1;
                    }
                    else if(this.cor == carta2.cor) return -1;
                    else return 0;
                case VERMELHO:
                    if(carta2.cor == Cor.AMARELO
                            || carta2.cor == Cor.VERDE
                            || carta2.cor == Cor.MARROM
                            || carta2.cor == Cor.CINZA
                            || carta2.cor == Cor.PRETO
                            ){
                        return 1;
                    }
                    else if(this.cor == carta2.cor) return -1;
                    else return 0;
                case AMARELO:
                    if(carta2.cor == Cor.VERDE
                            || carta2.cor == Cor.MARROM
                            || carta2.cor == Cor.BRANCO
                            || carta2.cor == Cor.CINZA
                            || carta2.cor == Cor.PRETO
                            ){
                        return 1;
                    }
                    else if(this.cor == carta2.cor) return -1;
                    else return 0;
                case VERDE:
                    if(carta2.cor == Cor.LARANJA
                            || carta2.cor == Cor.MARROM
                            || carta2.cor == Cor.BRANCO
                            || carta2.cor == Cor.CINZA
                            || carta2.cor == Cor.PRETO
                            ){
                        return 1;
                    }
                    else if(this.cor == carta2.cor) return -1;
                    else return 0;
                case CINZA:
                    if(carta2.cor == Cor.AZUL
                            || carta2.cor == Cor.ROXO
                            || carta2.cor == Cor.BRANCO
                            || carta2.cor == Cor.LARANJA
                            || carta2.cor == Cor.PRETO
                            ){
                        return 1;
                    }
                    else if(this.cor == carta2.cor) return -1;
                    else return 0;
                case LARANJA:
                    if(carta2.cor == Cor.ROXO
                            || carta2.cor == Cor.AZUL
                            || carta2.cor == Cor.VERMELHO
                            || carta2.cor == Cor.AMARELO
                            || carta2.cor == Cor.VERDE
                            ){
                        return 1;
                    }
                    else if(this.cor == carta2.cor) return -1;
                    else return 0;
                case MARROM:
                    if(carta2.cor == Cor.ROXO
                            || carta2.cor == Cor.CINZA
                            || carta2.cor == Cor.PRETO
                            || carta2.cor == Cor.BRANCO
                            || carta2.cor == Cor.LARANJA
                            ){
                        return 1;
                    }
                    else if(this.cor == carta2.cor) return -1;
                    else return 0;
                case ROXO:
                    if(carta2.cor == Cor.AZUL
                            || carta2.cor == Cor.MARROM
                            || carta2.cor == Cor.VERMELHO
                            || carta2.cor == Cor.AMARELO
                            || carta2.cor == Cor.VERDE
                            ){
                        return 1;
                    }
                    else if(this.cor == carta2.cor) return -1;
                    else return 0;
                case BRANCO:
                    if(carta2.cor == Cor.LARANJA
                            || carta2.cor == Cor.AZUL
                            || carta2.cor == Cor.VERMELHO
                            || carta2.cor == Cor.AMARELO
                            || carta2.cor == Cor.ROXO
                            ){
                        return 1;
                    }
                    else if(this.cor == carta2.cor) return -1;
                    else return 0;  
                case PRETO:
                    if(carta2.cor == Cor.ROXO
                            || carta2.cor == Cor.AZUL
                            || carta2.cor == Cor.VERMELHO
                            || carta2.cor == Cor.LARANJA
                            || carta2.cor == Cor.ROXO
                            ){
                        return 1;
                    }
                    else if(this.cor == carta2.cor) return -1;
                    else return 0;
                case MAIOR:
                        if(this.cor == carta2.cor) return -1;
                        else return 1;
                case MENOR:
                        if(this.cor == carta2.cor) return -1;
                        else return 0;                          
                default:
                    return 0;
            }
        }

        public int comparaDecomposicao(Carta carta2) {
                if(comparaMegaWinner(carta2) == -1){
                    if (this.decomposicao < carta2.decomposicao)
                        return 1;
                    else if (this.decomposicao > carta2.decomposicao)
                        return 0;
                    else
                        return -1;
                }
                else return comparaMegaWinner(carta2);
        }

        public int comparaReciclavel(Carta carta2) {
                if (this.ehReciclavel() && !carta2.ehReciclavel())
                    return 1;
                else if (!this.ehReciclavel() && carta2.ehReciclavel())
                    return 0;
                else
                    return -1;
        }
        
        public int comparaAtaque(Carta carta2) {
            if(comparaMegaWinner(carta2) == -1){
                if (this.ataque > carta2.ataque)
                    return 1;
                else if (this.ataque < carta2.ataque)
                    return 0;
                else
                    return -1;
            }
            else return comparaMegaWinner(carta2);
        }
    }
