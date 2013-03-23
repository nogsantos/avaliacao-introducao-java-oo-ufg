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
    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet resultSet;  
    public PerfilImpl() {
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
                        + ""+ex.getSQLState());
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
        try {
            this.preStatement = this.connection.prepareStatement(""
                    + " INSERT INTO perfil ("
                    + " codigo_perfil, nome, descricao"
                    + ") values (?,?,?)");
            this.preStatement.setInt(1, perfil.getCodigoPerfil());
            this.preStatement.setString(2, perfil.getNome());
            this.preStatement.setString(3, perfil.getDescricao());
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("##ERRO.PERFIL.IMPLEMENTACAO.CADASTRAR::"
                    + " Erro na tentativa de inserção dos dados.: \n"
                    + ""+e.getMessage().toString());
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
    public  Integer perfilNextVal(){
        String valor = "";
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery("SELECT "
                    + "MAX(codigo_perfil)+1 as max FROM perfil");
            while (this.resultSet.next()) {
                valor = this.resultSet.getString("MAX");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
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
    public boolean editar(Perfil perfil){
        try {
            this.preStatement = this.connection.prepareStatement(""
                    + " UPDATE perfil SET"
                    + " nome = ?, "
                    + " descricao = ? "
                    + " where codigo_perfil = ? ");
            this.preStatement.setString(1, perfil.getNome());
            this.preStatement.setString(2, perfil.getDescricao());
            this.preStatement.setInt(3, perfil.getCodigoPerfil());
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.EDIÇÃO::"
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
    public boolean excluir(Perfil perfil){
        try {
            this.preStatement = this.connection.prepareStatement(""
                    + " DELETE from perfil "
                    + " where codigo_perfil = ? ");
            this.preStatement.setInt(1, perfil.getCodigoPerfil());
            this.preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.DELEÇÃO::"
                    + " Erro na tentativa de deleção do dado.: \n"
                    + ""+e.getMessage().toString());
            return false;
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
    public List<Perfil> listar(){
        List<Perfil> listaDePerfis = new ArrayList();
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery("SELECT "
                    + "codigo_perfil, nome, descricao FROM perfil order by codigo_perfil desc");
            while (this.resultSet.next()) {
                Perfil perfilList = new Perfil();
                perfilList.setCodigoPerfil(this.resultSet.getInt("codigo_perfil"));
                perfilList.setNome(this.resultSet.getString("nome"));
                perfilList.setDescricao(this.resultSet.getString("descricao"));
                
                listaDePerfis.add(perfilList);
            }
        } catch (SQLException e) {
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.LISTAR::"
                    + " Erro na tentativa de recuperação dos dados.: \n"
                    + ""+e.getMessage().toString());
            return null;
        } finally {
            fecharConexao();
        }
        return listaDePerfis;
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
    public Perfil getByCodigo(int codigoPerfil){
        if(codigoPerfil >= 0){
            try {
                this.statement = this.connection.createStatement();
                this.resultSet = statement.executeQuery("SELECT "
                        + "codigo_perfil, nome, descricao FROM perfil where codigo_perfil = "+codigoPerfil+"");
                Perfil perfil = new Perfil();
                while (this.resultSet.next()) {
                    perfil.setCodigoPerfil(this.resultSet.getInt("CODIGO_PERFIL"));
                    perfil.setNome(this.resultSet.getString("NOME"));
                    perfil.setDescricao(this.resultSet.getString("DESCRICAO"));
                }
                return perfil;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }else{
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.GETBYCODIGO::"
                        + " Código Inválido");
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
    public boolean confirmaPerfil(int codigoPerfil){
        if(codigoPerfil >= 0){
            try {
                this.statement = this.connection.createStatement();
                this.resultSet = this.statement.executeQuery(""
                        + " SELECT codigo_perfil, nome, descricao FROM perfil "
                        + " WHERE codigo_perfil = "+codigoPerfil+"");
                if(this.resultSet.wasNull()){
                    return false;
                }else{
                    return true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            } finally {
                fecharConexao();
            }
        }else{
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.GETBYCODIGO::"
                        + " Código Inválido");
            return false;
        }
    }

    private void fecharConexao() {
        try {
            this.statement.close();
            this.connection.close();
        } catch (SQLException ex) {
            System.err.println("##ERRO.PERFIL.IMPLEMENTACAO.CONFIRMAR:: Erro ao desconectar do banco de dados.: \n" + ex.getMessage());
        }
    }
}