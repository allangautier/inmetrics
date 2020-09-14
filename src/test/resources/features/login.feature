#language: pt
#encoding: utf-8

Funcionalidade: Login
  Como um usuário
  Quero inserir dados de login
  Para acessar as funcionalidades do sistema

  Cenario: Login válido
    Dado que acesso o sistema inmetrics
    Quando inserir usuário "inmetricsuser"
    E inserir senha "inmetrics123"
    E realizar login
    Então efetua login com sucesso

  Cenario: Login inválido
    Dado que acesso o sistema inmetrics
    Quando inserir usuário "inmetricsinvalido"
    E inserir senha "inmetricsinvalido"
    E realizar login
    Então o sistema apresenta a mensagem de erro "ERRO! Usuário ou Senha inválidos"