# ROTEIRO DO VIDEO - ARVORE 2-3
## Duracao: 10 minutos

---

## MINUTO 0-1: INTRODUCAO (1 min)

### O QUE FALAR:
"Oi, eu sou Lucas Dal Pra e hoje vou explicar a Arvore 2-3, uma estrutura de dados multiway que mantem balanceamento automatico."

"A Arvore 2-3 e uma arvore de busca onde cada no tem 1 ou 2 chaves, e 2 ou 3 filhos. A principal caracteristica e que TODAS as folhas ficam no mesmo nivel, garantindo balanceamento perfeito."

### O QUE MOSTRAR:
- Desenho simples de uma arvore 2-3 no papel/quadro
- Mostrar um no com 1 chave [10]
- Mostrar um no com 2 chaves [10, 20]

---

## MINUTO 1-4: INSERCAO (3 min)

### O QUE FALAR:
"Vou comecar explicando como funciona a INSERCAO."

"Passo 1: Se a arvore esta vazia, criamos o primeiro no."
"Passo 2: Descemos ate uma folha, seguindo as regras de comparacao."
"Passo 3: Se a folha tem espaco (1 chave), apenas adicionamos."
"Passo 4: Se a folha esta cheia (2 chaves), dividimos o no."

"Na divisao, pegamos as 3 chaves, ordenamos, e:
- A menor fica no no atual
- A do meio SOBE para o pai
- A maior vai para um novo no"

"Se o pai tambem estiver cheio, dividimos ele tambem. Isso pode propagar ate a raiz."

### O QUE MOSTRAR:
Executar o Main.java e mostrar:
1. Inserir 10 (arvore vazia)
2. Inserir 20 (folha tem espaco)
3. Inserir 30 (DIVISAO! mostrar como divide)
4. Inserir 40, 50, 60 (mostrar divisoes propagando)

COMANDO: java Main

---

## MINUTO 4-6: BUSCA (2 min)

### O QUE FALAR:
"A busca e bem simples, parecida com arvore binaria de busca."

"Comecamos na raiz e comparamos:
1. Se a chave esta no no atual, encontramos!
2. Se e menor que chave1, vamos pro filho esquerdo
3. Se esta entre chave1 e chave2, vamos pro filho do meio
4. Se e maior que chave2, vamos pro filho direito
5. Se chegamos em null, a chave nao existe"

### O QUE MOSTRAR:
Abrir o codigo e mostrar o metodo buscarRecursivo
Executar algumas buscas no Main.java

---

## MINUTO 6-9: REMOCAO (3 min)

### O QUE FALAR:
"A remocao e a operacao MAIS COMPLEXA da Arvore 2-3."

"Existem dois casos principais:"

"CASO 1 - Remover de uma FOLHA:
- Se a folha tem 2 chaves, simplesmente removemos uma
- Se a folha tem 1 chave, precisamos REBALANCEAR"

"CASO 2 - Remover de um NO INTERNO:
- Substituimos pela PREDECESSORA (maior valor da subarvore esquerda)
- Depois removemos a predecessora da folha"

"O rebalanceamento tem duas estrategias:
1. REDISTRIBUICAO: Pega uma chave emprestada do irmao
2. FUSAO: Une dois nos quando nao da pra redistribuir"

"Isso mantem a propriedade de que todas as folhas ficam no mesmo nivel."

### O QUE MOSTRAR:
1. Mostrar no codigo o metodo remover
2. Executar remocoes no Main.java
3. Mostrar como a arvore se reorganiza

---

## MINUTO 9-10: APLICACOES E CONCLUSAO (1 min)

### O QUE FALAR:
"A Arvore 2-3 e muito importante porque foi a BASE para criar as Arvores B, que sao usadas em bancos de dados para indexacao."

"Vantagens:
- Sempre balanceada (todas as folhas no mesmo nivel)
- Busca, insercao e remocao em O(log n)
- Boa para memoria secundaria"

"Desvantagens:
- Implementacao complexa (como voces viram!)
- A Arvore B e mais usada na pratica por ser mais flexivel"

"O codigo completo esta no meu GitHub. Obrigado!"

### O QUE MOSTRAR:
- Mostrar a arvore final no terminal
- Mostrar rapidamente o repositorio no GitHub

---

## DICAS DE GRAVACAO:

1. ANTES DE GRAVAR:
   - Compile e teste o codigo
   - Deixe o terminal pronto
   - Teste o audio/video

2. DURANTE A GRAVACAO:
   - Fale devagar e com clareza
   - Mostre o codigo E os resultados
   - Use zoom quando mostrar codigo

3. FERRAMENTAS:
   - OBS Studio (gravar tela)
   - QuickTime (Mac)
   - Zoom no IntelliJ (Cmd + scroll)

4. ESTRUTURA:
   - Alterne entre EXPLICAR e MOSTRAR
   - Nao fique so lendo codigo
   - Execute e mostre funcionando

---

## CHECKLIST FINAL:

[ ] Audio claro
[ ] Tela visivel (zoom no codigo)
[ ] Mostrou insercao funcionando
[ ] Mostrou busca funcionando
[ ] Mostrou remocao funcionando
[ ] Explicou rebalanceamento
[ ] Falou sobre aplicacoes
[ ] Ate 10 minutos
[ ] Link do GitHub no final
