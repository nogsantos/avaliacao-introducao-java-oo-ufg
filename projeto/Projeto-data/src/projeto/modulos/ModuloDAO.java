/**
 *
 * Descrição: Interface ModuloDAO.
 *
 * @author Fabricio Nogueira
 *
 * @since 21-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;

import java.sql.SQLException;
import java.util.List;


public interface ModuloDAO {

    public boolean cadastrar(Modulo modulo) throws SQLException;
    public boolean editar(Modulo modulo) throws SQLException;
    public boolean excluir(Modulo modulo) throws SQLException;
    public List<Modulo> listar() throws SQLException;
    public Modulo getByCodigo(int codigoModulo) throws SQLException;

}
