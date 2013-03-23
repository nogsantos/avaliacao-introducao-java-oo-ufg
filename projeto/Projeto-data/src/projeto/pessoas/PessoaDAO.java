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
import java.util.List;


public interface PessoaDAO {

    public boolean cadastrar(Pessoa pessoa) throws SQLException;
    public boolean editar(Pessoa pessoa) throws SQLException;
    public boolean excluir(Pessoa pessoa) throws SQLException;
    public List<Pessoa> listar() throws SQLException;
    public Pessoa getByCodigo(int codigoPessoa) throws SQLException;

}
