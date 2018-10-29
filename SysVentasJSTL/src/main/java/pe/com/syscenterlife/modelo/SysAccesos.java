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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sys_accesos")
@NamedQueries({
    @NamedQuery(name = "SysAccesos.findAll", query = "SELECT s FROM SysAccesos s")})
public class SysAccesos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAccesos")
    private Integer idAccesos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo_seg")
    private String codigoSeg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_orden")
    private int nroOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "imagen")
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAccesos")
    private Collection<SysPrivilegios> sysPrivilegiosCollection;
    @JoinColumn(name = "idMenu", referencedColumnName = "idMenu")
    @ManyToOne(optional = false)
    private SysMenu idMenu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAccesos")
    private Collection<SysAccesosPerfiles> sysAccesosPerfilesCollection;

    public SysAccesos() {
    }

    public SysAccesos(Integer idAccesos) {
        this.idAccesos = idAccesos;
    }

    public SysAccesos(Integer idAccesos, String nombre, String descripcion, String url, String codigoSeg, int nroOrden, String estado, String imagen) {
        this.idAccesos = idAccesos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.codigoSeg = codigoSeg;
        this.nroOrden = nroOrden;
        this.estado = estado;
        this.imagen = imagen;
    }

    public Integer getIdAccesos() {
        return idAccesos;
    }

    public void setIdAccesos(Integer idAccesos) {
        this.idAccesos = idAccesos;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCodigoSeg() {
        return codigoSeg;
    }

    public void setCodigoSeg(String codigoSeg) {
        this.codigoSeg = codigoSeg;
    }

    public int getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(int nroOrden) {
        this.nroOrden = nroOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Collection<SysPrivilegios> getSysPrivilegiosCollection() {
        return sysPrivilegiosCollection;
    }

    public void setSysPrivilegiosCollection(Collection<SysPrivilegios> sysPrivilegiosCollection) {
        this.sysPrivilegiosCollection = sysPrivilegiosCollection;
    }

    public SysMenu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(SysMenu idMenu) {
        this.idMenu = idMenu;
    }

    public Collection<SysAccesosPerfiles> getSysAccesosPerfilesCollection() {
        return sysAccesosPerfilesCollection;
    }

    public void setSysAccesosPerfilesCollection(Collection<SysAccesosPerfiles> sysAccesosPerfilesCollection) {
        this.sysAccesosPerfilesCollection = sysAccesosPerfilesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccesos != null ? idAccesos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysAccesos)) {
            return false;
        }
        SysAccesos other = (SysAccesos) object;
        if ((this.idAccesos == null && other.idAccesos != null) || (this.idAccesos != null && !this.idAccesos.equals(other.idAccesos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.SysAccesos[ idAccesos=" + idAccesos + " ]";
    }
    
}
