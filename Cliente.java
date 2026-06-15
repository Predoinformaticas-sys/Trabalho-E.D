package trabalhoJunior;

import java.util.Date;

public class Cliente {
    private int codigo;
    private String nome;
    private Date data;
    private String endereco;
    private String telefone;
    private String cidade;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, Date data, String endereco, String telefone, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.data = data;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cidade = cidade;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // Método para exibir dados
    public void exibir() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Cidade: " + cidade);
        System.out.println("----------------------------");
    }
}