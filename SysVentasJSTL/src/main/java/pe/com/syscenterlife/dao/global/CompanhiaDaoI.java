
package pe.com.syscenterlife.dao.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloCompanhia;

/**
 *
 * @author pc
 */
public interface CompanhiaDaoI {
    public List<GloCompanhia> listarEntidad();
    public List<GloCompanhia> listarEntidadDato(String dato);
    public GloCompanhia buscarEntidadId(int id);
    public void guardarEntidad(GloCompanhia companhia);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloCompanhia companhia);
}
