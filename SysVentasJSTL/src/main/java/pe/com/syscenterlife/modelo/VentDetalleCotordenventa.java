/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author davidmp
 */
@Entity
@Table(name = "vent_detalle_cotordenventa")
@NamedQueries({
    @NamedQuery(name = "VentDetalleCotordenventa.findAll", query = "SELECT v FROM VentDetalleCotordenventa v")})
public class VentDetalleCotordenventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetallecotordenventa")
    private Integer idDetallecotordenventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idArticulo")
    private int idArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "dc")
    private String dc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "detalle")
    private String detalle;
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
    @Column(name = "base_imp")
    private double baseImp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "igv")
    private double igv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exonerados")
    private double exonerados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inafectos")
    private double inafectos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuestoigv")
    private double impuestoigv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTrabajador")
    private int idTrabajador;
    @JoinColumn(name = "idCotordenventa", referencedColumnName = "idCotordenventa")
    @ManyToOne(optional = false)
    private VentCotordenventa idCotordenventa;

    public VentDetalleCotordenventa() {
    }

    public VentDetalleCotordenventa(Integer idDetallecotordenventa) {
        this.idDetallecotordenventa = idDetallecotordenventa;
    }

    public VentDetalleCotordenventa(Integer idDetallecotordenventa, int idArticulo, String dc, String detalle, double cantidad, double preciounit, double baseImp, double igv, double importe, double exonerados, double inafectos, double impuestoigv, Date fechaEntrega, int idTrabajador) {
        this.idDetallecotordenventa = idDetallecotordenventa;
        this.idArticulo = idArticulo;
        this.dc = dc;
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.preciounit = preciounit;
        this.baseImp = baseImp;
        this.igv = igv;
        this.importe = importe;
        this.exonerados = exonerados;
        this.inafectos = inafectos;
        this.impuestoigv = impuestoigv;
        this.fechaEntrega = fechaEntrega;
        this.idTrabajador = idTrabajador;
    }

    public Integer getIdDetallecotordenventa() {
        return idDetallecotordenventa;
    }

    public void setIdDetallecotordenventa(Integer idDetallecotordenventa) {
        this.idDetallecotordenventa = idDetallecotordenventa;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
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

    public double getBaseImp() {
        return baseImp;
    }

    public void setBaseImp(double baseImp) {
        this.baseImp = baseImp;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getExonerados() {
        return exonerados;
    }

    public void setExonerados(double exonerados) {
        this.exonerados = exonerados;
    }

    public double getInafectos() {
        return inafectos;
    }

    public void setInafectos(double inafectos) {
        this.inafectos = inafectos;
    }

    public double getImpuestoigv() {
        return impuestoigv;
    }

    public void setImpuestoigv(double impuestoigv) {
        this.impuestoigv = impuestoigv;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public VentCotordenventa getIdCotordenventa() {
        return idCotordenventa;
    }

    public void setIdCotordenventa(VentCotordenventa idCotordenventa) {
        this.idCotordenventa = idCotordenventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallecotordenventa != null ? idDetallecotordenventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentDetalleCotordenventa)) {
            return false;
        }
        VentDetalleCotordenventa other = (VentDetalleCotordenventa) object;
        if ((this.idDetallecotordenventa == null && other.idDetallecotordenventa != null) || (this.idDetallecotordenventa != null && !this.idDetallecotordenventa.equals(other.idDetallecotordenventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentDetalleCotordenventa[ idDetallecotordenventa=" + idDetallecotordenventa + " ]";
    }
    
}
