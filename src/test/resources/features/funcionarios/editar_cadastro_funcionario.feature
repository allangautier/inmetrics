#language: pt
#encoding: utf-8

Funcionalidade: Editar cadastro de funcionário
  Como um usuário
  Quero editar cadastro de funcionário
  Para corrigir informações

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

  Cenario: Editar cadastro
    Quando abrir cadastro do funcionário
    E alterar cargo do funcionário para "QA Tester"
    E enviar formulário de cadastro de funcionário
    E pesquisar por funcionário cadastrado
    Então o cadastro é atualizado com sucesso
    E o cargo do funcionário mostra na lista como "QA Tester"