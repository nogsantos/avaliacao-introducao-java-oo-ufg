/**
 *
 * Descrição:Classe Main
 *
 * @author Fabricio Nogueira
 *
 * @since 19-Mar-2013
 *
 * @version 1.0.0
 *
 */
package projeto.app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Selecione uma das opções abaixo digitando o número correspondente:");
        menu();
    }
   /**
    * Implementação do menu.
    * 
    * @author Fabricio Nogueira
    * @since 19-Mar-2013
    * @version 1.0.0
    * @return void
    */
    private static void menu() {
        Scanner leitor = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        Integer acao;

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
            menu();
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
            case 1:
                System.out.println("Cadastro de perfil");
                break;
            case 2:
                System.out.println("Cadastro de usuário");
                break;
            case 3:
                System.out.println("Cadastro de modulos");
                break;
            case 4:
                System.out.println("Cadastro de formulários");
                break;
            case 5:
                System.out.println("Cadastro de funções");
                break;
            case 6:
                System.out.println("Edição de perfil");
                break;
            case 7:
                System.out.println("Edição de usuário");
                break;
            case 8:
                System.out.println("Edição de módulos");
                break;
            case 9:
                System.out.println("Edição de Formulários");
                break;
            case 10:
                System.out.println("Edição de funções");
                break;
            case 11:
                System.out.println("Exclusão de perfil");
                break;
            case 12:
                System.out.println("Exclusão de usuário");
                break;
            case 13:
                System.out.println("Exclusão de módulos");
                break;
            case 14:
                System.out.println("Exclusão de formulários");
                break;
            case 15:
                System.out.println("Exclusão de funções");
                break;
            case 16:
                System.out.println("Relatório de perfis");
                break;
            case 17:
                System.out.println("Relatório de usuários");
                break;
            case 18:
                System.out.println("Relatório de módulos");
                break;
            case 19:
                System.out.println("Relatório de formulários");
                break;
            case 20:
                System.out.println("Relatório de funções");
                break;
            default:
                System.exit(0);
        }
    }
}
