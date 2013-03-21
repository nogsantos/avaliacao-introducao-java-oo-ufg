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

import java.util.List;
import projeto.utils.ProjetoStringUtils;

public class PerfilService {

    private PerfilDAO camadaDados;
    private PerfilImpl dados = new PerfilImpl();

    public PerfilService() {
        this.camadaDados = new PerfilImpl();
    }
    /**
     * Método para setar e cadastrar os dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public boolean incluirPerfil(Integer codigoPerfil, 
            String nome, String descricao){
        
        Perfil perfil = new Perfil();
        perfil.setCodigoPerfil(codigoPerfil);
        perfil.setNome(nome);
        perfil.setDescricao(descricao);
        
        return this.dados.cadastrar(perfil);
    }
    /**
     * Listagem dos perfis
     */
    public void listarPerfis() {
        List<Perfil> listaDePerfis = this.dados.listar();
        StringBuilder listagemPerfil = new StringBuilder();
        int count = 0;
        if (!listaDePerfis.isEmpty()) {
            listagemPerfil.append("***** LISTAGEM DE PERFIS ************************************");
            listagemPerfil.append("\n");
            listagemPerfil.append("----------------------------------------------------------------");
            listagemPerfil.append("\n");
            listagemPerfil.append("|Codigo | Nome                    | Descrição                  |");
            listagemPerfil.append("\n");
            listagemPerfil.append("----------------------------------------------------------------");
            listagemPerfil.append("\n");
            for (Perfil perfil : listaDePerfis){
                listagemPerfil.append("| ").append(ProjetoStringUtils.rpad(Integer.toString(perfil.getCodigoPerfil()), " ", 6)).append("|");
                listagemPerfil.append(ProjetoStringUtils.rpad(perfil.getNome(), " ", 25)).append("|");
                listagemPerfil.append(ProjetoStringUtils.rpad(perfil.getDescricao(), " ", 28));
                listagemPerfil.append("|");
                listagemPerfil.append("\n");
                count ++;
            }
            listagemPerfil.append("----------------------------------------------------------------");
            listagemPerfil.append("\n");
            listagemPerfil.append(ProjetoStringUtils.lpad("Total de "+count+" registros", " ", 63));
            listagemPerfil.append("\n");
            System.out.println(listagemPerfil);
        } else {
            System.out.println("*************** Tabela de Perfis está vazia ***************");
        }
    } 
}