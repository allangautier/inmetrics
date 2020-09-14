#language: pt
#encoding: utf-8

Funcionalidade: Cadastro de funcionários
  Como um usuário
  Quero cadastrar funcionários
  Para entrar na lista de funcinários do sistema

  Contexto: Abrir tela de novos funcionários
    Dado que estou logado no sistema inmetrics
      | usuario       | senha        |
      | inmetricsuser | inmetrics123 |
    E acessar a tela "Novo Funcionário"

    Cenario: Cadastrar novo funcionário
      Quando incluir as informações de cadastro
        | nome       | cpf        | sexo      | admissao  | cargo       | salario | tipoContratacao |
        | automatico | automatico | Masculino | dataAtual | Analista QA | 500000  | CLT             |
      E enviar formulário de cadastro de funcionário
      E pesquisar por funcionário cadastrado
      Então o funcionário é cadastrado com sucesso
      E o funcionário entra na lista de funcionários do sistema

    Cenario: Cadastrar novo funcionário com cpf inválido
      Quando inserir cpf "12345678925"
      Então o sistema apresenta alerta de erro "CPF Invalido!"