#language: pt
#encoding: utf-8

Funcionalidade: Pesquisar funcionario
  Como um usuário
  Quero pesquisar um funcionario
  Para saber se faz parte da lista de funcionarios

  Contexto: Cadastrar funcionário na lista de funcionários do sistema
    Dado que estou logado no sistema inmetrics
      | usuario       | senha        |
      | inmetricsuser | inmetrics123 |
    E acessar a tela "Novo Funcionário"
    Quando incluir as informações de cadastro
      | nome       | cpf        | sexo      | admissao  | cargo       | salario | tipoContratacao |
      | automatico | automatico | Masculino | dataAtual | Analista QA | 800000  | PJ              |
    E enviar formulário de cadastro de funcionário

  Cenario: Pesquisar funcionario cadastrado
    Quando pesquisar por funcionário cadastrado
    Então o funcionário aparece na lista de funcionários