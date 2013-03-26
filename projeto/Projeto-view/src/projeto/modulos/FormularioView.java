/**
 *
 * Descrição:Classe FormularioView
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
import projeto.utils.ProjetoStringUtils;


public class FormularioView {
    /*
     * Instâncias
     */
    private MenuFormulario menuFormulario = new MenuFormulario();
    private Scanner leitor                = new Scanner(System.in);
    /**
     * Formulário de cadastro de formulario.
     *
     * @author Fabricio Nogueira
     * @since 22-Mar-2013
     * @version 1.0.0
     * @return void
     */
    public void leitorCadastroFormulario() {
        Integer codigo = 0;
        /*
         * Recupera o próximo codigo que será inserido no banco.
         */
        try {
            FormularioImpl nextVal = new FormularioImpl();
            codigo = nextVal.formularioNextVal();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        /*
         * Instância do menu no formulario
         */
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::CADASTRO DE FORMULÁRIO",
                "*",
                66
            )
        );
        try {
            
            System.out.println("Codigo: " + codigo);
            Integer codigoFormulario = codigo;
            
            System.out.println("Modulo: ");
            Integer codigoModulo  = this.leitor.nextInt();
            
            System.out.println("Nome: ");
            String nome = this.leitor.next().toString();
            
            System.out.println("Nome Menu: ");
            String nomeMenu = this.leitor.next().toString();
            
            System.out.println("Descrição: ");
            String descricao = this.leitor.next().toString();
            
            System.out.println("Ordem: ");
            Integer ordem = this.leitor.nextInt();
            
            System.out.println("Formulário oculto? (t / f): ");
            String flagOculto = this.leitor.next().toString();
            /*
             * Cadastrar
             */
            FormularioService formularioCadastrar = new FormularioService(
                codigoFormulario,
                codigoModulo,
                nome,
                nomeMenu,
                descricao,
                ordem,
                flagOculto
            );
            String cadastro = formularioCadastrar.cadastrar();
            if (cadastro.equals("sucesso")) {
                System.out.println(
                    ProjetoStringUtils.rpad(
                        "SUCESSO:: Dado inserido com sucesso.",
                        "*",
                        66
                    )
                );
                this.menuFormulario.showMenuFormulario();
            } else {
                System.err.println(cadastro);
                this.menuFormulario.showMenuFormularioError();
            }
        } catch (Exception e) {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "##ERRO.FORMULÁRIO.VIEW.LEITORFORMULÁRIO::Erro na leitura dos dados.",
                    "*",
                    66
                )
            );
            this.menuFormulario.showMenuFormularioError();
        }
    }
    /**
     * Formulário de edição de formulario.
     *
     * @author Fabricio Nogueira
     * @since 22-Mar-2013
     * @version 1.0.0
     * @return void
     */
    public void leitorEdicaoFormulario(Integer codigoFormularioLeitor) {
        /*
         * Titulo do formulário.
         */
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::EDIÇÃO DE FORMULÁRIO ",
                "*",
                66
            )
        );
        if (codigoFormularioLeitor >= 0) {
            /*
             * Leitura dos campos
             */
            try {
                System.out.println("Codigo: " + codigoFormularioLeitor);
                Integer codigoFormulario = codigoFormularioLeitor;

                System.out.println("Modulo: ");
                Integer codigoModulo  = this.leitor.nextInt();

                System.out.println("Nome: ");
                String nome = this.leitor.next().toString();

                System.out.println("Nome Menu: ");
                String nomeMenu = this.leitor.next().toString();

                System.out.println("Descrição: ");
                String descricao = this.leitor.next().toString();

                System.out.println("Ordem: ");
                Integer ordem = this.leitor.nextInt();

                System.out.println("Formulário oculto? (t / f): ");
                String flagOculto = this.leitor.next().toString();
                /*
                 * Edição
                 */
                FormularioService formularioEditar = new FormularioService(
                    codigoFormulario,
                    codigoModulo,
                    nome,
                    nomeMenu,
                    descricao,
                    ordem,
                    flagOculto
                );
                String edicao = formularioEditar.editar();
                if (edicao.equals("sucesso")) {
                    System.out.println(
                        ProjetoStringUtils.rpad(
                            "SUCESSO::Dado editado com sucesso.",
                            "*",
                            66
                        )
                    );
                    this.menuFormulario.showMenuFormulario();
                } else {
                    System.err.println(edicao);
                    this.menuFormulario.showMenuFormularioError();
                }
            } catch (Exception e) {
                System.err.println(
                    ProjetoStringUtils.rpad(
                        "##ERRO.FORMULÁRIO.VIEW.LEITORFORMULÁRIO::Erro na leitura dos dados.",
                        "*",
                        66
                    )
                );
                this.menuFormulario.showMenuFormularioError();
            }
        } else {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "##ERRO.FORMULÁRIO.VIEW.LEITORPERFIL::CÓDIGO FORMULÁRIO INVÁLIDO",
                    "*",
                    66
                )
            );
        }
    }
    /**
     * Formulário de exclusão de formulario.
     *
     * @author Fabricio Nogueira
     * @since 22-Mar-2013
     * @version 1.0.0
     * @return void
     */
    public void leitorExclusaoFormulario(Integer codigoFormularioLeitor) {
        String confirmacao;
        /*
         * Titulo do formulário
         */
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::EXCLUSÃO DE FORMULÁRIO ",
                "*",
                66
            )
        );
        if (codigoFormularioLeitor >= 0) {
            /*
             * Confirmação da exclusão
             */
            System.out.println(
                    "Confirma a exclusão do formulário Codigo = "
                    + codigoFormularioLeitor + " (S/N)?");
            confirmacao = this.leitor.nextLine().toString();
            switch (confirmacao) {
                case "s":
                case "S":
                    Integer codigoFormulario = codigoFormularioLeitor;
                    FormularioService formularioExcluir = new FormularioService(
                            codigoFormulario);
                    String excluir = formularioExcluir.excluir();
                    if (excluir.equals("sucesso")) {
                        System.out.println(
                            ProjetoStringUtils.rpad(
                                "SUCESSO::Dado excluído com sucesso.",
                                "*",
                                66
                            )
                        );
                        this.menuFormulario.showMenuFormulario();
                    } else {
                        System.err.println(excluir);
                        this.menuFormulario.showMenuFormularioError();
                    }
                    break;
                case "n":
                case "N":
                    this.menuFormulario.showMenuFormulario();
                    break;
                default:
                    System.err.println(
                        ProjetoStringUtils.rpad(
                            "##ERRO.FORMULÁRIO.VIEW.LEITORFORMULÁRIOEXCLUSÃO::Opção Inválida.",
                            "*",
                            66
                        )
                    );
                    this.menuFormulario.showMenuFormularioError();
                    break;
            }
        } else {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "##ERRO.PERFIL.VIEW.LEITORFORMULÁRIOEXCLUSÃO::CÓDIGO FORMULÁRIO INVÁLIDO",
                    "*",
                    66
                )
            );
            this.menuFormulario.showMenuFormularioError();
        }
    }
}
