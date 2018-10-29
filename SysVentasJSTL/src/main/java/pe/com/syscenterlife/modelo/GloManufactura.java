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
@Table(name = "glo_manufactura")
@NamedQueries({
    @NamedQuery(name = "GloManufactura.findAll", query = "SELECT g FROM GloManufactura g")})
public class GloManufactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idManufactura")
    private Integer idManufactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idManufactura")
    private Collection<GloManufacturaAlmacen> gloManufacturaAlmacenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idManufactura")
    private Collection<GloUnidadmedManufact> gloUnidadmedManufactCollection;
    @JoinColumn(name = "idCategoriamanufactura", referencedColumnName = "idCategoriamanufactura")
    @ManyToOne(optional = false)
    private GloCategoriamanufact idCategoriamanufactura;
    @JoinColumn(name = "idTipomanufact", referencedColumnName = "idTipomanufact")
    @ManyToOne(optional = false)
    private GloTipomanufact idTipomanufact;

    public GloManufactura() {
    }

    public GloManufactura(Integer idManufactura) {
        this.idManufactura = idManufactura;
    }

    public GloManufactura(Integer idManufactura, String nombre, String estado, String descripcion) {
        this.idManufactura = idManufactura;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public Integer getIdManufactura() {
        return idManufactura;
    }

    public void setIdManufactura(Integer idManufactura) {
        this.idManufactura = idManufactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<GloManufacturaAlmacen> getGloManufacturaAlmacenCollection() {
        return gloManufacturaAlmacenCollection;
    }

    public void setGloManufacturaAlmacenCollection(Collection<GloManufacturaAlmacen> gloManufacturaAlmacenCollection) {
        this.gloManufacturaAlmacenCollection = gloManufacturaAlmacenCollection;
    }

    public Collection<GloUnidadmedManufact> getGloUnidadmedManufactCollection() {
        return gloUnidadmedManufactCollection;
    }

    public void setGloUnidadmedManufactCollection(Collection<GloUnidadmedManufact> gloUnidadmedManufactCollection) {
        this.gloUnidadmedManufactCollection = gloUnidadmedManufactCollection;
    }

    public GloCategoriamanufact getIdCategoriamanufactura() {
        return idCategoriamanufactura;
    }

    public void setIdCategoriamanufactura(GloCategoriamanufact idCategoriamanufactura) {
        this.idCategoriamanufactura = idCategoriamanufactura;
    }

    public GloTipomanufact getIdTipomanufact() {
        return idTipomanufact;
    }

    public void setIdTipomanufact(GloTipomanufact idTipomanufact) {
        this.idTipomanufact = idTipomanufact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idManufactura != null ? idManufactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloManufactura)) {
            return false;
        }
        GloManufactura other = (GloManufactura) object;
        if ((this.idManufactura == null && other.idManufactura != null) || (this.idManufactura != null && !this.idManufactura.equals(other.idManufactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloManufactura[ idManufactura=" + idManufactura + " ]";
    }
    
}
