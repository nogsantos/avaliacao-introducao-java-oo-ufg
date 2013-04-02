/**
 *
 * Descrição:Classe Perfil
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


public class Perfil {

    private Integer codigoPerfil;
    private String nome;
    private String descricao;

    public Integer getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(Integer codigoPerfil){
        this.codigoPerfil = codigoPerfil;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NullPointerException{
        if(!nome.isEmpty()){
            this.nome = nome;
        }else{
            throw new NullPointerException("Nome Inválido.");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws NullPointerException {
        if(!descricao.isEmpty()){
            this.descricao = descricao;
        }else{
            throw new NullPointerException("Descrição Inválida.");
        }
    }
}
