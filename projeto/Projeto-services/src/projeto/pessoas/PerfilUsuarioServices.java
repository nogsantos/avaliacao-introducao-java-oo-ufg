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


public class PerfilUsuarioServices implements PerfilUsuarioInterface {
    /*
     * Instância da implementação DAO do perfil.
     */
    private Perfil perfil = new Perfil();
    private Pessoa pessoa = new Pessoa();
    /*
     * 
     */
    public PerfilUsuarioServices() {}   
    /*
     * 
     */
    public PerfilUsuarioServices(String codigoPessoa, Integer codigoPerfil) {
        this.pessoa.setCodigoPessoa(codigoPessoa);
        this.perfil.setCodigoPerfil(codigoPerfil);
    }
    
    @Override
    public String cadastrar(){
        return "";
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
