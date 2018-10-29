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

/**
 *
 * @author davidmp
 */
@Entity
@Table(name = "glo_almacen_producto")
@NamedQueries({
    @NamedQuery(name = "GloAlmacenProducto.findAll", query = "SELECT g FROM GloAlmacenProducto g")})
public class GloAlmacenProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlmacenProducto")
    private Integer idAlmacenProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_producto")
    private double precioProducto;
    @JoinColumn(name = "idAlmacen", referencedColumnName = "idAlmacen")
    @ManyToOne(optional = false)
    private GloAlmacen idAlmacen;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private GloProductos idProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacenProducto")
    private Collection<CompCompraDetalles> compCompraDetallesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacenProducto")
    private Collection<VentVentasDetalles> ventVentasDetallesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacenProducto")
    private Collection<VentSalidadivDetalles> ventSalidadivDetallesCollection;

    public GloAlmacenProducto() {
    }

    public GloAlmacenProducto(Integer idAlmacenProducto) {
        this.idAlmacenProducto = idAlmacenProducto;
    }

    public GloAlmacenProducto(Integer idAlmacenProducto, double precioProducto) {
        this.idAlmacenProducto = idAlmacenProducto;
        this.precioProducto = precioProducto;
    }

    public Integer getIdAlmacenProducto() {
        return idAlmacenProducto;
    }

    public void setIdAlmacenProducto(Integer idAlmacenProducto) {
        this.idAlmacenProducto = idAlmacenProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public GloAlmacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(GloAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public GloProductos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(GloProductos idProducto) {
        this.idProducto = idProducto;
    }

    public Collection<CompCompraDetalles> getCompCompraDetallesCollection() {
        return compCompraDetallesCollection;
    }

    public void setCompCompraDetallesCollection(Collection<CompCompraDetalles> compCompraDetallesCollection) {
        this.compCompraDetallesCollection = compCompraDetallesCollection;
    }

    public Collection<VentVentasDetalles> getVentVentasDetallesCollection() {
        return ventVentasDetallesCollection;
    }

    public void setVentVentasDetallesCollection(Collection<VentVentasDetalles> ventVentasDetallesCollection) {
        this.ventVentasDetallesCollection = ventVentasDetallesCollection;
    }

    public Collection<VentSalidadivDetalles> getVentSalidadivDetallesCollection() {
        return ventSalidadivDetallesCollection;
    }

    public void setVentSalidadivDetallesCollection(Collection<VentSalidadivDetalles> ventSalidadivDetallesCollection) {
        this.ventSalidadivDetallesCollection = ventSalidadivDetallesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlmacenProducto != null ? idAlmacenProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloAlmacenProducto)) {
            return false;
        }
        GloAlmacenProducto other = (GloAlmacenProducto) object;
        if ((this.idAlmacenProducto == null && other.idAlmacenProducto != null) || (this.idAlmacenProducto != null && !this.idAlmacenProducto.equals(other.idAlmacenProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloAlmacenProducto[ idAlmacenProducto=" + idAlmacenProducto + " ]";
    }
    
}
