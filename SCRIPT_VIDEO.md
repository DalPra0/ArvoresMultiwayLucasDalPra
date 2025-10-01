# SCRIPT EXPANDIDO - 10 MINUTOS COMPLETOS

## [0:00-1:00] ABERTURA E INTRODUCAO (1 min)

"Oi, eu sou Lucas Dal Pra Brascher, estudante da PUCPR, e hoje vou apresentar a Arvore 2-3, uma estrutura de dados multiway com balanceamento automatico."

[PAUSA 2 SEGUNDOS]

"A Arvore 2-3 foi criada em 1970 por John Hopcroft e e a base para as Arvores B que usamos em bancos de dados hoje em dia."

"Neste video vou explicar em detalhes como funciona a insercao, a busca, e a remocao com rebalanceamento. Vou mostrar o codigo funcionando na pratica e no final falar sobre as aplicacoes reais dessa estrutura."

## [1:00-1:30] O QUE E ARVORE 2-3 (30 seg)

"Primeiro, o que e uma Arvore 2-3?"

"A Arvore 2-3 tem esse nome porque cada no pode ter 1 ou 2 chaves, e consequentemente 2 ou 3 filhos."

[DESENHAR OU MOSTRAR DIAGRAMA]

"Por exemplo: um no com 1 chave, como [10], tem 2 filhos - um pra valores menores que 10, outro pra valores maiores."

"Um no com 2 chaves, como [10, 20], tem 3 filhos - um pra valores menores que 10, um pra valores entre 10 e 20, e outro pra valores maiores que 20."

"A propriedade FUNDAMENTAL: TODAS as folhas ficam SEMPRE no mesmo nivel. Isso garante que a arvore esta sempre perfeitamente balanceada."

## [1:30-5:00] INSERCAO DETALHADA (3 min 30 seg)

"Agora vou explicar a insercao em detalhes. E a operacao mais importante porque e ela que cria e mantem o balanceamento da arvore."

[ABRIR TERMINAL E EXECUTAR]

"Vou inserir varios valores para mostrar todos os casos possiveis: 10, 20, 30, 40, 50, 60 e 70."

"Inserindo 10: A arvore esta vazia, entao apenas criamos o primeiro no com [10]."

[MOSTRAR OUTPUT]

"Inserindo 20: A raiz tem espaco, porque tem apenas 1 chave. Entao simplesmente adicionamos. Agora temos [10, 20]."

[MOSTRAR OUTPUT]

"Inserindo 30: AGORA fica interessante! O no esta cheio com [10, 20], e vamos inserir mais um valor."

"Aqui acontece a DIVISAO. Temos 3 valores: 10, 20 e 30."

[FALAR DEVAGAR]

"O algoritmo faz o seguinte:"
"- Ordena os 3 valores: 10, 20, 30"
"- O valor do MEIO, que e o 20, SOBE e vira a nova raiz"
"- O menor valor, o 10, fica no no da esquerda"
"- O maior valor, o 30, vai para um novo no a direita"

[MOSTRAR A ESTRUTURA NO OUTPUT]

"Vejam como ficou: A raiz agora e [20], com dois filhos: [10] e [30]."

"Inserindo 40: Comecamos na raiz [20]. 40 e maior que 20, entao descemos para a direita."

"Chegamos na folha [30]. Ela tem espaco! Entao simplesmente adicionamos. Fica [30, 40]."

[MOSTRAR OUTPUT]

"Inserindo 50: De novo comecamos na raiz [20]. 50 e maior que 20, descemos para direita."

"Chegamos na folha [30, 40]. Esta cheia! Precisa dividir de novo."

"Temos 3 valores: 30, 40, 50."
"- O 40 sobe para o pai"
"- O 30 fica na esquerda" 
"- O 50 vai pra direita"

[MOSTRAR OUTPUT]

"Agora a raiz tem [20, 40] com 3 filhos: [10], [30] e [50]."

"Inserindo 60: Raiz tem [20, 40]. 60 e maior que 40, vai pro filho direito."

"Folha [50] tem espaco. Fica [50, 60]."

[MOSTRAR OUTPUT]

"Inserindo 70: Mais uma vez, raiz [20, 40], 70 vai pra direita."

"Folha [50, 60] esta cheia! Divide: 60 sobe, 50 fica, 70 vai pra novo no."

"AGORA a raiz [20, 40] vai receber o 60. Mas ela JA tem 2 chaves!"

"Entao a RAIZ tambem divide! Isso mostra como as divisoes propagam pra cima."

[MOSTRAR OUTPUT FINAL]

"Vejam como a arvore cresceu mantendo todas as folhas no mesmo nivel."

## [5:00-6:30] BUSCA DETALHADA (1 min 30 seg)

"Agora a busca. E bem mais simples que a insercao."

[MOSTRAR CODIGO]

"A busca e recursiva. Vamos buscar o valor 30 passo a passo."

"Comecamos na raiz. Comparamos o valor com as chaves do no."

