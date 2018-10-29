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
@Table(name = "comp_compras")
@NamedQueries({
    @NamedQuery(name = "CompCompras.findAll", query = "SELECT c FROM CompCompras c")})
public class CompCompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mov_compra")
    private Integer idMovCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numdoc")
    private String numdoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMovCompra")
    private Collection<CompCompraDetalles> compCompraDetallesCollection;
    @JoinColumn(name = "idVoucher", referencedColumnName = "idVoucher")
    @ManyToOne(optional = false)
    private CompVoucher idVoucher;
    @JoinColumn(name = "idTipomoneda", referencedColumnName = "idTipomoneda")
    @ManyToOne(optional = false)
    private GloTipomoneda idTipomoneda;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private GloUsuario idUsuario;
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor")
    @ManyToOne(optional = false)
    private CompProveedores idProveedor;
    @JoinColumn(name = "idComprobante", referencedColumnName = "idComprobante")
    @ManyToOne(optional = false)
    private GloComprobante idComprobante;

    public CompCompras() {
    }

    public CompCompras(Integer idMovCompra) {
        this.idMovCompra = idMovCompra;
    }

    public CompCompras(Integer idMovCompra, Date fechaCompra, Date fechaRegistro, String serie, String numdoc) {
        this.idMovCompra = idMovCompra;
        this.fechaCompra = fechaCompra;
        this.fechaRegistro = fechaRegistro;
        this.serie = serie;
        this.numdoc = numdoc;
    }

    public Integer getIdMovCompra() {
        return idMovCompra;
    }

    public void setIdMovCompra(Integer idMovCompra) {
        this.idMovCompra = idMovCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public Collection<CompCompraDetalles> getCompCompraDetallesCollection() {
        return compCompraDetallesCollection;
    }

    public void setCompCompraDetallesCollection(Collection<CompCompraDetalles> compCompraDetallesCollection) {
        this.compCompraDetallesCollection = compCompraDetallesCollection;
    }

    public CompVoucher getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(CompVoucher idVoucher) {
        this.idVoucher = idVoucher;
    }

    public GloTipomoneda getIdTipomoneda() {
        return idTipomoneda;
    }

    public void setIdTipomoneda(GloTipomoneda idTipomoneda) {
        this.idTipomoneda = idTipomoneda;
    }

    public GloUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(GloUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public CompProveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(CompProveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    public GloComprobante getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(GloComprobante idComprobante) {
        this.idComprobante = idComprobante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovCompra != null ? idMovCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompCompras)) {
            return false;
        }
        CompCompras other = (CompCompras) object;
        if ((this.idMovCompra == null && other.idMovCompra != null) || (this.idMovCompra != null && !this.idMovCompra.equals(other.idMovCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.syscenterlife.modelo.CompCompras[ idMovCompra=" + idMovCompra + " ]";
    }
    
}
