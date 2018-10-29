/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author davidmp
 */
@Entity
@Table(name = "vent_cotordenventa")
@NamedQueries({
    @NamedQuery(name = "VentCotordenventa.findAll", query = "SELECT v FROM VentCotordenventa v")})
public class VentCotordenventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCotordenventa")
    private Integer idCotordenventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idComprobante")
    private int idComprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipomoneda")
    private int idTipomoneda;
    @Size(max = 6)
    @Column(name = "tipo_venta")
    private String tipoVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "glosa")
    private String glosa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "export_import")
    private double exportImport;
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
    @Column(name = "exonerados")
    private double exonerados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inafectos")
    private double inafectos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isc")
    private double isc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private double descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anticipo")
    private double anticipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private double saldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_cambio")
    private double tipoCambio;
    @Size(max = 5)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "comentario")
    private String comentario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCotordenventa")
    private Collection<VentDetalleCotordenventa> ventDetalleCotordenventaCollection;

    public VentCotordenventa() {
    }

    public VentCotordenventa(Integer idCotordenventa) {
        this.idCotordenventa = idCotordenventa;
    }

    public VentCotordenventa(Integer idCotordenventa, int idComprobante, int idUsuario, int idCliente, int idTipomoneda, Date fechaVenta, Date fechaVenc, String glosa, double exportImport, double baseImp, double igv, double exonerados, double inafectos, double isc, double importe, double descuento, double anticipo, double saldo, double tipoCambio, String ip, String comentario) {
        this.idCotordenventa = idCotordenventa;
        this.idComprobante = idComprobante;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.idTipomoneda = idTipomoneda;
        this.fechaVenta = fechaVenta;
        this.fechaVenc = fechaVenc;
        this.glosa = glosa;
        this.exportImport = exportImport;
        this.baseImp = baseImp;
        this.igv = igv;
        this.exonerados = exonerados;
        this.inafectos = inafectos;
        this.isc = isc;
        this.importe = importe;
        this.descuento = descuento;
        this.anticipo = anticipo;
        this.saldo = saldo;
        this.tipoCambio = tipoCambio;
        this.ip = ip;
        this.comentario = comentario;
    }

    public Integer getIdCotordenventa() {
        return idCotordenventa;
    }

    public void setIdCotordenventa(Integer idCotordenventa) {
        this.idCotordenventa = idCotordenventa;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipomoneda() {
        return idTipomoneda;
    }

    public void setIdTipomoneda(int idTipomoneda) {
        this.idTipomoneda = idTipomoneda;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public double getExportImport() {
        return exportImport;
    }

    public void setExportImport(double exportImport) {
        this.exportImport = exportImport;
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

    public double getIsc() {
        return isc;
    }

    public void setIsc(double isc) {
        this.isc = isc;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Collection<VentDetalleCotordenventa> getVentDetalleCotordenventaCollection() {
        return ventDetalleCotordenventaCollection;
    }

    public void setVentDetalleCotordenventaCollection(Collection<VentDetalleCotordenventa> ventDetalleCotordenventaCollection) {
        this.ventDetalleCotordenventaCollection = ventDetalleCotordenventaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotordenventa != null ? idCotordenventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentCotordenventa)) {
            return false;
        }
        VentCotordenventa other = (VentCotordenventa) object;
        if ((this.idCotordenventa == null && other.idCotordenventa != null) || (this.idCotordenventa != null && !this.idCotordenventa.equals(other.idCotordenventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentCotordenventa[ idCotordenventa=" + idCotordenventa + " ]";
    }
    
}
