package InterfacesDAO;

import Entidades.Boleta;

public interface DaoBoleta {
    boolean insertarBoletaVenta(Boleta boletaVenta);
    int obtenerUltimoIDBoletaVenta();
}
