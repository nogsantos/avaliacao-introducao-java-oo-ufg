/**
 * Descrição:Classe PerfilService.
 * Classe dedicada a implementação das regras 
 * de negócio para o cadastro de Perfil.
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
    /*
     * Instância da implementação DAO do perfil.
     */
    private PerfilImpl perfilData = new PerfilImpl();
    private Perfil perfil         = new Perfil();
    /**
     * Sobrecarga no Construtor
     * @param null
     */
    public PerfilService(){}
    /**
     * Sobrecarga Construtor 
     * Apenas código como parametro.
     * 
     * @param Integer Codigo perfil
     */
    public PerfilService(Integer codigoPerfil) {
        this.perfil.setCodigoPerfil(codigoPerfil);
    }
    /**
     * Sobrecarga Construtor 
     * Todos os parametros.
     * 
     * @param Integer codigoPerfil
     * @param String nome
     * @param String descricao
     */
    public PerfilService(Integer codigoPerfil, 
            String nome, String descricao) {
        this.perfil.setCodigoPerfil(codigoPerfil);
        this.perfil.setNome(nome);
        this.perfil.setDescricao(descricao);
    }
    /**
     * cadastro dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public boolean cadastrar(){
        try {
            return this.perfilData.cadastrar(this.perfil);
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
    public boolean editar(){
        try {           
            return this.perfilData.editar(this.perfil);
        } catch (SQLException ex) {
            return false;
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
    public boolean excluir(){
        try {
            return this.perfilData.excluir(this.perfil);
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
    public void listar() {
        List<Perfil> listaDePerfis = null;
        try {
            listaDePerfis = this.perfilData.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        StringBuilder listagemPerfil = new StringBuilder();
        int count = 0;
        if (listaDePerfis.isEmpty()) {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "***** A Tabela de Perfis está vazia ",
                    " * ",
                    66
                )
            );
        } else {
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
            for (Perfil perfilList : listaDePerfis){
                listagemPerfil.append("| ").append(
                    ProjetoStringUtils.rpad(
                        perfilList.getCodigoPerfil().toString(), 
                        " ", 
                        7
                    )
                ).append("|");
                listagemPerfil.append(
                    ProjetoStringUtils.rpad(
                        perfilList.getNome(), 
                        " ",
                        24
                    )
                ).append("|");
                listagemPerfil.append(
                    ProjetoStringUtils.rpad(
                        perfilList.getDescricao(),
                        " ", 
                        30
                    )
                );
                listagemPerfil.append("|");
                listagemPerfil.append("\n");
                count ++;
            }
            /*
             * Rodapé 
             */
            listagemPerfil.append(
                ProjetoStringUtils.rpad(
                    "-", 
                    "-",
                    66
                )
            ).append("\n");
            listagemPerfil.append(ProjetoStringUtils.lpad(
                    "Total de "+count+" registros", 
                    " ", 
                    66
                )
            ).append("\n");
            System.out.println(listagemPerfil);
        }
    } 
}