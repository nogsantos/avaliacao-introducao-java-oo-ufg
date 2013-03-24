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
    /*
     * Definindo a quantidade de colunas
     */
    private static final int QTD_COL_EXTERIOR     = 66;
    private static final int QTD_COL_INTERIOR     = 65;
    private static final int QTD_COL_OPCOES       = 32;
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
                "PERFIL::SELECIONE ABAIXO A OPÇÃO DESEJADA ", 
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
                "2. Editar um perfil",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 3. Excluir um perfil", 
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "4. Listar perfis", 
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
        System.out.println(menu);
        intAcao = leitor.nextInt();
        defineAcaoMenuPerfil(intAcao);
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
    private void defineAcaoMenuPerfil(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case EDITAR:
                /*
                 * Listando perfis cadastrados
                 */
                PerfilService editarPerfil = new PerfilService();
                editarPerfil.listarPerfis();
                /*
                 * Menu com as opções de edição
                 */
                MenuPerfil editarMenuPerfil = new MenuPerfil();
                editarMenuPerfil.edicaoMenuPerfil();
                break;
            case EXCLUIR:
                /*
                 * Listando perfis cadastrados
                 */
                PerfilService excluirPerfil = new PerfilService();
                excluirPerfil.listarPerfis();
                /*
                 * Menu com as opções de exclusão
                 */
                MenuPerfil excluirMenuPerfil = new MenuPerfil();
                excluirMenuPerfil.exclusaoMenuPerfil();
                break;
            case LISTAR:
                /*
                 * Listagem dos perfis
                 */
                PerfilService perfil = new PerfilService();
                perfil.listarPerfis();
                /*
                 * Menu listagem
                 */
                listagemMenuPerfil();
                break;
            case CONTINUAR:
                PerfilView perfilView = new PerfilView();
                perfilView.leitorCadastroPerfil();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuPerfil();
                break;
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
                " ", 
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
        System.out.println(menu);
        intAcao = leitor.nextInt();
        defineAcaoMenuPerfilError(intAcao);
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
    private void defineAcaoMenuPerfilError(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case CONTINUAR:
                PerfilView perfilView = new PerfilView();
                perfilView.leitorCadastroPerfil();
                break;
                case SAIR:
                    System.exit(0);
                    break;
            default:
                showMenuPerfilError();
        }
    }
    /**
     *
     * Menu principal perfil para listagem.
     * 
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     * 
     */
    public void listagemMenuPerfil(){
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
        System.out.println(menu);
        intAcao = leitor.nextInt();
        defineAcaoListagemMenuPerfil(intAcao);
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
    private void defineAcaoListagemMenuPerfil(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case CONTINUAR:
                PerfilView perfilView = new PerfilView();
                perfilView.leitorCadastroPerfil();
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
     * Menu principal perfil para listagem.
     * 
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     * 
     */
    public void edicaoMenuPerfil(){
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
                "EDIÇÃO::Informe Código dor perfil desejado",
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
        System.out.println(menu);
        strAcao = leitor.nextLine().toString().toLowerCase();
        defineAcaoEdicaoMenuPerfil(strAcao);
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
    private void defineAcaoEdicaoMenuPerfil(String strAcao) {
        Integer codigoPerfil;
        if(strAcao.equals("c")) {
            showMenuPerfil();
        }else{
            codigoPerfil = Integer.parseInt(strAcao);
            PerfilView leitorPerfil = new PerfilView();
            leitorPerfil.leitorEdicaoPerfil(codigoPerfil);
        }
    }
    /**
     *
     * Menu principal perfil para listagem.
     * 
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     * 
     */
    public void exclusaoMenuPerfil(){
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
                "EXCLUSÃO::Informe Código dor perfil desejado",
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
        System.out.println(menu);
        strAcao = leitor.nextLine().toString().toLowerCase();
        defineAcaoExclusaoMenuPerfil(strAcao);
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
    private void defineAcaoExclusaoMenuPerfil(String strAcao) {
        Integer codigoPerfil;
        if(strAcao.equals("c")) {
            showMenuPerfil();
        }else{
            codigoPerfil = Integer.parseInt(strAcao);
            PerfilView leitorPerfil = new PerfilView();
            leitorPerfil.leitorExclusaoPerfil(codigoPerfil);
        }
    }
}