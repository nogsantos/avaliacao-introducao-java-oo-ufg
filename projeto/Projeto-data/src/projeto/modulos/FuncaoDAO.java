/**
 *
 * Descrição: Interface FuncaoDAO
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


public interface FuncaoDAO {

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
    public boolean cadastrar(Funcao funcao, Formulario formulario) throws SQLException;

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
    public boolean editar(Funcao funcao,Formulario formulario) throws SQLException;

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
    public boolean excluir(Funcao funcao) throws SQLException;

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
    public List<Funcao> listar() throws SQLException;

    /**
     * Recuperação de um dado pelo seu identificador.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 26-Mar-2013
     * @return Objeto
     * @exception Gera uma exceção de sql (SqlException)
     *
     */
    public Funcao getByCodigo(int codigoFuncao) throws SQLException;    

}
