/**
 *
 * Descrição:Classe ModuloImpl
 *
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


public class ModuloImpl implements ModuloDAO{

    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public boolean cadastrar(Modulo modulo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean editar(Modulo modulo) throws SQLException {
        /**
         * Método editar
         *
         * @author Fabricio Nogueira
         * @version 1.0.0
         *
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean excluir(Modulo modulo) throws SQLException {
        /**
         * Método excluir
         *
         * @author Fabricio Nogueira
         * @version 1.0.0
         *
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Modulo> listar() throws SQLException {
        /**
         * Método listar
         *
         * @author Fabricio Nogueira
         * @version 1.0.0
         *
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Modulo getByCodigo(int codigoModulo) throws SQLException {
        /**
         * Método getByCodigo
         *
         * @author Fabricio Nogueira
         * @version 1.0.0
         *
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
