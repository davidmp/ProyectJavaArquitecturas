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
@Table(name = "glo_manufactura_almacen")
@NamedQueries({
    @NamedQuery(name = "GloManufacturaAlmacen.findAll", query = "SELECT g FROM GloManufacturaAlmacen g")})
public class GloManufacturaAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idManufactAlmacen")
    private Integer idManufactAlmacen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockdia")
    private double stockdia;
    @JoinColumn(name = "idAlmacen", referencedColumnName = "idAlmacen")
    @ManyToOne(optional = false)
    private GloAlmacen idAlmacen;
    @JoinColumn(name = "idManufactura", referencedColumnName = "idManufactura")
    @ManyToOne(optional = false)
    private GloManufactura idManufactura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idManufactAlmacen")
    private Collection<VentVentaServicioDetalle> ventVentaServicioDetalleCollection;

    public GloManufacturaAlmacen() {
    }

    public GloManufacturaAlmacen(Integer idManufactAlmacen) {
        this.idManufactAlmacen = idManufactAlmacen;
    }

    public GloManufacturaAlmacen(Integer idManufactAlmacen, double precio, double stockdia) {
        this.idManufactAlmacen = idManufactAlmacen;
        this.precio = precio;
        this.stockdia = stockdia;
    }

    public Integer getIdManufactAlmacen() {
        return idManufactAlmacen;
    }

    public void setIdManufactAlmacen(Integer idManufactAlmacen) {
        this.idManufactAlmacen = idManufactAlmacen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getStockdia() {
        return stockdia;
    }

    public void setStockdia(double stockdia) {
        this.stockdia = stockdia;
    }

    public GloAlmacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(GloAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public GloManufactura getIdManufactura() {
        return idManufactura;
    }

    public void setIdManufactura(GloManufactura idManufactura) {
        this.idManufactura = idManufactura;
    }

    public Collection<VentVentaServicioDetalle> getVentVentaServicioDetalleCollection() {
        return ventVentaServicioDetalleCollection;
    }

    public void setVentVentaServicioDetalleCollection(Collection<VentVentaServicioDetalle> ventVentaServicioDetalleCollection) {
        this.ventVentaServicioDetalleCollection = ventVentaServicioDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idManufactAlmacen != null ? idManufactAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloManufacturaAlmacen)) {
            return false;
        }
        GloManufacturaAlmacen other = (GloManufacturaAlmacen) object;
        if ((this.idManufactAlmacen == null && other.idManufactAlmacen != null) || (this.idManufactAlmacen != null && !this.idManufactAlmacen.equals(other.idManufactAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloManufacturaAlmacen[ idManufactAlmacen=" + idManufactAlmacen + " ]";
    }
    
}
