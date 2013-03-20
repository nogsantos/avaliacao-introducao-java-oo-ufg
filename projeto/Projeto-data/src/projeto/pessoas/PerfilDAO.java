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

import java.util.List;


public interface PerfilDAO {

    public boolean cadastrar(Perfil perfil) throws Exception;
    public boolean editar(Perfil perfil) throws Exception;
    public boolean excluir(Perfil perfil) throws Exception;
    public List<Perfil> listar();
    public Perfil getByCodigo(int codigoPerfil) throws Exception;

}
