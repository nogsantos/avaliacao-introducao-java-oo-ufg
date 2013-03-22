/**
 *
 * Descrição:Classe StringUtils.
 * Definições de métodos úteis para manipulação de strings.
 *
 * @author Fabricio Nogueira
 *
 * @since 21-Mar-2013
 *
 * @version 1.0.0
 *
 */
package projeto.utils;

public class ProjetoStringUtils {

    /**
     * Preenche a string definida com um substituidor até 
     * o tamanho definido a esquerda.
     * 
     * @param String valueToPad String que será preenchida
     * @param String filler Valor a preencher
     * @param int size tamanho total da string
     * 
     * @return String 
     */
    public static String lpad(String valueToPad, String filler, int size) {
        while (valueToPad.length() < size) {
            valueToPad = filler + valueToPad;
        }
        return valueToPad;
    }
    /**
     * Preenche a string definida com um substituidor até 
     * o tamanho definido a direita.
     * 
     * @param String valueToPad String que será preenchida
     * @param String filler Valor a preencher
     * @param int size tamanho total da string
     * 
     * @return String 
     */
    public static String rpad(String valueToPad, String filler, int size) {
        while (valueToPad.length() < size) {
            valueToPad = valueToPad + filler;
        }
        return valueToPad;
    }
}
