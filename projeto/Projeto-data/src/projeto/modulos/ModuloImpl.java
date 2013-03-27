/**
 *
 * Descrição:Classe ModuloImpl
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 21-Mar-2013
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


public class ModuloImpl implements ModuloDAO{
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
    public ModuloImpl() {
        this.preStatement = null;
        this.statement    = null;
        this.resultSet    = null;
    }
    
    /**
     * Método cadastrar.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public boolean cadastrar(Modulo modulo) throws SQLException {
        this.sSql.append("INSERT INTO modulo ( ");
        this.sSql.append(" codigo_modulo, ");
        this.sSql.append(" nome, ");
        this.sSql.append(" descricao, ");
        this.sSql.append(" ordem ");
        this.sSql.append(") values ( ");
        this.sSql.append(" ?,?,?,? ");
        this.sSql.append(") ");
        try {
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setInt(1, modulo.getCodigoModulo());
            this.preStatement.setString(2, modulo.getNome());
            this.preStatement.setString(3, modulo.getDescricao());
            this.preStatement.setInt(4, modulo.getOrdem());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.MODULO.IMPLEMENTACAO.CADASTRAR::");
            this.mensagem.append("Erro na inserção dos dados.: \n");
            this.mensagem.append(e.getMessage());
            throw new SQLException(this.mensagem.toString());
        } 
    }
    /**
     * Retorna o próximo número da sequência na listagem dos modulos.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Integer Próximo codigo na sequencia regitrado na tabela
     */
    public Integer moduloNextVal() throws SQLException {
        String valor = "";
        this.sSql.append("SELECT MAX(codigo_modulo) + 1 as max FROM modulo");
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
    public boolean editar(Modulo modulo) throws SQLException {
        this.sSql.append(" UPDATE modulo SET ");
        this.sSql.append(" nome = ?, ");
        this.sSql.append(" descricao = ?, ");
        this.sSql.append(" ordem = ? ");
        this.sSql.append(" WHERE ");
        this.sSql.append(" codigo_modulo = ? ");
        try {
            this.preStatement = this.connection.prepareStatement(
                this.sSql.toString()
            );
            this.preStatement.setString(1, modulo.getNome());
            this.preStatement.setString(2, modulo.getDescricao());
            this.preStatement.setInt(3, modulo.getOrdem());
            this.preStatement.setInt(4, modulo.getCodigoModulo());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.MODULO.IMPLEMENTACAO.EDIÇÃO::");
            this.mensagem.append("Erro na edição do dado.: \n");
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
    public boolean excluir(Modulo modulo) throws SQLException {
        this.sSql.append(" DELETE ");
        this.sSql.append(" FROM modulo ");
        this.sSql.append(" WHERE ");
        this.sSql.append(" codigo_modulo = ? ");
        try {
            this.preStatement = this.connection.prepareStatement(
                    this.sSql.toString()
            );
            this.preStatement.setInt(1, modulo.getCodigoModulo());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.MODULO.IMPLEMENTACAO.EXCLUSÃO::");
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
    public List<Modulo> listar() throws SQLException {
        List<Modulo> listaDeModulos = new ArrayList();
        this.sSql.append(" SELECT ");
        this.sSql.append(" codigo_modulo, ");
        this.sSql.append(" nome, ");
        this.sSql.append(" descricao, ");
        this.sSql.append(" ordem ");
        this.sSql.append(" FROM ");
        this.sSql.append(" modulo ");
        this.sSql.append(" ORDER BY ");
        this.sSql.append(" codigo_modulo DESC ");
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                Modulo moduloList = new Modulo();
                moduloList.setCodigoModulo(this.resultSet.getInt("codigo_modulo"));
                moduloList.setNome(this.resultSet.getString("nome"));
                moduloList.setDescricao(this.resultSet.getString("descricao"));
                moduloList.setOrdem(this.resultSet.getInt("ordem"));

                listaDeModulos.add(moduloList);
            }
            return listaDeModulos;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.MODULO.IMPLEMENTACAO.LISTAGEM::");
            this.mensagem.append("Erro na listagem dos dados.:\n");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        }
    }
    /**
     * Listagem simples
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public List<Modulo> listagemSimples() throws SQLException {
        List<Modulo> listaDeModulos = new ArrayList();
        this.sSql.append(" SELECT ");
        this.sSql.append(" codigo_modulo, ");
        this.sSql.append(" nome ");
        this.sSql.append(" FROM ");
        this.sSql.append(" modulo ");
        this.sSql.append(" ORDER BY ");
        this.sSql.append(" codigo_modulo DESC ");
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                Modulo moduloList = new Modulo();
                moduloList.setCodigoModulo(this.resultSet.getInt("codigo_modulo"));
                moduloList.setNome(this.resultSet.getString("nome"));
                listaDeModulos.add(moduloList);
            }
            return listaDeModulos;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.MODULO.IMPLEMENTACAO.LISTAGEMSIMPLES::");
            this.mensagem.append("Erro na listagem dos dados.:\n");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        }
    }

    @Override
    public Modulo getByCodigo(int codigoModulo) throws SQLException {
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
