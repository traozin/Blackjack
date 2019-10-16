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
public class CartaTest {

    private Carta a;
    private Carta b;
    private Carta c;
    private Carta d;
    private Carta e;

    @Before
    public void setUp() {
        a = new Carta("A", '♠', 1);
        b = new Carta("A", '♠', 1);
        c = new Carta("2", '♥', 2);
        d = new Carta("3", '♣', 3);
        e = new Carta("10", '♦', 4);
    }

    @Test
    public void testBasic() {
        assertEquals("A", a.getFace());
        assertEquals('♠', a.getNipe());
        assertEquals(1, a.getId());

        assertTrue(a.equals(b));
        assertFalse(a.equals(c));
        assertFalse(a.equals(d));
        assertFalse(a.equals(e));

    }

    @Test
    public void testValorReal() {
        assertEquals(a.valorReal(), 1);
        assertEquals(b.valorReal(), 1);
        assertEquals(c.valorReal(), 2);
        assertEquals(d.valorReal(), 3);
        assertEquals(e.valorReal(), 10);
    }

}
