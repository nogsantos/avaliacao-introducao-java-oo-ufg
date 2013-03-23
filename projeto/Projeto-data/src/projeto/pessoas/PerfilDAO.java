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
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public boolean cadastrar(Perfil perfil) throws SQLException;
    /**
     * Editação dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     * @todo Verificar se o codigo do perfil informado já existe na base
     * de dados, o método implementado para isso foi confirmaPerfil();
     *
     */
    public boolean editar(Perfil perfil) throws SQLException;
    /**
     * Exclusão dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public boolean excluir(Perfil perfil) throws SQLException;
    /**
     * Listagem dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public List<Perfil> listar() throws SQLException;
    /**
     * Recuperação de um dado pelo identificado.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public Perfil getByCodigo(int codigoPerfil) throws SQLException;

}
