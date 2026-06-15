package trabalhoJunior;
import trabalhoJunior.Cliente;
import trabalhoJunior.FilaCliente;
import java.util.Date;
public class TesteFilaCliente {
	public static void main(String[] args) {
		Cliente cliente = new Cliente("791384265", "Jorge", new Date(), "Ali", "1395271", "Aurilandia");
		System.out.println(cliente.getNome());
	}
}