*1. Ideia Geral do Projeto*

Regra: *O primeiro que chega é o primeiro que sai = FIFO*.
Só que o banco falou: "nossa fila tem limite de 5 pessoas". Por isso é *fila estática* = tamanho fixo.

Usamos um vetor porque é rápido e simples. Mas vetor normal dá problema: se você só remove do início, sobra buraco. Solução: *fila circular*. Quando chega no final do vetor, volta pro começo.

---

*2. Classe `Cliente` - A ficha do cliente*

Essa classe é só pra guardar os dados. Cada cliente é uma ficha.
private int codigo; // Ex: 1, 2, 3
private String nome; // "João da Silva"
private Date data; // Data de nascimento
private String endereco; // "Rua A, 123"
private String telefone; // "6499999-8888"
private String cidade; // "Urutaí" - importante pra buscar depois
*Por que `private`?* Pra ninguém de fora mudar o código do cliente direto. Só muda usando `setCodigo()`. Isso é encapsulamento.

*Construtores*: São as "fábricas" de cliente.
1. `Cliente()` vazio: cria cliente sem nada, preenche depois com setters.
2. `Cliente(...)` cheio: já cria com todos os dados de uma vez.

*`exibir()`*: Método de conveniência. Em vez de dar 6 `System.out.println` toda hora, você só chama `joao.exibir()`.

---

*3. Classe `FilaCliente` - A fila de verdade*

*3.1 Os 4 atributos que controlam tudo*
private Cliente[] cliente; // Array de clientes
private int inicio; // Primeiro cliente que será removido
private int fim; // Espaço queo próximo liente pode entrar
private int tamanho; // Quantos clientes tem na fila agora
Exemplo visual com `maxTam = 5`:
Índice: 0 1 2 3 4
Gaveta: [João][Maria][ ][ ][ ]
         ↑ ↑
       inicio=0 fim=2
       tamanho=2
*3.2 `enfileira()` - Cliente chegando na fila*
if ((fim + 1) % this.cliente.length == inicio) {
    throw new Exception("Erro: A fila está cheia");
}

Se a próxima gaveta do `fim` for `inicio`, tá cheio.
Por que `% length`? Pra dar a volta. Se `fim = 4` e `length = 5`, `(4+1)%5 = 0`. Se `inicio` também for 0, bateu.
this.cliente[fim] = cliente;
fim = (fim + 1) % this.cliente.length;
tamanho++;
1. Coloca o cliente no `fim`
2. `fim` anda pra próxima posição. O `%` faz ele voltar pra 0 se passar do final
3. Aumenta contador de `tamanho`

*3.3 `desenfileira()` - Remove cliente*
if (vazia()) {
    throw new Exception("Erro: A fila está vazia");
}
Se `inicio == fim`, não tem ninguém.
Cliente removido = this.cliente[inicio];
inicio = (inicio + 1) % this.cliente.length;
tamanho--;
return removido;
1. Pega o cliente da gaveta `inicio` pra devolver
2. `inicio` anda pra próxima. O `%` faz circular também
3. Diminui `tamanho`
4. Retorna quem foi atendido

*Por que circular?*
Sem `%`, se você atender 5 clientes, `inicio` vira 5 e a fila "trava" mesmo tendo gavetas 0-4 vazias. Com `%`, ele volta pra 0 e reutiliza.

*3.4 Métodos de Busca - Achar cliente na fila*

Os 3 são iguais, só muda o `if`. Vou explicar `buscarClienteNome`:
int i = inicio; // Começa a procurar do primeiro da fila
boolean encontrou = false; // Flag pra saber se achou alguém

while (i!= fim) { // Enquanto não chegou no fim da fila
    if (cliente[i].getNome().equalsIgnoreCase(nome)) { // Compara ignorando maiúscula
        cliente[i].exibir(); // Achou, mostra na tela
        encontrou = true;
    }
    i = (i + 1) % cliente.length; // Anda pra próxima posição, circular
}

if (!encontrou) {
    System.out.println("Cliente não encontrado!");
}
*Ponto chave*: `i!= fim` e `i = (i+1) % length`. Isso garante que você só olha nas posiçõess que têm cliente, do `inicio` até o `fim`.
Se a fila tá nas posições 3, 4, 0, ele percorre 3→4→0 certinho.

`buscarClienteCodigo` compara `==` porque é `int`.
`buscarClienteCidade` usa `equalsIgnoreCase` também.

*3.5 `vazia()` e o detalhe da posição sacrificada*
public boolean vazia() {
    return inicio == fim;
}
Se `inicio` alcançou `fim`, a fila esvaziou.

Mas pra diferenciar "vazia" de "cheia", essa lógica sacrifica 1 posição.
Fila com `maxTam = 5` guarda só 4 clientes.
Quando tem 4, `(fim + 1) % 5 == inicio`, então dá "cheia" antes de usar a última gaveta.

Por quê? Se usasse todas, `cheia` também seria `inicio == fim`. Ia confundir com vazia. É o preço da fila circular simples.

---

*4. Classe `TesteFilaCliente` - Testando se funciona*

1. *Cria fila de tamanho 5*: `new FilaCliente(5)` = 5 posiçõess, mas só cabem 4 clientes.
2. *Cria 3 clientes*: c1 João, c2 Maria, c3 Pedro.
3. *Enfileira*: João entra na posição 0, Maria na 1, Pedro na 2. `fim` para na 3.
4. *Imprime*: Mostra os 3 em ordem.
5. *Busca*: Procura Maria por nome, código 2, e todos de Urutaí. Tem que achar João e Pedro.
6. *Remove*: `desenfileira` tira João, que era o `inicio`. Agora `inicio` vira 1.
7. *Imprime de novo*: Só Maria e Pedro sobram.
8. *Tamanho*: `getTamanho()` retorna 2.

O `try-catch` tá ali porque os métodos lançam `Exception` se der erro. Se tentar inserir o 5º cliente, cai no `catch` e mostra "Erro: A fila está cheia".
