/**
 *
 * Descrição:Classe PerfilView
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

    public void leitorPerfil(){
        /*
         * Instancia o menu do perfil
         */
        MenuPerfil menuPerfil = new MenuPerfil();
        Scanner leitor = new Scanner(System.in);
        System.out.println(ProjetoStringUtils.rpad("FORMULÁRIO PERFIL "
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
}
