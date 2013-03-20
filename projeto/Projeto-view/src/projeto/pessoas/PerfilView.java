/**
 *
 * Descrição:Classe PerfilView
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

import java.util.Scanner;


public class PerfilView {

    public void leitorPerfil() throws Exception{
        /*
         * Instancia o menu do perfil
         */
        MenuPerfil menuPerfil = new MenuPerfil();
        try {
            System.out.println("FORMULÁRIO DE PERFIL *******************************");
            Scanner leitor = new Scanner(System.in);
            System.out.println("Codigo: ");
            Integer codigoPerfil = leitor.nextInt();
            System.out.println("Nome: ");
            String nome = leitor.next();
            System.out.println("Descrição: ");
            String descricao = leitor.next();

            PerfilService perfil = new PerfilService();
            try {
                perfil.incluirPerfil(codigoPerfil, nome, descricao);
                menuPerfil.showMenuPerfil();
            } catch (Exception e) {
                System.out.println("ERRO.PERFIL.VIEW ## Erro na inclusão dos dados. \t" + e.getMessage());
                menuPerfil.showMenuPerfilError();
            }
        } catch (Exception e) {
            System.out.println("ERRO.PERFIL.VIEW ## Erro na leitura dos dados \t" + e.getMessage());
            menuPerfil.showMenuPerfilError();
        }
    }
}
