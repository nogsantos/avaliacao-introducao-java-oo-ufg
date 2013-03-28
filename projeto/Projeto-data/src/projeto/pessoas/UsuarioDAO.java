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

public interface UsuarioDAO {
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
    public String cadastrar(Usuario usuario, Pessoa pessoa) throws SQLException;
    /**
     * Editação dos dados.
     * Implementa a edição dos dados
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return Boolean, sucesso ou fracasso na edição. 
     * @exception Gera uma exceção de sql (SqlException).
     * 
     */
    public String editar(Usuario usuario, Pessoa pessoa) throws SQLException;
    /**
     * Exclusão dos dados.
     * Implementa a edição dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013 
     * @return Boolean, sucesso ou fracasso na exclusão dos dados. 
     * @exception Gera uma exceção de sql (SqlException).
     *
     */
    public String excluir(Usuario usuario, Pessoa pessoa) throws SQLException;
    /**
     * Listagem dos dados.
     * Listagem dos dados cadastrados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013 
     * @return Objeto do tipo Lista. 
     * @exception Gera uma exceção de sql (SqlException).
     * 
     */
    public List<Usuario> listar() throws SQLException;
    /**
     * Recuperação de um dado pelo seu identificador.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013 
     * @return Objeto
     * @exception Gera uma exceção de sql (SqlException)
     *
     */
    public Usuario getByCodigo(String codigoPessoa) throws SQLException;
}
