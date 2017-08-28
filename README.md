# Seleção Planner Sistemas
### Aplicação javaee com jsf, primefaces, hibernate e cdi

## Arquitetura do projeto
* Java Web 
  * Java 8 versão 1.8.0_41 
  * Implementação do JSF versão 2.2
  * Primefaces versão 6.1
* Framework JPA
  * Hibernate versão 5.2
* Database
  * HSQLDB versão 2.3
* Controle e Injeção de Dependências
  * Implementação do CDI weld versão 2.4
* Container Servlet
  * Tomcat versão 7

## Executando o projeto com Eclipse

* Faça o clone do projeto para seu workspace, após o download, vá no menu File do eclipse, clique em Import, na tela
de dialogo, seleciona Maven, e em seguida Existing Maven Projects e clique em Next. Na próxima janela clique no botão Browse,
para selecionar a pasta que você clonou no seu workspace, e clique em Finish.

* Aguarde o maven configurar o projeto, uma barra de progresso no canto inferior direito do Eclipse ficará visível enquanto
o maven faz o download das dependências.

* Após o termino da configuração, o projeta estará pronto para rodar. Clique em cima do projeto com o botão direito, e selecione Run As =>
Run on Server. Importânte que neste momento seu Eclipse já tenha um servidor Tomcat configurado, caso não tenha, um novo servidor deve ser
adicionado e configurado para que esse passo da execução seja realizado.

## Executando o projeto com NetBeans

* Faça o clone do projeto para sua pasta NetBeansProjects ou outra de sua escolha, após o download, vá no menu Arquivo do Netbeans, 
clique em Abrir Projeto, na tela de dialogo, selecione a pasta que você clonou, e clique em Abrir Projeto.

* Aguarde o maven configurar o projeto, uma barra de progresso no canto inferior do NetBeans ficará visível enquanto
o maven faz o download das dependências. Caso a barra não apareça e um icone amarelo fique visível, clique com o botão
direito, e selecione Resolver Problemas do Projeto.

* Após o termino da configuração, o projeta estará pronto para rodar. Clique em cima do projeto com o botão direito, e selecione Executar. Importânte que neste momento seu NetBeans já tenha um servidor Tomcat instalado, caso não tenha, um novo servidor deve ser
instalado para que esse passo da execução seja realizado.

## Arquitetura de negócio e funcionamento

### Camada cliente
* Views
  * Home.xhtm
    - Tela de boas vinda da aplicação
    - caminho ./Home.xhtml
  * CadastroCargo.xhtm
    - Tela com ações para o processo de CRUD básico para administrar informações de cargos.
    - caminho ./cargo/CadastroCargo.xhtml
  * CadastroFuncionario.xhtml
    - Tela com ações para o processo de CRUD básico para administrar informações de funcionários.
    - caminho ./funcionario/CadastroFuncionario.xhtml
  * AplicacaoPromocao.xhtm
    - Tela para aplicação de promoção, através de lançamento de percentual por cargo,
  	 atualizando os salários de todos os funcionários cadastrados.
    - caminho ./promocao/AplicacaoPromocao.xhtml
### Camada servidor
* Controles
  * CargoBean.java
    - Representa um managed bean resolvendo as requisições entre a view e a classe de entidade
 Cargo.
  * FuncionarioBean.java
    - Representa um managed bean resolvendo as requisições entre a view e a classe de entidade
Funcionario.
  * PromocaoBean.java
    - Representa um managed bean resolvendo as requisições entre a view e a regra de negócio
 da aplicação referênte ao aumento de salários por cargo.
* Modelos
  * Cargo.java
    - Representa uma classe persistente que implementa uma entidade de negócio da aplicação,
 seguindo o modelo de programação POJO.
  * Funcionario.java
    - Representa uma classe persistente que implementa uma entidade de negócio da aplicação,
 seguindo o modelo de programação POJO.
* Acesso a dados
  * CargoRepository.java
    - Implementa a interface de acesso ao banco de dados para transações de dados de objetos da classe
 Cargo.
  * FuncionarioRepository.java
    - Implementa a interface de acesso ao banco de dados para transações de dados de objetos da classe
 Funcionario.
