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

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Antonio Neto e Victor César
 */
public class BaralhoTest {

    private Baralho a;
    private Baralho b;

    @Before
    public void setUp() {
        a = new Baralho();
        b = new Baralho();
    }

    @Test
    public void testBasic() {   

        assertTrue(a.equals(b));

        b.embaralha();

        assertFalse(a.equals(b));

        b.ordenaBaralho();

        assertTrue(a.equals(b));
    }

}
