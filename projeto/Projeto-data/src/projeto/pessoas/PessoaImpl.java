/**
 *
 * Descrição:
 *          Classe PessoaImpl
 *
 * @author Fabricio Nogueira
 * @since Mar 23, 2013
 *
 */

package projeto.pessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import projeto.conexao.Conexao;


public class PessoaImpl implements PessoaDAO{
    /*
     * Instancição dos atributos da classe
     */
    private Connection connection  = new Conexao().getConnection();
    private StringBuilder sSql     = new StringBuilder();
    private StringBuilder mensagem = new StringBuilder();
    private PreparedStatement preStatement;

    public PessoaImpl() {
        this.preStatement = null;
    }
    /**
     * Método cadastrar.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    @Override
    public String cadastrar(Pessoa pessoa) throws SQLException {
        try {
            this.sSql.append(" INSERT INTO pessoa ( ");
            this.sSql.append(" codigo_pessoa, ");
            this.sSql.append(" nome, ");
            this.sSql.append(" logradouro, ");
            this.sSql.append(" email, ");
            this.sSql.append(" telefone ");
            this.sSql.append(" ) VALUES ( ");
            this.sSql.append(" ?,?,?,?,? ) ");
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setString(1, pessoa.getCodigoPessoa());
            this.preStatement.setString(2, pessoa.getNome());
            this.preStatement.setString(3, pessoa.getLogradouro());
            this.preStatement.setString(4, pessoa.getEmail());
            this.preStatement.setString(5, pessoa.getTelefone());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PESSOA.IMPLEMENTACAO.CADASTRAR::");
            this.mensagem.append("Erro na inserção dos dados.");
            this.mensagem.append(e.getMessage());
            return this.mensagem.toString();
        }
    }
    /**
     * Método editar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    @Override
    public String editar(Pessoa pessoa) throws SQLException {
        try {
            this.sSql.append(" UPDATE pessoa SET ");
            this.sSql.append(" nome = ?, ");
            this.sSql.append(" logradouro = ?, ");
            this.sSql.append(" email = ?, ");
            this.sSql.append(" telefone = ? ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" codigo_pessoa = ? ");
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setString(1, pessoa.getNome());
            this.preStatement.setString(2, pessoa.getLogradouro());
            this.preStatement.setString(3, pessoa.getEmail());
            this.preStatement.setString(4, pessoa.getTelefone());
            this.preStatement.setString(5, pessoa.getCodigoPessoa());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PESSOA.IMPLEMENTACAO.EDITAR::");
            this.mensagem.append("Erro na edição dos dados.");
            this.mensagem.append(e.getMessage());
            return this.mensagem.toString();
        }
    }
    /**
     * Método excluir
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public String excluir(Pessoa pessoa) throws SQLException {
        try {
            this.sSql.append(" DELETE FROM pessoa ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" codigo_pessoa = ? ");
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setString(1, pessoa.getCodigoPessoa());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PESSOA.IMPLEMENTACAO.EXCLUIR::");
            this.mensagem.append("Erro na edição dos dados.");
            this.mensagem.append(e.getMessage());
            return this.mensagem.toString();
        }
    }
}