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
@Table(name = "glo_usuario")
@NamedQueries({
    @NamedQuery(name = "GloUsuario.findAll", query = "SELECT g FROM GloUsuario g")})
public class GloUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_acceso")
    @Temporal(TemporalType.DATE)
    private Date fechaAcceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ip")
    private String ip;
    @Column(name = "estado")
    private Integer estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<GloUsuarioalmacen> gloUsuarioalmacenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<VentVentas> ventVentasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<SysPrivilegios> sysPrivilegiosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<VentSalidaDiversa> ventSalidaDiversaCollection;
    @JoinColumn(name = "idAreaUsuario", referencedColumnName = "idAreaUsuario")
    @ManyToOne(optional = false)
    private GloAreaUsuario idAreaUsuario;
    @JoinColumn(name = "idCargo", referencedColumnName = "idCargo")
    @ManyToOne(optional = false)
    private GloCargo idCargo;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private GloPersonas idPersona;
    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil")
    @ManyToOne(optional = false)
    private SysPerfiles idPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<CompCompras> compComprasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<VentVentaServicio> ventVentaServicioCollection;

    public GloUsuario() {
    }

    public GloUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public GloUsuario(Integer idUsuario, Date fechaAcceso, Date fechaAlta, String ip) {
        this.idUsuario = idUsuario;
        this.fechaAcceso = fechaAcceso;
        this.fechaAlta = fechaAlta;
        this.ip = ip;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(Date fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Collection<GloUsuarioalmacen> getGloUsuarioalmacenCollection() {
        return gloUsuarioalmacenCollection;
    }

    public void setGloUsuarioalmacenCollection(Collection<GloUsuarioalmacen> gloUsuarioalmacenCollection) {
        this.gloUsuarioalmacenCollection = gloUsuarioalmacenCollection;
    }

    public Collection<VentVentas> getVentVentasCollection() {
        return ventVentasCollection;
    }

    public void setVentVentasCollection(Collection<VentVentas> ventVentasCollection) {
        this.ventVentasCollection = ventVentasCollection;
    }

    public Collection<SysPrivilegios> getSysPrivilegiosCollection() {
        return sysPrivilegiosCollection;
    }

    public void setSysPrivilegiosCollection(Collection<SysPrivilegios> sysPrivilegiosCollection) {
        this.sysPrivilegiosCollection = sysPrivilegiosCollection;
    }

    public Collection<VentSalidaDiversa> getVentSalidaDiversaCollection() {
        return ventSalidaDiversaCollection;
    }

    public void setVentSalidaDiversaCollection(Collection<VentSalidaDiversa> ventSalidaDiversaCollection) {
        this.ventSalidaDiversaCollection = ventSalidaDiversaCollection;
    }

    public GloAreaUsuario getIdAreaUsuario() {
        return idAreaUsuario;
    }

    public void setIdAreaUsuario(GloAreaUsuario idAreaUsuario) {
        this.idAreaUsuario = idAreaUsuario;
    }

    public GloCargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(GloCargo idCargo) {
        this.idCargo = idCargo;
    }

    public GloPersonas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(GloPersonas idPersona) {
        this.idPersona = idPersona;
    }

    public SysPerfiles getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(SysPerfiles idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Collection<CompCompras> getCompComprasCollection() {
        return compComprasCollection;
    }

    public void setCompComprasCollection(Collection<CompCompras> compComprasCollection) {
        this.compComprasCollection = compComprasCollection;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloUsuario)) {
            return false;
        }
        GloUsuario other = (GloUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
