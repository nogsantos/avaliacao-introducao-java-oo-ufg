/**
 *
 * Descrição:Classe MenuUsuario
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 28-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.pessoas;

import java.util.Scanner;
import static projeto.app.MenuPrincipal.showMenu;
import projeto.utils.ProjetoStringUtils;


public class MenuUsuario {

    private static final int SAIR           = 0;
    private static final int MENU_INICIAL   = 1;
    private static final int EDITAR         = 2;
    private static final int EXCLUIR        = 3;
    private static final int LISTAR         = 4;
    private static final int CONTINUAR      = 5;
    private static final int DEFINIR_PERFIL = 6;
    /*
     * Definindo a quantidade de colunas
     */
    private static final int QTD_COL_EXTERIOR = 66;
    private static final int QTD_COL_INTERIOR = 65;
    private static final int QTD_COL_OPCOES   = 32;
    /**
     *
     * Menu principal usuario.
     * Gera opções após o cadastro realizado com sucesso.
     * 
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     * 
     */
    public void showMenuUsuario(){
        Scanner leitor     = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        Integer intAcao;
        /*
         * Linha superior titulo
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "*", 
                "*",
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Titulo
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "USUÁRIO::SELECIONE ABAIXO A OPÇÃO DESEJADA ", 
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        /*
         * Linha inferiro titulo
         */
        menu.append(ProjetoStringUtils.rpad("*", "*",QTD_COL_EXTERIOR)).append("\n");
        /*
         * Opções o menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "0. Encerrar Sistema",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 1. Retornar ao menu inicial",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "2. Editar um usuário",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 3. Excluir um usuário", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "4. Listar usuários", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 5. Continuar cadastro", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        /*
         * Linha final menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*",QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            intAcao = leitor.nextInt();
            defineAcaoMenuUsuario(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO::" + e.getMessage());
            showMenuUsuario();
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
    private void defineAcaoMenuUsuario(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case EDITAR:
                /*
                 * Listando perfis cadastrados
                 */
                UsuarioService editarUsuario = new UsuarioService();
                editarUsuario.listagemSimples();
                /*
                 * Menu com as opções de edição
                 */
                MenuUsuario editarMenuUsuario = new MenuUsuario();
                editarMenuUsuario.edicaoMenuUsuario();
                break;
            case EXCLUIR:
                /*
                 * Listando perfis cadastrados
                 */
                UsuarioService excluirUsuario = new UsuarioService();
                excluirUsuario.listagemSimples();
                /*
                 * Menu com as opções de exclusão
                 */
                MenuUsuario excluirMenuUsuario = new MenuUsuario();
                excluirMenuUsuario.exclusaoMenuUsuario();
                break;
            case LISTAR:
                /*
                 * Listagem dos perfis
                 */
                UsuarioService usuario = new UsuarioService();
                usuario.listar();
                /*
                 * Menu listagem
                 */
                listagemMenuUsuario();
                break;
            case CONTINUAR:
                UsuarioView usuarioView = new UsuarioView();
                usuarioView.leitorCadastroUsuario();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuUsuario();
                break;
        }
    }
    /**
     *
     * Menu principal usuario error.
     * Gera opções quando um erro no cadastro foi gerado. 
     * 
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     * 
     */
    public void showMenuUsuarioError(){
        Scanner leitor     = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        Integer intAcao;
        /*
         * Linha superiro titulo menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "*", 
                "*",
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Titulo Menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "##ERRO::SELECIONE ABAIXO A OPÇÃO DESEJADA ", 
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        /*
         * Linha inferior titulo menu
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
                "0. Encerrar Sistema",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 1. Retornar ao menu inicial",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "5. Continuar cadastro", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                "6. Definir perfil", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        /*
         * Linha final menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*",QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            intAcao = leitor.nextInt();
            defineAcaoMenuUsuarioError(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO::" + e.getMessage());
            showMenuUsuarioError();
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
    private void defineAcaoMenuUsuarioError(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case CONTINUAR:
                UsuarioView usuarioView = new UsuarioView();
                usuarioView.leitorCadastroUsuario();
                break;
            case DEFINIR_PERFIL:
                UsuarioPerfilView usuarioPerfilView = new UsuarioPerfilView();
                
                break;
                case SAIR:
                    System.exit(0);
                    break;
            default:
                showMenuUsuarioError();
        }
    }
    /**
     *
     * Menu principal usuario para listagem.
     * 
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     * 
     */
    public void listagemMenuUsuario(){
        Scanner leitor     = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        Integer intAcao;
        /*
         * Linha superior titulo menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "*", 
                "*",
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Titulo do menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "LISTAGEM::SELECIONE ABAIXO A OPÇÃO DESEJADA ", 
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        /*
         * Linha inferior titulo menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*",QTD_COL_EXTERIOR)).append("\n");
        /*
         * Opções do menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "0. Encerrar Sistema",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 1. Retornar ao menu inicial",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "5. Continuar cadastro", 
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
         * Linha final do menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*",QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            intAcao = leitor.nextInt();
            defineAcaoListagemMenuUsuario(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO::" + e.getMessage());
            listagemMenuUsuario();
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
    private void defineAcaoListagemMenuUsuario(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case CONTINUAR:
                UsuarioView usuarioView = new UsuarioView();
                usuarioView.leitorCadastroUsuario();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuUsuario();
        }
    }
    /**
     *
     * Menu principal usuario para listagem.
     * 
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     * 
     */
    public void edicaoMenuUsuario(){
        Scanner leitor     = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        String strAcao;
        /*
         * Linha superior titulo menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "*", 
                "*",
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Titulo Menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "EDIÇÃO::Informe Cpf do usuário",
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        /*
         * Opções Menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "ou a letra 'C' para Cancelar",
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        /*
         * Linha Final menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*",QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            strAcao = leitor.nextLine().toString().toLowerCase();
            defineAcaoEdicaoMenuUsuario(strAcao);
        } catch (Exception e) {
            System.err.println("##ERRO::" + e.getMessage());
            edicaoMenuUsuario();
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
    private void defineAcaoEdicaoMenuUsuario(String strAcao) {
        if(strAcao.equals("c")) {
            showMenuUsuario();
        }else{
            UsuarioView leitorUsuario = new UsuarioView();
            leitorUsuario.leitorEdicaoUsuario(strAcao);
        }
    }
    /**
     *
     * Menu principal usuario para listagem.
     * 
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     * 
     */
    public void exclusaoMenuUsuario(){
        Scanner leitor     = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        String strAcao;
        /*
         * Linha superior titulo menu
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
                "EXCLUSÃO::Informe Código do usuário",
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "ou a letra 'C' para Cancelar",
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
        /*
         * Linha final do menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*",QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            strAcao = leitor.nextLine().toString().toLowerCase();
            defineAcaoExclusaoMenuUsuario(strAcao);
        } catch (Exception e) {
            System.err.println("##ERRO::" + e.getMessage());
            exclusaoMenuUsuario();
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
    private void defineAcaoExclusaoMenuUsuario(String strAcao) {
        if(strAcao.equals("c")) {
            showMenuUsuario();
        }else{
            UsuarioView leitorUsuario = new UsuarioView();
            leitorUsuario.leitorExclusaoUsuario(strAcao);
        }
    }

}
