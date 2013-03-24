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
    /*
     * Definindo a quantidade de colunas
     */
    private static final int QTD_COL_EXTERIOR     = 66;
    private static final int QTD_COL_INTERIOR     = 65;
    private static final int QTD_COL_OPCOES       = 21;
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
        /*
         * Titulo
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "MENU PRINCIPAL ",
                "*",
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Sub-titulo
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "Digite o número da opção desejada:",
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        /*
         * Linha inferior titulo
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "*", 
                "*",
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Opções do menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "0. Encerrar Sistema ", 
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "*", 
                "*",
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Grupo Cadastros
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "CADASTROS", 
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "1. Perfil", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 2. Usuário", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 3. Módulo",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "4. Formulário", 
                " ",
                QTD_COL_OPCOES
                )
            ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 5. Funções", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(" ", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "*", 
                "*",
                QTD_COL_EXTERIOR 
            )
        ).append("\n");
        /*
         * Edição
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "EDIÇÃO", 
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "6. Perfil", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 7. Usuário", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 8. Módulo", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "9. Formulário", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 10. Funções", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " ", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "*",
                "*",
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Exclusão
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "EXCLUSÃO", 
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "11. Perfil", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 12. Usuário", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 13. Módulo", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "14. Formulário", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 15. Funções", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " ", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "*",
                "*",
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Listagens
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "LISTAGENS", 
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "16. Perfil", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 17. Usuário", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 18. Módulo", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "19. Formulário",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 20. Funções", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " ", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        /*
         * Linha final menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "*", 
                "*",
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Impressão do menu
         */
        System.out.println(menu);
        acao = leitor.nextInt();
        defineAcaoMenu(acao);
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
                PerfilView perfilView = new PerfilView();
                perfilView.leitorCadastroPerfil();
                break;
            case CADASTRAR_USUARIO:
                System.err.println("Cadastro de usuário - Não Implementado");
                break;
            case CADASTRAR_MODULO:
                System.err.println("Cadastro de modulos  - Não Implementado");
                break;
            case CADASTRAR_FORMULARIO:
                System.err.println("Cadastro de formulários - Não Implementado");
                break;
            case CADASTRAR_FUNCAO:
                System.err.println("Cadastro de funções - Não Implementado");
                break;
            case EDITAR_PERFIL:
                PerfilService editarPerfil = new PerfilService();
                editarPerfil.listarPerfis();
                MenuPerfil editarMenuPerfil = new MenuPerfil();
                editarMenuPerfil.edicaoMenuPerfil();
                break;
            case EDITAR_USUARIO:
                System.err.println("Edição de usuário - Não Implementado");
                break;
            case EDITAR_MODULO:
                System.err.println("Edição de módulos - Não Implementado");
                break;
            case EDITAR_FORMULARIO:
                System.err.println("Edição de Formulários - Não Implementado");
                break;
            case EDITAR_FUNCAO:
                System.err.println("Edição de funções - Não Implementado");
                break;
            case EXCLUIR_PERFIL:
                PerfilService excluirPerfil = new PerfilService();
                excluirPerfil.listarPerfis();
                MenuPerfil excluirMenuPerfil = new MenuPerfil();
                excluirMenuPerfil.exclusaoMenuPerfil();
                break;
            case EXCLUIR_USUARIO:
                System.err.println("Exclusão de usuário - Não Implementado");
                break;
            case EXCLUIR_MODULO:
                System.err.println("Exclusão de módulos - Não Implementado");
                break;
            case EXCLUIR_FORMULARIO:
                System.err.println("Exclusão de formulários - Não Implementado");
                break;
            case EXCLUIR_FUNCAO:
                System.err.println("Exclusão de funções - Não Implementado");
                break;
            case LISTAR_PERFIL:
                PerfilService listarPerfil = new PerfilService();
                listarPerfil.listarPerfis();
                MenuPerfil listarMenuPerfil = new MenuPerfil();
                listarMenuPerfil.listagemMenuPerfil();
                break;
            case LISTAR_USUARIO:
                System.err.println("Relatório de usuários - Não Implementado");
                break;
            case LISTAR_MODULO:
                System.err.println("Relatório de módulos - Não Implementado");
                break;
            case LISTAR_FORMULARIO:
                System.err.println("Relatório de formulários - Não Implementado");
                break;
            case LISTAR_FUNCAO:
                System.err.println("Relatório de funções - Não Implementado");
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenu();
        }
    }
}
