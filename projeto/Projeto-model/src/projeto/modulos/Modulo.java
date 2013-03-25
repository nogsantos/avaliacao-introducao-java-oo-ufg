/**
 *
 * Descrição:Classe Modulo
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 21-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;


public class Modulo {

    private Integer codigoModulo;
    private String nome;
    private String descricao;
    private Integer ordem;

    public Integer getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(Integer codigoModulo) {
        this.codigoModulo = codigoModulo;
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

    public void setDescricao(String descricao) throws NullPointerException{
        if(!descricao.isEmpty()){
            this.descricao = descricao;
        }else{
            throw new NullPointerException("Descrição Inválida.");
        }
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem >= 0 ? ordem : 0;
    }
}
