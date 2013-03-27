/**
 *
 * Descrição:Classe MenuFuncao
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 27-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;

import java.util.Scanner;
import static projeto.app.MenuPrincipal.showMenu;
import projeto.utils.ProjetoStringUtils;


public class MenuFuncao {

    
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
    public void showMenuFuncao() {
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
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Titulo
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "FUNÇÃO::SELECIONE ABAIXO A OPÇÃO DESEJADA ",
                " ",
                QTD_COL_INTERIOR
            )
        ).append("*").append("\n");
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
                "2. Editar uma função",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 3. Excluir uma função",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "4. Listar funções",
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
        menu.append(ProjetoStringUtils.rpad("*", "*", QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            intAcao = leitor.nextInt();
            defineAcaoMenuFuncao(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            showMenuFuncao();
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
    private void defineAcaoMenuFuncao(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case EDITAR:
                /*
                 * Listando funções cadastrados
                 */
                FuncaoService editarFuncao = new FuncaoService();
                editarFuncao.listar();
                /*
                 * Menu com as opções de edição
                 */
                MenuFuncao editarMenuFuncao = new MenuFuncao();
                editarMenuFuncao.edicaoMenuFuncao();
                break;
            case EXCLUIR:
                /*
                 * Listando as funçoes cadastrados
                 */
                FuncaoService excluirFuncao = new FuncaoService();
                excluirFuncao.listar();
                /*
                 * Menu com as opções de exclusão
                 */
                MenuFuncao excluirMenuFuncao = new MenuFuncao();
                excluirMenuFuncao.exclusaoMenuFuncao();
                break;
            case LISTAR:
                /*
                 * Listagem das funções
                 */
                FuncaoService funcao = new FuncaoService();
                funcao.listar();
                /*
                 * Menu listagem
                 */
                listagemMenuFuncao();
                break;
            case CONTINUAR:
                FuncaoView funcaoView = new FuncaoView();
                funcaoView.leitorCadastroFuncao();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuFuncao();
                break;
        }
    }
    /**
     *
     * Menu principal funcao error.
     * Gera opções quando um erro no cadastro foi gerado.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void showMenuFuncaoError() {
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
        menu.append(ProjetoStringUtils.rpad("*", "*", QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            intAcao = leitor.nextInt();
            defineAcaoMenuFuncaoError(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            showMenuFuncaoError();
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
    private void defineAcaoMenuFuncaoError(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case CONTINUAR:
                FuncaoView funcaoView = new FuncaoView();
                funcaoView.leitorCadastroFuncao();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuFuncaoError();
        }
    }
    /**
     *
     * Menu principal funcao para listagem.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void listagemMenuFuncao() {
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
         * Linha final do menu
         */
        menu.append(ProjetoStringUtils.rpad("*", "*", QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            intAcao = leitor.nextInt();
            defineAcaoListagemMenuFuncao(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            listagemMenuFuncao();
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
    private void defineAcaoListagemMenuFuncao(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case CONTINUAR:
                FuncaoView funcaoView = new FuncaoView();
                funcaoView.leitorCadastroFuncao();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuFuncao();
        }
    }
    /**
     *
     * Menu principal funcao para listagem.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void edicaoMenuFuncao() {
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
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Titulo Menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "EDIÇÃO::Informe Código da funcao desejado",
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
        menu.append(ProjetoStringUtils.rpad("*", "*", QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            strAcao = leitor.nextLine().toString().toLowerCase();
            defineAcaoEdicaoMenuFuncao(strAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            edicaoMenuFuncao();
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
    private void defineAcaoEdicaoMenuFuncao(String strAcao) {
        Integer codigoFuncao;
        if (strAcao.equals("c")) {
            showMenuFuncao();
        } else {
            codigoFuncao = Integer.parseInt(strAcao);
            FuncaoView leitorFuncao = new FuncaoView();
            leitorFuncao.leitorEdicaoFuncao(codigoFuncao);
        }
    }
    /**
     *
     * Menu principal funcao para listagem.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void exclusaoMenuFuncao() {
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
                QTD_COL_EXTERIOR
            )
        ).append("\n");
        /*
         * Opções do menu
         */
        menu.append(
            ProjetoStringUtils.rpad(
                "EXCLUSÃO::Informe Código da funcao desejado",
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
        menu.append(ProjetoStringUtils.rpad("*", "*", QTD_COL_EXTERIOR));
        /*
         * Impressão do menu
         */
        try {
            System.out.println(menu);
            strAcao = leitor.nextLine().toString().toLowerCase();
            defineAcaoExclusaoMenuFuncao(strAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            exclusaoMenuFuncao();
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
    private void defineAcaoExclusaoMenuFuncao(String strAcao) {
        Integer codigoFuncao;
        if (strAcao.equals("c")) {
            showMenuFuncao();
        } else {
            codigoFuncao = Integer.parseInt(strAcao);
            FuncaoView leitorFuncao = new FuncaoView();
            leitorFuncao.leitorExclusaoFuncao(codigoFuncao);
        }
    }
}
