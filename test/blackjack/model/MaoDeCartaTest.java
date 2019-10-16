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

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio Neto e Victor César
 */
public class MaoDeCartaTest {

    MaoDeCarta m1;
    MaoDeCarta m2;
    MaoDeCarta m3;

    @Before
    public void setUp() {
        m1 = new MaoDeCarta();
        m2 = new MaoDeCarta();
        m3 = new MaoDeCarta();
    }

    @Test
    public void testValorDaMao() {
        Carta rei = new Carta("K", '♦', 0);
        Carta as = new Carta("A", '♠', 2);
        Carta dois = new Carta("2", '♣', 4);
        Carta tres = new Carta("3", '♦', 5);
        Carta quatro = new Carta("4", '♠', 6);

        m1.addCarta(rei);
        m1.addCarta(as);
        m1.addCarta(dois);
        m1.addCarta(tres);
        m1.addCarta(quatro);
        m1.addCarta(tres);

        assertEquals(m1.valorDaMao(), 23);

        m2.addCarta(rei);
        m2.addCarta(as);

        assertEquals(m2.valorDaMao(), 21);

        m3.addCarta(as);
        m3.addCarta(as);
        m3.addCarta(dois);

        assertEquals(m3.valorDaMao(), 14);

    }

}
