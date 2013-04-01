/**
 *
 * Descrição:Classe UsuarioPerfilView
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 01-Apr-2013
 *
 * @version 1.0.0
 *
 */

package projeto.pessoas;

import java.util.Scanner;
import projeto.utils.ProjetoStringUtils;


public class UsuarioPerfilView {
    /*
     * Instâncias
     */
    private MenuUsuario menuUsuario = new MenuUsuario();
    private Scanner leitor          = new Scanner(System.in);
    
    public void leitorUsuario(){
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::CADASTRO DE PERFIL USUARIO",
                "*",
                66
            )
        );
        System.out.println("Informe o código do usuário\n");
        System.out.println("Cpf: ");
        try {
            String codigoPessoa = this.leitor.next();
            leitorCadastroPerfilUsuario(codigoPessoa);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            this.menuUsuario.showMenuUsuarioError();
        }
    }
    
    /**
     * Formulário de perfil de usuário.
     *
     * @author Fabricio Nogueira
     * @since 01-Apr-2013
     * @version 1.0.0
     * @return void
     */
    public void leitorCadastroPerfilUsuario(String codigoUsuario) {
        System.out.println(
            ProjetoStringUtils.rpad(
                "FORMULÁRIO::CADASTRO DE PERFIL USUARIO",
                "*",
                66
            )
        );
        System.out.println("Cpf: " + codigoUsuario);
        String codigoPessoa = codigoUsuario;
        System.out.println("Perfil (Caso haja mais de um, "
                + "utilize virgula para separá-los ex.: 1,2,3): ");
        String codigoPerfil = this.leitor.next();
        /*
         * Cadastrar
         */
        PerfilUsuarioServices perfilUsuarioCadastrar = new PerfilUsuarioServices();
        String cadastro  = perfilUsuarioCadastrar.cadastrar();
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

}
