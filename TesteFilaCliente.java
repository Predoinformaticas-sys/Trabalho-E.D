package trabalhoJunior;

import java.util.Date;

public class TesteFilaCliente {
    public static void main(String[] args) {

        try {
            // Criando fila
            FilaCliente fila = new FilaCliente(5);

            // Criando clientes
            Cliente c1 = new Cliente(1, "João", new Date(), "Rua A", "1111-1111", "Urutaí");
            Cliente c2 = new Cliente(2, "Maria", new Date(), "Rua B", "2222-2222", "Catalão");
            Cliente c3 = new Cliente(3, "Pedro", new Date(), "Rua C", "3333-3333", "Urutaí");

            // Inserindo na fila
            fila.enfileira(c1);
            fila.enfileira(c2);
            fila.enfileira(c3);

            System.out.println("\n--- FILA COMPLETA ---");
            fila.imprime();

            // Busca por nome
            System.out.println("\n--- BUSCA POR NOME (Maria) ---");
            fila.buscarClienteNome("Maria");

            // Busca por código
            System.out.println("\n--- BUSCA POR CÓDIGO (2) ---");
            fila.buscarClienteCodigo(2);

            // Busca por cidade
            System.out.println("\n--- BUSCA POR CIDADE (Urutaí) ---");
            fila.buscarClienteCidade("Urutaí");

            // Remoção
            System.out.println("\n--- REMOÇÃO ---");
            Cliente removido = fila.desenfileira();
            System.out.println("Cliente removido:");
            removido.exibir();

            // Fila depois da remoção
            System.out.println("\n--- FILA APÓS REMOÇÃO ---");
            fila.imprime();

            // Tamanho
            System.out.println("\nTamanho da fila: " + fila.getTamanho());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}