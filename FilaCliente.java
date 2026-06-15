package trabalhoJunior;

public class FilaCliente {
    private Cliente[] cliente;
    private int inicio;
    private int fim;
    private int tamanho;

    public FilaCliente(int maxTam) {
        this.cliente = new Cliente[maxTam];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean vazia() {
        return inicio == fim;
    }

    // Inserção
    public void enfileira(Cliente cliente) throws Exception {
        if ((fim + 1) % this.cliente.length == inicio) {
            throw new Exception("Erro: A fila está cheia");
        }

        this.cliente[fim] = cliente;
        fim = (fim + 1) % this.cliente.length;
        tamanho++;
    }

    // Remoção
    public Cliente desenfileira() throws Exception {
        if (vazia()) {
            throw new Exception("Erro: A fila está vazia");
        }

        Cliente removido = this.cliente[inicio];
        inicio = (inicio + 1) % this.cliente.length;
        tamanho--;

        return removido;
    }

    // Buscar por nome
    public void buscarClienteNome(String nome) throws Exception {
        if (vazia()) {
            throw new Exception("Erro: A fila está vazia");
        }

        int i = inicio;
        boolean encontrou = false;

        while (i != fim) {
            if (cliente[i].getNome().equalsIgnoreCase(nome)) {
                cliente[i].exibir();
                encontrou = true;
            }
            i = (i + 1) % cliente.length;
        }

        if (!encontrou) {
            System.out.println("Cliente não encontrado!");
        }
    }

    // Buscar por código (int)
    public void buscarClienteCodigo(int codigo) throws Exception {
        if (vazia()) {
            throw new Exception("Erro: A fila está vazia");
        }

        int i = inicio;
        boolean encontrou = false;

        while (i != fim) {
            if (cliente[i].getCodigo() == codigo) {
                cliente[i].exibir();
                encontrou = true;
            }
            i = (i + 1) % cliente.length;
        }

        if (!encontrou) {
            System.out.println("Cliente não encontrado!");
        }
    }

    // Buscar por cidade
    public void buscarClienteCidade(String cidade) throws Exception {
        if (vazia()) {
            throw new Exception("Erro: A fila está vazia");
        }

        int i = inicio;
        boolean encontrou = false;

        while (i != fim) {
            if (cliente[i].getCidade().equalsIgnoreCase(cidade)) {
                cliente[i].exibir();
                encontrou = true;
            }
            i = (i + 1) % cliente.length;
        }

        if (!encontrou) {
            System.out.println("Cliente não encontrado!");
        }
    }

    // Imprimir fila
    public void imprime() {
        if (vazia()) {
            System.out.println("Fila vazia!");
            return;
        }

        int i = inicio;

        while (i != fim) {
            cliente[i].exibir();
            i = (i + 1) % cliente.length;
        }
    }
}