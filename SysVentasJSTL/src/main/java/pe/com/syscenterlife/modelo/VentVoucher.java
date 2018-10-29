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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vent_voucher")
@NamedQueries({
    @NamedQuery(name = "VentVoucher.findAll", query = "SELECT v FROM VentVoucher v")})
public class VentVoucher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVoucher")
    private Integer idVoucher;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVenta")
    private int idVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "voucher")
    private String voucher;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "libro")
    private String libro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "modulo")
    private String modulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lote")
    private String lote;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVoucher")
    private Collection<VentVentas> ventVentasCollection;
    @JoinColumn(name = "idAperturaPeriodo", referencedColumnName = "idAperturaPeriodo")
    @ManyToOne(optional = false)
    private GloAperturaPeriodo idAperturaPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVoucher")
    private Collection<VentVentaServicio> ventVentaServicioCollection;

    public VentVoucher() {
    }

    public VentVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }

    public VentVoucher(Integer idVoucher, int idVenta, String voucher, String libro, Date fecha, String estado, String modulo, String lote) {
        this.idVoucher = idVoucher;
        this.idVenta = idVenta;
        this.voucher = voucher;
        this.libro = libro;
        this.fecha = fecha;
        this.estado = estado;
        this.modulo = modulo;
        this.lote = lote;
    }

    public Integer getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Collection<VentVentas> getVentVentasCollection() {
        return ventVentasCollection;
    }

    public void setVentVentasCollection(Collection<VentVentas> ventVentasCollection) {
        this.ventVentasCollection = ventVentasCollection;
    }

    public GloAperturaPeriodo getIdAperturaPeriodo() {
        return idAperturaPeriodo;
    }

    public void setIdAperturaPeriodo(GloAperturaPeriodo idAperturaPeriodo) {
        this.idAperturaPeriodo = idAperturaPeriodo;
    }

    public Collection<VentVentaServicio> getVentVentaServicioCollection() {
        return ventVentaServicioCollection;
    }

    public void setVentVentaServicioCollection(Collection<VentVentaServicio> ventVentaServicioCollection) {
        this.ventVentaServicioCollection = ventVentaServicioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVoucher != null ? idVoucher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentVoucher)) {
            return false;
        }
        VentVoucher other = (VentVoucher) object;
        if ((this.idVoucher == null && other.idVoucher != null) || (this.idVoucher != null && !this.idVoucher.equals(other.idVoucher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentVoucher[ idVoucher=" + idVoucher + " ]";
    }
    
}
