/**
 *
 * Descrição:Classe UsuarioService
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 28-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.pessoas;

import java.sql.SQLException;
import java.util.List;
import projeto.utils.ProjetoStringUtils;


public class UsuarioService implements UsuarioInterface {
    /*
     * Instância da implementação DAO do formulário.
     */
    private UsuarioImpl usuarioData = new UsuarioImpl();
    private Usuario usuario         = new Usuario();
    private Pessoa pessoa           = new Pessoa();
    /*
     * Definindo a quantidade de colunas
     */
    private static final int QTD_COL_EXTERIOR = 142;
    private static final int QTD_COL_EXTERIOR_MIN = 66;
    /**
     * Sobrecarga no Construtor
     *
     * @param null
     */
    public UsuarioService() {}
    /**
     * Sobrecarga Construtor
     * Apenas código como parametro.
     *
     * @param String Codigo pessoa
     */
    public UsuarioService(String codigoPessoa) {
        this.pessoa.setCodigoPessoa(codigoPessoa);
    }
    /**
     * Sobrecarga Construtor
     * Todos os parametros.
     *
     * @param String codigoPessoa
     * @param String nome
     * @param String logradouro
     * @param String email
     * @param String telefone
     * @param String login
     * @param String senha
     */
    public UsuarioService(String codigoPessoa, String nome, 
            String logradouro, String email, String telefone, 
            String login, String senha) {
        this.pessoa.setCodigoPessoa(codigoPessoa);
        this.pessoa.setNome(nome);
        this.pessoa.setLogradouro(logradouro);
        this.pessoa.setEmail(email);
        this.pessoa.setTelefone(telefone);
        this.usuario.setLogin(login);
        this.usuario.setSenha(senha);
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
            return this.usuarioData.cadastrar(this.usuario, this.pessoa);
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
            return this.usuarioData.editar(this.usuario, this.pessoa);
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
            return this.usuarioData.excluir(this.usuario, this.pessoa);
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
        List<Usuario> listaDeUsuarios = null;
        try {
            listaDeUsuarios = this.usuarioData.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        StringBuilder listagemUsuarios = new StringBuilder();
        int count = 0;
        if (listaDeUsuarios.isEmpty()) {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "***** A Tabela de Usuários está vazia ",
                    " * ",
                    QTD_COL_EXTERIOR
                )
            );
        } else {
            /*
             * Cabeçalho
             */
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "***** LISTAGEM DE USUÁRIOS ",
                    "*",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            /*
             * Titulos da tabela
             */
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "|Codigo ",
                    " ",
                    13
                )
            );
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "|Nome ",
                    " ",
                    18
                )
            );
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "|Logradouro ",
                    " ",
                    18
                )
            );
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "|Email ",
                    " ",
                    21
                )
            );
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "|Telefone ",
                    " ",
                    15
                )
            );
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "|Login ",
                    " ",
                    15
                )
            );
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "|Senha ",
                    " ",
                   41
                )
            ).append("|").append("\n");
            listagemUsuarios.append(
                    ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            /*
             * Dados da tabela
             */
            for (Usuario usuarioList : listaDeUsuarios) {
                listagemUsuarios.append("|").append(
                    ProjetoStringUtils.rpad(
                        usuarioList.getCodigoPessoa(),
                        " ",
                        12
                    )
                ).append("|");
                listagemUsuarios.append(
                    ProjetoStringUtils.rpad(
                        usuarioList.getNome(),
                        " ",
                        17
                    )
                ).append("|");
                listagemUsuarios.append(
                    ProjetoStringUtils.rpad(
                        usuarioList.getLogradouro(),
                        " ",
                        17
                    )
                ).append("|");
                listagemUsuarios.append(
                    ProjetoStringUtils.rpad(
                        usuarioList.getEmail(),
                        " ",
                        20
                    )
                ).append("|");
                listagemUsuarios.append(
                    ProjetoStringUtils.rpad(
                        usuarioList.getTelefone(),
                        " ",
                        14
                    )
                ).append("|");
                listagemUsuarios.append(
                    ProjetoStringUtils.rpad(
                        usuarioList.getLogin(),
                        " ",
                        14
                    )
                ).append("|");
                listagemUsuarios.append(
                    ProjetoStringUtils.rpad(
                        usuarioList.getSenha(),
                        " ",
                        40
                    )
                );
                listagemUsuarios.append("|");
                listagemUsuarios.append("\n");
                count++;
            }
            /*
             * Rodapé
             */
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            listagemUsuarios.append(
                ProjetoStringUtils.lpad(
                    "Total de " + count + " registros",
                    " ",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            System.out.println(listagemUsuarios);
        }
    }
    /**
     * Serviço para listagem dos dados simples.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 01-Apr-2013
     * @return void
     *
     */
    public void listagemSimples() {
        List<Usuario> listaDeUsuarios = null;
        try {
            listaDeUsuarios = this.usuarioData.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        StringBuilder listagemUsuarios = new StringBuilder();
        if (listaDeUsuarios.isEmpty()) {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "***** A Tabela de Usuários está vazia ",
                    " * ",
                    QTD_COL_EXTERIOR_MIN
                )
            );
        } else {
            /*
             * Cabeçalho
             */
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "***** LISTAGEM DE USUÁRIOS SIMPLES ",
                    "*",
                    QTD_COL_EXTERIOR_MIN
                )
            ).append("\n");
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR_MIN
                )
            ).append("\n");
            /*
             * Titulos da tabela
             */
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "|Codigo ",
                    " ",
                    6
                )
            );
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "|Nome ",
                    " ",
                    57
                )
            ).append("|").append("\n");
            listagemUsuarios.append(
                    ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR_MIN
                )
            ).append("\n");
            /*
             * Dados da tabela
             */
            for (Usuario usuarioList : listaDeUsuarios) {
                listagemUsuarios.append("| ").append(
                    ProjetoStringUtils.rpad(
                        usuarioList.getCodigoPessoa(),
                        " ",
                        6
                    )
                ).append("|");
                listagemUsuarios.append(
                    ProjetoStringUtils.rpad(
                        usuarioList.getNome(),
                        " ",
                        56
                    )
                );
                listagemUsuarios.append("|");
                listagemUsuarios.append("\n");
            }
            /*
             * Rodapé
             */
            listagemUsuarios.append(
                ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR_MIN
                )
            ).append("\n");
            System.out.println(listagemUsuarios);
        }
    }

}
