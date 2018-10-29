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
@Table(name = "glo_codigopostal")
@NamedQueries({
    @NamedQuery(name = "GloCodigopostal.findAll", query = "SELECT g FROM GloCodigopostal g")})
public class GloCodigopostal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCodigoPostal")
    private Integer idCodigoPostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ubigeo")
    private String ubigeo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "distrito")
    private String distrito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "departamento")
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "pais")
    private String pais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCodigoPostal")
    private Collection<CompProveedores> compProveedoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCodigoPostal")
    private Collection<VentClientes> ventClientesCollection;

    public GloCodigopostal() {
    }

    public GloCodigopostal(Integer idCodigoPostal) {
        this.idCodigoPostal = idCodigoPostal;
    }

    public GloCodigopostal(Integer idCodigoPostal, String ubigeo, String distrito, String provincia, String departamento, String pais) {
        this.idCodigoPostal = idCodigoPostal;
        this.ubigeo = ubigeo;
        this.distrito = distrito;
        this.provincia = provincia;
        this.departamento = departamento;
        this.pais = pais;
    }

    public Integer getIdCodigoPostal() {
        return idCodigoPostal;
    }

    public void setIdCodigoPostal(Integer idCodigoPostal) {
        this.idCodigoPostal = idCodigoPostal;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Collection<CompProveedores> getCompProveedoresCollection() {
        return compProveedoresCollection;
    }

    public void setCompProveedoresCollection(Collection<CompProveedores> compProveedoresCollection) {
        this.compProveedoresCollection = compProveedoresCollection;
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
        hash += (idCodigoPostal != null ? idCodigoPostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloCodigopostal)) {
            return false;
        }
        GloCodigopostal other = (GloCodigopostal) object;
        if ((this.idCodigoPostal == null && other.idCodigoPostal != null) || (this.idCodigoPostal != null && !this.idCodigoPostal.equals(other.idCodigoPostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloCodigopostal[ idCodigoPostal=" + idCodigoPostal + " ]";
    }
    
}
