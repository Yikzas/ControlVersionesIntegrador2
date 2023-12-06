package InterfacesDAO;

import Entidades.Acciones;
import Entidades.Empleado;
import java.util.List;

public interface DaoEmpleado {
    List<Empleado> empleadoSel();
    List<Acciones> listaAccion();
    Empleado empleadoGet(String cargo, String user,String pass);
    String empleadoIns(Empleado empleado);
    String empleadoUpd(Empleado empleado);
    String empleadoDel(String codEmpleado);
    String obtenerCodPorCredenciales(String user, String pass);
    String llevarCodAuxiliar(String codEmp);
    String obtenerCodAuxiliar();
    void eliminarCodAuxiliar();
    void actualizarEstadoEmpleado(String codEmpleado, String nuevoEstado);
    String getMensaje();  
}
