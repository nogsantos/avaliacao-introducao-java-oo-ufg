/**
 *
 * Descrição:Classe ModuloView
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
import projeto.utils.ProjetoStringUtils;


public class ModuloView {
    /*
     * Instâncias
     */
    private MenuModulo menuModulo = new MenuModulo();
    private Scanner leitor = new Scanner(System.in);
    /**
     * Formulário de cadastro de modulo.
     *
     * @author Fabricio Nogueira
     * @since 22-Mar-2013
     * @version 1.0.0
     * @return void
     */
    public void leitorCadastroModulo() {
        Integer codigo = 0;
        /*
         * Recupera o próximo codigo que será inserido no banco.
         */
        try {
            ModuloImpl nextVal = new ModuloImpl();
            codigo = nextVal.moduloNextVal();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        /*
         * Instância do menu no modulo
         */
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::CADASTRO DE MODULO",
                "*",
                66
            )
        );
        System.out.println("Codigo: " + codigo);
        Integer codigoModulo = codigo;
        System.out.println("Nome: ");
        String nome = this.leitor.nextLine();
        System.out.println("Descrição: ");
        String descricao = this.leitor.nextLine();
        System.out.println("Ordem: ");
        Integer ordem = this.leitor.nextInt();
        /*
         * Cadastrar
         */
        ModuloService moduloCadastrar = new ModuloService(
                codigoModulo,
                nome,
                descricao,
                ordem
        );
        if (moduloCadastrar.cadastrar()) {
            System.out.println(
                    ProjetoStringUtils.rpad(
                    "SUCESSO:: Dado inserido com sucesso.",
                    "*",
                    66));
            this.menuModulo.showMenuModulo();
        } else {
            this.menuModulo.showMenuModuloError();
        }
    }

    /**
     * Formulário de edição de modulo.
     *
     * @author Fabricio Nogueira
     * @since 22-Mar-2013
     * @version 1.0.0
     * @return void
     */
    public void leitorEdicaoModulo(Integer codigoModuloLeitor) {
        /*
         * Titulo do formulário.
         */
        System.out.println(
                ProjetoStringUtils.rpad(
                "FORMULÁRIO::EDIÇÃO DE MÓDULO ",
                "*",
                66));
        if (codigoModuloLeitor >= 0) {
            /*
             * Leitura dos campos
             */
            Integer codigoModulo = 0;
            String nome = null;
            String descricao = null;
            Integer ordem = 0;
            try {
                System.out.println("Codigo: " + codigoModuloLeitor);
                codigoModulo = codigoModuloLeitor;
                System.out.println("Nome: ");
                nome = this.leitor.nextLine().toString();
                System.out.println("Descrição: ");
                descricao = this.leitor.nextLine().toString();
                System.out.println("Ordem: ");
                ordem = this.leitor.nextInt();
            } catch (Exception e) {
                System.err.println(
                        ProjetoStringUtils.rpad(
                        "##ERRO.MODULO.VIEW.LEITORMODULO::Erro na leitura dos dados.",
                        "*",
                        66));
                this.menuModulo.showMenuModuloError();
            }
            /*
             * Edição
             */
            ModuloService moduloEditar = new ModuloService(
                codigoModulo,
                nome,
                descricao,
                ordem
            );
            if (moduloEditar.editar()) {
                System.out.println(
                    ProjetoStringUtils.rpad(
                        "SUCESSO::Dado editado com sucesso.",
                        "*",
                        66
                    )
                );
                this.menuModulo.showMenuModulo();
            } else {
                System.err.println(
                    ProjetoStringUtils.rpad(
                        "***** O módulo informado não existe! ",
                        "*",
                        66
                    )
                );
                this.menuModulo.showMenuModuloError();
            }
        } else {
            System.err.println(
                    ProjetoStringUtils.rpad(
                    "##ERRO.MÓDULO.VIEW.LEITORPERFIL::CÓDIGO MÓDULO INVÁLIDO",
                    "*",
                    66));
        }
    }

    /**
     * Formulário de exclusão de modulo.
     *
     * @author Fabricio Nogueira
     * @since 22-Mar-2013
     * @version 1.0.0
     * @return void
     */
    public void leitorExclusaoModulo(Integer codigoModuloLeitor) {
        String confirmacao;
        /*
         * Titulo do formulário
         */
        System.out.println(
                ProjetoStringUtils.rpad(
                "FORMULÁRIO::EXCLUSÃO DE MÓDULO ",
                "*",
                66));
        if (codigoModuloLeitor >= 0) {
            /*
             * Confirmação da exclusão
             */
            System.out.println(
                    "Confirma a exclusão do módulo Codigo = "
                    + codigoModuloLeitor + " (S/N)?");
            confirmacao = this.leitor.nextLine().toString();
            switch (confirmacao) {
                case "s":
                case "S":
                    Integer codigoModulo = codigoModuloLeitor;
                    ModuloService moduloExcluir = new ModuloService(
                            codigoModulo
                    );
                    if (moduloExcluir.excluir()) {
                        System.out.println(
                                ProjetoStringUtils.rpad(
                                "SUCESSO::Dado excluído com sucesso.",
                                "*",
                                66));
                        this.menuModulo.showMenuModulo();
                    } else {
                        System.err.println(
                                ProjetoStringUtils.rpad(
                                "***** O módulo informado não existe! ",
                                "*",
                                66));
                        this.menuModulo.showMenuModuloError();
                    }
                    break;
                case "n":
                case "N":
                    this.menuModulo.showMenuModulo();
                    break;
                default:
                    System.err.println(
                        ProjetoStringUtils.rpad(
                            "##ERRO.MÓDULO.VIEW.LEITORMODULOEXCLUSÃO::Opção Inválida.",
                            "*",
                            66
                        )
                    );
                    this.menuModulo.showMenuModuloError();
                    break;
            }
        } else {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "##ERRO.PERFIL.VIEW.LEITORMODULOEXCLUSÃO::CÓDIGO MÓDULO INVÁLIDO",
                    "*",
                    66
                )
            );
            this.menuModulo.showMenuModuloError();
        }
    }
}
