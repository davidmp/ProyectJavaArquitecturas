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
@Table(name = "glo_productos")
@NamedQueries({
    @NamedQuery(name = "GloProductos.findAll", query = "SELECT g FROM GloProductos g")})
public class GloProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciounitario")
    private double preciounitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<GloAlmacenProducto> gloAlmacenProductoCollection;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private GloCategoriaProducto idCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<GloUnidadmedProducto> gloUnidadmedProductoCollection;

    public GloProductos() {
    }

    public GloProductos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public GloProductos(Integer idProducto, String nombre, String descripcion, double preciounitario, int estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preciounitario = preciounitario;
        this.estado = estado;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Collection<GloAlmacenProducto> getGloAlmacenProductoCollection() {
        return gloAlmacenProductoCollection;
    }

    public void setGloAlmacenProductoCollection(Collection<GloAlmacenProducto> gloAlmacenProductoCollection) {
        this.gloAlmacenProductoCollection = gloAlmacenProductoCollection;
    }

    public GloCategoriaProducto getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(GloCategoriaProducto idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Collection<GloUnidadmedProducto> getGloUnidadmedProductoCollection() {
        return gloUnidadmedProductoCollection;
    }

    public void setGloUnidadmedProductoCollection(Collection<GloUnidadmedProducto> gloUnidadmedProductoCollection) {
        this.gloUnidadmedProductoCollection = gloUnidadmedProductoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GloProductos)) {
            return false;
        }
        GloProductos other = (GloProductos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.GloProductos[ idProducto=" + idProducto + " ]";
    }
    
}
