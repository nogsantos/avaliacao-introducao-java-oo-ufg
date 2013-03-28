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
    private static final int QTD_COL_EXTERIOR = 66;
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
     * @param Date dataNascimento
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
            this.usuarioData.cadastrar(this.usuario, this.pessoa);
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
            this.usuarioData.editar(this.usuario, this.pessoa);
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
            this.usuarioData.excluir(this.usuario, this.pessoa);
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
//        List<Funcao> listaDeFuncoes = null;
//        try {
//            listaDeFuncoes = this.usuarioData.listar();
//        } catch (SQLException ex) {
//            System.err.println(ex.getSQLState());
//        }
//        StringBuilder listagemFuncoes = new StringBuilder();
//        int count = 0;
//        if (listaDeFuncoes.isEmpty()) {
//            System.err.println(
//                ProjetoStringUtils.rpad(
//                    "***** A Tabela de funções está vazia ",
//                    " * ",
//                    QTD_COL_EXTERIOR
//                )
//            );
//        } else {
//            /*
//             * Cabeçalho
//             */
//            listagemFuncoes.append(
//                ProjetoStringUtils.rpad(
//                    "***** LISTAGEM DE FUNÇÕES ",
//                    "*",
//                    QTD_COL_EXTERIOR
//                )
//            ).append("\n");
//            listagemFuncoes.append(
//                ProjetoStringUtils.rpad(
//                    "-",
//                    "-",
//                    QTD_COL_EXTERIOR
//                )
//            ).append("\n");
//            /*
//             * Titulos da tabela
//             */
//            listagemFuncoes.append(
//                ProjetoStringUtils.rpad(
//                    "|Codigo ",
//                    " ",
//                    6
//                )
//            );
//            listagemFuncoes.append(
//                ProjetoStringUtils.rpad(
//                    "|Formulário ",
//                    " ",
//                    18
//                )
//            );
//            listagemFuncoes.append(
//                ProjetoStringUtils.rpad(
//                    "|Nome ",
//                    " ",
//                    17
//                )
//            );
//            listagemFuncoes.append(
//                ProjetoStringUtils.rpad(
//                    "|Descrição ",
//                    " ",
//                   22
//                )
//            ).append("|").append("\n");
//            listagemFuncoes.append(
//                    ProjetoStringUtils.rpad(
//                    "-",
//                    "-",
//                    QTD_COL_EXTERIOR
//                )
//            ).append("\n");
//            /*
//             * Dados da tabela
//             */
//            for (Funcao funcaoList : listaDeFuncoes) {
//                listagemFuncoes.append("| ").append(
//                    ProjetoStringUtils.rpad(
//                        funcaoList.getCodigoFuncao().toString(),
//                        " ",
//                        6
//                    )
//                ).append("|");
//                listagemFuncoes.append(
//                    ProjetoStringUtils.rpad(
//                        funcaoList.getNomeFormulario(),
//                        " ",
//                        17
//                    )
//                ).append("|");
//                listagemFuncoes.append(
//                    ProjetoStringUtils.rpad(
//                        funcaoList.getNome(),
//                        " ",
//                        16
//                    )
//                ).append("|");
//                listagemFuncoes.append(
//                    ProjetoStringUtils.rpad(
//                        funcaoList.getDescricao(),
//                        " ",
//                        21
//                    )
//                );
//                listagemFuncoes.append("|");
//                listagemFuncoes.append("\n");
//                count++;
//            }
//            /*
//             * Rodapé
//             */
//            listagemFuncoes.append(
//                ProjetoStringUtils.rpad(
//                    "-",
//                    "-",
//                    QTD_COL_EXTERIOR
//                )
//            ).append("\n");
//            listagemFuncoes.append(
//                ProjetoStringUtils.lpad(
//                    "Total de " + count + " registros",
//                    " ",
//                    QTD_COL_EXTERIOR
//                )
//            ).append("\n");
//            System.out.println(listagemFuncoes);
//        }
    }

}
