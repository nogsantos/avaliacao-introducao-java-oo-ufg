/**
 *
 * Descrição:Classe PessoaDAO
 *
 * @author Fabricio Nogueira
 * 
 * @since 19-Mar-2013
 *
 * @version 1.0.0
 * 
 */

package projeto.pessoas;

import java.sql.SQLException;


public interface PessoaDAO {
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
    public Boolean cadastrar(Pessoa pessoa) throws SQLException;
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
    public Boolean editar(Pessoa pessoa) throws SQLException;
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
    public Boolean excluir(Pessoa pessoa) throws SQLException;
}