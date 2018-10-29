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
@Table(name = "glo_apertura_periodo")
@NamedQueries({
    @NamedQuery(name = "GloAperturaPeriodo.findAll", query = "SELECT g FROM GloAperturaPeriodo g")})
public class GloAperturaPeriodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAperturaPeriodo")
    private Integer idAperturaPeriodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTrabajador")
    private int idTrabajador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAperturaPeriodo")
    private Collection<CompVoucher> compVoucherCollection;
    @JoinColumn(name = "idAlmacen", referencedColumnName = "idAlmacen")
    @ManyToOne(optional = false)
    private GloAlmacen idAlmacen;
    @JoinColumn(name = "idConfiguracion", referencedColumnName = "idConfiguracion")
    @ManyToOne(optional = false)
    private GloConfiguracion idConfiguracion;
    @JoinColumn(name = "idPeriodo", referencedColumnName = "idPeriodo")
    @ManyToOne(optional = false)
    private GloPeriodo idPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAperturaPeriodo")
    private Collection<VentVoucher> ventVoucherCollection;

    public GloAperturaPeriodo() {
    }

    public GloAperturaPeriodo(Integer idAperturaPeriodo) {
        this.idAperturaPeriodo = idAperturaPeriodo;
    }

    public GloAperturaPeriodo(Integer idAperturaPeriodo, String estado, String ip, int idTrabajador) {
        this.idAperturaPeriodo = idAperturaPeriodo;
        this.estado = estado;
        this.ip = ip;
        this.idTrabajador = idTrabajador;
    }

    public Integer getIdAperturaPeriodo() {
        return idAperturaPeriodo;
    }

    public void setIdAperturaPeriodo(Integer idAperturaPeriodo) {
        this.idAperturaPeriodo = idAperturaPeriodo;
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

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Collection<CompVoucher> getCompVoucherCollection() {
        return compVoucherCollection;
    }

    public void setCompVoucherCollection(Collection<CompVoucher> compVoucherCollection) {
        this.compVoucherCollection = compVoucherCollection;
    }

    public GloAlmacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(GloAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public GloConfiguracion getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(GloConfiguracion idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public GloPeriodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(GloPeriodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Collection<VentVoucher> getVentVoucherCollection() {
        return ventVoucherCollection;
    }

    public void setVentVoucherCollection(Collection<VentVoucher> ventVoucherCollection) {
        this.ventVoucherCollection = ventVoucherCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAperturaPeriodo != null ? idAperturaPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloAperturaPeriodo)) {
            return false;
        }
        GloAperturaPeriodo other = (GloAperturaPeriodo) object;
        if ((this.idAperturaPeriodo == null && other.idAperturaPeriodo != null) || (this.idAperturaPeriodo != null && !this.idAperturaPeriodo.equals(other.idAperturaPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloAperturaPeriodo[ idAperturaPeriodo=" + idAperturaPeriodo + " ]";
    }
    
}
