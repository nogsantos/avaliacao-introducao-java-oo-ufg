/**
 *
 * Descrição:Classe MenuPerfil.
 * Define o Menu para o cadastro de perfil.
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
import projeto.utils.ProjetoStringUtils;


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
        
        menu.append(ProjetoStringUtils.rpad("*", "*",66)).append("\n");
        menu.append(ProjetoStringUtils.rpad("SELECIONE ABAIXO A "
                + "OPÇÃO DESEJADA ", " ",65)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("*", "*",66)).append("\n");
        menu.append(ProjetoStringUtils.rpad("0. Encerrar Sistema",
                " ",32)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 1. Retornar ao menu inicial",
                " ",32)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("2. Editar um perfil",
                " ",32)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 3. Excluir um perfil", 
                " ",32)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("4. Listar perfis", 
                " ",32)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 5. Continuar cadastro", 
                " ",32)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("*", "*",66));
        System.out.println(menu);
        try {
            acao = leitor.nextInt();
            defineAcaoMenuPerfil(acao);
        } catch (Exception e) {
            System.out.println("##ERRO:: Opção Inválida");
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
                    System.out.println("##ERRO:: Opção Inválida");
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
                PerfilService perfil = new PerfilService();
                perfil.listarPerfis();
                showMenuPerfil();
                break;
            case CONTINUAR:
                try {
                    PerfilView perfilView = new PerfilView();
                    perfilView.leitorPerfil();
                } catch (Exception e) {
                    System.out.println("##ERRO:: Opção Inválida");
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
        
        menu.append(ProjetoStringUtils.rpad("*", "*",66)).append("\n");
        menu.append(ProjetoStringUtils.rpad("##ERRO::SELECIONE "
                + "ABAIXO A OPÇÃO DESEJADA ", "*",66));
        menu.append("\n");
        menu.append(ProjetoStringUtils.rpad("0. Encerrar Sistema",
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad("1. Retornar ao menu inicial",
                " ",21)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("5. Continuar o cadastro", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" ", 
                " ",21)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("*", "*",66));
        System.out.println(menu);
        try {
            acao = leitor.nextInt();
            defineAcaoMenuPerfilError(acao);
        } catch (Exception e) {
            System.out.println("##ERRO:: Opção Inválida");
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
                    System.out.println("##ERRO:: Opção Inválida");
                    showMenuPerfilError();
                }
                break;
            case CONTINUAR:
                try {
                    PerfilView perfilView = new PerfilView();
                    perfilView.leitorPerfil();
                } catch (Exception e) {
                    System.out.println("##ERRO:: Opção Inválida");
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