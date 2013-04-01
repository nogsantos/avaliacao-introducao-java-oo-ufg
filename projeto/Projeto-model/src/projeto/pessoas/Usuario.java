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
    private String codigoPessoa;
    private String nome;
    private String logradouro;
    private String email;
    private String telefone;
    private String login;
    private String senha;
    private Perfil perfil;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(String codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
