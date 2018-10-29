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
@Table(name = "glo_companhia")
@NamedQueries({
    @NamedQuery(name = "GloCompanhia.findAll", query = "SELECT g FROM GloCompanhia g")})
public class GloCompanhia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompanhia")
    private Integer idCompanhia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "razonsocial")
    private String razonsocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "direccionlegal")
    private String direccionlegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "direccionref")
    private String direccionref;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "paginaweb")
    private String paginaweb;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "logo")
    private String logo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "siglas")
    private String siglas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "replegal")
    private String replegal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompanhia")
    private Collection<GloEmpresa> gloEmpresaCollection;

    public GloCompanhia() {
    }

    public GloCompanhia(Integer idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public GloCompanhia(Integer idCompanhia, String nombre, String razonsocial, String direccionlegal, String direccionref, String telefono, String celular, String ruc, String paginaweb, String email, String logo, String siglas, String replegal) {
        this.idCompanhia = idCompanhia;
        this.nombre = nombre;
        this.razonsocial = razonsocial;
        this.direccionlegal = direccionlegal;
        this.direccionref = direccionref;
        this.telefono = telefono;
        this.celular = celular;
        this.ruc = ruc;
        this.paginaweb = paginaweb;
        this.email = email;
        this.logo = logo;
        this.siglas = siglas;
        this.replegal = replegal;
    }

    public Integer getIdCompanhia() {
        return idCompanhia;
    }

    public void setIdCompanhia(Integer idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDireccionlegal() {
        return direccionlegal;
    }

    public void setDireccionlegal(String direccionlegal) {
        this.direccionlegal = direccionlegal;
    }

    public String getDireccionref() {
        return direccionref;
    }

    public void setDireccionref(String direccionref) {
        this.direccionref = direccionref;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getReplegal() {
        return replegal;
    }

    public void setReplegal(String replegal) {
        this.replegal = replegal;
    }

    public Collection<GloEmpresa> getGloEmpresaCollection() {
        return gloEmpresaCollection;
    }

    public void setGloEmpresaCollection(Collection<GloEmpresa> gloEmpresaCollection) {
        this.gloEmpresaCollection = gloEmpresaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompanhia != null ? idCompanhia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloCompanhia)) {
            return false;
        }
        GloCompanhia other = (GloCompanhia) object;
        if ((this.idCompanhia == null && other.idCompanhia != null) || (this.idCompanhia != null && !this.idCompanhia.equals(other.idCompanhia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloCompanhia[ idCompanhia=" + idCompanhia + " ]";
    }
    
}
