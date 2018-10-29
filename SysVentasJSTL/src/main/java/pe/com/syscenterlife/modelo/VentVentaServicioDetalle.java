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
@Table(name = "vent_venta_servicio_detalle")
@NamedQueries({
    @NamedQuery(name = "VentVentaServicioDetalle.findAll", query = "SELECT v FROM VentVentaServicioDetalle v")})
public class VentVentaServicioDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVentaServicioDetalle")
    private Integer idVentaServicioDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVenta")
    private int idVenta;
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
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTrabajador")
    private int idTrabajador;
    @JoinColumn(name = "idManufactAlmacen", referencedColumnName = "idManufactAlmacen")
    @ManyToOne(optional = false)
    private GloManufacturaAlmacen idManufactAlmacen;
    @JoinColumn(name = "idVentaServicio", referencedColumnName = "idVentaServicio")
    @ManyToOne(optional = false)
    private VentVentaServicio idVentaServicio;

    public VentVentaServicioDetalle() {
    }

    public VentVentaServicioDetalle(Integer idVentaServicioDetalle) {
        this.idVentaServicioDetalle = idVentaServicioDetalle;
    }

    public VentVentaServicioDetalle(Integer idVentaServicioDetalle, int idVenta, String dc, String detalle, double cantidad, double preciounit, double baseImp, double igv, double importe, double exonerados, double inafectos, double impuestoigv, String estado, Date fechaEntrega, int idTrabajador) {
        this.idVentaServicioDetalle = idVentaServicioDetalle;
        this.idVenta = idVenta;
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
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.idTrabajador = idTrabajador;
    }

    public Integer getIdVentaServicioDetalle() {
        return idVentaServicioDetalle;
    }

    public void setIdVentaServicioDetalle(Integer idVentaServicioDetalle) {
        this.idVentaServicioDetalle = idVentaServicioDetalle;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public GloManufacturaAlmacen getIdManufactAlmacen() {
        return idManufactAlmacen;
    }

    public void setIdManufactAlmacen(GloManufacturaAlmacen idManufactAlmacen) {
        this.idManufactAlmacen = idManufactAlmacen;
    }

    public VentVentaServicio getIdVentaServicio() {
        return idVentaServicio;
    }

    public void setIdVentaServicio(VentVentaServicio idVentaServicio) {
        this.idVentaServicio = idVentaServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaServicioDetalle != null ? idVentaServicioDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentVentaServicioDetalle)) {
            return false;
        }
        VentVentaServicioDetalle other = (VentVentaServicioDetalle) object;
        if ((this.idVentaServicioDetalle == null && other.idVentaServicioDetalle != null) || (this.idVentaServicioDetalle != null && !this.idVentaServicioDetalle.equals(other.idVentaServicioDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentVentaServicioDetalle[ idVentaServicioDetalle=" + idVentaServicioDetalle + " ]";
    }
    
}
