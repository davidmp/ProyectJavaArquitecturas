/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author davidmp
 */
@Entity
@Table(name = "vent_salidadiv_detalles")
@NamedQueries({
    @NamedQuery(name = "VentSalidadivDetalles.findAll", query = "SELECT v FROM VentSalidadivDetalles v")})
public class VentSalidadivDetalles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalleSalDiv")
    private Integer idDetalleSalDiv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciounit")
    private double preciounit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @JoinColumn(name = "idAlmacenProducto", referencedColumnName = "idAlmacenProducto")
    @ManyToOne(optional = false)
    private GloAlmacenProducto idAlmacenProducto;
    @JoinColumn(name = "idSalidaDiversa", referencedColumnName = "idSalidaDiversa")
    @ManyToOne(optional = false)
    private VentSalidaDiversa idSalidaDiversa;

    public VentSalidadivDetalles() {
    }

    public VentSalidadivDetalles(Integer idDetalleSalDiv) {
        this.idDetalleSalDiv = idDetalleSalDiv;
    }

    public VentSalidadivDetalles(Integer idDetalleSalDiv, double cantidad, double preciounit, double importe) {
        this.idDetalleSalDiv = idDetalleSalDiv;
        this.cantidad = cantidad;
        this.preciounit = preciounit;
        this.importe = importe;
    }

    public Integer getIdDetalleSalDiv() {
        return idDetalleSalDiv;
    }

    public void setIdDetalleSalDiv(Integer idDetalleSalDiv) {
        this.idDetalleSalDiv = idDetalleSalDiv;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciounit() {
        return preciounit;
    }

    public void setPreciounit(double preciounit) {
        this.preciounit = preciounit;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public GloAlmacenProducto getIdAlmacenProducto() {
        return idAlmacenProducto;
    }

    public void setIdAlmacenProducto(GloAlmacenProducto idAlmacenProducto) {
        this.idAlmacenProducto = idAlmacenProducto;
    }

    public VentSalidaDiversa getIdSalidaDiversa() {
        return idSalidaDiversa;
    }

    public void setIdSalidaDiversa(VentSalidaDiversa idSalidaDiversa) {
        this.idSalidaDiversa = idSalidaDiversa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleSalDiv != null ? idDetalleSalDiv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentSalidadivDetalles)) {
            return false;
        }
        VentSalidadivDetalles other = (VentSalidadivDetalles) object;
        if ((this.idDetalleSalDiv == null && other.idDetalleSalDiv != null) || (this.idDetalleSalDiv != null && !this.idDetalleSalDiv.equals(other.idDetalleSalDiv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentSalidadivDetalles[ idDetalleSalDiv=" + idDetalleSalDiv + " ]";
    }
    
}
