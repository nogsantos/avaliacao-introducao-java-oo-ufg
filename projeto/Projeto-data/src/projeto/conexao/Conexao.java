/**
 *
 * Descrição:Classe Conexao
 *
 * @author Fabricio Nogueira
 *
 * @since 19-Mar-2013
 *
 * @version 1.0.0
 *
 */
package projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class Conexao {
    private static final int BANCO = 1;
    private static final int DB_ORACLE = 0;
    private static final int DB_POSTGRESQL = 1;
    
    private String url;
    private String usuario;
    private String senha;
    
    private Connection conn = null;
    private static Conexao instance = null;
    
//    private Connection connection = new Conexao().getConnection();
//    private PreparedStatement preStatement;
//    private Statement statement;
//    private ResultSet resultSet;  
    
    /**
     * Construtor da classe Inicializa a conexao
     */
    public Conexao() {
        switch(BANCO){
            case DB_ORACLE:
                url = "jdbc:oracle:thin:@localhost:1521:xe";
                usuario = "aluno";
                senha = "aluno";
                break;
            case DB_POSTGRESQL:
                url = "jdbc:postgresql://localhost:5432/java_oo";
                usuario = "postgres";
                senha = "123456";
                break;
        }
        try {
            inicializar();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("##ERRO::SQL.INICIALIZAÇÃO.CONEXÃO: "
                    + ex.getMessage());
        }
    }
    /**
     * Metodo que carrega o driver a efetua a conexao com o banco de dados
     */
    private void inicializar() throws ClassNotFoundException, SQLException {
        try {
            Properties connectProperties = new Properties();
            connectProperties.put("user", this.usuario);
            connectProperties.put("password", this.senha);
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(this.url, connectProperties);
        } catch (SQLException sqle) {
            System.out.println("##ERRO::SQLException em Conecta.java "
                    + sqle.getMessage());
        }
    }
    /**
     * Metodo invocado por outras classes para solicitar 
     * a conexao com banco de dados.
     * 
     * @return
     */
    public Connection getConnection() {
        return conn;
    }
    /**
     * Metodo chamado por outras classes para instanciar um objeto
     * do tipo conecta e poder utilizado Este metodo verifica se uma
     * instancia ja foi feita ou nao.
     *
     * @return
     */
    public static Conexao getInstance() {
        if (instance == null) {
            instance = new Conexao();
        }
        return instance;
    }
    /**
     * Metodo utilizado para fechar a conexao com o banco de dados
     */
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexao [" + e.getMessage()
                    + "]");
        }
    }
    /**
     * Preparação para uma ação que será realizada no banco de dados
     */
//    public void beginAction(){
//        try {
//            this.connection.setAutoCommit(true);
//            this.preStatement = null;
//            this.statement = null;
//            this.resultSet = null;
//        } catch (SQLException ex) {
//            System.out.println("##ERRO.CONEXÃO::"
//                    + " Erro BeginAction.: \n"
//                    + ""+ex.getMessage().toString());
//        }
//    }
//    
//    public boolean cadastrar(String sql, Object classe, HashMap<String, String> parametros) throws SQLException{
//        try {
//            this.preStatement = this.connection.prepareStatement(sql);
////            for (int i = 0 ; i< parametros.le  ) {
////                Object object = .getKey();
////                Object object1 = .getValue();
////                
////            }
//            
////            this.preStatement.setInt(1, perfil.getCodigoPerfil());
////            this.preStatement.setString(2, perfil.getNome());
////            this.preStatement.setString(3, perfil.getDescricao());
////            this.preStatement.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            System.out.println("##ERRO.PERFIL.IMPLEMENTACAO.CADASTRAR::"
//                    + " Erro na tentativa de inserção dos dados.: \n"
//                    + ""+e.getMessage().toString());
//            return false;
//        } finally {
//            closeConnection();
//        }
//    }
//    public boolean editar(){
//        return true;
//    }
//    public boolean excluir(){
//        return true;
//    }
}