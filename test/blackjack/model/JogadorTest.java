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
public class JogadorTest {

    private Jogador j1;
    private Jogador j2;

    @Before
    public void setUp() {
        j1 = new Jogador("Traoz", "12345");
        j2 = new Jogador("Neto", "1234");
    }

    @Test
    public void testJogador() {

        assertFalse(j1.equals(j2));

        j1 = j2;

        assertTrue(j1.equals(j2));

    }

}
