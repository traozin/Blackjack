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
public class Croupier extends Jogador {

    private boolean pegou21;

    public Croupier() {
        pegou21 = false;
    }

    public boolean isPegou21() {
        return pegou21;
    }
    
    /**
     * Inteligência que faz o croupier cavar enquanto sua mão estiver menor que 17
     * @param baralho baralho da partida
     * 
     * @return o croupier só retorna false se o croupier estourar a mão
     */
    public boolean ate17(Baralho baralho) {
        Carta retirada;

        while (super.getMao().valorDaMao() < 17) {
            retirada = baralho.pegarCarta();
            System.out.println("Croupier pegou pegou um(a) " + retirada.toString());
            super.getMao().addCarta(retirada);

            System.out.println("Valor da mão: " + super.getMao().valorDaMao());
        }

        if (super.getMao().valorDaMao() == 21) {
            pegou21 = true;
            return true;
        }
        
        else if(super.getMao().valorDaMao() > 21){
            System.out.println("Croupier estourou a mão!\n");
            super.setEstourou(true);
            return false;
        }        
        
        return true;
    }
    

}
