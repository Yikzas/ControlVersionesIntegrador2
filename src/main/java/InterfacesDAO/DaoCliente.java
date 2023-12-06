package InterfacesDAO;

import Entidades.Cliente;
import java.util.List;

public interface DaoCliente {
    List<Cliente> clienteSel();
    Cliente clienteGet(Integer IDCliente);
    String clienteIns(Cliente cliente);
    String clienteUpd(Cliente cliente);
    String clienteDel(Integer IDCliente);
    Cliente clienteGetByDNI(String dni);
    boolean clienteExists(String dni);
    String getMensaje();
}
