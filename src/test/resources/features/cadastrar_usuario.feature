#language: pt
#encoding: utf-8

Funcionalidade: Cadastrar usuário
  Como um usuário
  Quero cadastrar credenciais de acesso
  Para ter acesso ao sistema

  Contexto: Abrir tela de cadastro de usuário
    Dado que estou na tela de cadastro de usuário do sistema inmetrics

  Cenario: Cadastrar usuário pelo link cadastre-se com nome e senha automaticos
    Quando gerar nome de usuário
    E gerar senha do usuário
    E cadastrar usuário com confirmação de senha gerada
    E efetuar login com credenciais geradas
    Então efetua login com sucesso

  Cenario: Tentar cadastrar usuário já cadastrado
    Quando inserir usuário "inmetricsuser"
    E inserir senha "inmetrics123"
    E cadastrar usuário com confirmação de senha "inmetrics123"
    Então o sistema informa mensagem de erro de cadastro "Usuário já cadastrado"

  Cenario: Tentar cadastrar usuário confirmação de senha diferente
    Quando inserir usuário "inmetricsuser"
    E inserir senha "inmetrics123"
    E cadastrar usuário com confirmação de senha "senhadiferente"
    Então o sistema informa mensagem de erro de cadastro "Senhas não combinam"