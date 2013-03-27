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
import java.util.ArrayList;
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
        this.sSql.append(" ) values ( ");
        this.sSql.append(" ?,?,?,? ");
        this.sSql.append(" ) ");
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
    /**
     * Retorna o próximo número da sequência na listagem das funções.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Integer Próximo codigo na sequencia regitrado na tabela
     */
    public Integer funcaoNextVal() throws SQLException {
        String valor = "";
        this.sSql.append(" SELECT MAX(codigo_funcao) + 1 as max FROM funcao ");
        try {
            this.statement = this.connection.createStatement();
            this.connection.setAutoCommit(true);
            this.resultSet = this.statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                valor = this.resultSet.getString("MAX");
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return Integer.parseInt(valor);
    }
    /**
     * Método editar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public boolean editar(Funcao funcao,Formulario formulario) throws SQLException {
        this.sSql.append(" UPDATE funcao SET ");
        this.sSql.append(" codigo_formulario = ?, ");
        this.sSql.append(" nome = ? , ");
        this.sSql.append(" descricao = ?  ");
        this.sSql.append(" WHERE ");
        this.sSql.append(" codigo_funcao = ? ");
        try {
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setInt    (1, formulario.getCodigoFormulario());
            this.preStatement.setString (2, funcao.getNome());
            this.preStatement.setString (3, funcao.getDescricao());
            this.preStatement.setInt    (4, funcao.getCodigoFuncao());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.FUNCAO.IMPLEMENTACAO.EDITAR::");
            this.mensagem.append("Erro na inserção dos dados.: \n");
            this.mensagem.append(e.getMessage());
            throw new SQLException(this.mensagem.toString());
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
    public boolean excluir(Funcao funcao) throws SQLException {
        this.sSql.append(" DELETE ");
        this.sSql.append(" FROM funcao ");
        this.sSql.append(" WHERE ");
        this.sSql.append(" codigo_funcao = ? ");
        try {
            this.preStatement = this.connection.prepareStatement(
                    this.sSql.toString()
            );
            this.preStatement.setInt(1, funcao.getCodigoFuncao());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.FUNCAO.IMPLEMENTACAO.EXCLUSÃO::");
            this.mensagem.append("Erro na exclusão do dado.:\n");
            this.mensagem.append(e.getMessage());
            throw new SQLException(this.mensagem.toString());
        }
    }
    /**
     * Método listar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public List<Funcao> listar() throws SQLException {
        List<Funcao> listaDeFuncoes = new ArrayList();
        this.sSql.append(" SELECT ");
        this.sSql.append(" fu.codigo_funcao, ");
        this.sSql.append(" f.codigo_formulario||' - '||f.nome formulario, ");
        this.sSql.append(" fu.nome, ");
        this.sSql.append(" fu.descricao ");
        this.sSql.append(" from funcao fu, formulario f ");
        this.sSql.append(" where fu.codigo_formulario = f.codigo_formulario ");
        this.sSql.append(" order by fu.codigo_funcao desc ");
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                Funcao funcoesList = new Funcao();
                funcoesList.setCodigoFuncao(this.resultSet.getInt("codigo_funcao"));
                funcoesList.setNomeFormulario(this.resultSet.getString("formulario"));
                funcoesList.setNome(this.resultSet.getString("nome"));
                funcoesList.setDescricao(this.resultSet.getString("descricao"));
                listaDeFuncoes.add(funcoesList);
            }
            return listaDeFuncoes;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.FUNCOES.IMPLEMENTACAO.LISTAGEM::");
            this.mensagem.append("Erro na listagem dos dados.:\n");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        }
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
