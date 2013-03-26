/**
 *
 * Descrição: Interface ModuloInterface
 *
 * @author Fabricio Nogueira
 *
 * @since 25-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;


public interface ModuloInterface {

    /**
     * Serviço para cadastro dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    boolean cadastrar();
    /**
     * Serviço para edição dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return boolean
     *
     */
    boolean editar();
    /**
     * Serviço para exclusão dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    boolean excluir();
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