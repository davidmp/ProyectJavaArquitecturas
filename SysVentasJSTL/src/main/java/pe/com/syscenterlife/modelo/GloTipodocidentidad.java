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
@Table(name = "glo_tipodocidentidad")
@NamedQueries({
    @NamedQuery(name = "GloTipodocidentidad.findAll", query = "SELECT g FROM GloTipodocidentidad g")})
public class GloTipodocidentidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipodocidentidad")
    private Integer idTipodocidentidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipodocidentidad")
    private Collection<VentClientes> ventClientesCollection;

    public GloTipodocidentidad() {
    }

    public GloTipodocidentidad(Integer idTipodocidentidad) {
        this.idTipodocidentidad = idTipodocidentidad;
    }

    public GloTipodocidentidad(Integer idTipodocidentidad, String codigo, String descripcion, String estado) {
        this.idTipodocidentidad = idTipodocidentidad;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdTipodocidentidad() {
        return idTipodocidentidad;
    }

    public void setIdTipodocidentidad(Integer idTipodocidentidad) {
        this.idTipodocidentidad = idTipodocidentidad;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<VentClientes> getVentClientesCollection() {
        return ventClientesCollection;
    }

    public void setVentClientesCollection(Collection<VentClientes> ventClientesCollection) {
        this.ventClientesCollection = ventClientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipodocidentidad != null ? idTipodocidentidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloTipodocidentidad)) {
            return false;
        }
        GloTipodocidentidad other = (GloTipodocidentidad) object;
        if ((this.idTipodocidentidad == null && other.idTipodocidentidad != null) || (this.idTipodocidentidad != null && !this.idTipodocidentidad.equals(other.idTipodocidentidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloTipodocidentidad[ idTipodocidentidad=" + idTipodocidentidad + " ]";
    }
    
}
