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
@Table(name = "glo_tipomoneda")
@NamedQueries({
    @NamedQuery(name = "GloTipomoneda.findAll", query = "SELECT g FROM GloTipomoneda g")})
public class GloTipomoneda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipomoneda")
    private Integer idTipomoneda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "simbolo")
    private String simbolo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipocambio")
    private double tipocambio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipomoneda")
    private Collection<VentVentas> ventVentasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipomoneda")
    private Collection<CompCompras> compComprasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipomoneda")
    private Collection<VentVentaServicio> ventVentaServicioCollection;

    public GloTipomoneda() {
    }

    public GloTipomoneda(Integer idTipomoneda) {
        this.idTipomoneda = idTipomoneda;
    }

    public GloTipomoneda(Integer idTipomoneda, String codigo, String descripcion, String simbolo, String estado, double tipocambio) {
        this.idTipomoneda = idTipomoneda;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.simbolo = simbolo;
        this.estado = estado;
        this.tipocambio = tipocambio;
    }

    public Integer getIdTipomoneda() {
        return idTipomoneda;
    }

    public void setIdTipomoneda(Integer idTipomoneda) {
        this.idTipomoneda = idTipomoneda;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTipocambio() {
        return tipocambio;
    }

    public void setTipocambio(double tipocambio) {
        this.tipocambio = tipocambio;
    }

    public Collection<VentVentas> getVentVentasCollection() {
        return ventVentasCollection;
    }

    public void setVentVentasCollection(Collection<VentVentas> ventVentasCollection) {
        this.ventVentasCollection = ventVentasCollection;
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
        hash += (idTipomoneda != null ? idTipomoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloTipomoneda)) {
            return false;
        }
        GloTipomoneda other = (GloTipomoneda) object;
        if ((this.idTipomoneda == null && other.idTipomoneda != null) || (this.idTipomoneda != null && !this.idTipomoneda.equals(other.idTipomoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloTipomoneda[ idTipomoneda=" + idTipomoneda + " ]";
    }
    
}
