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

import java.sql.SQLException;
import java.util.List;
import projeto.utils.ProjetoStringUtils;

public class PerfilService implements PerfilInterface {

    private PerfilDAO camadaDados;
    private PerfilImpl dados = new PerfilImpl();

    public PerfilService() {
        this.camadaDados = new PerfilImpl();
    }
    /**
     * cadastro dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public boolean incluirPerfil(Integer codigoPerfil, 
            String nome, String descricao){
        
        Perfil perfil = new Perfil();
        perfil.setCodigoPerfil(codigoPerfil);
        perfil.setNome(nome);
        perfil.setDescricao(descricao);
        try {
            this.dados.cadastrar(perfil);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    /**
     * Editação dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * 
     * @todo Verificar se o codigo do perfil informado já existe na base
     * de dados, o método implementado para isso foi confirmaPerfil();
     *
     */
    @Override
    public boolean editarPerfil(Integer codigoPerfil, 
            String nome, String descricao){
        
        Perfil perfil = new Perfil();
        perfil.setCodigoPerfil(codigoPerfil);
        perfil.setNome(nome);
        perfil.setDescricao(descricao);
        try {           
            return this.dados.editar(perfil);
        } catch (SQLException ex) {
            return  false;
        }
    }
    /**
     * Exclusão dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * 
     * @todo Verificar se o codigo do perfil informado já existe na base
     * de dados, o método implementado para isso foi confirmaPerfil();
     *
     */
    @Override
    public boolean excluirPerfil(Integer codigoPerfil){
        
        Perfil perfil = new Perfil();
        perfil.setCodigoPerfil(codigoPerfil);
        try {
            return this.dados.excluir(perfil);
        } catch (SQLException ex) {
            return false;
        }
    }
    /**
     * Implementação da listagem dos perfis.
     * @author Fabricio Nogueira
     * @version 1.0.0
     */
    @Override
    public void listarPerfis() {
        List<Perfil> listaDePerfis = null;
        try {
            listaDePerfis = this.dados.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        StringBuilder listagemPerfil = new StringBuilder();
        int count = 0;
        if (!listaDePerfis.isEmpty()) {
            /*
             * Cabeçalho
             */
            listagemPerfil.append(
                ProjetoStringUtils.rpad(
                    "***** LISTAGEM DE PERFIS ", 
                    "*",
                    66
                )
            ).append("\n");
            listagemPerfil.append(
                ProjetoStringUtils.rpad(
                    "-", 
                    "-",
                    66
                )
            ).append("\n");
            /*
             * Titulos da tabela
             */
            listagemPerfil.append(
                ProjetoStringUtils.rpad(
                    "| Codigo ",
                    " ",
                    8
                )
            );
            listagemPerfil.append(
                ProjetoStringUtils.rpad(
                    "| Nome ", 
                    " ",
                    25
                )
            );
            listagemPerfil.append(
                ProjetoStringUtils.rpad(
                    "| Descrição ", 
                    " ",
                    31
                )
            ).append("|").append("\n");
            listagemPerfil.append(
                ProjetoStringUtils.rpad(
                    "-", 
                    "-",
                    66
                )
            ).append("\n");
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
            System.out.println(
                ProjetoStringUtils.rpad(
                    "***** O pefil Tabela de Perfis está vazia ",
                    " * ",
                    66
                )
            );
        }
    } 
}