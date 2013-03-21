/**
 *
 * Descrição:Classe PerfilImpl
 *
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
    private PreparedStatement preStatement = null;
    private Statement statement;
    private ResultSet resultSet;    
    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public boolean cadastrar(Perfil perfil){
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
            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.CADASTRAR::"
                    + " Erro na tentativa de inserção dos dados.: \n"
                    + ""+e.getMessage().toString());
            return false;
        } finally {
            try {
                this.preStatement.close();
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
     */
    public  Integer perfilNextVal(){
        String valor = "";
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery("SELECT "
                    + "MAX(nvl(codigo_perfil,0))+1 as max FROM perfil");
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
     *
     */
    @Override
    public boolean editar(Perfil perfil){
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * Método listar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public List<Perfil> listar(){
        List<Perfil> listaDePerfis = new ArrayList<Perfil>();
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery("SELECT "
                    + "codigo_perfil, nome, descricao FROM perfil");
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
                this.statement.close();
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
     * Método getByCodigo
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public Perfil getByCodigo(int codigoPerfil){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}