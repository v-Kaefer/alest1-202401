# alest1-202401




26/02/24
Linguagem Utilizada: Java


# Exercícios revisão #1
◼ Construa um método que:
1. Receba um inteiro n e retorne um String com todos os inteiros de 0 até n;
2. Receba um inteiro n e retorne um array com todos os inteiros de 0 até n;
3. Receba um número e retorne true se este número for primo, false caso contrário;
4. Receba dois inteiros e retorne um array com todos os primos entre estes números.
Baseado no material Prof. Michael Moura


# Exercícios revisão #2
◼ Construa um método que:
1. Método que retorna quantas ocorrências de um elemento estão na lista.
int nOcorrencias(int[] l, Integer el)
2. Método que retorna true se l tem elementos repetidos
boolean hasRepeat(int[] l)
3. Método que retorna o número de elementos repetidos em l
int nroRepeat(int[] l)
4. Método que retorna uma lista de elementos repetidos de l
int[] listRepeat(int[] l)
5. Método que retorna a união de l1 e l2
int[] union(int[] l1, int[] l2)
6. Método que retorna a intersecção de l1 e l2
int[] intersect(int[] l1, int[] l2)

# Trabalho 2

## O que deve ser implementado:

* Leitura do arquivo de entrada da simulação.
* Processamento passo a passo ou contínua?
* Iniciar a simulação em um tempo t=0 e a cada <ENTER> que o usuário pressionar ele avança uma unidade de tempo (um ciclo).
* Caso o usuário digite "C" a simulação segue de forma contínua sem interrupção produzindo os resultados.

## Cada pedido processado deve ser inserido em uma Árvore Binária de Pesquisa na ordem em que eles vão sendo produzidos.

Os resultados finais a serem gerados são: 
 - Total de pedidos processados 
 - Total de tempo executado 
 - Pedido mais demorado (se tiver mais de um mostrar todos) 
 - Um CSV com a situação da fila a cada instante t, conforme exemplo na página anterior. 
- Um CSV com o caminhamento em ordem central da ABP gerada pelos pedidos que foram sendo processados, 
contendo apenas o código do pedido e separado por vírgula. 
Observações: 
Não pode ser usado ArrayList nem qualquer outra estrutura para manipulação de listas do Java.