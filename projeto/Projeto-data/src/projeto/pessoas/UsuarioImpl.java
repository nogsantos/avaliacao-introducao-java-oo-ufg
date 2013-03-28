/**
 *
 * Descrição:Classe UsuarioImpl
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 25-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.pessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import projeto.conexao.Conexao;
import projeto.utils.ProjetoStringUtils;


public class UsuarioImpl implements UsuarioDAO{
   /*
    * Instancição dos atributos da classe
    */
    private Connection connection = new Conexao().getConnection();
    private StringBuilder sSql = new StringBuilder();
    private StringBuilder mensagem = new StringBuilder();
    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet resultSet;
   /*
    * Construtor
    */
    public UsuarioImpl() {
        this.preStatement = null;
        this.statement    = null;
        this.resultSet    = null;
    }
    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public String cadastrar(Usuario usuario, Pessoa pessoa) throws SQLException {
        this.sSql.append(" INSERT INTO usuario ( ");
        this.sSql.append(" codigo_pessoa, ");
        this.sSql.append(" login, ");
        this.sSql.append(" senha ");
        this.sSql.append(" ) VALUES ( ");
        this.sSql.append(" ?,?,? )");
        try {
            PessoaImpl pessoaImpl = new PessoaImpl();
            if(pessoaImpl.cadastrar(pessoa)){
                this.preStatement = this.connection.prepareStatement(this.sSql.toString());
                this.preStatement.setString(1, pessoa.getCodigoPessoa());
                this.preStatement.setString(2, usuario.getLogin());
                this.preStatement.setString(3, ProjetoStringUtils.encryptSenha(usuario.getSenha()));
                this.connection.setAutoCommit(true);
                this.preStatement.executeUpdate();
            }else{
                this.mensagem.append("##ERRO.USUARIO.IMPLEMENTACAO.CADASTRAR::");
                this.mensagem.append("Erro na inserção dos dados pessoa.");
                throw new SQLException(this.mensagem.toString());
            }
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.USUARIO.IMPLEMENTACAO.CADASTRAR::");
            this.mensagem.append("Erro na inserção dos dados.");
            this.mensagem.append(e.getMessage());
            return this.mensagem.toString();
        }
    }

    @Override
    public String editar(Usuario usuario, Pessoa pessoa) throws SQLException {
        /**
         * Método editar
         *
         * @author Fabricio Nogueira
         * @version 1.0.0
         *
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String excluir(Usuario usuario, Pessoa pessoa) throws SQLException {
        /**
         * Método excluir
         *
         * @author Fabricio Nogueira
         * @version 1.0.0
         *
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> listar() throws SQLException {
        /**
         * Método listar
         *
         * @author Fabricio Nogueira
         * @version 1.0.0
         *
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario getByCodigo(String codigoPessoa) throws SQLException {
        /**
         * Método getByCodigo
         *
         * @author Fabricio Nogueira
         * @version 1.0.0
         *
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }
}