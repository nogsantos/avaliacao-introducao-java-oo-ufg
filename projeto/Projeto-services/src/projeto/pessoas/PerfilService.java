/**
 *
 * Descrição:Classe PerfilService
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 20-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.pessoas;


public class PerfilService {

    private PerfilDAO camadaDados;

    public PerfilService() {
        camadaDados = new PerfilImpl();
    }
    
    /**
     *
     *
     */
    public boolean incluirPerfil(Integer codigoPerfil, 
            String nome, String descricao) throws Exception{

        Perfil perfil = new Perfil();
        perfil.setCodigoPerfil(codigoPerfil);
        perfil.setNome(nome);
        perfil.setDescricao(descricao);
        
        PerfilImpl perfilbd = new PerfilImpl();

        try {
            perfilbd.cadastrar(perfil);
            System.out.println("Perfil inserido com sucesso!");
            return true;
        } catch (Exception e) {
            throw new Exception("ERRO.PERFIL.SERVICE ## Falha na inserção. \t"+e.getMessage());
        }
    }
}