# SCRIPT DETALHADO - FALE EXATAMENTE ISSO

## [0:00-0:30] ABERTURA

"Oi, eu sou Lucas Dal Pra Brascher, e hoje vou apresentar a Arvore 2-3, uma estrutura de dados multiway com balanceamento automatico."

"Vou explicar como funciona a insercao, a busca, e a remocao com rebalanceamento. Vou mostrar o codigo funcionando e depois falar sobre aplicacoes praticas."

## [0:30-1:00] O QUE E ARVORE 2-3

"A Arvore 2-3 tem esse nome porque cada no pode ter 1 ou 2 chaves, e 2 ou 3 filhos."

[MOSTRAR DESENHO]

"Um no com 1 chave tem 2 filhos. Um no com 2 chaves tem 3 filhos."

"A propriedade mais importante: TODAS as folhas ficam no mesmo nivel. Isso garante que a arvore esta sempre balanceada."

## [1:00-4:00] INSERCAO

"Vamos comecar com a insercao. Vou inserir os valores 10, 20, 30, 40, 50, 60 e 70."

[EXECUTAR MAIN.JAVA]

"Inserindo 10: Como a arvore esta vazia, criamos o primeiro no."

"Inserindo 20: O no raiz tem espaco, entao simplesmente adicionamos. Agora temos [10, 20]."

"Inserindo 30: Agora o no esta cheio! Precisa DIVIDIR."

"Olha o que acontece: Temos 3 valores: 10, 20 e 30."
"- O 10 fica no no da esquerda"
"- O 20 SOBE e vira nova raiz"
"- O 30 vai pro no da direita"

"Inserindo 40: Desce ate a folha da direita, que tem espaco. Fica [30, 40]."

"Inserindo 50: A folha [30, 40] esta cheia! Divide novamente."
"- 30 fica na esquerda"
"- 40 sobe para o pai"
"- 50 vai pra direita"

"Agora a raiz tem [20, 40] com 3 filhos."

"Inserindo 60 e 70: Mais divisoes acontecem. Vejam como a arvore cresce mantendo o balanceamento."

## [4:00-6:00] BUSCA

"Agora vou explicar a busca. Vou buscar o valor 30."

[MOSTRAR CODIGO DA BUSCA]

"A busca e recursiva. Comeca na raiz [20, 40]."

"30 esta entre 20 e 40? Sim! Entao vamos pro filho do MEIO."

"No proximo no, comparamos de novo ate encontrar ou chegar em null."

"Vou executar algumas buscas:"

[EXECUTAR]

"Buscar 30: ENCONTRADO"
"Buscar 45: NAO ENCONTRADO"
"Buscar 70: ENCONTRADO"

"A complexidade e O(log n) porque a arvore esta sempre balanceada."

## [6:00-9:00] REMOCAO

"Agora a parte mais complexa: a REMOCAO."

"Existem dois casos principais:"

"CASO 1 - Remover de uma FOLHA:"
"Se a folha tem 2 chaves, e facil, so remove uma."
"Se a folha tem apenas 1 chave, precisamos REBALANCEAR."

"CASO 2 - Remover de um NO INTERNO:"
"Nao podemos simplesmente apagar, senao perde os filhos!"
"A solucao: substituir pela PREDECESSORA."
"Predecessora e o maior valor da subarvore esquerda."
"Depois removemos a predecessora da folha."

"Vou remover o 20 e o 50 para mostrar:"

[EXECUTAR REMOCOES]

"Removendo 20: E um no interno. Busca a predecessora, substitui, e remove da folha."

"Removendo 50: Olha o rebalanceamento acontecendo!"

"O rebalanceamento tem duas estrategias:"
"1. REDISTRIBUICAO: Pega uma chave emprestada do irmao que tem 2 chaves"
"2. FUSAO: Se ninguem pode emprestar, funde dois nos"

[MOSTRAR NO CODIGO]

"Aqui no codigo, o metodo rebalancearAposRemocao verifica os irmaos."
"Se tem 2 chaves, redistribui. Se nao, funde."

"Isso SEMPRE mantem todas as folhas no mesmo nivel."

## [9:00-10:00] APLICACOES E CONCLUSAO

"A Arvore 2-3 foi criada nos anos 70 e foi a BASE para as Arvores B."

"Arvores B sao usadas em BANCOS DE DADOS para indexacao."
"Exemplos: MySQL, PostgreSQL, todos usam variantes de Arvores B."

"Por que? Porque:"
"- Sempre balanceadas: busca, insercao e remocao sempre O(log n)"
"- Poucas comparacoes: bom para disco"
"- Todas as folhas no mesmo nivel: previsivel"

"Desvantagens:"
"- Implementacao complexa como voces viram"
"- Arvores B sao mais flexiveis (podem ter mais chaves por no)"

"O codigo completo com todos os testes esta no GitHub. Link na descricao."

"Obrigado pela atencao!"

---

## TIMING:
- Introducao: 1 min
- Insercao: 3 min
- Busca: 2 min
- Remocao: 3 min
- Conclusao: 1 min
TOTAL: 10 min
