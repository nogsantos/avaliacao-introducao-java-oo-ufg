/**
 *
 * Descrição:Classe FuncaoImpl
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import projeto.conexao.Conexao;


public class FuncaoImpl implements FuncaoDAO{
    /*
     * Instancição dos atributos da classe
     */
    private Connection connection  = new Conexao().getConnection();
    private StringBuilder sSql     = new StringBuilder();
    private StringBuilder mensagem = new StringBuilder();
    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet resultSet;
    /*
     * Construtor
     */
    public FuncaoImpl() {
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
    public boolean cadastrar(Funcao funcao, Formulario formulario) throws SQLException {
        this.sSql.append(" INSERT INTO funcao ( ");
        this.sSql.append(" codigo_funcao, ");
        this.sSql.append(" codigo_formulario, ");
        this.sSql.append(" nome, ");
        this.sSql.append(" descricao ");
        this.sSql.append(") values ( ");
        this.sSql.append(" ?,?,?,?,?,? ");
        this.sSql.append(") ");
        try {
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setInt(1, funcao.getCodigoFuncao());
            this.preStatement.setInt(2, formulario.getCodigoFormulario() );
            this.preStatement.setString(3, funcao.getNome());
            this.preStatement.setString(4, funcao.getDescricao());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.FUNCAO.IMPLEMENTACAO.CADASTRAR::");
            this.mensagem.append("Erro na inserção dos dados.: \n");
            this.mensagem.append(e.getMessage());
            throw new SQLException(this.mensagem.toString());
        } 
    }

    @Override
    public boolean editar(Funcao funcao,Formulario formulario) throws SQLException {
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
    public boolean excluir(Funcao funcao) throws SQLException {
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
    public List<Funcao> listar() throws SQLException {
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
    public Funcao getByCodigo(int codigoFuncao) throws SQLException {
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
