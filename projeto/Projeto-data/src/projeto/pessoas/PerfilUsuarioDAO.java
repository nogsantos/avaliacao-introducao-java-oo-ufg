/**
 *
 * Descrição: Interface NewInterface
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


public interface PerfilUsuarioDAO {

    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    String cadastrar(String codigoPessoa, Integer codigoPerfil) throws SQLException;

    /**
     * Método editar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    String editar(PerfilUsuario perfilUsuario) throws SQLException;

    /**
     * Método excluir
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    String excluir(PerfilUsuario perfilUsuario) throws SQLException;

    

}
