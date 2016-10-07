#language: pt
  Funcionalidade: Adicionar Hotel

    Delineacao do Cenario: Adicionando hoteis
      Dado que esteja cadastrado no sistema a cidade de "<nome_cidade>" estado de "<nome_estado>"
      Quando o usuario for cadastrar o hotel "<nome_hotel>" no cidade de "<nome_cidade>"
      Então para o hotel deve ser retornado "<codigo_retorno>"
      Exemplos:
      |nome_hotel                                          |nome_cidade      |nome_estado  |codigo_retorno |
      |X                                                   | Ribeirão Preto  | SP          | 500           |
      |xxxxxxxxxx                                          |                 |             | 500           |
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx | Ribeirão Preto  | SP          | 500           |
      |Ibis Hotel                                          | Ribeirão Preto  | SP          | 200           |
      |Ibis Hotel                                          | Ribeirão Preto  | SP          | 500           |
