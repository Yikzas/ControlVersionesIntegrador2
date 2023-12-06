package InterfacesDAO;

import Entidades.Cliente;
import Entidades.Registro;
import java.util.List;

public interface DaoRegistro {
    List<Registro> obtenerRegistros();
    Registro registroGet(Integer IDRegistro);
    String registroIns(Registro registro);
    String registroUpd(Registro registro);
    String registroDel(Integer IDRegistro);
    int obtenerUltimoIDRegistro();
    double obtenerTotalRegistroPorID(Integer idRegistro);
    String obtenerDescuentoRegistroPorID(Integer idRegistro);
    boolean actualizarEstadoRegistro(int idRegistro, String nuevoEstado);
    boolean actualizarTotal(Integer idRegistro, double nuevoTotal);
    List<Cliente> obtenerClientesPorIDRegistro(int idRegistro);
    Cliente obtenerClientePorID(int idCliente);
    boolean insertarRelacion(int idRegistro, int idCliente); 
    String obtenerFechaEntradaPorIDRegistro(int idRegistro);
    String getMensaje();
}
