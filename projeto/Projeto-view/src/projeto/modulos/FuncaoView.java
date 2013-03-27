/**
 *
 * Descrição:Classe FuncaoView
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
import projeto.utils.ProjetoStringUtils;


public class FuncaoView {
    /*
     * Instâncias
     */
    private MenuFuncao menuFuncao = new MenuFuncao();
    private Scanner leitor        = new Scanner(System.in);
    /**
     * Formulário de cadastro de formulario.
     *
     * @author Fabricio Nogueira
     * @since 22-Mar-2013
     * @version 1.0.0
     * @return void
     */
    public void leitorCadastroFuncao() {
        Integer codigo = 0;
        /*
         * Recupera o próximo codigo que será inserido no banco.
         */
        try {
            FuncaoImpl nextVal = new FuncaoImpl();
            codigo = nextVal.funcaoNextVal();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        /*
         * Instância do menu na função
         */
        System.out.println(
            ProjetoStringUtils.rpad(
                "FUNÇÃO::CADASTRO DE FUNÇÃO",
                "*",
                66
            )
        );
        try {
            System.out.println("Codigo: " + codigo);
            Integer codigoFuncao = codigo;
            /*
             * Listando os formulários para auxilio no cadastro de funções
             */
            FormularioService formularioService = new FormularioService();
            System.out.println(formularioService.listagemSimples());
            
            System.out.println("Formulário: ");
            Integer codigoFormulario  = this.leitor.nextInt();
            
            System.out.println("Nome: ");
            String nome = this.leitor.next().toString();
            
            System.out.println("Descrição: ");
            String descricao = this.leitor.next().toString();
            /*
             * Cadastrar
             */
            FuncaoService funcaoCadastrar = new FuncaoService(
                codigoFuncao,
                codigoFormulario,
                nome,
                descricao
            );
            String cadastro = funcaoCadastrar.cadastrar();
            if (cadastro.equals("sucesso")) {
                System.out.println(
                    ProjetoStringUtils.rpad(
                        "SUCESSO:: Dado inserido com sucesso.",
                        "*",
                        66
                    )
                );
                this.menuFuncao.showMenuFuncao();
            } else {
                System.err.println(cadastro);
                this.menuFuncao.showMenuFuncaoError();
            }
        } catch (Exception e) {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "##ERRO.FUNÇÃO.VIEW.LEITORFUNÇÃO::Erro na leitura dos dados.",
                    "*",
                    66
                )
            );
            this.menuFuncao.showMenuFuncaoError();
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
    public void leitorEdicaoFuncao(Integer codigoFuncaoLeitor) {
        /*
         * Titulo do formulário.
         */
        System.out.println(
            ProjetoStringUtils.rpad(
                "FUNÇÃO::EDIÇÃO DE FUNÇÃO ",
                "*",
                66
            )
        );
        if (codigoFuncaoLeitor >= 0) {
            /*
             * Leitura dos campos
             */
            try {
                System.out.println("Codigo: " + codigoFuncaoLeitor);
                Integer codigoFuncao = codigoFuncaoLeitor;
                /*
                 * Listando os formulários para auxilio no cadastro de funções
                 */
                FormularioService formularioService = new FormularioService();
                System.out.println(formularioService.listagemSimples());

                System.out.println("Formulário: ");
                Integer codigoFormulario  = this.leitor.nextInt();

                System.out.println("Nome: ");
                String nome = this.leitor.next().toString();

                System.out.println("Descrição: ");
                String descricao = this.leitor.next().toString();
                /*
                 * Edição
                 */
                FuncaoService funcaoEditar = new FuncaoService(
                    codigoFuncao,
                    codigoFormulario,
                    nome,
                    descricao
                );
                String edicao = funcaoEditar.editar();
                if (edicao.equals("sucesso")) {
                    System.out.println(
                        ProjetoStringUtils.rpad(
                            "SUCESSO::Dado editado com sucesso.",
                            "*",
                            66
                        )
                    );
                    this.menuFuncao.showMenuFuncao();
                } else {
                    System.err.println(edicao);
                    this.menuFuncao.showMenuFuncaoError();
                }
            } catch (Error | NullPointerException er){
                System.err.println(er.getMessage());
            }catch (Exception e) {
                System.err.println(
                    ProjetoStringUtils.rpad(
                        "##ERRO.FUNÇÃO.VIEW.LEITORFUNÇÃO::Erro na leitura dos dados.",
                        "*",
                        66
                    )
                );
                this.menuFuncao.showMenuFuncaoError();
            }
        } else {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "##ERRO.FUNÇÃO.VIEW.LEITORPERFIL::CÓDIGO FUNÇÃO INVÁLIDO",
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
    public void leitorExclusaoFuncao(Integer codigoFormularioLeitor) {
        String confirmacao;
        /*
         * Titulo do formulário
         */
        System.out.println(
            ProjetoStringUtils.rpad(
                "FUNÇÃO::EXCLUSÃO DE FUNÇÃO ",
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
                + codigoFormularioLeitor + " (S/N)?"
            );
            confirmacao = this.leitor.nextLine().toString();
            switch (confirmacao) {
                case "s":
                case "S":
                    Integer codigoFormulario = codigoFormularioLeitor;
                    FuncaoService funcaoExcluir = new FuncaoService(
                            codigoFormulario);
                    String excluir = funcaoExcluir.excluir();
                    if (excluir.equals("sucesso")) {
                        System.out.println(
                            ProjetoStringUtils.rpad(
                                "SUCESSO::Dado excluído com sucesso.",
                                "*",
                                66
                            )
                        );
                        this.menuFuncao.showMenuFuncao();
                    } else {
                        System.err.println(excluir);
                        this.menuFuncao.showMenuFuncaoError();
                    }
                    break;
                case "n":
                case "N":
                    this.menuFuncao.showMenuFuncao();
                    break;
                default:
                    System.err.println(
                        ProjetoStringUtils.rpad(
                            "##ERRO.FUNÇÃO.VIEW.LEITORFUNÇÃOEXCLUSÃO::Opção Inválida.",
                            "*",
                            66
                        )
                    );
                    this.menuFuncao.showMenuFuncaoError();
                    break;
            }
        } else {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "##ERRO.PERFIL.VIEW.LEITORFUNÇÃOEXCLUSÃO::CÓDIGO FUNÇÃO INVÁLIDO",
                    "*",
                    66
                )
            );
            this.menuFuncao.showMenuFuncaoError();
        }
    }
}
