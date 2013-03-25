/**
 * Descrição:Classe ModuloService.
 * Classe dedicada a implementação das regras 
 * de negócio para o cadastro de módulos.
 *
 * @author Fabricio Nogueira
 *
 * @since 21-Mar-2013
 *
 * @version 1.0.0
 *
 */

package projeto.modulos;

import java.sql.SQLException;
import java.util.List;
import projeto.utils.ProjetoStringUtils;


public class ModuloService implements ModuloInterface {
    /*
     * Instância da implementação DAO do módulo.
     */
    private ModuloImpl moduloData = new ModuloImpl();
    private Modulo modulo         = new Modulo();
    /*
     * Definindo a quantidade de colunas
     */
    private static final int QTD_COL_EXTERIOR = 66;
    /**
     * Sobrecarga no Construtor
     * @param null
     */
    public ModuloService() {
    }
    /**
     * Sobrecarga Construtor 
     * Apenas código como parametro.
     * 
     * @param Integer Codigo perfil
     */
    public ModuloService(Integer codigoModulo) {
        this.modulo.setCodigoModulo(codigoModulo);
    }
    /**
     * Sobrecarga Construtor 
     * Todos os parametros.
     * 
     * @param Integer codigoPerfil
     * @param String nome
     * @param String descricao
     * @param int ordem
     */
    public ModuloService(Integer codigoModulo, String nome, 
            String descricao, int ordem) {
        this.modulo.setCodigoModulo(codigoModulo);
        this.modulo.setDescricao(descricao);
        this.modulo.setNome(nome);
        this.modulo.setOrdem(ordem);
    }
    /**
     * Serviço para cadastro dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    @Override
    public boolean cadastrar(){
        try {
            return this.moduloData.cadastrar(this.modulo);
        } catch (SQLException ex) {
            return false;
        }
    }
    /**
     * Serviço para edição dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return boolean
     *
     */
    @Override
    public boolean editar(){
        try {
            return this.moduloData.editar(this.modulo);
        } catch (SQLException ex) {
            return false;
        }
    }
    /**
     * Serviço para exclusão dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    @Override
    public boolean excluir(){
        try {
            return this.moduloData.excluir(this.modulo);
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * Serviço para listagem dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    @Override
    public void listar(){
        List<Modulo> listaDeModulos = null;
        try {
            listaDeModulos = this.moduloData.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        StringBuilder listagemModulos = new StringBuilder();
        int count = 0;
        if (listaDeModulos.isEmpty()) {
            System.err.println(
                ProjetoStringUtils.rpad(
                    "***** A Tabela de módulos está vazia ",
                    " * ",
                    QTD_COL_EXTERIOR
                )
            );
        } else {
            /*
             * Cabeçalho
             */
            listagemModulos.append(
                    ProjetoStringUtils.rpad(
                    "***** LISTAGEM DE MÓDULOS ",
                    "*",
                    QTD_COL_EXTERIOR)).append("\n");
            listagemModulos.append(
                    ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR)).append("\n");
            /*
             * Titulos da tabela
             */
            listagemModulos.append(
                ProjetoStringUtils.rpad(
                    "|Codigo ",
                    " ",
                    6
                )
            );
            listagemModulos.append(
                ProjetoStringUtils.rpad(
                    "|Nome ",
                    " ",
                    22
                )
            );
            listagemModulos.append(
                ProjetoStringUtils.rpad(
                    "|Descrição ",
                    " ",
                    28
                )
            );
            listagemModulos.append(
                ProjetoStringUtils.rpad(
                    "|Ordem ",
                    " ",
                    6
                )
            ).append("|").append("\n");
            listagemModulos.append(
                ProjetoStringUtils.rpad(
                    "-",
                    "-",
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            /*
             * Dados da tabela
             */
            for (Modulo moduloList : listaDeModulos) {
                listagemModulos.append("| ").
                    append(
                        ProjetoStringUtils.rpad(
                            Integer.toString(
                                moduloList.getCodigoModulo()
                            ), 
                            " ", 
                            6
                        )
                    ).append("|");
                listagemModulos.append(
                    ProjetoStringUtils.rpad(
                        moduloList.getNome(),
                        " ", 
                        21
                    )
                ).append("|");
                listagemModulos.append(
                    ProjetoStringUtils.rpad( 
                        moduloList.getDescricao(),
                        " ", 
                        27
                    )
                ).append("|");
                listagemModulos.append(
                    ProjetoStringUtils.rpad( 
                        moduloList.getOrdem().toString(),
                        " ", 
                        6
                    )
                );
                listagemModulos.append("|");
                listagemModulos.append("\n");
                count++;
            }
            /*
             * Rodapé
             */
            listagemModulos.append(
                ProjetoStringUtils.rpad(
                    "-",
                    "-", 
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            listagemModulos.append(
                ProjetoStringUtils.lpad(
                    "Total de " + count + " registros", 
                    " ", 
                    QTD_COL_EXTERIOR
                )
            ).append("\n");
            System.out.println(listagemModulos);
        }
    }
}
