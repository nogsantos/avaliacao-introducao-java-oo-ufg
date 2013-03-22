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
   /**
    * Formulário de cadastro de perfil.
    * 
    * @author Fabricio Nogueira
    * @since 22-Mar-2013
    * @version 1.0.0
    * @return void
    */
    public void leitorCadastroPerfil(){
        /*
         * Instancia do menu no perfil
         */
        MenuPerfil menuPerfil = new MenuPerfil();
        Scanner leitor = new Scanner(System.in);
        System.out.println(ProjetoStringUtils.rpad("FORMULÁRIO::CADASTRO DE PERFIL "
                + "", "*",66));
        try {
            PerfilImpl nextVal = new PerfilImpl();
            
            System.out.println("Codigo: " + nextVal.perfilNextVal());
            Integer codigoPerfil = nextVal.perfilNextVal(); //leitor.nextInt();
            System.out.println("Nome: ");
            String nome = leitor.nextLine().toString();
            System.out.println("Descrição: ");
            String descricao = leitor.nextLine().toString();
            PerfilService perfil = new PerfilService();            
            
            if(perfil.incluirPerfil(codigoPerfil, nome, descricao)){
            System.out.println(ProjetoStringUtils.rpad("SUCESSO:: Dado "
                    + "inserido com sucesso.", "*",66));
            menuPerfil.showMenuPerfil();
            }else{
                menuPerfil.showMenuPerfilError();
            }
        } catch (Exception e) {
            System.out.println(ProjetoStringUtils.rpad("##ERRO.PERFIL."
                    + "VIEW.LEITORPERFIL ::Erro na leitura dos dados.", "*",66));
            menuPerfil.showMenuPerfilError();
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
         * Instancia do menu no perfil
         */
        MenuPerfil menuPerfil = new MenuPerfil();
        Scanner leitor = new Scanner(System.in);
        System.out.println(ProjetoStringUtils.rpad("FORMULÁRIO::"
                + "EDIÇÃO DE PERFIL ", "*",66));
        try {
            if(codigoPerfilLeitor >=0 ){
                System.out.println("Codigo: " + codigoPerfilLeitor);
                Integer codigoPerfil = codigoPerfilLeitor;
                System.out.println("Nome: ");
                String nome = leitor.nextLine().toString();
                System.out.println("Descrição: ");
                String descricao = leitor.nextLine().toString();
                PerfilService perfil = new PerfilService();            

                if(perfil.editarPerfil(codigoPerfil, nome, descricao)){
                    System.out.println(ProjetoStringUtils.rpad("SUCESSO:: "
                            + "Dado editado com sucesso.", "*",66));
                    menuPerfil.showMenuPerfil();
                }else{
                    System.out.println(ProjetoStringUtils.rpad("***** O pefil "
                        + "informado não existe! ","*",66));
                    menuPerfil.showMenuPerfilError();
                }
            }else{
                System.out.println(ProjetoStringUtils.rpad("##ERRO.PERFIL."
                        + "VIEW.LEITORPERFIL::CÓDIGO PERFIL INVÁLIDO", "*",66));
            }
        } catch (Exception e) {
            System.out.println(ProjetoStringUtils.rpad("##ERRO.PERFIL."
                    + "VIEW.LEITORPERFIL ::Erro na leitura dos dados.", "*",66));
            menuPerfil.showMenuPerfilError();
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
         * Instancia do menu no perfil
         */
        MenuPerfil menuPerfil = new MenuPerfil();
        Scanner leitor = new Scanner(System.in);
        System.out.println(ProjetoStringUtils.rpad("FORMULÁRIO::"
                + "EXCLUSÃO DE PERFIL ", "*",66));
        try {
            if(codigoPerfilLeitor >=0 ){
                System.out.println("Confirma a exclusão do perfil de "
                        + "Codigo = " + codigoPerfilLeitor +" (S/N)?");
                confirmacao = leitor.nextLine().toString().toLowerCase();
                switch (confirmacao) {
                    case "s":
                        Integer codigoPerfil = codigoPerfilLeitor;
                        PerfilService perfil = new PerfilService();
                        if(perfil.excluirPerfil(codigoPerfil)){
                            System.out.println(ProjetoStringUtils.rpad("SUCESSO:: "
                                    + "Dado excluído com sucesso.", "*",66));
                            menuPerfil.showMenuPerfil();
                        }else{
                            System.out.println(ProjetoStringUtils.rpad("***** "
                                    + "O pefil informado não existe! ","*",66));
                            menuPerfil.showMenuPerfilError();
                        }
                        break;
                    case "n":
                        menuPerfil.showMenuPerfil();
                        break;
                    default:
                        System.out.println(ProjetoStringUtils.rpad("##ERRO.PERFIL."
                        + "VIEW.LEITORPERFILEXCLUSÃO::"
                                + "Opção Inválida.", "*",66));
                        menuPerfil.showMenuPerfilError();
                        break;
                }
            }else{
                System.out.println(ProjetoStringUtils.rpad("##ERRO.PERFIL."
                        + "VIEW.LEITORPERFILEXCLUSÃO::"
                        + "CÓDIGO PERFIL INVÁLIDO", "*",66));
            }
        } catch (Exception e) {
            System.out.println(ProjetoStringUtils.rpad("##ERRO.PERFIL."
                    + "VIEW.LEITORPERFILEXCLUSÃO::"
                    + "Erro na leitura dos dados.", "*",66));
            menuPerfil.showMenuPerfilError();
        }
    }
}
