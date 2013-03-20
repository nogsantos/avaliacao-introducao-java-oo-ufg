/**
 *
 * Descrição:Classe MenuPrincipal
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 20-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.app;

import java.util.Scanner;
import projeto.pessoas.PerfilView;


public class MenuPrincipal {

    private static final int SAIR                 = 0;
    private static final int CADASTRA_PERFIL      = 1;
    private static final int CADASTRAR_USUARIO    = 2;
    private static final int CADASTRAR_MODULO     = 3;
    private static final int CADASTRAR_FORMULARIO = 4;
    private static final int CADASTRAR_FUNCAO     = 5;
    private static final int EDITAR_PERFIL        = 6;
    private static final int EDITAR_USUARIO       = 7;
    private static final int EDITAR_MODULO        = 8;
    private static final int EDITAR_FORMULARIO    = 9;
    private static final int EDITAR_FUNCAO        = 10;
    private static final int EXCLUIR_PERFIL       = 11;
    private static final int EXCLUIR_USUARIO      = 12;
    private static final int EXCLUIR_MODULO       = 13;
    private static final int EXCLUIR_FORMULARIO   = 14;
    private static final int EXCLUIR_FUNCAO       = 15;
    private static final int LISTAR_PERFIL        = 16;
    private static final int LISTAR_USUARIO       = 17;
    private static final int LISTAR_MODULO        = 18;
    private static final int LISTAR_FORMULARIO    = 19;
    private static final int LISTAR_FUNCAO        = 20;
   /**
    * Implementação do menu.
    * 
    * @author Fabricio Nogueira
    * @since 19-Mar-2013
    * @version 1.0.0
    * @return void
    */
    public static void showMenu() {
        Scanner leitor = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        Integer acao;

        menu.append("MENU PRINCIPAL **********************************************");
        menu.append("\n");
        menu.append("Selecione uma das opções abaixo\ndigitando o número correspondente:");
        menu.append("\n");
        menu.append("*************************************************************");
        menu.append("\n");
        menu.append("0. Encerrar Sistema                                         *\t");
        menu.append("\n");
        menu.append("*************************************************************");
        menu.append("\n");
        menu.append("CADASTROS                                                   *");
        menu.append("\n");
        menu.append("1. Perfil        *\t");
        menu.append("2. Usuário       *\t");
        menu.append("3. Módulo   *\t");
        menu.append("\n");
        menu.append("4. Formulário    *\t");
        menu.append("5. Funções       *\t");
        menu.append("            *");
        menu.append("\n");
        menu.append("*************************************************************");
        menu.append("\n");
        menu.append("EDIÇÃO:                                                     *");
        menu.append("\n");
        menu.append("6. Perfil        *\t");
        menu.append("7. Usuário       *\t");
        menu.append("8. Módulo   *\t");
        menu.append("\n");
        menu.append("9. Formulários   *\t");
        menu.append("10. Funções      *\t");
        menu.append("            *");
        menu.append("\n");
        menu.append("*************************************************************");
        menu.append("\n");
        menu.append("EXCLUSÃO:                                                   *");
        menu.append("\n");
        menu.append("11. Perfil       *\t");
        menu.append("12. Usuario      *\t");
        menu.append("13. Módulo  *\t");
        menu.append("\n");
        menu.append("14. Formulários  *\t");
        menu.append("15. Funções      *\t");
        menu.append("            *");
        menu.append("\n");
        menu.append("*************************************************************");
        menu.append("\n");
        menu.append("RELATÓRIOS:                                                 *");
        menu.append("\n");
        menu.append("16. Perfis       *\t");
        menu.append("17. Usuários     *\t");
        menu.append("18. Módulos *\t");
        menu.append("\n");
        menu.append("19. Formulários  *\t");
        menu.append("20. Funções      *\t");
        menu.append("            *");
        menu.append("\n");
        menu.append("*************************************************************");
        menu.append("\n");

        System.out.println(menu);
        try {
            acao = leitor.nextInt();
            defineAcaoMenu(acao);
        } catch (Exception e) {
            System.out.println("Termo inválido, tente novamente selecionando uma das opções abaixo:");
            showMenu();
        }
    }
   /**
    * Define a ação que será tomada com base na escolha realizada pelo 
    * menu.
    * 
    * @author Fabricio Nogueira
    * @since 19-Mar-2013    
    * @version 1.0.0
    * @return void
    */
    private static void defineAcaoMenu(int acao) {
        switch (acao) {
            case CADASTRA_PERFIL:
                try {
                    PerfilView perfilView = new PerfilView();
                    perfilView.leitorPerfil();
                } catch (Exception e) {
                    System.out.println("Termo inválido, tente novamente selecionando uma das opções abaixo:");
                    showMenu();
                }
                break;
            case CADASTRAR_USUARIO:
                System.out.println("Cadastro de usuário");
                break;
            case CADASTRAR_MODULO:
                System.out.println("Cadastro de modulos");
                break;
            case CADASTRAR_FORMULARIO:
                System.out.println("Cadastro de formulários");
                break;
            case CADASTRAR_FUNCAO:
                System.out.println("Cadastro de funções");
                break;
            case EDITAR_PERFIL:
                System.out.println("Edição de perfil");
                break;
            case EDITAR_USUARIO:
                System.out.println("Edição de usuário");
                break;
            case EDITAR_MODULO:
                System.out.println("Edição de módulos");
                break;
            case EDITAR_FORMULARIO:
                System.out.println("Edição de Formulários");
                break;
            case EDITAR_FUNCAO:
                System.out.println("Edição de funções");
                break;
            case EXCLUIR_PERFIL:
                System.out.println("Exclusão de perfil");
                break;
            case EXCLUIR_USUARIO:
                System.out.println("Exclusão de usuário");
                break;
            case EXCLUIR_MODULO:
                System.out.println("Exclusão de módulos");
                break;
            case EXCLUIR_FORMULARIO:
                System.out.println("Exclusão de formulários");
                break;
            case EXCLUIR_FUNCAO:
                System.out.println("Exclusão de funções");
                break;
            case LISTAR_PERFIL:
                System.out.println("Relatório de perfis");
                break;
            case LISTAR_USUARIO:
                System.out.println("Relatório de usuários");
                break;
            case LISTAR_MODULO:
                System.out.println("Relatório de módulos");
                break;
            case LISTAR_FORMULARIO:
                System.out.println("Relatório de formulários");
                break;
            case LISTAR_FUNCAO:
                System.out.println("Relatório de funções");
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenu();
        }
    }
}
