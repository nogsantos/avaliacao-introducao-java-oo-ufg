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
    private Scanner leitor          = new Scanner(System.in);
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
            email,
            telefone,
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
    public void leitorEdicaoUsuario(String codigoUsuarioLeitor) {
        /*
         * Titulo do formulário.
         */
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::EDIÇÃO DE USUÁRIO ",
                "*",
                66
            )
        );
        if (!codigoUsuarioLeitor.isEmpty()) {
            try {
                System.out.println("Cpf: " + codigoUsuarioLeitor);
                String codigoPessoa = codigoUsuarioLeitor;
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
                 * Edição
                 */
                UsuarioService usuarioEditar = new UsuarioService(
                    codigoPessoa,
                    nome,
                    logradouro,
                    email,
                    telefone,
                    login,
                    senha
                );
                String cadastro = usuarioEditar.editar();
                if (cadastro.equals("sucesso")){
                    System.out.println(
                        ProjetoStringUtils.rpad(
                            "SUCESSO::Dado editado com sucesso.",
                            "*",
                            66
                        )
                    );
                    this.menuUsuario.showMenuUsuario();
                } else {
                    System.err.println(
                        ProjetoStringUtils.rpad(
                            "***** O pefil informado não existe! ",
                            "*",
                            66
                        )
                    );
                    this.menuUsuario.showMenuUsuarioError();
                }
            } catch (Exception e) {
                System.err.println(
                    ProjetoStringUtils.rpad(
                        "##ERRO.USUARIO.VIEW.LEITORUSUÁRIO::Erro na leitura dos dados.",
                        "*",
                        66
                    )
                );
                this.menuUsuario.showMenuUsuarioError();
            }
        } else {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "##ERRO.USUÁRIO.VIEW.LEITORUSUÁRIO::CÓDIGO USUÁRIO INVÁLIDO.",
                    "*",
                    66
                )
            );
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
    public void leitorExclusaoUsuario(String codigoUsuarioLeitor) {
        String confirmacao;
        /*
         * Titulo do formulário
         */
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::EXCLUSÃO DE USUÁRIO ",
                "*",
                66
            )
        );
        if (!codigoUsuarioLeitor.isEmpty()) {
            /*
             * Confirmação da exclusão
             */
            System.out.println(
                    "Confirma a exclusão do perfil de Codigo = "
                    + codigoUsuarioLeitor + " (S/N)?"
            );
            confirmacao = this.leitor.nextLine().toString();
            switch (confirmacao) {
                case "s":
                case "S":
                    UsuarioService usuarioExcluir = new UsuarioService(
                            codigoUsuarioLeitor
                    );
                    String exclusao = usuarioExcluir.excluir();
                    if (exclusao.equals("sucesso")) {
                        System.out.println(
                            ProjetoStringUtils.rpad(
                                "SUCESSO::Dado excluído com sucesso.",
                                "*",
                                66
                            )
                        );
                        this.menuUsuario.showMenuUsuario();
                    } else {
                        System.err.println(
                            ProjetoStringUtils.rpad(
                                "***** O usuário informado não existe! ",
                                "*",
                                66
                            )
                        );
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
                            "##ERRO.USUÁRIO.VIEW.LEITORUSUÁRIOEXCLUSÃO::Opção Inválida.",
                            "*",
                            66
                        )
                    );
                    this.menuUsuario.showMenuUsuarioError();
                    break;
            }
        } else {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "##ERRO.USUÁRIO.VIEW.LEITORUSUÁRIOEXCLUSÃO::CÓDIGO USUÁRIO INVÁLIDO",
                    "*",
                    66
                )
            );
            this.menuUsuario.showMenuUsuarioError();
        }
    }
}
