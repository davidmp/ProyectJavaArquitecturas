
package pe.com.syscenterlife.dao.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloSucursal;

/**
 *
 * @author pc
 */
public interface SucursalDaoI {
    public List<GloSucursal> listarEntidad();
    public List<GloSucursal> listarEntidadDato(String dato);
    public GloSucursal buscarEntidadId(int id);
    public void guardarEntidad(GloSucursal sucursal);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloSucursal sucursal);
}
