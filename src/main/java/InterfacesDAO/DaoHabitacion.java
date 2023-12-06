package InterfacesDAO;

import Entidades.Habitacion;
import java.util.List;

public interface DaoHabitacion {
    boolean actualizarEstadoPorID(int idHabitacion, String nuevoEstado);
    boolean insertarHabitacion(Habitacion habitacion);
    String obtenerEstadoPorID(int idHabitacion);
    String obtenerTipoPorID(int idHabitacion);
    boolean insertarRelacionHabitacionR(int idRegistro, int idHabitacion);
    boolean eliminarRelacionHabitacionR(int idRegistro, int idHabitacion);
    int obtenerIDRegistroPorIDHabitacion(int idHabitacion);
    String actualizar(Habitacion habitacion);
    List<Habitacion> habitacionSel();
    String eliminar (int id);
    Habitacion getHabi (int IDHabitacion);
    String getImage(int IDHabitacion);
}

