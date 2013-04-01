/**
 *
 * Descrição:Interface FormularioDAO
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 26-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;

import java.sql.SQLException;
import java.util.List;


public interface FormularioDAO {

    /**
     * Cadastro dos dados.
     * Implementação do cadastro de dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 26-Mar-2013
     * @return Boolean, sucesso ou fracasso ao cadastrar.
     * @exception Gera uma exceção de sql (SqlException).
     *
     */
    public String cadastrar(Formulario formulario, Modulo modulo) throws SQLException;

    /**
     * Editação dos dados.
     * Implementa a edição dos dados
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 26-Mar-2013
     * @return Boolean, sucesso ou fracasso na edição.
     * @exception Gera uma exceção de sql (SqlException).
     *
     */
    public String editar(Formulario formulario, Modulo modulo) throws SQLException;

    /**
     * Exclusão dos dados.
     * Implementa a edição dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 26-Mar-2013
     * @return Boolean, sucesso ou fracasso na exclusão dos dados.
     * @exception Gera uma exceção de sql (SqlException).
     *
     */
    public String excluir(Formulario formulario) throws SQLException;

    /**
     * Listagem dos dados.
     * Listagem dos dados cadastrados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 26-Mar-2013
     * @return Objeto do tipo Lista.
     * @exception Gera uma exceção de sql (SqlException).
     *
     */
    public List<Formulario> listar() throws SQLException;
}