"Se encontrou, retorna true. Se o no e folha e nao encontrou, retorna false."

"Se nao, decidimos qual filho visitar:"
"- Se o valor e menor que chave1, vai pro filho esquerdo"
"- Se esta entre chave1 e chave2, vai pro filho do meio"
"- Se e maior que chave2, vai pro filho direito"

[EXECUTAR BUSCAS]

"Vou executar 3 buscas:"

"Buscar 30: Comeca na raiz, desce pela arvore, encontra na folha. ENCONTRADO!"

"Buscar 45: Comeca na raiz, desce, chega numa folha mas o 45 nao esta la. NAO ENCONTRADO!"

"Buscar 70: Comeca na raiz, desce, encontra na folha. ENCONTRADO!"

"A complexidade e O(log n) garantido porque a arvore esta sempre balanceada. A altura maxima e log n."

## [6:30-9:00] REMOCAO DETALHADA (2 min 30 seg)

"Agora a parte mais complexa e interessante: a REMOCAO."

"A remocao precisa manter o balanceamento, entao tem varios casos."

"Existem DOIS casos principais:"

[FALAR DEVAGAR]

"CASO 1 - Remover de uma FOLHA:"
"Se a folha tem 2 chaves, tipo [30, 40], e queremos remover o 30, e facil. Simplesmente removemos e fica [40]."

"Mas se a folha tem APENAS 1 chave, tipo [50], e queremos remover, a folha fica VAZIA. Isso quebra a estrutura!"

"Entao precisamos REBALANCEAR pegando uma chave do irmao ou fundindo nos."

[PAUSA]

"CASO 2 - Remover de um NO INTERNO:"
"Se o no nao e folha, ele tem filhos. Nao podemos simplesmente apagar!"

"A solucao: substituir pela PREDECESSORA."

"Predecessora e o MAIOR valor da subarvore ESQUERDA. E sempre uma folha!"

"Entao substituimos a chave pela predecessora, e depois removemos a predecessora da folha. Ai cai no caso 1."

[EXECUTAR REMOCOES]

"Vou remover o 20 primeiro:"

"20 esta na raiz, e um no interno. Busca a predecessora, que e o 10."

"Substitui o 20 pelo 10, e remove o 10 da folha."

[MOSTRAR OUTPUT]

"Agora vou remover o 50:"

[MOSTRAR OUTPUT]

"Vejam como a arvore se reorganizou!"

[MOSTRAR CODIGO]

"Aqui no codigo, o rebalanceamento tem duas estrategias:"

"REDISTRIBUICAO: Se um irmao tem 2 chaves, podemos pegar uma emprestada."
"Uma chave do pai desce, e uma chave do irmao sobe pro pai."

"FUSAO: Se nenhum irmao pode emprestar, fundimos dois nos."
"Uma chave do pai desce e junta com as chaves dos dois nos."

"Isso pode propagar ate a raiz, diminuindo a altura da arvore."

"O importante e que SEMPRE mantemos todas as folhas no mesmo nivel."

## [9:00-10:00] APLICACOES E CONCLUSAO (1 min)

"Agora vamos falar sobre onde essa estrutura e usada na pratica."

"A Arvore 2-3 foi criada em 1970 e foi a BASE para criar as Arvores B nos anos seguintes."

"Arvores B sao usadas em TODOS os principais bancos de dados:"
"- MySQL usa B+ Tree para indices"
"- PostgreSQL usa B-Tree para indices"
"- SQLite tambem usa B-Tree"
"- Sistemas de arquivos como NTFS e ext4 usam variantes de B-Tree"

"Por que sao tao usadas?"

"Primeiro: Sempre balanceadas. Todas as operacoes sao O(log n) garantido."

"Segundo: Poucas operacoes de disco. Como cada no tem varias chaves, fazemos menos acessos ao disco."

"Terceiro: Previsibilidade. Sempre sabemos que a altura e log n."

[PAUSA]

"As desvantagens:"
"A implementacao e BEM complexa, como voces viram nesse video. Sao mais de 500 linhas de codigo!"

"Por isso na pratica usamos Arvores B, que sao uma generalizacao da 2-3, mas permitem mais chaves por no, deixando mais flexivel."

[MOSTRAR TERMINAL]

"Todo o codigo que mostrei esta no meu GitHub. O link esta na descricao."

"Implementei tudo em Java puro, sem usar nenhuma estrutura pronta, seguindo as regras do trabalho."

"Obrigado pela atencao!"

---

## TIMING DETALHADO:
- Abertura: 1 min
- Definicao: 0.5 min
- Insercao: 3.5 min
- Busca: 1.5 min
- Remocao: 2.5 min
- Aplicacoes: 1 min
TOTAL: 10 minutos

## DICAS PARA EXPANDIR:
- FALE DEVAGAR e com pausas
- REPITA conceitos importantes
- MOSTRE o terminal apos cada operacao
- EXPLIQUE o codigo enquanto mostra
- DE EXEMPLOS concretos
