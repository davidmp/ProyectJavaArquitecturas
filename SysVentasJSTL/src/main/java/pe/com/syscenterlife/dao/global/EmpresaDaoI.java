
package pe.com.syscenterlife.dao.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloEmpresa;

/**
 *
 * @author pc
 */
public interface EmpresaDaoI {
    public List<GloEmpresa> listarEntidad();
    public List<GloEmpresa> listarEntidadDato(String dato);
    public GloEmpresa buscarEntidadId(int id);
    public void guardarEntidad(GloEmpresa empresa);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloEmpresa empresa);
}
