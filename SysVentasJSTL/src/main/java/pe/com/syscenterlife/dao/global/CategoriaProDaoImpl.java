
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloCategoriaProducto;




@Repository
public class CategoriaProDaoImpl extends SysDataAccess<Integer, GloCategoriaProducto> implements CategoriaProDaoI{

    @SuppressWarnings("unchecked")
    
    @Override
    public List<GloCategoriaProducto> listarEntidad() {return getListAll();
    }

    @Override
    public List<GloCategoriaProducto> listarEntidadDato(String dato) {
       return (List<GloCategoriaProducto>)sessionFactory.getCurrentSession()
       .createQuery("SELECT cp from GloCategoriaProducto cp WHERE cp.nombre LIKE ?1")
       .setParameter(1,"%"+ dato+"%")
       .list();
    }

    @Override
    public GloCategoriaProducto buscarEntidadId(int id) {
        return getById(id);}
    

    @Override
    public void guardarEntidad(GloCategoriaProducto categoria) {
        savev(categoria);
    }

    @Override
    public void eliminarEntidad(int id) {
        delete(id);
    }

    @Override
    public void modificarEntidad(GloCategoriaProducto categoria) {
        update(categoria);
    }

  
    
}
