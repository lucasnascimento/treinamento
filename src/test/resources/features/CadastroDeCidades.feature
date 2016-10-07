#language: pt
  Funcionalidade: Adicionar Cidade

    Delineacao do Cenario: Adicionando cidades
      Quando o usuario for cadastrar a cidade "<nome_cidade>" no estado de "<nome_estado>"
      Então deve ser retornado "<codigo_retorno>"
      Exemplos:
      |nome_cidade                                         |nome_estado|codigo_retorno|
      |x                                                   |           | 500          |
      |Araraquara                                          |           | 500          |
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx |           | 500          |
      |Araraquara                                          | SP        | 200          |
      |Araraquara                                          | SP        | 500          |
