/**
 *
 * Descrição:Classe MenuFormulario
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 26-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;

import java.util.Scanner;
import static projeto.app.MenuPrincipal.showMenu;
import projeto.utils.ProjetoStringUtils;

public class MenuFormulario {

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
    public void showMenuFormulario() {
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
                "FORMULÁRIO::SELECIONE ABAIXO A OPÇÃO DESEJADA ",
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
                "2. Editar um formulário",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*");
        menu.append(
            ProjetoStringUtils.rpad(
                " 3. Excluir um formulário",
                " ",
                QTD_COL_OPCOES
            )
        ).append("*").append("\n");
        menu.append(
            ProjetoStringUtils.rpad(
                "4. Listar formulários",
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
            defineAcaoMenuFormulario(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            showMenuFormulario();
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
    private void defineAcaoMenuFormulario(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case EDITAR:
                /*
                 * Listando perfis cadastrados
                 */
                FormularioService editarFormulario = new FormularioService();
                editarFormulario.listar();
                /*
                 * Menu com as opções de edição
                 */
                MenuFormulario editarMenuFormulario = new MenuFormulario();
                editarMenuFormulario.edicaoMenuFormulario();
                break;
            case EXCLUIR:
                /*
                 * Listando perfis cadastrados
                 */
                FormularioService excluirFormulario = new FormularioService();
                excluirFormulario.listar();
                /*
                 * Menu com as opções de exclusão
                 */
                MenuFormulario excluirMenuFormulario = new MenuFormulario();
                excluirMenuFormulario.exclusaoMenuFormulario();
                break;
            case LISTAR:
                /*
                 * Listagem dos perfis
                 */
                FormularioService formulario = new FormularioService();
                formulario.listar();
                /*
                 * Menu listagem
                 */
                listagemMenuFormulario();
                break;
            case CONTINUAR:
                FormularioView formularioView = new FormularioView();
                formularioView.leitorCadastroFormulario();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuFormulario();
                break;
        }
    }
    /**
     *
     * Menu principal formulario error.
     * Gera opções quando um erro no cadastro foi gerado.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void showMenuFormularioError() {
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
            defineAcaoMenuFormularioError(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            showMenuFormularioError();
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
    private void defineAcaoMenuFormularioError(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case CONTINUAR:
                FormularioView formularioView = new FormularioView();
                formularioView.leitorCadastroFormulario();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuFormularioError();
        }
    }
    /**
     *
     * Menu principal formulario para listagem.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void listagemMenuFormulario() {
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
            defineAcaoListagemMenuFormulario(intAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            listagemMenuFormulario();
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
    private void defineAcaoListagemMenuFormulario(int intAcao) {
        switch (intAcao) {
            case MENU_INICIAL:
                showMenu();
                break;
            case CONTINUAR:
                FormularioView formularioView = new FormularioView();
                formularioView.leitorCadastroFormulario();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenuFormulario();
        }
    }
    /**
     *
     * Menu principal formulario para listagem.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void edicaoMenuFormulario() {
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
                "EDIÇÃO::Informe Código dor formulario desejado",
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
            defineAcaoEdicaoMenuFormulario(strAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            edicaoMenuFormulario();
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
    private void defineAcaoEdicaoMenuFormulario(String strAcao) {
        Integer codigoFormulario;
        if (strAcao.equals("c")) {
            showMenuFormulario();
        } else {
            codigoFormulario = Integer.parseInt(strAcao);
            FormularioView leitorFormulario = new FormularioView();
            leitorFormulario.leitorEdicaoFormulario(codigoFormulario);
        }
    }
    /**
     *
     * Menu principal formulario para listagem.
     *
     * @author Fabricio Nogueira
     * @since 20 MAR 2013
     *
     */
    public void exclusaoMenuFormulario() {
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
                "EXCLUSÃO::Informe Código do formulario desejado",
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
            defineAcaoExclusaoMenuFormulario(strAcao);
        } catch (Exception e) {
            System.err.println("##ERRO:: " + e.getMessage());
            exclusaoMenuFormulario();
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
    private void defineAcaoExclusaoMenuFormulario(String strAcao) {
        Integer codigoFormulario;
        if (strAcao.equals("c")) {
            showMenuFormulario();
        } else {
            codigoFormulario = Integer.parseInt(strAcao);
            FormularioView leitorFormulario = new FormularioView();
            leitorFormulario.leitorExclusaoFormulario(codigoFormulario);
        }
    }
}