/**
 *
 * Descrição: Interface Perfil
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

    public boolean cadastrar(Perfil perfil) throws SQLException;
    public boolean editar(Perfil perfil) throws SQLException;
    public boolean excluir(Perfil perfil) throws SQLException;
    public List<Perfil> listar() throws SQLException;
    public Perfil getByCodigo(int codigoPerfil) throws SQLException;

}
