/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author David
 * @param <PK>
 * @param <E>
 */
public abstract class SysDataAccess<PK extends Serializable, E>{
	public final Class<E> persistentClass;
	protected final Log logger;

	@Autowired(required = true)
	public SessionFactory sessionFactory;     

        
        @SuppressWarnings("unchecked")
	public SysDataAccess(){
		this.persistentClass =(Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
                this.logger = LogFactory.getLog(this.persistentClass);
	}
	
           
        
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}    
	
        @SuppressWarnings("unchecked")
	public E getByKey(PK key) {
		return (E) getSession().get(persistentClass, key);
	}
	public void persist(E entity) {		
                try{                 
                  getSession().persist(entity);                
                }catch (Exception e){
                  this.logger.info("Mensage de Error en Al momento de Guardar " + e.getMessage());
                }                 
	}        
        public E save(E entity){
                try{                 
                  getSession().save(entity);                  
                }catch (Exception e){
                  this.logger.info("Mensage de Error en Al momento de Guardar " + e.getMessage());
                }  
                return entity;
        }        
        public void savev(E entity){                
                try{                 
                  getSession().save(entity);                  
                }catch (Exception e){
                  this.logger.info("Mensage de Error en Al momento de Guardar " + e.getMessage());
                }               
        }              
        public E update(E entity){
            try{
              getSession().update(entity);
            }
            catch (Exception e){
              this.logger.info("Mensage de Error en Al momento de Actualizar " + e.getMessage());
            }
            return entity;
        }  
        public void delete(String id){
              try{
                getSession().delete(getSession().get(this.persistentClass, id));
              }
              catch (Exception e){
                this.logger.info("Mensage de Error en Al momento de Eliminar " + e.getMessage());
              }
        }  
        public void delete(Serializable id){
              try{                
                getSession().delete(getSession().get(this.persistentClass, id));
              }catch (Exception e){
                this.logger.info("Mensage de Error en Al momento de Eliminar " + e.getMessage());
              }
        }  
        public void delete(int id){
              try{
                getSession().delete(getSession().get(this.persistentClass, id));
              }catch (Exception e){
                this.logger.info("Mensage de Error en Al momento de Eliminar " + e.getMessage());
              }
        }  
        public void remove(E entity){
              try{
                getSession().delete(entity);
              }catch (Exception e){
                this.logger.info("Mensage de Error en Al momento de Eliminar o Remover " + e.getMessage());
              }
        }  
        public E getById(Serializable id){
              E entidad = null;
              try{
                entidad = (E)(Serializable)getSession().createCriteria(this.persistentClass).add(Restrictions.idEq(id)).uniqueResult();
              }catch (HibernateException e){
                this.logger.info("Mensage de Error en Al momento de Buscar por el Id " + e.getMessage());
              }
              return entidad;
        }  
        public E getById(int id){
              E entidad = null;
              try{
                entidad = (E)(Serializable)getSession().get(this.persistentClass, id);
              }catch (Exception e){
                this.logger.info("Mensage de Error en Al momento de Buscar por el Id " + e.getMessage());
              }
              return entidad;
        }
        public E getByStrId(String id){
              E entidad = null;
              try{
                entidad = (E)(Serializable)getSession().get(this.persistentClass, id);
              }catch (Exception e){
                this.logger.info("Mensage de Error en Al momento de Buscar por el Id " + e.getMessage());
              }
              return entidad;
        }  
        public E getById(String id){
              E entidad = null;
              try{
                entidad = (E)(Serializable)getSession().get(this.persistentClass, id);
              }
              catch (Exception e){
                this.logger.info("Mensage de Error en Al momento de Buscar por el Id " + e.getMessage());
              }
              return entidad;
        }  
        public List<E> getListAll(){
              List<E> lista = null;
              try{
                lista = getSession().createCriteria(this.persistentClass).list();
                if (lista == null) {
                  lista = new ArrayList();
                }}
              catch (HibernateException e){
                this.logger.info("Mensage de Error en Al momento de Listar una Entidad " + e.getMessage());
              }
              return lista;
      }
        public List<E> getListId(String id){
              List<E> lista = null;
              try{
                lista = getSession().createCriteria(this.persistentClass).add(Restrictions.idEq(id)).list();
                if(lista == null){
                  lista = new ArrayList();
                }
              }catch (HibernateException e){
                this.logger.info("Mensage de Error en Al momento de Listar una Entidad " + e.getMessage());
              }
              return lista;
        }
        public List<E> getListId(Serializable id){
              List<E> lista = null;
              try{
                lista = getSession().createCriteria(this.persistentClass).add(Restrictions.idEq(id)).list();
                if(lista == null) {
                  lista = new ArrayList();
                }
              }catch (HibernateException e){
                this.logger.info("Mensage de Error en Al momento de Listar una Entidad " + e.getMessage());
              }
              return lista;
        }  
        public List<E> getListId(int id){
                  List<E> lista = null;
                  try{
                    lista = getSession().createCriteria(this.persistentClass).add(Restrictions.idEq(id)).list();
                    if (lista == null) {
                      lista = new ArrayList();
                    }

                  }catch (HibernateException e){
                    this.logger.info("Mensage de Error en Al momento de Listar una Entidad " + e.getMessage());
                  }
                  return lista;
        }           
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}        
}
