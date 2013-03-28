/**
 *
 * Descrição:Classe UsuarioView
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
import projeto.utils.ProjetoStringUtils;


public class UsuarioView {
    /*
     * Instâncias
     */
    private MenuUsuario menuUsuario = new MenuUsuario();
    private Scanner leitor = new Scanner(System.in);
    /**
     * Formulário de cadastro de perfil.
     *
     * @author Fabricio Nogueira
     * @since 22-Mar-2013
     * @version 1.0.0
     * @return void
     */
    public void leitorCadastroUsuario() {
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::CADASTRO DE USUARIO",
                "*",
                66
            )
        );
        System.out.println("Cpf: ");
        String codigoPessoa = this.leitor.next();
        System.out.println("Nome: ");
        String nome = this.leitor.next();
        System.out.println("Logradouro: ");
        String logradouro = this.leitor.next();
        System.out.println("Telefone: ");
        String telefone = this.leitor.next();
        System.out.println("Email: ");
        String email = this.leitor.next();
        System.out.println("Login: ");
        String login = this.leitor.next();
        System.out.println("Senha: ");
        String senha = this.leitor.next();
        /*
         * Cadastrar
         */
        UsuarioService usuarioCadastrar = new UsuarioService(
            codigoPessoa,
            nome,
            logradouro,
            telefone,
            email,
            login,
            senha
        );
        String cadastro  = usuarioCadastrar.cadastrar();
        if (cadastro.equals("sucesso")) {
            System.out.println(
                ProjetoStringUtils.rpad(
                    "SUCESSO:: Dado inserido com sucesso.",
                    "*",
                    66
                )
            );
            this.menuUsuario.showMenuUsuario();
        } else {
            System.err.println(cadastro);
            this.menuUsuario.showMenuUsuarioError();
        }
    }
    /**
     * Formulário de edição de perfil.
     *
     * @author Fabricio Nogueira
     * @since 22-Mar-2013
     * @version 1.0.0
     * @return void
     */
    public void leitorEdicaoUsuario(Integer codigoPerfilLeitor) {
        /*
         * Titulo do formulário.
         */
        System.out.println(
                ProjetoStringUtils.rpad(
                "FORMULÁRIO::EDIÇÃO DE PERFIL ",
                "*",
                66));
        if (codigoPerfilLeitor >= 0) {
            /*
             * Leitura dos campos
             */
            Integer codigoPerfil = 0;
            String nome = null;
            String descricao = null;
            try {
                System.out.println("Codigo: " + codigoPerfilLeitor);
                codigoPerfil = codigoPerfilLeitor;
                System.out.println("Nome: ");
                nome = this.leitor.nextLine().toString();
                System.out.println("Descrição: ");
                descricao = this.leitor.nextLine().toString();
            } catch (Exception e) {
                System.err.println(
                        ProjetoStringUtils.rpad(
                        "##ERRO.PERFIL.VIEW.LEITORPERFIL ::Erro na leitura dos dados.",
                        "*",
                        66));
                this.menuUsuario.showMenuUsuarioError();
            }
            /*
             * Edição
             */
            PerfilService perfilEditar = new PerfilService(
                    codigoPerfil,
                    nome,
                    descricao);
            if (perfilEditar.editar()) {
                System.out.println(
                        ProjetoStringUtils.rpad(
                        "SUCESSO::Dado editado com sucesso.",
                        "*",
                        66));
                this.menuUsuario.showMenuUsuario();
            } else {
                System.err.println(
                        ProjetoStringUtils.rpad(
                        "***** O pefil informado não existe! ",
                        "*",
                        66));
                this.menuUsuario.showMenuUsuarioError();
            }
        } else {
            System.err.println(
                    ProjetoStringUtils.rpad(
                    "##ERRO.PERFIL.VIEW.LEITORPERFIL::CÓDIGO PERFIL INVÁLIDO",
                    "*",
                    66));
        }
    }

    /**
     * Formulário de exclusão de perfil.
     *
     * @author Fabricio Nogueira
     * @since 22-Mar-2013
     * @version 1.0.0
     * @return void
     */
    public void leitorExclusaoUsuario(Integer codigoPerfilLeitor) {
        String confirmacao;
        /*
         * Titulo do formulário
         */
        System.out.println(
                ProjetoStringUtils.rpad(
                "FORMULÁRIO::EXCLUSÃO DE PERFIL ",
                "*",
                66));
        if (codigoPerfilLeitor >= 0) {
            /*
             * Confirmação da exclusão
             */
            System.out.println(
                    "Confirma a exclusão do perfil de Codigo = "
                    + codigoPerfilLeitor + " (S/N)?");
            confirmacao = this.leitor.nextLine().toString();
            switch (confirmacao) {
                case "s":
                case "S":
                    Integer codigoPerfil = codigoPerfilLeitor;
                    PerfilService perfilExcluir = new PerfilService(
                            codigoPerfil);
                    if (perfilExcluir.excluir()) {
                        System.out.println(
                                ProjetoStringUtils.rpad(
                                "SUCESSO::Dado excluído com sucesso.",
                                "*",
                                66));
                        this.menuUsuario.showMenuUsuario();
                    } else {
                        System.err.println(
                                ProjetoStringUtils.rpad(
                                "***** O pefil informado não existe! ",
                                "*",
                                66));
                        this.menuUsuario.showMenuUsuarioError();
                    }
                    break;
                case "n":
                case "N":
                    this.menuUsuario.showMenuUsuario();
                    break;
                default:
                    System.err.println(
                            ProjetoStringUtils.rpad(
                            "##ERRO.PERFIL.VIEW.LEITORPERFILEXCLUSÃO::Opção Inválida.",
                            "*",
                            66));
                    this.menuUsuario.showMenuUsuarioError();
                    break;
            }
        } else {
            System.err.println(
                    ProjetoStringUtils.rpad(
                    "##ERRO.PERFIL.VIEW.LEITORPERFILEXCLUSÃO::CÓDIGO PERFIL INVÁLIDO",
                    "*",
                    66));
            this.menuUsuario.showMenuUsuarioError();
        }
    }

}
