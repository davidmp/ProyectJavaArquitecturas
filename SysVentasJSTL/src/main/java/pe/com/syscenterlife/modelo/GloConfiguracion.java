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
@Table(name = "glo_configuracion")
@NamedQueries({
    @NamedQuery(name = "GloConfiguracion.findAll", query = "SELECT g FROM GloConfiguracion g")})
public class GloConfiguracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConfiguracion")
    private Integer idConfiguracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "id_cuenta_igv")
    private String idCuentaIgv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "igv_porcent")
    private double igvPorcent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConfiguracion")
    private Collection<GloAperturaPeriodo> gloAperturaPeriodoCollection;

    public GloConfiguracion() {
    }

    public GloConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public GloConfiguracion(Integer idConfiguracion, String idCuentaIgv, double igvPorcent) {
        this.idConfiguracion = idConfiguracion;
        this.idCuentaIgv = idCuentaIgv;
        this.igvPorcent = igvPorcent;
    }

    public Integer getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public String getIdCuentaIgv() {
        return idCuentaIgv;
    }

    public void setIdCuentaIgv(String idCuentaIgv) {
        this.idCuentaIgv = idCuentaIgv;
    }

    public double getIgvPorcent() {
        return igvPorcent;
    }

    public void setIgvPorcent(double igvPorcent) {
        this.igvPorcent = igvPorcent;
    }

    public Collection<GloAperturaPeriodo> getGloAperturaPeriodoCollection() {
        return gloAperturaPeriodoCollection;
    }

    public void setGloAperturaPeriodoCollection(Collection<GloAperturaPeriodo> gloAperturaPeriodoCollection) {
        this.gloAperturaPeriodoCollection = gloAperturaPeriodoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfiguracion != null ? idConfiguracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloConfiguracion)) {
            return false;
        }
        GloConfiguracion other = (GloConfiguracion) object;
        if ((this.idConfiguracion == null && other.idConfiguracion != null) || (this.idConfiguracion != null && !this.idConfiguracion.equals(other.idConfiguracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloConfiguracion[ idConfiguracion=" + idConfiguracion + " ]";
    }
    
}
