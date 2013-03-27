/**
 *
 * Descrição:Classe FormularioImpl
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


public class FormularioImpl implements FormularioDAO{
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
    public FormularioImpl() {
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
    public void cadastrar(Formulario formulario, 
                                    Modulo modulo) throws SQLException {
        this.sSql.append(" INSERT INTO formulario ( ");
        this.sSql.append(" codigo_formulario, ");
        this.sSql.append(" codigo_modulo, ");
        this.sSql.append(" nome, ");
        this.sSql.append(" nome_menu, ");
        this.sSql.append(" descricao, ");
        this.sSql.append(" ordem, ");
        this.sSql.append(" flag_oculto )");
        this.sSql.append(" values ");
        this.sSql.append(" (?,?,?,?,?,?,? )");
        try {
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setInt    (1, formulario.getCodigoFormulario());
            this.preStatement.setInt    (2, modulo.getCodigoModulo());
            this.preStatement.setString (3, formulario.getNome());
            this.preStatement.setString (4, formulario.getNomeMenu());
            this.preStatement.setString (5, formulario.getDescricao());
            this.preStatement.setInt    (6, formulario.getOrdem());
            this.preStatement.setString (7, formulario.getFlagOculto());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.FORMULARIO.IMPLEMENTACAO.CADASTRAR::");
            this.mensagem.append("Erro na inserção dos dados.: \n");
            this.mensagem.append(e.getMessage());
            throw new SQLException(this.mensagem.toString());
        } 
    }
    /**
     * Retorna o próximo número da sequência na listagem dos formularios.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Integer Próximo codigo na sequencia regitrado na tabela
     */
    public Integer formularioNextVal() throws SQLException {
        String valor = "";
        this.sSql.append(" SELECT MAX(codigo_formulario) + 1 as max FROM formulario ");
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
    public void editar(Formulario formulario, 
                                Modulo modulo) throws SQLException {
        this.sSql.append(" UPDATE formulario SET ");
        this.sSql.append(" codigo_modulo = ?, ");
        this.sSql.append(" nome = ?, ");
        this.sSql.append(" nome_menu = ?, ");
        this.sSql.append(" descricao = ?, ");
        this.sSql.append(" ordem = ? , ");
        this.sSql.append(" flag_oculto = ? ");
        this.sSql.append(" WHERE ");
        this.sSql.append(" codigo_formulario = ? ");
        try {
            this.preStatement = this.connection.prepareStatement(
                this.sSql.toString()
            );
            this.preStatement.setInt    (1, modulo.getCodigoModulo());
            this.preStatement.setString (2, formulario.getNome());
            this.preStatement.setString (3, formulario.getNomeMenu());
            this.preStatement.setString (4, formulario.getDescricao());
            this.preStatement.setInt    (5, formulario.getOrdem());
            this.preStatement.setString (6, formulario.getFlagOculto());
            this.preStatement.setInt    (7, formulario.getCodigoFormulario());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.FORMULARIO.IMPLEMENTACAO.EDIÇÃO::");
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
    public void excluir(Formulario formulario) throws SQLException {
        this.sSql.append(" DELETE ");
        this.sSql.append(" FROM formulario ");
        this.sSql.append(" WHERE ");
        this.sSql.append(" codigo_formulario = ? ");
        try {
            this.preStatement = this.connection.prepareStatement(
                    this.sSql.toString()
            );
            this.preStatement.setInt(1, formulario.getCodigoFormulario());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.FORMULARIO.IMPLEMENTACAO.EXCLUSÃO::");
            this.mensagem.append("Erro na exclusão do dado.:\n");
            this.mensagem.append("Pode estar sendo referênciado.\n");
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
    public List<Formulario> listar() throws SQLException {
        List<Formulario> listaDeFormularios = new ArrayList();
        this.sSql.append(" SELECT ");
        this.sSql.append(" f.codigo_formulario, ");
        this.sSql.append(" m.codigo_modulo||'-'||m.nome modulo, ");
        this.sSql.append(" f.nome, ");
        this.sSql.append(" f.nome_menu, ");
        this.sSql.append(" f.descricao, ");
        this.sSql.append(" f.ordem, ");
        this.sSql.append(" case f.flag_oculto when 't' then 'Oculto' when 'f' ");
        this.sSql.append(" then 'Visivel' else 'Não Definido' end flag_oculto ");
        this.sSql.append(" FROM ");
        this.sSql.append(" formulario f, modulo m ");
        this.sSql.append(" WHERE ");
        this.sSql.append(" m.codigo_modulo = f.codigo_modulo ");
        this.sSql.append(" ORDER BY f.codigo_formulario DESC ");
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                Formulario formularioList = new Formulario();
                formularioList.setCodigoFormulario(this.resultSet.getInt("codigo_formulario"));
                formularioList.setNomeModulo(this.resultSet.getString("modulo"));
                formularioList.setNome(this.resultSet.getString("nome"));
                formularioList.setNomeMenu(this.resultSet.getString("nome_menu"));
                formularioList.setDescricao(this.resultSet.getString("descricao"));
                formularioList.setOrdem(this.resultSet.getInt("ordem"));
                formularioList.setFlagOculto(this.resultSet.getString("flag_oculto"));

                listaDeFormularios.add(formularioList);
            }
            return listaDeFormularios;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.FORMULARIO.IMPLEMENTACAO.LISTAGEM::");
            this.mensagem.append("Erro na listagem dos dados.: (SQL) \n");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        }
    }

    @Override
    public Formulario getByCodigo(int codigoFormulario) throws SQLException {
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
