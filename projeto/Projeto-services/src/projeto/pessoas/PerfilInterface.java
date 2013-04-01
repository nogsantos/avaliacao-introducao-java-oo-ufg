/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.pessoas;


public interface PerfilInterface {

    /**
     * Editação dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    String editar();

    /**
     * Exclusão dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    String excluir();

    /**
     * cadastro dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    String cadastrar();

    /**
     * Implementação da listagem dos perfis.
     * @author Fabricio Nogueira
     * @version 1.0.0
     */
    void listar();
    
}
