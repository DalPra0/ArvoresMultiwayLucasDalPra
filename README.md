# Arvore 2-3 - Implementacao Completa

Implementacao de uma Arvore 2-3 em Java puro, sem uso de bibliotecas prontas.

## Autor
Lucas Dal Pra Brascher

## O que e Arvore 2-3?

A Arvore 2-3 e uma estrutura de dados multiway onde:
- Cada no tem **1 ou 2 chaves**
- Cada no tem **2 ou 3 filhos** (se nao for folha)
- **Todas as folhas ficam no mesmo nivel**
- Arvore sempre **balanceada automaticamente**

## Funcionalidades Implementadas

### ✅ Insercao
- Insercao em folhas
- Divisao de nos quando necessario
- Propagacao de divisoes ate a raiz
- Criacao de nova raiz quando necessario

### ✅ Busca
- Busca recursiva
- Complexidade O(log n)
- Retorna true/false

### ✅ Remocao
- Remocao em folhas
- Remocao em nos internos (substitui pela predecessora)
- Redistribuicao de chaves entre irmaos
- Fusao de nos quando necessario
- Rebalanceamento automatico

### ✅ Impressao
- Impressao em ordem (in-order traversal)
- Impressao da estrutura hierarquica da arvore

## Como Executar

```bash
# Compile
javac src/*.java

# Execute
java -cp src Main
```

## Estrutura do Projeto

```
src/
├── No23.java              # Classe do no da arvore
├── Arvore23.java          # Classe principal da arvore
├── ResultadoInsercao.java # Classe auxiliar para insercao
└── Main.java              # Exemplos de uso
```

## Exemplo de Uso

```java
Arvore23 arvore = new Arvore23();

// Insercao
arvore.inserir(10);
arvore.inserir(20);
arvore.inserir(30);

// Busca
boolean encontrou = arvore.buscar(20); // true

// Remocao
arvore.remover(20);

// Impressao
arvore.imprimirArvore();
```

## Complexidade

| Operacao | Complexidade |
|----------|--------------|
| Busca    | O(log n)     |
| Insercao | O(log n)     |
| Remocao  | O(log n)     |

## Aplicacoes Praticas

- Base para **Arvores B** (usadas em bancos de dados)
- Indexacao de dados em memoria secundaria
- Estruturas de dados sempre balanceadas

## Restricoes de Implementacao

Seguindo as regras do trabalho:
- ❌ Sem uso de estruturas prontas (List, ArrayList, etc)
- ❌ Sem StringBuilder
- ❌ Sem try/catch/exceptions
- ✅ Length permitido apenas para Strings
- ✅ Implementacao 100% manual

## Video Explicativo

[Link do YouTube será adicionado aqui]

## Licenca

Projeto academico - PUCPR 2024
