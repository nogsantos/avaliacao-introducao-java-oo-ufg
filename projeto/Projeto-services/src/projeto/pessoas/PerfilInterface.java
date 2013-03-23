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
     * @todo Verificar se o codigo do perfil informado já existe na base
     * de dados, o método implementado para isso foi confirmaPerfil();
     *
     */
    boolean editarPerfil(Integer codigoPerfil, String nome, String descricao);

    /**
     * Exclusão dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     * @todo Verificar se o codigo do perfil informado já existe na base
     * de dados, o método implementado para isso foi confirmaPerfil();
     *
     */
    boolean excluirPerfil(Integer codigoPerfil);

    /**
     * cadastro dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    boolean incluirPerfil(Integer codigoPerfil, String nome, String descricao);

    /**
     * Implementação da listagem dos perfis.
     * @author Fabricio Nogueira
     * @version 1.0.0
     */
    void listarPerfis();
    
}
