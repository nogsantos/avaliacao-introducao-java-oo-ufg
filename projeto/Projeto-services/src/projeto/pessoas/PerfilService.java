/**
 *
 * Descrição:Classe PerfilService.
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
     * Implementação da listagem dos perfis.
     * @author Fabricio Nogueira
     * @version 1.0.0
     */
    public void listarPerfis() {
        List<Perfil> listaDePerfis = this.dados.listar();
        StringBuilder listagemPerfil = new StringBuilder();
        int count = 0;
        if (!listaDePerfis.isEmpty()) {
            /*
             * Cabeçalho
             */
            listagemPerfil.append(ProjetoStringUtils.rpad("***** "
                    + "LISTAGEM DE PERFIS ", "*",66)).append("\n");
            listagemPerfil.append(ProjetoStringUtils.rpad("-", 
                    "-",66)).append("\n");
            /*
             * Titulos da tabela
             */
            listagemPerfil.append(ProjetoStringUtils.rpad("| Codigo ", " ",8));
            listagemPerfil.append(ProjetoStringUtils.rpad("| Nome ", " ",25));
            listagemPerfil.append(ProjetoStringUtils.rpad("| Descrição ", 
                    " ",31)).append("|").append("\n");
            listagemPerfil.append(ProjetoStringUtils.rpad("-", 
                    "-",66)).append("\n");
            /*
             * Dados da tabela
             */
            for (Perfil perfil : listaDePerfis){
                listagemPerfil.append("| "
                        + "").append(ProjetoStringUtils.rpad(Integer.toString(
                        perfil.getCodigoPerfil()), " ", 7)).append("|");
                listagemPerfil.append(
                        ProjetoStringUtils.rpad(perfil.getNome(), 
                        " ", 24)).append("|");
                listagemPerfil.append(
                        ProjetoStringUtils.rpad(perfil.getDescricao(),
                        " ", 30));
                listagemPerfil.append("|");
                listagemPerfil.append("\n");
                count ++;
            }
            /*
             * Rodapé 
             */
            listagemPerfil.append(ProjetoStringUtils.rpad("-", 
                    "-",66)).append("\n");
            listagemPerfil.append(ProjetoStringUtils.lpad("Total de "+count+""
                    + " registros", " ", 66)).append("\n");
            System.out.println(listagemPerfil);
        } else {
            System.out.println("*************** "
                    + "Tabela de Perfis está vazia ***************");
        }
    } 
}