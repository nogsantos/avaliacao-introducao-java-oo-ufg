/**
 *
 * Descrição:Classe FormularioService
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 26-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;

import java.sql.SQLException;
import java.util.List;
import projeto.utils.ProjetoStringUtils;


public class FormularioService implements FormularioInterface {

    /*
     * Instância da implementação DAO do formulário.
     */
    private FormularioImpl formularioData = new FormularioImpl();
    private Formulario formulario         = new Formulario();
    private Modulo modulo                 = new Modulo();
    /*
     * Definindo a quantidade de colunas
     */
    private static final int QTD_COL_EXTERIOR = 117;

    /**
     * Sobrecarga no Construtor
     *
     * @param null
     */
    public FormularioService() {
    }

    /**
     * Sobrecarga Construtor
     * Apenas código como parametro.
     *
     * @param Integer Codigo perfil
     */
    public FormularioService(Integer codigoFormulario) {
        this.formulario.setCodigoFormulario(codigoFormulario);
    }

    /**
     * Sobrecarga Construtor
     * Todos os parametros.
     *
     * @param Integer codigoPerfil
     * @param String nome
     * @param String descricao
     * @param int ordem
     */
    public FormularioService(Integer codigoFormulario, Integer codigoModulo,
            String nome, String nomeMenu, String descricao, int ordem, String flagOculto) {
        
        this.formulario.setCodigoFormulario(codigoFormulario);
        this.modulo.setCodigoModulo(codigoModulo);
        this.formulario.setNome(nome);
        this.formulario.setNomeMenu(nomeMenu);
        this.formulario.setDescricao(descricao);
        this.formulario.setOrdem(ordem);
        this.formulario.setFlagOculto(flagOculto);
    }

    /**
     * Serviço para cadastro dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    @Override
    public String cadastrar() {
        try {
            this.formularioData.cadastrar(this.formulario, this.modulo);
            return "sucesso";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }

    /**
     * Serviço para edição dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return boolean
     *
     */
    @Override
    public String editar() {
        try {
            this.formularioData.editar(this.formulario, this.modulo);
            return "sucesso";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }

    /**
     * Serviço para exclusão dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    @Override
    public String excluir() {
        try {
            this.formularioData.excluir(this.formulario);
            return "sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * Serviço para listagem dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    @Override
    public void listar() {
        List<Formulario> listaDeFormularios = null;
        try {
            listaDeFormularios = this.formularioData.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        StringBuilder listagemFormularios = new StringBuilder();
        int count = 0;
        if (listaDeFormularios.isEmpty()) {
            System.err.println(
                    ProjetoStringUtils.rpad(
                    "***** A Tabela de formulários está vazia ",
                    " * ",
                    QTD_COL_EXTERIOR));
        } else {
            /*
             * Cabeçalho
             */
            listagemFormularios.append(
                    ProjetoStringUtils.rpad(
                    "***** LISTAGEM DE FORMULÁRIOS ",
                    "*",
                    QTD_COL_EXTERIOR)).append("\n");
            listagemFormularios.append(
                    ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR)).append("\n");
            /*
             * Titulos da tabela
             */
            listagemFormularios.append(
                    ProjetoStringUtils.rpad(
                    "|Codigo ",
                    " ",
                    6));
            listagemFormularios.append(
                    ProjetoStringUtils.rpad(
                    "|Módulo ",
                    " ",
                    18));
            listagemFormularios.append(
                    ProjetoStringUtils.rpad(
                    "|Nome ",
                    " ",
                    22));
            listagemFormularios.append(
                    ProjetoStringUtils.rpad(
                    "|Nome Menu ",
                    " ",
                    22));
            listagemFormularios.append(
                    ProjetoStringUtils.rpad(
                    "|Descrição ",
                    " ",
                    28));
            listagemFormularios.append(
                    ProjetoStringUtils.rpad(
                    "|Ordem ",
                    " ",
                    6));
            listagemFormularios.append(
                    ProjetoStringUtils.rpad(
                    "|Visuali. ",
                    " ",
                    11)).append("|").append("\n");
            listagemFormularios.append(
                    ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR)).append("\n");
            /*
             * Dados da tabela
             */
            for (Formulario formularioList : listaDeFormularios) {
                listagemFormularios.append("| ").
                        append(
                        ProjetoStringUtils.rpad(
                        formularioList.getCodigoFormulario().toString(),
                        " ",
                        6)).append("|");
                listagemFormularios.append(
                        ProjetoStringUtils.rpad(
                        formularioList.getNomeModulo(),
                        " ",
                        17)).append("|");
                listagemFormularios.append(
                        ProjetoStringUtils.rpad(
                        formularioList.getNome(),
                        " ",
                        21)).append("|");
                listagemFormularios.append(
                        ProjetoStringUtils.rpad(
                        formularioList.getNomeMenu(),
                        " ",
                        21)).append("|");
                listagemFormularios.append(
                        ProjetoStringUtils.rpad(
                        formularioList.getDescricao(),
                        " ",
                        27)).append("|");
                listagemFormularios.append(
                        ProjetoStringUtils.rpad(
                        formularioList.getOrdem().toString(),
                        " ",
                        6)).append("|");
                listagemFormularios.append(
                        ProjetoStringUtils.rpad(
                        formularioList.getFlagOculto(),
                        " ",
                        10  ));
                listagemFormularios.append("|");
                listagemFormularios.append("\n");
                count++;
            }
            /*
             * Rodapé
             */
            listagemFormularios.append(
                    ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR)).append("\n");
            listagemFormularios.append(
                    ProjetoStringUtils.lpad(
                    "Total de " + count + " registros",
                    " ",
                    QTD_COL_EXTERIOR)).append("\n");
            System.out.println(listagemFormularios);
        }
    }

}
