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

import java.util.Objects;

/**
 *
 * @author Antonio Neto e Victor César
 */
public class Carta {

    private String face;
    private char nipe;
    private int id;

    public Carta(String face, char nipe, int id) {
        this.face = face;
        this.nipe = nipe;
        this.id = id;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public char getNipe() {
        return nipe;
    }

    public void setNipe(char nipe) {
        this.nipe = nipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Compara a face da carta e retorna o valor da mesma
     * 
     * @return valor numérico da carta
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    public int valorReal() {
        switch (face) {
            case "Q":
            case "K":
            case "J":
                return 10;
            case "A":
                return 1;
            default:
                return Integer.parseInt(face);
        }
    }

    /**
     * Retorna o valor nominal da carta
     * 
     * @return nome da carta
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    @Override
    public String toString() {
        switch (face) {
            case "K":
                return "Rei de " + getNipe();
            case "Q":
                return "Dama de " + getNipe();
            case "J":
                return "Valete de " + getNipe();
            case "A":
                return "Ás de " + getNipe();
            default:
                return getFace() + " de " + getNipe();
        }
    }

    /**
     * Compara duas cartas
     * 
     * @param obj carta que vai ser comparada
     * @return true se a carta comparada for igual, false se for diferente
     * 
     * @author Antonio Neto
     * @author Victor César
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.nipe != other.nipe) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.face, other.face)) {
            return false;
        }
        return true;
    }

}
