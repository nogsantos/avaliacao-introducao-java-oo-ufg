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
import projeto.modulos.FormularioService;
import projeto.modulos.FormularioView;
import projeto.modulos.FuncaoService;
import projeto.modulos.FuncaoView;
import projeto.modulos.MenuFormulario;
import projeto.modulos.MenuFuncao;
import projeto.modulos.MenuModulo;
import projeto.modulos.ModuloService;
import projeto.modulos.ModuloView;
import projeto.pessoas.MenuPerfil;
import projeto.pessoas.MenuUsuario;
import projeto.pessoas.PerfilService;
import projeto.pessoas.PerfilView;
import projeto.pessoas.UsuarioService;
import projeto.pessoas.UsuarioView;
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
        Scanner leitor     = new Scanner(System.in);
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
        try {
            System.out.println(menu);
            acao = leitor.nextInt();
            defineAcaoMenu(acao);
        } catch (NullPointerException e) {
            System.err.println("##ERRO:: " + e.getMessage());
        } catch (Exception ex) {
            System.err.println("##ERRO:: Opção Inválida. ");
        } finally{
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
                PerfilView perfilView = new PerfilView();
                perfilView.leitorCadastroPerfil();
                break;
            case CADASTRAR_USUARIO:
                UsuarioView usuarioView = new UsuarioView();
                usuarioView.leitorCadastroUsuario();
                break;
            case CADASTRAR_MODULO:
                ModuloView moduloView = new ModuloView();
                moduloView.leitorCadastroModulo();
                break;
            case CADASTRAR_FORMULARIO:
                FormularioView formularioView = new FormularioView();
                formularioView.leitorCadastroFormulario();
                break;
            case CADASTRAR_FUNCAO:
                FuncaoView funcaoView = new FuncaoView();
                funcaoView.leitorCadastroFuncao();
                break;
            case EDITAR_PERFIL:
                PerfilService editarPerfil = new PerfilService();
                editarPerfil.listar();
                MenuPerfil editarMenuPerfil = new MenuPerfil();
                editarMenuPerfil.edicaoMenuPerfil();
                break;
            case EDITAR_USUARIO:
                UsuarioService editarUsuario = new UsuarioService();
                editarUsuario.listagemSimples();
                MenuUsuario editarMenuUsuario = new MenuUsuario();
                editarMenuUsuario.edicaoMenuUsuario();
                break;
            case EDITAR_MODULO:
                ModuloService editarModulo = new ModuloService();
                editarModulo.listar();
                MenuModulo editarMenuModulo = new MenuModulo();
                editarMenuModulo.edicaoMenuModulo();
                break;
            case EDITAR_FORMULARIO:
                FormularioService editarFormulario = new FormularioService();
                editarFormulario.listar();
                MenuFormulario editarMenuFormulario = new MenuFormulario();
                editarMenuFormulario.edicaoMenuFormulario();
                break;
            case EDITAR_FUNCAO:
                FuncaoService editarFuncao = new FuncaoService();
                editarFuncao.listar();
                MenuFuncao editarMenuFuncao = new MenuFuncao();
                editarMenuFuncao.edicaoMenuFuncao();
                break;
            case EXCLUIR_PERFIL:
                PerfilService excluirPerfil = new PerfilService();
                excluirPerfil.listar();
                MenuPerfil excluirMenuPerfil = new MenuPerfil();
                excluirMenuPerfil.exclusaoMenuPerfil();
                break;
            case EXCLUIR_USUARIO:
                UsuarioService excluirUsuario = new UsuarioService();
                excluirUsuario.listagemSimples();
                MenuUsuario excluirMenuUsuario = new MenuUsuario();
                excluirMenuUsuario.exclusaoMenuUsuario();
                break;
            case EXCLUIR_MODULO:
                ModuloService excluirModulo = new ModuloService();
                excluirModulo.listar();
                MenuModulo excluirMenuModulo = new MenuModulo();
                excluirMenuModulo.exclusaoMenuModulo();
                break;
            case EXCLUIR_FORMULARIO:
                FormularioService excluirFormulario = new FormularioService();
                excluirFormulario.listar();
                MenuFormulario excluirMenuFormulario = new MenuFormulario();
                excluirMenuFormulario.exclusaoMenuFormulario();
                break;
            case EXCLUIR_FUNCAO:
                FuncaoService excluirFuncao = new FuncaoService();
                excluirFuncao.listar();
                MenuFuncao excluirMenuFuncao = new MenuFuncao();
                excluirMenuFuncao.exclusaoMenuFuncao();
                break;
            case LISTAR_PERFIL:
                PerfilService listarPerfil = new PerfilService();
                listarPerfil.listar();
                MenuPerfil listarMenuPerfil = new MenuPerfil();
                listarMenuPerfil.listagemMenuPerfil();
                break;
            case LISTAR_USUARIO:
                UsuarioService listarUsuario = new UsuarioService();
                listarUsuario.listar();
                MenuUsuario listarMenuUsuario = new MenuUsuario();
                listarMenuUsuario.listagemMenuUsuario();
                break;
            case LISTAR_MODULO:
                ModuloService listarModulo = new ModuloService();
                listarModulo.listar();
                MenuModulo listarMenuModulo = new MenuModulo();
                listarMenuModulo.listagemMenuModulo();
                break;
            case LISTAR_FORMULARIO:
                FormularioService listarFormulario = new FormularioService();
                listarFormulario.listar();
                MenuFormulario listarMenuFormulario = new MenuFormulario();
                listarMenuFormulario.listagemMenuFormulario();
                break;
            case LISTAR_FUNCAO:
                FuncaoService listarFuncao = new FuncaoService();
                listarFuncao.listar();
                MenuFuncao listarMenuFuncao = new MenuFuncao();
                listarMenuFuncao.listagemMenuFuncao();
                break;
            case SAIR:
                System.exit(0);
                break;
            default:
                showMenu();
        }
    }
}
