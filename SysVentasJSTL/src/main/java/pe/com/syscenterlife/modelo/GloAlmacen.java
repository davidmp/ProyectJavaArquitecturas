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
@Table(name = "glo_almacen")
@NamedQueries({
    @NamedQuery(name = "GloAlmacen.findAll", query = "SELECT g FROM GloAlmacen g")})
public class GloAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlmacen")
    private Integer idAlmacen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreAlmacen")
    private String nombreAlmacen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private Collection<GloUsuarioalmacen> gloUsuarioalmacenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private Collection<GloManufacturaAlmacen> gloManufacturaAlmacenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private Collection<GloAlmacenProducto> gloAlmacenProductoCollection;
    @JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal")
    @ManyToOne(optional = false)
    private GloSucursal idSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private Collection<GloAperturaPeriodo> gloAperturaPeriodoCollection;

    public GloAlmacen() {
    }

    public GloAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public GloAlmacen(Integer idAlmacen, String nombreAlmacen, String descripcion, String estado) {
        this.idAlmacen = idAlmacen;
        this.nombreAlmacen = nombreAlmacen;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
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

    public Collection<GloUsuarioalmacen> getGloUsuarioalmacenCollection() {
        return gloUsuarioalmacenCollection;
    }

    public void setGloUsuarioalmacenCollection(Collection<GloUsuarioalmacen> gloUsuarioalmacenCollection) {
        this.gloUsuarioalmacenCollection = gloUsuarioalmacenCollection;
    }

    public Collection<GloManufacturaAlmacen> getGloManufacturaAlmacenCollection() {
        return gloManufacturaAlmacenCollection;
    }

    public void setGloManufacturaAlmacenCollection(Collection<GloManufacturaAlmacen> gloManufacturaAlmacenCollection) {
        this.gloManufacturaAlmacenCollection = gloManufacturaAlmacenCollection;
    }

    public Collection<GloAlmacenProducto> getGloAlmacenProductoCollection() {
        return gloAlmacenProductoCollection;
    }

    public void setGloAlmacenProductoCollection(Collection<GloAlmacenProducto> gloAlmacenProductoCollection) {
        this.gloAlmacenProductoCollection = gloAlmacenProductoCollection;
    }

    public GloSucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(GloSucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Collection<GloAperturaPeriodo> getGloAperturaPeriodoCollection() {
        return gloAperturaPeriodoCollection;
    }

    public void setGloAperturaPeriodoCollection(Collection<GloAperturaPeriodo> gloAperturaPeriodoCollection) {
        this.gloAperturaPeriodoCollection = gloAperturaPeriodoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlmacen != null ? idAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloAlmacen)) {
            return false;
        }
        GloAlmacen other = (GloAlmacen) object;
        if ((this.idAlmacen == null && other.idAlmacen != null) || (this.idAlmacen != null && !this.idAlmacen.equals(other.idAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloAlmacen[ idAlmacen=" + idAlmacen + " ]";
    }
    
}
