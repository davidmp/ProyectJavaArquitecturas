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
@Table(name = "vent_clientes")
@NamedQueries({
    @NamedQuery(name = "VentClientes.findAll", query = "SELECT v FROM VentClientes v")})
public class VentClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "paterno")
    private String paterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "materno")
    private String materno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numdoc_ident")
    private String numdocIdent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "celularcontacto")
    private String celularcontacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "direccion_fiscal")
    private String direccionFiscal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "idCodigoPostal", referencedColumnName = "idCodigoPostal")
    @ManyToOne(optional = false)
    private GloCodigopostal idCodigoPostal;
    @JoinColumn(name = "idTipoCliente", referencedColumnName = "idTipoCliente")
    @ManyToOne(optional = false)
    private VentTipoCliente idTipoCliente;
    @JoinColumn(name = "idTipodocidentidad", referencedColumnName = "idTipodocidentidad")
    @ManyToOne(optional = false)
    private GloTipodocidentidad idTipodocidentidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<VentVentas> ventVentasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<VentDespachos> ventDespachosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<VentVentaServicio> ventVentaServicioCollection;

    public VentClientes() {
    }

    public VentClientes(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public VentClientes(Integer idCliente, String nombre, String paterno, String materno, int estado, String ruc, String numdocIdent, Date fechaNacimiento, String celularcontacto, String direccionFiscal, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.estado = estado;
        this.ruc = ruc;
        this.numdocIdent = numdocIdent;
        this.fechaNacimiento = fechaNacimiento;
        this.celularcontacto = celularcontacto;
        this.direccionFiscal = direccionFiscal;
        this.direccion = direccion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNumdocIdent() {
        return numdocIdent;
    }

    public void setNumdocIdent(String numdocIdent) {
        this.numdocIdent = numdocIdent;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelularcontacto() {
        return celularcontacto;
    }

    public void setCelularcontacto(String celularcontacto) {
        this.celularcontacto = celularcontacto;
    }

    public String getDireccionFiscal() {
        return direccionFiscal;
    }

    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public GloCodigopostal getIdCodigoPostal() {
        return idCodigoPostal;
    }

    public void setIdCodigoPostal(GloCodigopostal idCodigoPostal) {
        this.idCodigoPostal = idCodigoPostal;
    }

    public VentTipoCliente getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(VentTipoCliente idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public GloTipodocidentidad getIdTipodocidentidad() {
        return idTipodocidentidad;
    }

    public void setIdTipodocidentidad(GloTipodocidentidad idTipodocidentidad) {
        this.idTipodocidentidad = idTipodocidentidad;
    }

    public Collection<VentVentas> getVentVentasCollection() {
        return ventVentasCollection;
    }

    public void setVentVentasCollection(Collection<VentVentas> ventVentasCollection) {
        this.ventVentasCollection = ventVentasCollection;
    }

    public Collection<VentDespachos> getVentDespachosCollection() {
        return ventDespachosCollection;
    }

    public void setVentDespachosCollection(Collection<VentDespachos> ventDespachosCollection) {
        this.ventDespachosCollection = ventDespachosCollection;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentClientes)) {
            return false;
        }
        VentClientes other = (VentClientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.VentClientes[ idCliente=" + idCliente + " ]";
    }
    
}
