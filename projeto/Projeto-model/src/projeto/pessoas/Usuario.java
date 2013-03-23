/**
 *
 * Descrição:
 *          Classe Usuario
 *
 * @author Fabricio Nogueira
 * @since Mar 23, 2013
 *
 */

package projeto.pessoas;


public class Usuario{

    private Pessoa pessoa;
    private String login;
    private String senha;


    public void setCodigoPessoa(Pessoa codigoPessoa) {
        this.pessoa = codigoPessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
