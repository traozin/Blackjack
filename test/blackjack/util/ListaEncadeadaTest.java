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

package blackjack.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Antonio Neto e Victor César
 */

public class ListaEncadeadaTest {

    ListaEncadeada lista;
    Object data1, data2, data3;

    @Before
    public void setUp() throws Exception {
        lista = new ListaEncadeada();
        data1 = new String("Data1");
        data2 = new String("Data2");
        data3 = new String("Data3");
    }

    @Test
    public void testEstaVazia() {
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testTamanho() {
        assertEquals(0, lista.tamanho());

        lista.insereInicio(data1);
        assertEquals(1, lista.tamanho());

        lista.insereInicio(data2);
        lista.insereInicio(data3);
        assertEquals(3, lista.tamanho());

        lista.removeUltimo();
        assertEquals(2, lista.tamanho());

        lista.removeInicio();
        lista.removeUltimo();
        assertEquals(0, lista.tamanho());
    }

    @Test
    public void testAdicionaInicioRemoveInicio() {
        lista.insereInicio(data1);
        lista.insereInicio(data2);
        lista.insereInicio(data3);
        assertFalse(lista.estaVazia());

        assertSame(data3, lista.removeInicio());
        assertFalse(lista.estaVazia());

        assertSame(data2, lista.removeInicio());
        assertFalse(lista.estaVazia());

        assertSame(data1, lista.removeInicio());
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testAdicionaInicioRemoveFinal() {
        lista.insereInicio(data1);
        lista.insereInicio(data2);
        lista.insereInicio(data3);
        assertFalse(lista.estaVazia());

        assertSame(data1, lista.removeUltimo());
        assertFalse(lista.estaVazia());

        assertSame(data2, lista.removeUltimo());
        assertFalse(lista.estaVazia());

        assertSame(data3, lista.removeUltimo());
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testAdicionaFinalRemoveInicio() {
        lista.insereFinal(data1);
        lista.insereFinal(data2);
        lista.insereFinal(data3);
        assertFalse(lista.estaVazia());

        assertSame(data1, lista.removeInicio());
        assertFalse(lista.estaVazia());

        assertSame(data2, lista.removeInicio());
        assertFalse(lista.estaVazia());

        assertSame(data3, lista.removeInicio());
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testAdicionaFinalRemoveFinal() {
        lista.insereFinal(data1);
        lista.insereFinal(data2);
        lista.insereFinal(data3);
        assertFalse(lista.estaVazia());

        assertSame(data3, lista.removeUltimo());
        assertFalse(lista.estaVazia());

        assertSame(data2, lista.removeUltimo());
        assertFalse(lista.estaVazia());

        assertSame(data1, lista.removeUltimo());
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testRecupera() {
        lista.insereFinal(data1);
        lista.insereFinal(data2);
        lista.insereInicio(data3);
        assertEquals(data3, lista.recupera(0));
        assertEquals(data1, lista.recupera(1));
        assertEquals(data2, lista.recupera(2));

        lista.removeUltimo();
        assertEquals(data3, lista.recupera(0));
        assertEquals(data1, lista.recupera(1));

        lista.removeInicio();
        assertEquals(data1, lista.recupera(0));
    }

    @Test
    public void testIterador() {
        Iterador it = lista.iterador();
        assertFalse(it.temProximo());

        lista.insereFinal(data1);
        lista.insereFinal(data2);
        lista.insereInicio(data3);
        it = lista.iterador();
        assertTrue(it.temProximo());
        assertSame(data3, it.proximo());
        assertTrue(it.temProximo());
        assertSame(data1, it.proximo());
        assertTrue(it.temProximo());
        assertSame(data2, it.proximo());
        assertFalse(it.temProximo());
    }

}
