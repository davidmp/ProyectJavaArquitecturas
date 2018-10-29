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
@Table(name = "glo_unidadmed_manufact")
@NamedQueries({
    @NamedQuery(name = "GloUnidadmedManufact.findAll", query = "SELECT g FROM GloUnidadmedManufact g")})
public class GloUnidadmedManufact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUnidadManufact")
    private Integer idUnidadManufact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private int orden;
    @JoinColumn(name = "idManufactura", referencedColumnName = "idManufactura")
    @ManyToOne(optional = false)
    private GloManufactura idManufactura;
    @JoinColumn(name = "idUnidadMedida", referencedColumnName = "idUnidadMedida")
    @ManyToOne(optional = false)
    private GloUnidadMedida idUnidadMedida;

    public GloUnidadmedManufact() {
    }

    public GloUnidadmedManufact(Integer idUnidadManufact) {
        this.idUnidadManufact = idUnidadManufact;
    }

    public GloUnidadmedManufact(Integer idUnidadManufact, double cantidad, int orden) {
        this.idUnidadManufact = idUnidadManufact;
        this.cantidad = cantidad;
        this.orden = orden;
    }

    public Integer getIdUnidadManufact() {
        return idUnidadManufact;
    }

    public void setIdUnidadManufact(Integer idUnidadManufact) {
        this.idUnidadManufact = idUnidadManufact;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public GloManufactura getIdManufactura() {
        return idManufactura;
    }

    public void setIdManufactura(GloManufactura idManufactura) {
        this.idManufactura = idManufactura;
    }

    public GloUnidadMedida getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(GloUnidadMedida idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadManufact != null ? idUnidadManufact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloUnidadmedManufact)) {
            return false;
        }
        GloUnidadmedManufact other = (GloUnidadmedManufact) object;
        if ((this.idUnidadManufact == null && other.idUnidadManufact != null) || (this.idUnidadManufact != null && !this.idUnidadManufact.equals(other.idUnidadManufact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloUnidadmedManufact[ idUnidadManufact=" + idUnidadManufact + " ]";
    }
    
}
