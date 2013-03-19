### Trabalho para a introdução a progamação OO - java 
======
Desenvolver o inicio de uma aplicação padrão que sirva de base para o desenvolvimento de qualquer outra aplicação.
Será um sistema modular, ou seja, pode se dizer que cada módulo será um sistema que compartilham os mesmos recursos que são comuns a todos os sistemas como cadastro de  pessoas, perfis, permissões de acesso etc. Por ser um sistema modular, o módulo padrão é o de segurança, que será o foco do trabalho.

O módulo de Segurança deverá conter os seguintes cadastros:
* **Pessoas:** O cadastro de pessoas será uma classe estática que deverá ser extendida para outras classes, como cadastro de usuários por exemplo.
* **Perfis:** Definição de perfis dos usuários.
* **Usuários:** Uma especialização de Pessoa,  responsável pelo cadastro de usuários no sistema.
* **Módulos:** Cadastro de módulos.
* **Formulários:** Cadastro de formulários dos módulos
* **Funções:** Cadastro das funções dos formulários

No main haverá um menu que conterá as seguintes ações:
```
Selecione uma das opções abaixo digitando o número correspondente:

*************************************************************
0. Encerrar Sistema                                         *  
*************************************************************
CADASTROS                                                   *
1. Perfil        *	2. Usuário       *	3. Módulo            *	
4. Formulário    *	5. Funções        *                      *
*************************************************************
EDIÇÃO:                                                     *
6. Perfil        *	7. Usuário       *	8. Módulo            *	
9. Formulários   *	10. Funções       *	                   *
*************************************************************
EXCLUSÃO:                                                   *
11. Perfil       *	12. Usuario      *	13. Módulo          *	
14. Formulários  *	15. Funções       *                      *
*************************************************************
RELATÓRIOS:                                                 *
16. Perfis       *	17. Usuários     *	18. Módulos          *	
19. Formulários  *	20. Funções       *	                   *
*************************************************************
```

Ao Selecionar alguma das opções que vão de 0 a 20, o usuário será direcionado para o seu respectivo formulário de cadastro ou relatório.

Na opção de **Cadastro**, o usuário deverá preencher os dados e ao final confirmar ou cancelar. Confirmando o cadastro, o usuário deverá ser redirecionado para a tela que contenham as informações que acabou preencher. Nessa tela deverá haver a opção de voltar ao menu inicial. Cancelado, o usuário deverá ser redirecionado para o menú inicial. 

Na opção de **Edição**, o usuário será redirecionado para uma tela que contenha uma listagem com o código e nome dos dados, para editar ele deverá selecionar o código para ser redirecionado para a tela de edição, ou cancelar retornando ao menu inicial. Na tela de edição ele deverá preencher os dados e ao final confirmar ou cancelar a edição.  Confirmando a edição, o usuário deverá ser redirecionado para a tela que contenham as informações que acabou preencher. Nessa tela deverá haver a opção de voltar ao menu inicial. Cancelado, o usuário deverá ser redirecionado para o menú inicial. 

Na opção de **Exclusão**, o usuário será redirecionado para uma tela que contenha uma listagem com o código e nome do dado, para excluir ele deverá selecionar o código para ser redirecionado para a tela de exclusão, ou cancelar retornando ao menu inicial. Na tela de exclusão, será apresentado o dado que foi selecionado e as opções de confirmar a exclusão ou cancelar retornando a listagem inicial da exclusão. Confirmando a exclusão, o dado deve ser deletado levando em consideração seus relacionamentos dentro do sistema, caso possua, retornar uma mensagem de erro informado o motivo do não cancelamento, quando a exclusão for realizada com sucesso o usuário deverá ser redirecionado para a listagem inicial de exclusão visualizando a listagem inicial sem o dado que foi removido. Nessa tela deverá haver a opção de voltar ao menu inicial. 

Na opção de **Listar**, o usuário será redirecionado para uma tela com a listagem de todos os dados cadastrados com a opção de visualização específica de um dado selecionando o seu código ou a opção de voltar ao menú inicial.
