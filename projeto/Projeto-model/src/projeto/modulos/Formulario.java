/**
 *
 * Descrição:Classe Formulario
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


public class Formulario {

    private Integer codigoFormulario;
    private Modulo modulo;
    private String nomeModulo;
    private String nome;
    private String nomeMenu;
    private String descricao;
    private Integer ordem;
    private String flagOculto;

    public Integer getCodigoFormulario() {
        return codigoFormulario;
    }

    public void setCodigoFormulario(Integer codigoFormulario) {
        this.codigoFormulario = codigoFormulario;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo){
        this.nomeModulo = nomeModulo;
    }
    
    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NullPointerException{
        if (!nome.isEmpty()) {
            this.nome = nome;
        }else{
            throw new NullPointerException("##ERRO::Nome inválido");
        }
    }

    public String getNomeMenu() {
        return nomeMenu;
    }

    public void setNomeMenu(String nomeMenu) throws NullPointerException {
        this.nomeMenu = nomeMenu;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public String getFlagOculto() {
        return flagOculto;
    }

    public void setFlagOculto(String flagOculto) throws Error{
        if( flagOculto.toLowerCase().equals("visivel")       | 
            flagOculto.toLowerCase().equals("oculto")        | 
            flagOculto.toLowerCase().equals("não Definido")  | 
            flagOculto.toLowerCase().equals("t")             |
            flagOculto.toLowerCase().equals("f") ){
            this.flagOculto = flagOculto;
        }else{
            throw new Error("##ERRO::Flag oculto. Informe t para verdadeiro ou f para falso.");
        }
    }
}
