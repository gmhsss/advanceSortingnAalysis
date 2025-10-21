
# Sort Comparison (Comb, Gnome, Bucket vs Bubble, Selection, Cocktail)

Este repositório contém implementações em Java de seis algoritmos de ordenação com contadores de:
- trocas (swaps)
- iterações (vezes que um corpo de laço executa)

E uma classe `Runner` que executa nos três vetores solicitados e imprime métricas.

## Observação sobre Bucket Sort e "trocas"
Bucket Sort é um algoritmo baseado em distribuição, que por natureza não faz *trocas* como Bubble/Cocktail/etc.
Para tornar a métrica comparável, **contamos como "trocas" os movimentos adjacentes** realizados na ordenação por inserção usada dentro de cada bucket.

## Vetores
```
vetor1 = (12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28)
vetor2 = (5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32)
vetor3 = (99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6)
```

## Como executar
Compile e rode (Java 17+):
```
javac -d out src/*.java
java -cp out sortcompare.Runner
```

## Resultados (pode conferir também dentro da pasta source_results o index.html com uma pag web básica com todos esses resultados e seus arquivos)!

### Vetor 1 — Tabela completa
| Algoritmo   |   Swaps |   Iterações | Está ordenado?   |
|:------------|--------:|------------:|:-----------------|
| Bubble      |      78 |         210 | True             |
| Bucket      |      23 |          64 | True             |
| Cocktail    |      78 |         160 | True             |
| Comb        |      22 |         138 | True             |
| Gnome       |      78 |         176 | True             |
| Selection   |      18 |         210 | True             |

#### Ranking por trocas (vetor 1)
|   Posição | Algoritmo   |   Swaps |
|----------:|:------------|--------:|
|         1 | Selection   |      18 |
|         2 | Comb        |      22 |
|         3 | Bucket      |      23 |
|         4 | Bubble      |      78 |
|         5 | Cocktail    |      78 |
|         6 | Gnome       |      78 |

#### Ranking por iterações (vetor 1)
|   Posição | Algoritmo   |   Iterações |
|----------:|:------------|------------:|
|         1 | Bucket      |          64 |
|         2 | Comb        |         138 |
|         3 | Cocktail    |         160 |
|         4 | Gnome       |         176 |
|         5 | Bubble      |         210 |
|         6 | Selection   |         210 |

### Vetor 2 — Tabela completa
| Algoritmo   |   Swaps |   Iterações | Está ordenado?   |
|:------------|--------:|------------:|:-----------------|
| Bubble      |       0 |         210 | True             |
| Bucket      |       0 |          41 | True             |
| Cocktail    |       0 |          20 | True             |
| Comb        |       0 |         118 | True             |
| Gnome       |       0 |          20 | True             |
| Selection   |       0 |         210 | True             |

#### Ranking por trocas (vetor 2)
|   Posição | Algoritmo   |   Swaps |
|----------:|:------------|--------:|
|         1 | Bubble      |       0 |
|         2 | Bucket      |       0 |
|         3 | Cocktail    |       0 |
|         4 | Comb        |       0 |
|         5 | Gnome       |       0 |
|         6 | Selection   |       0 |

#### Ranking por iterações (vetor 2)
|   Posição | Algoritmo   |   Iterações |
|----------:|:------------|------------:|
|         1 | Cocktail    |          20 |
|         2 | Gnome       |          20 |
|         3 | Bucket      |          41 |
|         4 | Comb        |         118 |
|         5 | Bubble      |         210 |
|         6 | Selection   |         210 |

### Vetor 3 — Tabela completa
| Algoritmo   |   Swaps |   Iterações | Está ordenado?   |
|:------------|--------:|------------:|:-----------------|
| Bubble      |     190 |         210 | True             |
| Bucket      |      97 |         138 | True             |
| Cocktail    |     190 |         200 | True             |
| Comb        |      18 |         138 | True             |
| Gnome       |     190 |         400 | True             |
| Selection   |      10 |         210 | True             |

#### Ranking por trocas (vetor 3)
|   Posição | Algoritmo   |   Swaps |
|----------:|:------------|--------:|
|         1 | Selection   |      10 |
|         2 | Comb        |      18 |
|         3 | Bucket      |      97 |
|         4 | Bubble      |     190 |
|         5 | Cocktail    |     190 |
|         6 | Gnome       |     190 |

#### Ranking por iterações (vetor 3)
|   Posição | Algoritmo   |   Iterações |
|----------:|:------------|------------:|
|         1 | Bucket      |         138 |
|         2 | Comb        |         138 |
|         3 | Cocktail    |         200 |
|         4 | Bubble      |         210 |
|         5 | Selection   |         210 |
|         6 | Gnome       |         400 |

