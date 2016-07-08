/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbm.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FABIO
 */
@Entity
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findId", query = "SELECT e FROM Estado e WHERE E.idestado := param"),
    @NamedQuery(name = "Estado.findNombre", query = "SELECT e FROM Estado e WHERE e.nombre := param"),
    @NamedQuery(name = "Estado.findAlias",query = "SELECT e FROM Estado e WHERE e.alias := param"),
    @NamedQuery(name = "Estado.findFechaRegistro", query = "SELECT e FROM Estado e WHERE e.fecharegistro BETWEEN param1 AND param2"),
    @NamedQuery(name = "Estado.findFechaModificacion", query = "SELECT e FROM Estado e WHERE e.fechamodificacion BETWEEN param1 AND param2"),
    @NamedQuery(name = "Estado.findFechaEliminacion", query = "SELECT e FROM Estado e WHERE e.fechaeliminacion BETWEEN param1 AND param2")

})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestado")
    private BigDecimal idestado;
    @Size(max = 10)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 3)
    @Column(name = "alias")
    private String alias;
    @Size(max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Column(name = "fechaeliminacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaeliminacion;

    public Estado() {
    }

    public Estado(BigDecimal idestado) {
        this.idestado = idestado;
    }

    public BigDecimal getIdestado() {
        return idestado;
    }

    public void setIdestado(BigDecimal idestado) {
        this.idestado = idestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Date getFechaeliminacion() {
        return fechaeliminacion;
    }

    public void setFechaeliminacion(Date fechaeliminacion) {
        this.fechaeliminacion = fechaeliminacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestado != null ? idestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.idestado == null && other.idestado != null) || (this.idestado != null && !this.idestado.equals(other.idestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  idestado + " " +nombre;
    }
    
}