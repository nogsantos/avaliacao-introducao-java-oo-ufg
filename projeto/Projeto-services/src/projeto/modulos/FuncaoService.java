/**
 *
 * Descrição:Classe FuncaoService
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 27-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;

import java.sql.SQLException;
import java.util.List;
import projeto.utils.ProjetoStringUtils;


public class FuncaoService implements FuncaoInterface {
    /*
     * Instância da implementação DAO do formulário.
     */
    private FuncaoImpl funcaoData = new FuncaoImpl();
    private Funcao funcao         = new Funcao();
    private Formulario formulario = new Formulario();
    /*
     * Definindo a quantidade de colunas
     */
    private static final int QTD_COL_EXTERIOR = 66;
    /**
     * Sobrecarga no Construtor
     *
     * @param null
     */
    public FuncaoService() {}
    /**
     * Sobrecarga Construtor
     * Apenas código como parametro.
     *
     * @param Integer Codigo perfil
     */
    public FuncaoService(Integer codigoFuncao) {
        this.funcao.setCodigoFuncao(codigoFuncao);
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
    public FuncaoService(Integer codigoFuncao, Integer codigoFormulario,
            String nome, String descricao) {
        
        this.funcao.setCodigoFuncao(codigoFuncao);
        this.formulario.setCodigoFormulario(codigoFormulario);
        this.funcao.setNome(nome);
        this.funcao.setDescricao(descricao);
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
            this.funcaoData.cadastrar(this.funcao, this.formulario);
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
            this.funcaoData.editar(this.funcao, this.formulario);
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
            this.funcaoData.excluir(this.funcao);
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
        List<Funcao> listaDeFuncoes = null;
        try {
            listaDeFuncoes = this.funcaoData.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        StringBuilder listagemFuncoes = new StringBuilder();
        int count = 0;
        if (listaDeFuncoes.isEmpty()) {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "***** A Tabela de funções está vazia ",
                    " * ",
                    QTD_COL_EXTERIOR
                )
            );
        } else {
            /*
             * Cabeçalho
             */
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "***** LISTAGEM DE FUNÇÕES ",
                    "*",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            /*
             * Titulos da tabela
             */
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "|Codigo ",
                    " ",
                    6
                )
            );
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "|Formulário ",
                    " ",
                    18
                )
            );
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "|Nome ",
                    " ",
                    17
                )
            );
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "|Descrição ",
                    " ",
                   22
                )
            ).append("|").append("\n");
            listagemFuncoes.append(
                    ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            /*
             * Dados da tabela
             */
            for (Funcao funcaoList : listaDeFuncoes) {
                listagemFuncoes.append("| ").append(
                    ProjetoStringUtils.rpad(
                        funcaoList.getCodigoFuncao().toString(),
                        " ",
                        6
                    )
                ).append("|");
                listagemFuncoes.append(
                    ProjetoStringUtils.rpad(
                        funcaoList.getNomeFormulario(),
                        " ",
                        17
                    )
                ).append("|");
                listagemFuncoes.append(
                    ProjetoStringUtils.rpad(
                        funcaoList.getNome(),
                        " ",
                        16
                    )
                ).append("|");
                listagemFuncoes.append(
                    ProjetoStringUtils.rpad(
                        funcaoList.getDescricao(),
                        " ",
                        21
                    )
                );
                listagemFuncoes.append("|");
                listagemFuncoes.append("\n");
                count++;
            }
            /*
             * Rodapé
             */
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            listagemFuncoes.append(
                ProjetoStringUtils.lpad(
                    "Total de " + count + " registros",
                    " ",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            System.out.println(listagemFuncoes);
        }
    }
    /**
     * Listagem simples dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    public String listagemSimples() {
        List<Funcao> listaDeFuncoes = null;
        try {
            listaDeFuncoes = this.funcaoData.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        StringBuilder listagemFuncoes = new StringBuilder();
        if (listaDeFuncoes.isEmpty()) {
            return ProjetoStringUtils.rpad(
                    "***** A Tabela de funções está vazia ",
                    " * ",
                    QTD_COL_EXTERIOR
                );
        } else {
            /*
             * Cabeçalho
             */
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "***** FUNÇÕES ",
                    "*",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            /*
             * Titulos da tabela
             */
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "|Codigo ",
                    " ",
                    6
                )
            );
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "|Nome ",
                    " ",
                    17
                )
            ).append("|").append("\n");
            listagemFuncoes.append(
                    ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            /*
             * Dados da tabela
             */
            for (Funcao funcaoList : listaDeFuncoes) {
                listagemFuncoes.append("| ").append(
                    ProjetoStringUtils.rpad(
                        funcaoList.getCodigoFuncao().toString(),
                        " ",
                        6
                    )
                ).append("|");
                listagemFuncoes.append(
                    ProjetoStringUtils.rpad(
                        funcaoList.getNome(),
                        " ",
                        16
                    )
                );
                listagemFuncoes.append("|");
                listagemFuncoes.append("\n");
            }
            /*
             * Rodapé
             */
            listagemFuncoes.append(
                ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            return listagemFuncoes.toString();
        }
    }
}
