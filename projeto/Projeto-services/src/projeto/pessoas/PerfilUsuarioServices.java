/**
 *
 * Descrição:Classe PerfilUsuarioServices
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 01-Apr-2013
 *
 * @version 1.0.0
 *
 */

package projeto.pessoas;

import java.sql.SQLException;


public class PerfilUsuarioServices implements PerfilUsuarioInterface {
    /*
     * Instância da implementação DAO do perfil.
     */
    private PerfilUsuarioImpl perfilUsuario = new PerfilUsuarioImpl();
    
    @Override
    public String cadastrar(String codigoPessoa, String codigoPerfil){
        
        String[] vCodigoPerfil = codigoPerfil.split(",");
        String cadastrar = "";
        try {
            for (int i = 0; i < vCodigoPerfil.length; i++) {
                cadastrar = this.perfilUsuario.cadastrar(codigoPessoa,Integer.parseInt(vCodigoPerfil[i]));
            }
        } catch (SQLException ex) {
            cadastrar = ex.getSQLState();
        }
        return cadastrar;
    }
    @Override
    public String editar(){
        return "";
    }
    @Override
    public String excluir(){
        return "";
    }
    

}
