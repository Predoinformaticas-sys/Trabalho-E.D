package trabalhoJunior;
public class FilaCliente {
	private Cliente cliente[];
	private int inicio;
	private int fim;
	private int tamanho;
	
	public int getTamanho() {
		return tamanho;
	}
	public FilaCliente(int maxTam) {
		this.cliente = new Cliente[maxTam];
		this.inicio = 0;
		this.fim = this.inicio;
		this.tamanho = 0;
	}
	
	//Search Clients
	public void buscarClienteNome(String nome) throws Exception {
		if( this.vazia()) {
			throw new Exception("Erro: A fila está vazia");
		}
		int i = inicio;
		while ( i != fim) {
			if(cliente[i].getNome().equals(nome)) {
				System.out.println(cliente[i].getCidade() + cliente[i].getCodigo() + cliente[i].getData() + cliente[i].getEndereco() + cliente[i].getNome() + cliente[i].getTelefone());
				break;
			}
			i = (i+1) % this.cliente.length;
		}
	}
	public void buscarClienteCodigo(String codigo) throws Exception{
		if( this.vazia()) {
			throw new Exception("Erro: A fila está vazia");
		}
		int i = inicio;
		while(i != fim) {
			if(cliente[i].getCodigo().equals(codigo)) {
				System.out.println(cliente[i].getCodigo() + cliente[i].getNome() + cliente[i].getData() + cliente[i].getEndereco() + cliente[i].getTelefone() + cliente[i].getCidade());
				break;
			}
			i = (i+1) % this.cliente.length;
		}
	}	
	public void buscarClienteCidade(String cidade) throws Exception{
		if( this.vazia()) {
			throw new Exception("Erro: A fila está vazia");
		}
		int i = inicio;
		while(i != fim) {
			if(cliente[i].getCidade().equals(cidade)) {
				System.out.println(cliente[i].getCodigo() + cliente[i].getNome() + cliente[i].getData() + cliente[i].getEndereco() + cliente[i].getTelefone() + cliente[i].getCidade());
				break;
			}
			i = (i+1) % this.cliente.length;
		}
	}
	
	public void enfileira(Cliente cliente) throws Exception {
		if ( ( this.fim + 1) % this.cliente.length == this.inicio)
			throw new Exception("Erro:A fila esta cheia");
		this.cliente[this.fim] = cliente;
		this.fim = (this.fim + 1) % this.cliente.length;
		tamanho++;
	}
	
	public Cliente desenfileira( ) throws Exception {
		if ( this.vazia() )
		throw new Exception("Erro: A fila esta vazia");
		Cliente cliente = this.cliente[this.inicio];
		this.inicio = (this.inicio+1) % this.cliente.length;
		tamanho--;
		return cliente;
	}
	
	public boolean vazia( ){
		return (this.inicio == this.fim);
	}
	
	public void imprime ( ) {
		if ( !this.vazia() ) {
			int i = inicio;
			while ( i != fim) {
				System.out.print( cliente[i].getNome() + " ");
				i = (i+1) % this.cliente.length;
			}
		}
	}	
}