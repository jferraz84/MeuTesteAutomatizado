#language:pt

#Esta classe contém a descrição dos cenários de testes elencados para a Navegação de um site.
# 
# author: Henrique dos Santos Ferraz, Jorge - jferrazjorge@gmail.com

Funcionalidade: Busca no Banco de Questões
  Eu como usuário desejo testar operações: Consulta para algumas funcionalidades

  @BuscarQuestoes @TesteAutomatizado
  Cenário: Busca por questão inexistente
  Dado que navego para a página de busca do banco de questões
  E clique para expandir o mode de pesquisa
  E digito 'Science: Computers' no campo de busca
  Quando clico no botão de buscar
  Então visualizo uma mensagem de erro com o texto 'No questions found.'

  @BuscarQuestoesPorCategoria @TesteAutomatizado
  Cenário: Busca por questão por categoria
  Dado que navego para a página de buscar no banco de questões
  E clique para expandir o modo de pesquisa
  E digito 'Video game' no campo de buscar
  Quando clico no botão de buscar
  Então visualizo a listagem de questões deve estar com 25 itens e navega pelo controle de paginação

  @BuscarUserCadastrado @TesteAutomatizado
  Cenário: Busca por User Cadastrado
  Dado que navego até a página de busca do banco de questões
  E seleciono a opção de Login
  E digito 'Testando01' no campo de Username
  E digito 'Teste01' no campo de Password
  Quando clico no botão SignIN e retorno a página inicial de busca do banco de questões
  E seleciono a opção de Login novamente e clico no botão Logout
  Então retorno a página inicial