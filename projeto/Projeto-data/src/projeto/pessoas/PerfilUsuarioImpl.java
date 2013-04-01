/**
 *
 * Descrição:Classe UsuarioPerfilImpl
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 01-Apr-2013
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
import projeto.conexao.Conexao;


public class PerfilUsuarioImpl implements PerfilUsuarioDAO {
    /*
     * Instancição dos atributos da classe
     */
    private Connection connection  = new Conexao().getConnection();
    private StringBuilder sSql     = new StringBuilder();
    private StringBuilder mensagem = new StringBuilder();
    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet resultSet;
    /**
     * Contrutor
     */
    public PerfilUsuarioImpl() {
        this.preStatement = null;
        this.statement    = null;
        this.resultSet    = null;
    }
    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    @Override
    public String cadastrar(PerfilUsuario perfilUsuario) throws SQLException{
        try {
            this.sSql.append(" INSERT INTO usuario_perfil ( ");
            this.sSql.append(" codigo_pessoa, ");
            this.sSql.append(" codigo_perfil ");
            this.sSql.append(" ) values ( ");
            this.sSql.append(" ?,? ");
            this.sSql.append(" ) ");
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setObject(1, perfilUsuario.getCodigoPessoa());
            this.preStatement.setObject(2, perfilUsuario.getCodigoPerfil());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFILUSUARIO.IMPLEMENTACAO.CADASTRAR::");
            this.mensagem.append("Erro na inserção dos dados.");
            this.mensagem.append(e.getMessage());
            return this.mensagem.toString();
        } 
    }
    /**
     * Método editar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    @Override
    public String editar(PerfilUsuario perfilUsuario) throws SQLException{
        return "";
    }
    /**
     * Método excluir
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    @Override
    public String excluir(PerfilUsuario perfilUsuario) throws SQLException{
        return "";
    }

}
