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
import java.sql.SQLException;
import java.util.List;
import projeto.conexao.Conexao;


public class PerfilImpl implements PerfilDAO{
    private Connection connection = null;
    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public boolean cadastrar(Perfil perfil) throws Exception {
        connection = Conexao.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(" insert into"
                    + " perfil (codigo_perfil, nome, descricao) values (?,?,?)");
            pstmt.setInt(1, perfil.getCodigoPerfil());
            pstmt.setString(2, perfil.getNome());
            pstmt.setString(3, perfil.getDescricao());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("ERRO.PERFIL.IMPLEMENTACAO ## Erro na inserção.\t"+e.getMessage());
            return false;
        } finally {
            try {
                pstmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("ERRO.PERFIL.IMPLEMENTACAO ## Erro ao desconectar.\t"+e.getSQLState());
            }
        }
    }
    
//    private Integer perfilNextVal(){
//        Integer valor;
//        Statement stmt = null;
//        try {
//            stmt = connection.createStatement();
//            ResultSet val = stmt.executeQuery("select seq_perfil.nextval from dual");
//            valor = val.getInt("NEXTVAL");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        } finally {
//            try {
//                stmt.close();
//                connection.close();
//            } catch (SQLException e) {
//                System.out.println("Erro ao desconectar");
//            }
//        }
//        return valor;
//    }
    /**
     * Método editar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public boolean editar(Perfil perfil) throws Exception {
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
    public boolean excluir(Perfil perfil) throws Exception {
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
    public List<Perfil> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * Método getByCodigo
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    @Override
    public Perfil getByCodigo(int codigoPerfil) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}