/**
 *
 * Descrição:Classe ModuloService
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


public class ModuloService {

    private ModuloDAO camadaDados;

    public ModuloService() {
        this.camadaDados = new ModuloImpl();
    }
    /**
     *
     * 
     */
    public void incluirModulo(Integer codigoModulo, String nome, 
            String descricao, int ordem){
        
        Modulo modulo = new Modulo();
        modulo.setCodigoModulo(codigoModulo);
        modulo.setDescricao(descricao);
        modulo.setNome(nome);
        modulo.setOrdem(ordem);
        
        ModuloImpl bd = new ModuloImpl();
        try {
            bd.cadastrar(modulo);
        } catch (Exception e) {
            System.out.println("ERRO.MODULO.SERVICE ## "
                    + "Erro na inserção.: "+e.getMessage());
        }
    }

}
