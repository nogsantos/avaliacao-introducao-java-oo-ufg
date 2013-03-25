/**
 *
 * Descrição:Classe PerfilView.
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
import projeto.utils.ProjetoStringUtils;


public class PerfilView {
    /*
     * Instâncias
     */
    private MenuPerfil menuPerfil = new MenuPerfil();
    private Scanner leitor        = new Scanner(System.in);
   /**
    * Formulário de cadastro de perfil.
    * 
    * @author Fabricio Nogueira
    * @since 22-Mar-2013
    * @version 1.0.0
    * @return void
    */
    public void leitorCadastroPerfil(){
        Integer codigo = 0;
        /*
         * Recupera o próximo codigo que será inserido no banco.
         */
        try {
            PerfilImpl nextVal = new PerfilImpl();
            codigo = nextVal.perfilNextVal();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        /*
         * Instancia do menu no perfil
         */
        
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::CADASTRO DE PERFIL",
                "*",
                66
            )
        );
        System.out.println("Codigo: " + codigo);
        Integer codigoPerfil = codigo;
        System.out.println("Nome: ");
        String nome = this.leitor.nextLine();
        System.out.println("Descrição: ");
        String descricao = this.leitor.nextLine();
        /*
         * Cadastrar
         */
        PerfilService perfilCadastrar = new PerfilService(
                codigoPerfil, 
                nome, 
                descricao
        );
        if(perfilCadastrar.cadastrar()){
            System.out.println(
                ProjetoStringUtils.rpad(
                    "SUCESSO:: Dado inserido com sucesso.", 
                    "*",
                    66
                )
            );
            this.menuPerfil.showMenuPerfil();
        }else{
            this.menuPerfil.showMenuPerfilError();
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
    public void leitorEdicaoPerfil(Integer codigoPerfilLeitor){
        /*
         * Titulo do formulário.
         */
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::EDIÇÃO DE PERFIL ",
                "*",
                66
            )
        );
        if(codigoPerfilLeitor >=0 ){
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
                        66
                    )
                );
                this.menuPerfil.showMenuPerfilError();
            }
            /*
             * Edição
             */
            PerfilService perfilEditar = new PerfilService(
                codigoPerfil, 
                nome, 
                descricao
            );
            if(perfilEditar.editar()){
                System.out.println(
                    ProjetoStringUtils.rpad(
                        "SUCESSO::Dado editado com sucesso.",
                        "*",
                        66
                    )
                );
                this.menuPerfil.showMenuPerfil();
            }else{
                System.err.println(
                    ProjetoStringUtils.rpad(
                        "***** O pefil informado não existe! ",
                        "*",
                        66
                    )
                );
                this.menuPerfil.showMenuPerfilError();
            }
        }else{
            System.err.println(
                ProjetoStringUtils.rpad(
                    "##ERRO.PERFIL.VIEW.LEITORPERFIL::CÓDIGO PERFIL INVÁLIDO", 
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
    public void leitorExclusaoPerfil(Integer codigoPerfilLeitor){
        String confirmacao;
        /*
         * Titulo do formulário
         */
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::EXCLUSÃO DE PERFIL ", 
                "*",
                66
            )
        );
        if(codigoPerfilLeitor >=0 ){
            /*
             * Confirmação da exclusão
             */
            System.out.println(
                "Confirma a exclusão do perfil de Codigo = " 
                + codigoPerfilLeitor +" (S/N)?");
            confirmacao = this.leitor.nextLine().toString();
            switch (confirmacao) {
                case "s":
                case "S":
                    Integer codigoPerfil = codigoPerfilLeitor;
                    PerfilService perfilExcluir = new PerfilService(
                        codigoPerfil
                    );
                    if(perfilExcluir.excluir()){
                        System.out.println(
                            ProjetoStringUtils.rpad(
                                "SUCESSO::Dado excluído com sucesso.",
                                "*",
                                66
                            )
                        );
                        this.menuPerfil.showMenuPerfil();
                    }else{
                        System.err.println(
                            ProjetoStringUtils.rpad(
                                "***** O pefil informado não existe! ",
                                "*",
                                66
                            )
                        );
                        this.menuPerfil.showMenuPerfilError();
                    }
                    break;
                case "n":
                case "N":
                    this.menuPerfil.showMenuPerfil();
                    break;
                default:
                    System.err.println(
                        ProjetoStringUtils.rpad(
                            "##ERRO.PERFIL.VIEW.LEITORPERFILEXCLUSÃO::Opção Inválida.",
                            "*",
                            66
                        )
                    );
                    this.menuPerfil.showMenuPerfilError();
                    break;
            }
        }else{
            System.err.println(
                ProjetoStringUtils.rpad(
                    "##ERRO.PERFIL.VIEW.LEITORPERFILEXCLUSÃO::CÓDIGO PERFIL INVÁLIDO", 
                    "*",
                    66
                )
            );
            this.menuPerfil.showMenuPerfilError();
        }
    }
}