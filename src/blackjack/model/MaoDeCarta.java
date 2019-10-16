/*******************************************************************************
Autores: Antonio Carlos Mendes Neto e Victor César da Rocha Bastos
Componente Curricular: MI - Programação
Concluido em: 28/05/2018
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/

package blackjack.model;

/**
 *
 * @author Antonio Neto e Victor César
 */
public class MaoDeCarta {

    private Carta[] monte;
    private int contCartas;

    public MaoDeCarta() {
        this.monte = new Carta[11];
        this.contCartas = 0;
    }

    public int getContCartas() {
        return contCartas;
    }

    public Carta[] getMonte() {
        return monte;
    }

    /**
     * Calcula o valor da mão do jogador, e atribui as pontuações à mais pela diferença do Ás
     * 
     * @return valor da mão adaptado pelo ás dinâmico
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public int valorDaMao() {
        int valor = 0;
        int qtdAs = 0;

        for (int i = 0; i < contCartas; i++) {
            valor = valor + monte[i].valorReal();
            if (monte[i].getFace().equals("A")) {
                qtdAs++;
            }
        }

        if (qtdAs != 0 && valor < 12) {
            valor = valor + 10;
        }

        return valor;
    }

    /**
     * Adiciona uma carta na mão, se possível
     * 
     * @param carta carta à ser adicionada
     * @return só retorna false se a mão do jogador estiver cheia
     */
    public boolean addCarta(Carta carta) {
        if (contCartas < monte.length) {
            monte[contCartas++] = carta;
            return true;
        }
        return false;
    }

}
