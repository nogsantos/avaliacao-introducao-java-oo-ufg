/**
 *
 * Descrição:Classe MenuPerfil
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
import static projeto.app.MenuPrincipal.showMenu;


public class MenuPerfil {

    private static final int SAIR         = 0;
    private static final int MENU_INICIAL = 1;
    private static final int EDITAR       = 2;
    private static final int EXCLUIR      = 3;
    private static final int LISTAR       = 4;
    private static final int CONTINUAR    = 5;
    /**
     *
     * Menu principal perfil.
     * Gera opções após o cadastro realizado com sucesso.
     * 
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     * 
     */
    public void showMenuPerfil(){
        Scanner leitor = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        Integer acao;
        
        menu.append("*************************************************************");
        menu.append("\n");
        menu.append("SELECIONE O QUE DESEJA FAZER                                *");
        menu.append("\n");
        menu.append("0. Encerrar Sistema          *\t");
        menu.append("1. Retornar ao menu inicial *\t");
        menu.append("\n");
        menu.append("2. Editar um perfil          *\t");
        menu.append("3. Excluir um perfil        *\t");
        menu.append("\n");
        menu.append("4. Listar perfis             *\t");
        menu.append("5. Continuar cadastro       *\t");
        menu.append("\n");
        menu.append("*************************************************************");
        System.out.println(menu);
        try {
            acao = leitor.nextInt();
            defineAcaoMenuPerfil(acao);
        } catch (Exception e) {
            System.out.println("Termo inválido, tente novamente\n"+ e.getMessage() +"\nselecionando uma das opções abaixo:");
            showMenuPerfilError();
        }
    }
   /**
    * Define a ação.
    * Com base na escolha realizada pelo menu.
    * 
    * @author Fabricio Nogueira
    * @since 19-Mar-2013    
    * @version 1.0.0
    * @return void
    */
    private void defineAcaoMenuPerfil(int acao) {
        switch (acao) {
            case MENU_INICIAL:
                try {
                    showMenu();
                } catch (Exception e) {
                    System.out.println("Termo inválido, tente novamente\n"+ e.getMessage() +"\nselecionando uma das opções abaixo:");
                    showMenuPerfilError();
                }
                break;
            case EDITAR:
                System.out.println("Editar Perfil");
                break;
            case EXCLUIR:
                System.out.println("Excluir perfil");
                break;
            case LISTAR:
                System.out.println("Listar perfis");
                break;
            case CONTINUAR:
                try {
                    PerfilView perfilView = new PerfilView();
                    perfilView.leitorPerfil();
                } catch (Exception e) {
                    System.out.println("Termo inválido, tente novamente\n"+ e.getMessage() +"\nselecionando uma das opções abaixo:");
                    showMenuPerfilError();
                }
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuPerfil();
        }
    }
    /**
     *
     * Menu principal perfil error.
     * Gera opções quando um erro no cadastro foi gerado. 
     * 
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     * 
     */
    public void showMenuPerfilError(){
        Scanner leitor = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        Integer acao;
        
        menu.append("*************************************************************");
        menu.append("\n");
        menu.append("ERRO. ## SELECIONE O QUE DESEJA FAZER                       *");
        menu.append("\n");
        menu.append("0. Encerrar Sistema         *\t");
        menu.append("1. Retornar ao menu inicial *\t");
        menu.append("\n");
        menu.append("5. Continuar o cadastro     *\t");
        menu.append("                            *");
        menu.append("\n");
        menu.append("*************************************************************");
        System.out.println(menu);
        try {
            acao = leitor.nextInt();
            defineAcaoMenuPerfilError(acao);
        } catch (Exception e) {
            System.out.println("Termo inválido, tente novamente\n"+ e.getMessage() +"\nselecionando uma das opções abaixo:");
            showMenuPerfilError();
        }
    }
   /**
    * Define a ação.
    * Com base na escolha realizada pelo menu.
    * 
    * @author Fabricio Nogueira
    * @since 19-Mar-2013    
    * @version 1.0.0
    * @return void
    */
    private void defineAcaoMenuPerfilError(int acao) {
        switch (acao) {
            case MENU_INICIAL:
                try {
                    showMenu();
                } catch (Exception e) {
                    System.out.println("Termo inválido, tente novamente\n"+ e.getMessage() +"\nselecionando uma das opções abaixo:");
                    showMenuPerfilError();
                }
                break;
            case CONTINUAR:
                try {
                    PerfilView perfilView = new PerfilView();
                    perfilView.leitorPerfil();
                } catch (Exception e) {
                    System.out.println("Termo inválido, tente novamente\n"+ e.getMessage() +"\nselecionando uma das opções abaixo:");
                    showMenuPerfilError();
                }
                break;
                case SAIR:
                    System.exit(0);
                    break;
            default:
                showMenuPerfilError();
        }
    }
}
