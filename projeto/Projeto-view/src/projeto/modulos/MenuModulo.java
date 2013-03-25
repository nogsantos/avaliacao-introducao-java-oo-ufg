/**
 *
 * Descrição:Classe MenuModulo
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 21-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;

import java.util.Scanner;
import static projeto.app.MenuPrincipal.showMenu;
import projeto.utils.ProjetoStringUtils;


public class MenuModulo {

    private static final int SAIR = 0;
    private static final int MENU_INICIAL = 1;
    private static final int EDITAR = 2;
    private static final int EXCLUIR = 3;
    private static final int LISTAR = 4;
    private static final int CONTINUAR = 5;
    /*
     * Definindo a quantidade de colunas
     */
    private static final int QTD_COL_EXTERIOR = 66;
    private static final int QTD_COL_INTERIOR = 65;
    private static final int QTD_COL_OPCOES = 32;

    /**
     *
     * Menu principal módulo.
     * Gera opções após o cadastro realizado com sucesso.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void showMenuModulo() {
        Scanner leitor = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        Integer intAcao;
        /*
         * Linha superior titulo
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "*",
                "*",
                QTD_COL_EXTERIOR)).append("\n");
        /*
         * Titulo
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "MODULO::SELECIONE ABAIXO A OPÇÃO DESEJADA ",
                " ",
                QTD_COL_INTERIOR)).append("*").append("\n");
        /*
         * Linha inferiro titulo
         */
        menu.append(ProjetoStringUtils.rpad("*", "*", QTD_COL_EXTERIOR)).append("\n");
        /*
         * Opções o menu
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "0. Encerrar Sistema",
                " ",
                QTD_COL_OPCOES)).append("*");
        menu.append(
                ProjetoStringUtils.rpad(
                " 1. Retornar ao menu inicial",
                " ",
                QTD_COL_OPCOES)).append("*").append("\n");
        menu.append(
                ProjetoStringUtils.rpad(
                "2. Editar um módulo",
                " ",
                QTD_COL_OPCOES)).append("*");
        menu.append(
                ProjetoStringUtils.rpad(
                " 3. Excluir um módulo",
                " ",
                QTD_COL_OPCOES)).append("*").append("\n");
        menu.append(
                ProjetoStringUtils.rpad(
                "4. Listar módulos",
                " ",
                QTD_COL_OPCOES)).append("*");
        menu.append(
                ProjetoStringUtils.rpad(
                " 5. Continuar cadastro",
                " ",
                QTD_COL_OPCOES)).append("*").append("\n");
        /*
         * Linha final menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*", QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            intAcao = leitor.nextInt();
            defineAcaoMenuModulo(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            showMenuModulo();
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
    private void defineAcaoMenuModulo(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case EDITAR:
                /*
                 * Listando perfis cadastrados
                 */
                ModuloService editarModulo = new ModuloService();
                editarModulo.listar();
                /*
                 * Menu com as opções de edição
                 */
                MenuModulo editarMenuModulo = new MenuModulo();
                editarMenuModulo.edicaoMenuModulo();
                break;
            case EXCLUIR:
                /*
                 * Listando perfis cadastrados
                 */
                ModuloService excluirModulo = new ModuloService();
                excluirModulo.listar();
                /*
                 * Menu com as opções de exclusão
                 */
                MenuModulo excluirMenuModulo = new MenuModulo();
                excluirMenuModulo.exclusaoMenuModulo();
                break;
            case LISTAR:
                /*
                 * Listagem dos perfis
                 */
                ModuloService modulo = new ModuloService();
                modulo.listar();
                /*
                 * Menu listagem
                 */
                listagemMenuModulo();
                break;
            case CONTINUAR:
                ModuloView moduloView = new ModuloView();
                moduloView.leitorCadastroModulo();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuModulo();
                break;
        }
    }

    /**
     *
     * Menu principal modulo error.
     * Gera opções quando um erro no cadastro foi gerado.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void showMenuModuloError() {
        Scanner leitor = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        Integer intAcao;
        /*
         * Linha superiro titulo menu
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "*",
                "*",
                QTD_COL_EXTERIOR)).append("\n");
        /*
         * Titulo Menu
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "##ERRO::SELECIONE ABAIXO A OPÇÃO DESEJADA ",
                " ",
                QTD_COL_INTERIOR)).append("*").append("\n");
        /*
         * Linha inferior titulo menu
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "*",
                "*",
                QTD_COL_EXTERIOR)).append("\n");
        /*
         * Opções do menu
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "0. Encerrar Sistema",
                " ",
                QTD_COL_OPCOES)).append("*");
        menu.append(
                ProjetoStringUtils.rpad(
                " 1. Retornar ao menu inicial",
                " ",
                QTD_COL_OPCOES)).append("*").append("\n");
        menu.append(
                ProjetoStringUtils.rpad(
                "5. Continuar cadastro",
                " ",
                QTD_COL_OPCOES)).append("*");
        menu.append(
                ProjetoStringUtils.rpad(
                " ",
                " ",
                QTD_COL_OPCOES)).append("*").append("\n");
        /*
         * Linha final menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*", QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            intAcao = leitor.nextInt();
            defineAcaoMenuModuloError(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            showMenuModuloError();
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
    private void defineAcaoMenuModuloError(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case CONTINUAR:
                ModuloView moduloView = new ModuloView();
                moduloView.leitorCadastroModulo();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuModuloError();
        }
    }

    /**
     *
     * Menu principal modulo para listagem.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void listagemMenuModulo() {
        Scanner leitor = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        Integer intAcao;
        /*
         * Linha superior titulo menu
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "*",
                "*",
                QTD_COL_EXTERIOR)).append("\n");
        /*
         * Titulo do menu
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "LISTAGEM::SELECIONE ABAIXO A OPÇÃO DESEJADA ",
                " ",
                QTD_COL_INTERIOR)).append("*").append("\n");
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
                QTD_COL_OPCOES)).append("*");
        menu.append(
                ProjetoStringUtils.rpad(
                " 1. Retornar ao menu inicial",
                " ",
                QTD_COL_OPCOES)).append("*").append("\n");
        menu.append(
                ProjetoStringUtils.rpad(
                "5. Continuar cadastro",
                " ",
                QTD_COL_OPCOES)).append("*");
        menu.append(
                ProjetoStringUtils.rpad(
                " ",
                " ",
                QTD_COL_OPCOES)).append("*").append("\n");
        /*
         * Linha final do menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*", QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            intAcao = leitor.nextInt();
            defineAcaoListagemMenuModulo(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            listagemMenuModulo();
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
    private void defineAcaoListagemMenuModulo(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case CONTINUAR:
                ModuloView moduloView = new ModuloView();
                moduloView.leitorCadastroModulo();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuModulo();
        }
    }

    /**
     *
     * Menu principal modulo para listagem.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void edicaoMenuModulo() {
        Scanner leitor = new Scanner(System.in);
        StringBuilder menu = new StringBuilder();
        String strAcao;
        /*
         * Linha superior titulo menu
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "*",
                "*",
                QTD_COL_EXTERIOR)).append("\n");
        /*
         * Titulo Menu
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "EDIÇÃO::Informe Código dor modulo desejado",
                " ",
                QTD_COL_INTERIOR)).append("*").append("\n");
        /*
         * Opções Menu
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "ou a letra 'C' para Cancelar",
                " ",
                QTD_COL_INTERIOR)).append("*").append("\n");
        /*
         * Linha Final menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*", QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            strAcao = leitor.nextLine().toString().toLowerCase();
            defineAcaoEdicaoMenuModulo(strAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            edicaoMenuModulo();
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
    private void defineAcaoEdicaoMenuModulo(String strAcao) {
        Integer codigoModulo;
        if (strAcao.equals("c")) {
            showMenuModulo();
        } else {
            codigoModulo = Integer.parseInt(strAcao);
            ModuloView leitorModulo = new ModuloView();
            leitorModulo.leitorEdicaoModulo(codigoModulo);
        }
    }

    /**
     *
     * Menu principal modulo para listagem.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void exclusaoMenuModulo() {
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
                QTD_COL_EXTERIOR)).append("\n");
        /*
         * Opções do menu
         */
        menu.append(
                ProjetoStringUtils.rpad(
                "EXCLUSÃO::Informe Código dor modulo desejado",
                " ",
                QTD_COL_INTERIOR)).append("*").append("\n");
        menu.append(
                ProjetoStringUtils.rpad(
                "ou a letra 'C' para Cancelar",
                " ",
                QTD_COL_INTERIOR)).append("*").append("\n");
        /*
         * Linha final do menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*", QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            strAcao = leitor.nextLine().toString().toLowerCase();
            defineAcaoExclusaoMenuModulo(strAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            exclusaoMenuModulo();
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
    private void defineAcaoExclusaoMenuModulo(String strAcao) {
        Integer codigoModulo;
        if (strAcao.equals("c")) {
            showMenuModulo();
        } else {
            codigoModulo = Integer.parseInt(strAcao);
            ModuloView leitorModulo = new ModuloView();
            leitorModulo.leitorExclusaoModulo(codigoModulo);
        }
    }

}
