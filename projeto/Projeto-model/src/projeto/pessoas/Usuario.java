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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws NullPointerException {
        if(!login.isEmpty()){
            this.login = login;
        }else{
            throw new NullPointerException("Login Inválido.");
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws NullPointerException {
        if(!senha.isEmpty()){
            this.senha = senha;
        }else{
            throw new NullPointerException("Senha Inválida.");
        }
    }

    
}
