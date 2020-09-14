#language: pt
#encoding: utf-8

Funcionalidade: Excluir funcionário
  Como um usuário
  Quero excluir um funcionário
  Para retirar da lista de funcionários

  Contexto: Cadastrar funcionário na lista de funcionários do sistema
    Dado que estou logado no sistema inmetrics
      | usuario       | senha        |
      | inmetricsuser | inmetrics123 |
    E acessar a tela "Novo Funcionário"
    Quando incluir as informações de cadastro
      | nome       | cpf        | sexo      | admissao  | cargo       | salario | tipoContratacao |
      | automatico | automatico | Masculino | dataAtual | Analista QA | 800000  | PJ              |
    E enviar formulário de cadastro de funcionário
    E pesquisar por funcionário cadastrado

    Cenario: Excluir funcionário
      Quando excluir o funcionário
      Então o funcionário será removido da lista com sucesso
      Quando pesquisar por funcionário cadastrado
      Então o sistema informa na lista "Nenhum registro encontrado"