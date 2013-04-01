/**
 *
 * Descrição: Interface Perfil.
 *
 * @author Fabricio Nogueira
 *
 * @since 20-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.pessoas;

import java.sql.SQLException;
import java.util.List;


public interface PerfilDAO {
    /**
     * Cadastro dos dados.
     * Implementação do cadastro de dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return Boolean, sucesso ou fracasso ao cadastrar.
     * @exception Gera uma exceção de sql (SqlException).
     *
     */
    public String cadastrar(Perfil perfil) throws SQLException;
    /**
     * Editação dos dados.
     * Implementa a edição dos dados
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return Boolean, sucesso ou fracasso ao cadastrar.
     * @exception Gera uma exceção de sql (SqlException).
     *
     */
    public String editar(Perfil perfil) throws SQLException;
    /**
     * Exclusão dos dados.
     * Implementa a edição dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return Boolean, sucesso ou fracasso ao cadastrar.
     * @exception Gera uma exceção de sql (SqlException).
     *
     */
    public String excluir(Perfil perfil) throws SQLException;
    /**
     * Listagem dos dados.
     * Listagem dos dados cadastrados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return Boolean, sucesso ou fracasso ao cadastrar.
     * @exception Gera uma exceção de sql (SqlException).
     *
     */
    public List<Perfil> listar() throws SQLException;
    /**
     * Recuperação de um dado pelo seu identificador.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return Boolean, sucesso ou fracasso ao cadastrar.
     * @exception Gera uma exceção de sql (SqlException).
     *
     */
    public Perfil getByCodigo(int codigoPerfil) throws SQLException;

}
