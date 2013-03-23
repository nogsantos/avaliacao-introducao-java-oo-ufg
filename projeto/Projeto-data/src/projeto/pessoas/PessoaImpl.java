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

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import projeto.conexao.Conexao;


public class PessoaImpl implements PessoaDAO{
    private Connection connection = new Conexao().getConnection();
    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet resultSet;

    public PessoaImpl() {
        try {
            /*
             * Definindo o auto commit
             */
            this.connection.setAutoCommit(true);
            this.preStatement = null;
            this.statement = null;
            this.resultSet = null;
        } catch (SQLException ex) {
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.CONSTRUTOR::"
                    + " Problemas na construção.: \n"
                    + "" + ex.getSQLState());
        }
    }
    /**
     * Método cadastrar.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    @Override
    public boolean cadastrar(Pessoa pessoa) throws SQLException {
        try {
            this.preStatement = this.connection.prepareStatement(""
                    + " INSERT INTO pessoa ("
                    + " codigo_perfil, nome, logradouro, telefone, email, data_nascimento"
                    + ") values (?,?,?,?,?,?)");
            this.preStatement.setString(1, pessoa.getCodigoPessoa());
            this.preStatement.setString(2, pessoa.getNome());
            this.preStatement.setString(3, pessoa.getLogradouro());
            this.preStatement.setString(4, pessoa.getTelefone());
            this.preStatement.setString(5, pessoa.getEmail());
            this.preStatement.setDate(6, (Date) pessoa.getDataNascimento());
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("##ERRO.PESSOA.IMPLEMENTACAO.CADASTRAR::"
                    + " Erro na tentativa de inserção dos dados.: \n"
                    + ""+e.getMessage().toString());
            return false;
        } finally {
            try {
                this.preStatement.close();
                this.connection.close();
            } catch (SQLException e) {
                System.out.println("##ERRO.PESSOA.IMPLEMENTACAO.CADASTRAR::"
                        + " Erro ao desconectar do banco de dados.: \n"
                        + ""+e.getSQLState());
            }
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
    public boolean editar(Pessoa pessoa) throws SQLException, InvalidParameterException {
        try {
            this.preStatement = this.connection.prepareStatement(""
                    + " UPDATE pessoa SET"
                    + " nome = ?, "
                    + " logradouro = ? "
                    + " telefone = ? "
                    + " email = ? "
                    + " data_nascimento = ? "
                    + " where codigo_pessoa = ? ");
            this.preStatement.setString(1, pessoa.getNome());
            this.preStatement.setString(2, pessoa.getLogradouro());
            this.preStatement.setString(3, pessoa.getTelefone());
            this.preStatement.setString(4, pessoa.getEmail());
            this.preStatement.setDate(5, (Date) pessoa.getDataNascimento());
            this.preStatement.setString(6, pessoa.getCodigoPessoa());
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("##ERRO.PESSOA.IMPLEMENTACAO.EDIÇÃO::"
                    + " Erro na tentativa de edição do dado.: \n"
                    + ""+e.getMessage().toString());
            return false;
        } finally {
            fecharConexao();
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
    public boolean excluir(Pessoa pessoa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }
    /**
     * Método listar.
     * Lista todos os registros cadastrados 
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Mixed 
     */
    @Override
    public List<Pessoa> listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * Método getByCodigo. Recupera um perfil por código.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Mixed
     */
    @Override
    public Pessoa getByCodigo(int codigoPessoa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void fecharConexao() throws InvalidParameterException{
        try {
            this.preStatement.close();
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("##ERRO.PESSOA.IMPLEMENTACAO.EDIÇÃO::"
                    + " Erro ao desconectar do banco de dados.: \n"
                    + ""+e.getSQLState());
        }
    }

    

}
