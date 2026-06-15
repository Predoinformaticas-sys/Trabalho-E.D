package trabalhoJunior;
import java.util.Date;
public class Cliente {
	private String codigo;
	private String nome;
	private Date data;
	private String endereco;
	private String telefone;
	private String cidade;
	
	public Cliente() {
	}
	public Cliente(String codigo, String nome, Date data, String endereco, String telefone, String cidade) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setData(data);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.setCidade(cidade);
	}
	
	//Getters and Setters
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}