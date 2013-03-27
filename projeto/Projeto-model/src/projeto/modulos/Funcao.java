/**
 *
 * Descrição:Classe Funcao
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 26-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;


public class Funcao {

    private Integer codigoFuncao;
    private Formulario formulario;
    private String nomeFormulario;
    private String nome;
    private String descricao;

    public Integer getCodigoFuncao() {
        return codigoFuncao;
    }

    public void setCodigoFuncao(Integer codigoFuncao) {
        this.codigoFuncao = codigoFuncao;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public String getNomeFormulario() {
        return nomeFormulario;
    }

    public void setNomeFormulario(String nomeFormulario) {
        this.nomeFormulario = nomeFormulario;
    }
    
    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NullPointerException{
        if(!nome.toLowerCase().isEmpty()){
            this.nome = nome;
        }else{
            throw new NullPointerException("Nome Inválido.");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
