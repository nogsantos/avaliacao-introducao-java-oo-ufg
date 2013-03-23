/**
 *
 * Descrição:Classe PerfilImpl.
 * Implementação das funcionalidades Perfil
 *
 * @author Fabricio Nogueira
 *
 * @since 20-Mar-2013
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
import java.util.ArrayList;
import java.util.List;
import projeto.conexao.Conexao;

public class PerfilImpl implements PerfilDAO{
    private Connection connection = new Conexao().getConnection();
    private StringBuilder sSql = new StringBuilder();
    private StringBuilder mensagem = new StringBuilder();
    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet resultSet;
    /**
     * Contrutor
     */
    public PerfilImpl() {
        try {
            this.connection.setAutoCommit(true);
            this.preStatement = null;
            this.statement = null;
            this.resultSet = null;
        } catch (Exception ex) {
            this.mensagem.append("##ERRO.PERFIL.IMPLEMENTACAO.CONSTRUTOR::");
            this.mensagem.append("Problemas na construção.: \n");
            this.mensagem.append(ex.getMessage());
            System.err.println(this.mensagem);
        }
    }
    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    @Override
    public boolean cadastrar(Perfil perfil) throws SQLException{
        this.sSql.append("INSERT INTO perfil (                              ");
        this.sSql.append("      codigo_perfil,                              ");
        this.sSql.append("      nome,                                       ");
        this.sSql.append("      descricao                                   ");
        this.sSql.append(") values (                                        ");
        this.sSql.append("      ?,?,?                                       ");
        this.sSql.append(")                                                 ");
        try {
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setInt(1, perfil.getCodigoPerfil());
            this.preStatement.setString(2, perfil.getNome());
            this.preStatement.setString(3, perfil.getDescricao());
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFIL.IMPLEMENTACAO.CADASTRAR::");
            this.mensagem.append("Erro na inserção dos dados.: \n");
            this.mensagem.append(e.getMessage());
            throw new SQLException(this.mensagem.toString());
        } finally {
            fecharConexao();
        }
    }
    /**
     * Retorna o próximo número da sequência na listagem dos perfis.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0 
     * @return Integer Próximo codigo na sequencia regitrado na tabela
     */
    public  Integer perfilNextVal() throws SQLException{
        String valor = "";
        this.sSql.append("SELECT MAX(codigo_perfil) + 1 as max FROM perfil");
        try {
            this.statement = this.connection.createStatement();
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
     * @return boolean
     */
    @Override
    public boolean editar(Perfil perfil) throws SQLException{
        this.sSql.append(" UPDATE perfil SET                                ");
        this.sSql.append("      nome = ?,                                   ");
        this.sSql.append("      descricao = ?                               ");
        this.sSql.append(" WHERE                                            ");
        this.sSql.append("      codigo_perfil = ?                           ");
        try {
            this.preStatement = this.connection.prepareStatement(
                    this.sSql.toString()
            );
            this.preStatement.setString(1, perfil.getNome());
            this.preStatement.setString(2, perfil.getDescricao());
            this.preStatement.setInt(3, perfil.getCodigoPerfil());
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFIL.IMPLEMENTACAO.EDIÇÃO::");
            this.mensagem.append("Erro na edição do dado.: \n");
            this.mensagem.append(e.getMessage());
            throw new SQLException(this.mensagem.toString());
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
    public boolean excluir(Perfil perfil) throws SQLException{
        this.sSql.append(" DELETE                                            ");
        this.sSql.append(" FROM perfil                                       ");
        this.sSql.append(" WHERE                                             ");
        this.sSql.append("      codigo_perfil = ?                            ");
        try {
            this.preStatement = this.connection.prepareStatement(
                    this.sSql.toString()
            );
            this.preStatement.setInt(1, perfil.getCodigoPerfil());
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFIL.IMPLEMENTACAO.EXCLUSÃO::");
            this.mensagem.append("Erro na exclusão do dado.:\n");
            this.mensagem.append(e.getMessage());
            throw new SQLException(this.mensagem.toString());
        } finally {
            fecharConexao();
        }
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
    public List<Perfil> listar() throws SQLException{
        List<Perfil> listaDePerfis = new ArrayList();
        this.sSql.append("SELECT");
        this.sSql.append("  codigo_perfil,                                   ");
        this.sSql.append("  nome,                                            ");
        this.sSql.append("  descricao                                        ");
        this.sSql.append("FROM                                               ");
        this.sSql.append("  perfil                                           ");
        this.sSql.append("ORDER BY                                           ");
        this.sSql.append("  codigo_perfil DESC                               ");
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                Perfil perfilList = new Perfil();
                perfilList.setCodigoPerfil(this.resultSet.getInt("codigo_perfil"));
                perfilList.setNome(this.resultSet.getString("nome"));
                perfilList.setDescricao(this.resultSet.getString("descricao"));
                
                listaDePerfis.add(perfilList);
            }
            return listaDePerfis;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFIL.IMPLEMENTACAO.LISTAGEM::");
            this.mensagem.append("Erro na listagem dos dados.:\n");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        } finally {
            fecharConexao();
        }
    }
    /**
     * Método getByCodigo.
     * Recupera um perfil por código.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Mixed
     */
    @Override
    public Perfil getByCodigo(int codigoPerfil) throws SQLException{
        if(codigoPerfil >= 0){
            this.sSql.append("SELECT                                         ");
            this.sSql.append("  codigo_perfil,                               ");
            this.sSql.append("  nome,                                        ");
            this.sSql.append("  descricao                                    ");
            this.sSql.append("FROM perfil                                    ");
            this.sSql.append("WHERE                                          ");
            this.sSql.append("  codigo_perfil =                              ");
            this.sSql.append(codigoPerfil);
            try {
                this.statement = this.connection.createStatement();
                this.resultSet = statement.executeQuery(this.sSql.toString());
                Perfil perfil = new Perfil();
                while (this.resultSet.next()) {
                    perfil.setCodigoPerfil(this.resultSet.getInt("CODIGO_PERFIL"));
                    perfil.setNome(this.resultSet.getString("NOME"));
                    perfil.setDescricao(this.resultSet.getString("DESCRICAO"));
                }
                return perfil;
            } catch (SQLException e) {
                this.mensagem.append("##ERRO.PERFIL.IMPLEMENTACAO.GETBYCODIGO::");
                this.mensagem.append("Erro na recuperação do dado.:\n");
                this.mensagem.append(e.getSQLState());
                throw new SQLException(this.mensagem.toString());
            }
        }else{
            this.mensagem.append("##ERRO.PERFIL.IMPLEMENTACAO.GETBYCODIGO::");
            this.mensagem.append("Código Inválido");
            System.err.println(this.mensagem.toString());
            return null;
        }
    }
    /**
     * Método confirmaPerfil.
     * Confirma a existencia de um perfil por código.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     * @return boolean
     */
    public boolean confirmaPerfil(int codigoPerfil) throws SQLException{
        if(codigoPerfil >= 0){
            this.sSql.append("SELECT                                        ");
            this.sSql.append("  codigo_perfil,                              ");
            this.sSql.append("  nome,                                       ");
            this.sSql.append("  descricao                                   ");
            this.sSql.append("FROM perfil                                   ");
            this.sSql.append("WHERE                                         ");
            this.sSql.append("  codigo_perfil =                             ");
            this.sSql.append(codigoPerfil);
            try {
                this.statement = this.connection.createStatement();
                this.resultSet = this.statement.executeQuery(this.sSql.toString());
                if(this.resultSet.wasNull()){
                    return false;
                }else{
                    return true;
                }
            } catch (SQLException e) {
                this.mensagem.append("##ERRO.PERFIL.IMPLEMENTACAO");
                this.mensagem.append("CONFIRMAPERFIL::");
                this.mensagem.append("Código Inválido");
                this.mensagem.append(e.getMessage());
                throw new SQLException(this.mensagem.toString());
            } finally {
                fecharConexao();
            }
        }else{
            this.mensagem.append("##ERRO.PERFIL.IMPLEMENTACAO.CONFIRMAPERFIL::");
            this.mensagem.append("Código Inválido");
            System.err.println(this.mensagem.toString());
            return false;
        }
    }
    /**
     * Fecha conexão 
     */
    private void fecharConexao() {
        try {
            this.statement.close();
            this.connection.close();
        } catch (SQLException ex) {
            this.mensagem.append("##ERRO.PERFIL.IMPLEMENTACAO.CONFIRMAR::");
            this.mensagem.append("Erro ao desconectar do banco de dados.: \n");
            this.mensagem.append(ex.getMessage());
            System.err.println(this.mensagem.toString());
        }
    }
}