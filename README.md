# Sort Comparison em Java  Comb, Gnome, Bucket vs Bubble, Selection, Cocktail  
Projeto que compara seis algoritmos de ordenação clássicos, medindo contadores educacionais, com reprodutibilidade e relatório em HTML.

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-blue" />
  <img src="https://img.shields.io/badge/Build-javac%2Fjar-informational" />
  <img src="https://img.shields.io/badge/Report-HTML-success" />
</p>

---

## Objetivo  
1. Implementar seis algoritmos de ordenação em Java sem bibliotecas externas.  
2. Medir duas métricas comparáveis entre algoritmos de comparação e de distribuição.  
3. Executar as mesmas entradas em um Runner único e gerar uma saída textual e uma página HTML com os resultados.  
4. Servir como base para explicação formal de complexidade, estabilidade, in-place e comportamento adaptativo.

---

## Algoritmos implementados  
Comb Sort, Gnome Sort, Bucket Sort, Bubble Sort, Selection Sort, Cocktail Shaker Sort.

Propriedades principais  
| Algoritmo | Paradigma | Estável | In-place | Adaptativo |
|:--|:--|:--:|:--:|:--:|
| Bubble | comparação, trocas adjacentes | sim | sim | parcialmente |
| Cocktail | comparação, bidirecional | sim | sim | parcialmente |
| Selection | comparação, seleção do mínimo | não | sim | não |
| Comb | comparação, gap decrescente | não | sim | parcialmente |
| Gnome | comparação, correção local | sim | sim | parcialmente |
| Bucket | distribuição por intervalos + inserção | depende da ordenação interna | não estritamente se buckets usam listas | depende da ordenação interna |

Observações  
1. Bucket Sort aqui usa Inserção por bucket para permitir contagem de “trocas adjacentes equivalentes”.  
2. Estabilidade do Bucket depende da estrutura e do sort interno. Ao usar Inserção estável e inserção preservando ordem, o conjunto permanece estável.

---

## Métricas educacionais adotadas  
As duas métricas são independentes de tempo de parede e focam no custo lógico.

1. Swaps trocas  
   Para algoritmos de comparação que usam trocas, cada operação de troca explícita conta 1.  
   Para Bucket, cada deslocamento adjacente na Inserção interna do bucket conta 1, simulando o custo de trocas adjacentes.  

2. Iterações  
   Conta quantas vezes um corpo de laço efetivamente executa. Em for duplos, cada passo do laço interno adiciona 1. Em while, cada execução da iteração conta 1. A contagem é consistente entre algoritmos para permitir comparação.

Validação de ordenação  
A saída final de cada algoritmo é verificada por uma função isSorted não inclusiva, O n, que confirma ordem não decrescente antes de registrar métricas.

---

## Conjuntos de entrada vetores fixos  
vetor1 = (12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28)
vetor2 = (5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32)
vetor3 = (99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6)

---
## Adicional
Relatório HTML  
Após a execução, o Runner grava source_results/index.html com as tabelas e rankings consolidados.

---

## Complexidade assintótica resumo  
| Algoritmo | Melhor | Médio | Pior | Memória |
|:--|:--:|:--:|:--:|:--:|
| Bubble | O n | O n² | O n² | O 1 |
| Cocktail | O n | O n² | O n² | O 1 |
| Selection | O n² | O n² | O n² | O 1 |
| Comb | O n log n aprox | O n log n aprox | O n² | O 1 |
| Gnome | O n | O n² | O n² | O 1 |
| Bucket | O n k  com k buckets | O n k  média uniforme | O n² se tudo cai no mesmo bucket | O n  para buckets |

Leituras rápidas  
1. Selection minimiza trocas, mas mantém alto número de iterações.  
2. Comb reduz inversões longas cedo, aproximando comportamento de Shell-like.  
3. Bucket depende de distribuição dos dados e da ordenação interna.

---


## Validações, invariantes e casos de borda  
1. Entrada nula ou tamanho 0 retorna imediatamente com métricas zeradas.  
2. Arrays são clonados por algoritmo para evitar interferência entre execuções.  
3. Função isSorted verifica ordem e falha aborta a gravação de resultados.  
4. Bucket lida com min=max colocando todos no bucket zero.  
5. Inteiros negativos são suportados por normalização de faixa min..max.


---

## Resultados consolidados fornecidos  
As tabelas abaixo são as mesmas emitidas pelo Runner e publicadas em source_results/index.html.

Vetor 1 tabela completa  
| Algoritmo | Swaps | Iterações | Está ordenado |
|:--|--:|--:|:--:|
| Bubble | 78 | 210 | True |
| Bucket | 23 | 64 | True |
| Cocktail | 78 | 160 | True |
| Comb | 22 | 138 | True |
| Gnome | 78 | 176 | True |
| Selection | 18 | 210 | True |

Ranking por trocas vetor 1  
| Posição | Algoritmo | Swaps |
|--:|:--|--:|
| 1 | Selection | 18 |
| 2 | Comb | 22 |
| 3 | Bucket | 23 |
| 4 | Bubble | 78 |
| 5 | Cocktail | 78 |
| 6 | Gnome | 78 |

Ranking por iterações vetor 1  
| Posição | Algoritmo | Iterações |
|--:|:--|--:|
| 1 | Bucket | 64 |
| 2 | Comb | 138 |
| 3 | Cocktail | 160 |
| 4 | Gnome | 176 |
| 5 | Bubble | 210 |
| 6 | Selection | 210 |

Vetor 2 tabela completa  
| Algoritmo | Swaps | Iterações | Está ordenado |
|:--|--:|--:|:--:|
| Bubble | 0 | 210 | True |
| Bucket | 0 | 41 | True |
| Cocktail | 0 | 20 | True |
| Comb | 0 | 118 | True |
| Gnome | 0 | 20 | True |
| Selection | 0 | 210 | True |

Ranking por trocas vetor 2 todos empatados com 0 swaps  
Ranking por iterações vetor 2  
| Posição | Algoritmo | Iterações |
|--:|:--|--:|
| 1 | Cocktail | 20 |
| 2 | Gnome | 20 |
| 3 | Bucket | 41 |
| 4 | Comb | 118 |
| 5 | Bubble | 210 |
| 6 | Selection | 210 |

Vetor 3 tabela completa  
| Algoritmo | Swaps | Iterações | Está ordenado |
|:--|--:|--:|:--:|
| Bubble | 190 | 210 | True |
| Bucket | 97 | 138 | True |
| Cocktail | 190 | 200 | True |
| Comb | 18 | 138 | True |
| Gnome | 190 | 400 | True |
| Selection | 10 | 210 | True |

Ranking por trocas vetor 3  
| Posição | Algoritmo | Swaps |
|--:|:--|--:|
| 1 | Selection | 10 |
| 2 | Comb | 18 |
| 3 | Bucket | 97 |
| 4 | Bubble | 190 |
| 5 | Cocktail | 190 |
| 6 | Gnome | 190 |

Ranking por iterações vetor 3  
| Posição | Algoritmo | Iterações |
|--:|:--|--:|
| 1 | Bucket | 138 |
| 2 | Comb | 138 |
| 3 | Cocktail | 200 |
| 4 | Bubble | 210 |
| 5 | Selection | 210 |
| 6 | Gnome | 400 |

## Como interpretar  ?
Selection minimiza trocas porque só troca uma vez por posição, mas paga em iterações. Comb vence em vetores com inversões longas. Bucket brilha quando a distribuição é razoavelmente uniforme e os buckets ficam pequenos. Cocktail melhora Bubble no melhor caso pois detecta ordenação mais cedo.



