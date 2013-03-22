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
    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    @Override
    public boolean cadastrar(Perfil perfil){
        PreparedStatement preStatement = null;
        try {
            preStatement = this.connection.prepareStatement(""
                    + " INSERT INTO perfil ("
                    + " codigo_perfil, nome, descricao"
                    + ") values (?,?,?)");
            preStatement.setInt(1, perfil.getCodigoPerfil());
            preStatement.setString(2, perfil.getNome());
            preStatement.setString(3, perfil.getDescricao());
            preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.CADASTRAR::"
                    + " Erro na tentativa de inserção dos dados.: \n"
                    + ""+e.getMessage().toString());
            return false;
        } finally {
            try {
                preStatement.close();
                this.connection.close();
            } catch (SQLException e) {
                System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.CADASTRAR::"
                        + " Erro ao desconectar do banco de dados.: \n"
                        + ""+e.getSQLState());
            }
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
        Statement statement = null;
        ResultSet resultSet;   
        String valor = "";
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT "
                    + "MAX(codigo_perfil)+1 as max FROM perfil");
            while (resultSet.next()) {
                valor = resultSet.getString("MAX");
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
        PreparedStatement preStatement = null;
        try {
            preStatement = this.connection.prepareStatement(""
                    + " UPDATE perfil SET"
                    + " nome = ?, "
                    + " descricao = ? "
                    + " where codigo_perfil = ? ");
            preStatement.setString(1, perfil.getNome());
            preStatement.setString(2, perfil.getDescricao());
            preStatement.setInt(3, perfil.getCodigoPerfil());
            preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.EDIÇÃO::"
                    + " Erro na tentativa de edição dos dados.: \n"
                    + ""+e.getMessage().toString());
            return false;
        } finally {
            try {
                preStatement.close();
                this.connection.close();
            } catch (SQLException e) {
                System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.EDIÇÃO::"
                        + " Erro ao desconectar do banco de dados.: \n"
                        + ""+e.getSQLState());
            }
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
        PreparedStatement preStatement = null;
        try {
            preStatement = this.connection.prepareStatement(""
                    + " DELETE perfil "
                    + " where codigo_perfil = ? ");
            preStatement.setInt(1, perfil.getCodigoPerfil());
            preStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.DELEÇÃO::"
                    + " Erro na tentativa de edição dos dados.: \n"
                    + ""+e.getMessage().toString());
            return false;
        } finally {
            try {
                preStatement.close();
                this.connection.close();
            } catch (SQLException e) {
                System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.DELEÇÃO::"
                        + " Erro ao desconectar do banco de dados.: \n"
                        + ""+e.getSQLState());
            }
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
        Statement statement = null;
        ResultSet resultSet;   
        List<Perfil> listaDePerfis = new ArrayList<Perfil>();
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT "
                    + "codigo_perfil, nome, descricao FROM perfil order by codigo_perfil desc");
            while (resultSet.next()) {
                Perfil perfilList = new Perfil();
                perfilList.setCodigoPerfil(resultSet.getInt("codigo_perfil"));
                perfilList.setNome(resultSet.getString("nome"));
                perfilList.setDescricao(resultSet.getString("descricao"));
                
                listaDePerfis.add(perfilList);
            }
        } catch (SQLException e) {
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.LISTAR::"
                    + " Erro na tentativa de recuperação dos dados.: \n"
                    + ""+e.getMessage().toString());
            return null;
        } finally {
            try {
                statement.close();
                this.connection.close();
            } catch (SQLException e) {
                System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.LISTAR::"
                        + " Erro ao desconectar do banco de dados.: \n"
                        + ""+e.getSQLState());
            }
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
        Statement statement = null;
        ResultSet resultSet;   
        if(codigoPerfil >= 0){
            try {
                statement = this.connection.createStatement();
                resultSet = statement.executeQuery("SELECT "
                        + "codigo_perfil, nome, descricao FROM perfil where codigo_perfil = "+codigoPerfil+"");
                Perfil perfil = new Perfil();
                while (resultSet.next()) {
                    perfil.setCodigoPerfil(resultSet.getInt("CODIGO_PERFIL"));
                    perfil.setNome(resultSet.getString("NOME"));
                    perfil.setDescricao(resultSet.getString("DESCRICAO"));
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
        Statement statement = null;
        ResultSet resultSet;   
        if(codigoPerfil >= 0){
            try {
                statement = this.connection.createStatement();
                resultSet = statement.executeQuery(""
                        + " SELECT codigo_perfil, nome, descricao FROM perfil "
                        + " WHERE codigo_perfil = "+codigoPerfil+"");
                if(resultSet.wasNull()){
                    return false;
                }else{
                    return true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            } finally {
            try {
                statement.close();
                this.connection.close();
            } catch (SQLException e) {
                System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.CONFIRMAR::"
                        + " Erro ao desconectar do banco de dados.: \n"
                        + ""+e.getSQLState());
            }
        }
        }else{
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.GETBYCODIGO::"
                        + " Código Inválido");
            return false;
        }
    }
}