* Regras de negócios
  * Acrescimo.java
    - Interface para classes que implementam aumento de valores baseado em percentual.
  * AplicarPromocao.java
    - Responsável por promover métodos para auxiliar no cálculo de aumento de salário.
### Funcionamento

A primeira vez que a aplicação rodar, será exibido uma tela de boas vindas, no canto superior direito, existe um menu com
nome Cadastros localizado no navbar, com links para acesso as telas de cadastro de cargos e funcionários e uma tela para promover aumento de salários por cargo. **Todos os campos dos formulários de cadastro são obrigatórios.** 

* Cadastrando, pesquisando, editando e removendo cargos
  * A primeira vez que abrir a tela de cargos, a página vai demorar um pouco para carregar, pois o sistema nesse momento
  estará criando o banco, as tabelas e seus relacionamentos.
  
  * Após o carregamento da página, um formulário com campos de código e descrição serão visíveis. Para cadastrar um novo cargo,
  insira um valor para código e descrição, e depois clique no botão salvar. Caso queira limpar o formulário clique no botão limpar formulário.
  
  * Após clicar no botão salvar, uma mensagem será exibida informando detalhes da operação, caso nenhum erro tenha acontecido, o registro será salvo e será exibido na tabela abaixo. A tabela contém um campo para pesquisar resgistros, e cada registro contém
  botões para editar ou remover o registro atual.
  
  * Para pesquisar um registro, basta digitar o código ou nome no imput com placehold buscar, localizado no cabeçalho a direita da tabela.  
  
  * Para editar um cargo, clique no botão com icone de caneta, os dados do registro serão carregados no formulário, edite
  os dados e clique no botão salvar, caso queira cancelar a edição, clique no botão limpar formulário.
  
  * Para deletar um cargo, clique no botão com icone de lixeira, uma janela de diálogo será exibida com a descrição do cargo e um alerta. Clique sim para confirmar ou não para cancelar. **Importante lembrar que a exclusão de um cargo, exclui também todos os funcionários com ele relacionado**, se deseja excluir apenas o cargo, os registros dos funcionários devem ser editados para outro cargo, antes da exclusão.   

* Cadastrando, pesquisando, editando e removendo funcionários
  * Antes de cadastrar um novo funcionário, pelo menos um cargo já deve ter sido cadastrado, pois a tentativa de cadastrar um
  funcionário sem está relacionado a um cargo exibirá um erro.
  
  * Após o carregamento da página, um formulário com campos de nome, matrícula, cargo e salário serão visíveis. Para cadastrar um novo funcionário, preencha todos os campos, e depois clique no botão salvar. Caso queira limpar o formulário clique no botão limpar formulário.
  
  * Após clicar no botão salvar, uma mensagem será exibida informando detalhes da operação, caso nenhum erro tenha acontecido, o registro será salvo e será exibido na tabela abaixo. A tabela contém um campo para pesquisar resgistros, e cada registro contém
  botões para editar ou remover o registro atual.
  
  * Para pesquisar um registro, basta digitar qualquer dado de uma das colunas no imput com placehold buscar, localizado no cabeçalho a direita da tabela.  
  
  * Para editar um funcionário, clique no botão com icone de caneta, os dados do registro serão carregados no formulário, edite
  os dados e clique no botão salvar, caso queira cancelar a edição, clique no botão limpar formulário.
  
  * Para deletar um funcionário, clique no botão com icone de lixeira, uma janela de diálogo será exibida com a descrição do cargo e um alerta. Clique sim para confirmar ou não para cancelar.

* Aplicando promoção de aumento de salário por cargo
  * No menu cadastros clique no link Aplicação de Promoção, uma nova página será carregada contendo um listbox com todos os cargos cadastrados, e uma tabela com campo para laçamento de percentual de aumento de salário.
  
  * Para aplicar a promoção, clique em um dos cargos exibidos no listbox, todos os funcionários do cargo selecionado serão carregados na tabela abaixo. Em seguida informe um valor referênte ao percentual de aumento que será aplicado ao salário de cada funcionário e clique em calcular.

  * Após a operação será exibido uma mensagem informando que os salários foram atualizados, e a tabela exibirá os funcionários com os novos salários.
  
  
