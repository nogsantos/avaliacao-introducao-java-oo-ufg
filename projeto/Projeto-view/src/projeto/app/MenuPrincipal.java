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
import projeto.pessoas.MenuPerfil;
import projeto.pessoas.PerfilService;
import projeto.pessoas.PerfilView;
import projeto.utils.ProjetoStringUtils;


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

        menu.append(ProjetoStringUtils.rpad("MENU PRINCIPAL ",
                "*",66)).append("\n");
        menu.append(ProjetoStringUtils.rpad("Digite o número da opção desejada:"
                + " ", " ",65)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("*", 
                "*",66)).append("\n");
        menu.append(ProjetoStringUtils.rpad("0. Encerrar Sistema ", 
                " ",65)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("*", "*",66)).append("\n");
        menu.append(ProjetoStringUtils.rpad("CADASTROS", 
                " ",65)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("1. Perfil", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 2. Usuário", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 3. Módulo",
                " ",21)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("4. Formulário", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 5. Funções", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" ", 
                " ",21)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("*", 
                "*",66)).append("\n");
        menu.append(ProjetoStringUtils.rpad("EDIÇÃO", 
                " ",65)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("6. Perfil", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 7. Usuário", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 8. Módulo", 
                " ",21)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("9. Formulário", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 10. Funções", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" ", 
                " ",21)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("*",
                "*",66)).append("\n");
        menu.append(ProjetoStringUtils.rpad("EXCLUSÃO", 
                " ",65)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("11. Perfil", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 12. Usuário", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 13. Módulo", 
                " ",21)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("14. Formulário", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 15. Funções", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" ", 
                " ",21)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("*",
                "*",66)).append("\n");
        menu.append(ProjetoStringUtils.rpad("RELATÓRIOS", 
                " ",65)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("16. Perfil", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 17. Usuário", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 18. Módulo", 
                " ",21)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("19. Formulário",
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" 20. Funções", 
                " ",21)).append("*");
        menu.append(ProjetoStringUtils.rpad(" ", 
                " ",21)).append("*").append("\n");
        menu.append(ProjetoStringUtils.rpad("*", 
                "*",66)).append("\n");
        System.out.println(menu);
        try {
            acao = leitor.nextInt();
            defineAcaoMenu(acao);
        } catch (Exception e) {
            System.out.println("##ERRO:: Opção Inválida");
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
                    perfilView.leitorCadastroPerfil();
                } catch (Exception e) {
                    System.out.println("##ERRO:: Opção Inválida");
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
                PerfilService editarPerfil = new PerfilService();
                editarPerfil.listarPerfis();
                MenuPerfil editarMenuPerfil = new MenuPerfil();
                editarMenuPerfil.edicaoMenuPerfil();
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
                PerfilService excluirPerfil = new PerfilService();
                excluirPerfil.listarPerfis();
                MenuPerfil excluirMenuPerfil = new MenuPerfil();
                excluirMenuPerfil.exclusaoMenuPerfil();
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
                PerfilService listarPerfil = new PerfilService();
                listarPerfil.listarPerfis();
                MenuPerfil listarMenuPerfil = new MenuPerfil();
                listarMenuPerfil.listagemMenuPerfil();
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
