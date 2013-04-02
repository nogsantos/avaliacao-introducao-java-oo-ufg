/**
 *
 * Descrição: Interface UsuarioDAO
 *
 * @author Fabricio Nogueira
 *
 * @since 01-Apr-2013
 *
 * @version 1.0.0
 *
 */

package projeto.pessoas;

import java.sql.SQLException;
import java.util.List;


public interface UsuarioDAO {

    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    String cadastrar(Usuario usuario, Pessoa pessoa) throws SQLException;

    /**
     * Método editar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    String editar(Usuario usuario, Pessoa pessoa) throws SQLException;

    /**
     * Método excluir
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    String excluir(Usuario usuario, Pessoa pessoa) throws SQLException;

    /**
     * Método listar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    List<Usuario> listar() throws SQLException;

    

}
