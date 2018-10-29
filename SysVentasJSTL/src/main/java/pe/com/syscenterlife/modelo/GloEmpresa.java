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
@Table(name = "glo_empresa")
@NamedQueries({
    @NamedQuery(name = "GloEmpresa.findAll", query = "SELECT g FROM GloEmpresa g")})
public class GloEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpresa")
    private Integer idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "razonsocial")
    private String razonsocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion")
    private String descripcion;
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
    @Size(min = 1, max = 80)
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
    @Column(name = "repLegal")
    private String repLegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "docidentReplegal")
    private String docidentReplegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombreAnho")
    private String nombreAnho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "gradoReplegal")
    private String gradoReplegal;
    @JoinColumn(name = "idCompanhia", referencedColumnName = "idCompanhia")
    @ManyToOne(optional = false)
    private GloCompanhia idCompanhia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private Collection<GloSucursal> gloSucursalCollection;

    public GloEmpresa() {
    }

    public GloEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public GloEmpresa(Integer idEmpresa, String razonsocial, String descripcion, String direccionlegal, String direccionref, String telefono, String celular, String ruc, String paginaweb, String email, String logo, String siglas, String repLegal, String docidentReplegal, String nombreAnho, String gradoReplegal) {
        this.idEmpresa = idEmpresa;
        this.razonsocial = razonsocial;
        this.descripcion = descripcion;
        this.direccionlegal = direccionlegal;
        this.direccionref = direccionref;
        this.telefono = telefono;
        this.celular = celular;
        this.ruc = ruc;
        this.paginaweb = paginaweb;
        this.email = email;
        this.logo = logo;
        this.siglas = siglas;
        this.repLegal = repLegal;
        this.docidentReplegal = docidentReplegal;
        this.nombreAnho = nombreAnho;
        this.gradoReplegal = gradoReplegal;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getRepLegal() {
        return repLegal;
    }

    public void setRepLegal(String repLegal) {
        this.repLegal = repLegal;
    }

    public String getDocidentReplegal() {
        return docidentReplegal;
    }

    public void setDocidentReplegal(String docidentReplegal) {
        this.docidentReplegal = docidentReplegal;
    }

    public String getNombreAnho() {
        return nombreAnho;
    }

    public void setNombreAnho(String nombreAnho) {
        this.nombreAnho = nombreAnho;
    }

    public String getGradoReplegal() {
        return gradoReplegal;
    }

    public void setGradoReplegal(String gradoReplegal) {
        this.gradoReplegal = gradoReplegal;
    }

    public GloCompanhia getIdCompanhia() {
        return idCompanhia;
    }

    public void setIdCompanhia(GloCompanhia idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public Collection<GloSucursal> getGloSucursalCollection() {
        return gloSucursalCollection;
    }

    public void setGloSucursalCollection(Collection<GloSucursal> gloSucursalCollection) {
        this.gloSucursalCollection = gloSucursalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloEmpresa)) {
            return false;
        }
        GloEmpresa other = (GloEmpresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloEmpresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
