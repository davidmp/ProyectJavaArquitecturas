/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author davidmp
 */
@Entity
@Table(name = "sys_perfiles")
@NamedQueries({
    @NamedQuery(name = "SysPerfiles.findAll", query = "SELECT s FROM SysPerfiles s")})
public class SysPerfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPerfil")
    private Integer idPerfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private Collection<SysAccesosPerfiles> sysAccesosPerfilesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private Collection<GloUsuario> gloUsuarioCollection;

    public SysPerfiles() {
    }

    public SysPerfiles(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public SysPerfiles(Integer idPerfil, String nombre, String descripcion, String estado, String codigo) {
        this.idPerfil = idPerfil;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.codigo = codigo;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Collection<SysAccesosPerfiles> getSysAccesosPerfilesCollection() {
        return sysAccesosPerfilesCollection;
    }

    public void setSysAccesosPerfilesCollection(Collection<SysAccesosPerfiles> sysAccesosPerfilesCollection) {
        this.sysAccesosPerfilesCollection = sysAccesosPerfilesCollection;
    }

    public Collection<GloUsuario> getGloUsuarioCollection() {
        return gloUsuarioCollection;
    }

    public void setGloUsuarioCollection(Collection<GloUsuario> gloUsuarioCollection) {
        this.gloUsuarioCollection = gloUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysPerfiles)) {
            return false;
        }
        SysPerfiles other = (SysPerfiles) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.SysPerfiles[ idPerfil=" + idPerfil + " ]";
    }
    
}
