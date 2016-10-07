#language: pt
Funcionalidade: Adicionar Recomendacao

  Delineacao do Cenario: Recomendando hoteis
    Dado que esteja cadastrado no sistema a cidade de "<nome_cidade>" estado de "<nome_estado>"
    E o usuario for cadastrar o hotel "<nome_hotel>" no cidade de "<nome_cidade>"
    Quando o usuario "<nome_usuario>" com o email "<email_usuario>" for recomendar o hotel com a nota "<nota>" e recomendacao "<recomendacao>"
    Então para a recomendacao deve ser retornado "<codigo_retorno>"
    Exemplos:
     |nome_usuario |email_usuario       | nota | recomendacao      | nome_hotel      | nome_cidade | nome_estado | codigo_retorno |
     | Lucas       | email@usuario.com  | 3    | Excelente Cozinha | Ibis Araraquara | Catanduva   | SP          | 200            |
