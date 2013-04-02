/**
 *
 * Descrição: Interface FormularioInterface
 *
 * @author Fabricio Nogueira
 *
 * @since 26-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;


public interface FormularioInterface {

    /**
     * Serviço para cadastro dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    String cadastrar();

    /**
     * Serviço para edição dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return boolean
     *
     */
    String editar();

    /**
     * Serviço para exclusão dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    String excluir();

    /**
     * Serviço para listagem dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    void listar();
}
