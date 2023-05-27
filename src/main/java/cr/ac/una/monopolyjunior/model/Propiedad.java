/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ANTHONY
 */
@Entity
@Table(name = "MNP_PROPIEDAD", schema = "UNA")
@NamedQueries({
    @NamedQuery(name = "Propiedad.findAll", query = "SELECT p FROM Propiedad p"),
    @NamedQuery(name = "Propiedad.findByProId", query = "SELECT p FROM Propiedad p WHERE p.id = :id"),
    @NamedQuery(name = "Propiedad.findByProNombre", query = "SELECT p FROM Propiedad p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Propiedad.findByProHipotecada", query = "SELECT p FROM Propiedad p WHERE p.hipotecada = :hipotecada"),
    @NamedQuery(name = "Propiedad.findByProCasas", query = "SELECT p FROM Propiedad p WHERE p.casas = :casas"),
    @NamedQuery(name = "Propiedad.findByProHotel", query = "SELECT p FROM Propiedad p WHERE p.hotel = :hotel")})
public class Propiedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "MNP_PROPIEDAD_PRO_ID_GENERATOR", sequenceName = "una.MNP_PROPIEDAD_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MNP_PROPIEDAD_PRO_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "PRO_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "PRO_NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "PRO_HIPOTECADA")
    private String hipotecada;
    @Column(name = "PRO_CASAS")
    private Long casas;
    @Column(name = "PRO_HOTEL")
    private Long hotel;
    @JoinColumn(name = "JUG_ID", referencedColumnName = "JUG_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jugador jugId;

    public Propiedad() {
    }

    public Propiedad(Long id) {
        this.id = id;
    }

    public Propiedad(Long id, String nombre, String hipotecada) {
        this.id = id;
        this.nombre = nombre;
        this.hipotecada = hipotecada;
    }
    
    public Propiedad(PropiedadDto propiedadDto) {
        this.id = propiedadDto.getId();
        actualizar(propiedadDto);
    }
    
    public void actualizar(PropiedadDto propiedadDto) {
        this.nombre = propiedadDto.getNombre();
        this.hipotecada = propiedadDto.isHipotecada() ? "S" : "N";
        this.casas = propiedadDto instanceof Solar ? Long.valueOf(((Solar)propiedadDto).getCasas()) : null;
        this.hotel = propiedadDto instanceof Solar ? Long.valueOf(((Solar)propiedadDto).getHotel()) : null;
    }

    public Long getProId() {
        return id;
    }

    public void setProId(Long id) {
        this.id = id;
    }

    public String getProNombre() {
        return nombre;
    }

    public void setProNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProHipotecada() {
        return hipotecada;
    }

    public void setProHipotecada(String hipotecada) {
        this.hipotecada = hipotecada;
    }

    public Long getProCasas() {
        return casas;
    }

    public void setProCasas(Long casas) {
        this.casas = casas;
    }

    public Long getProHotel() {
        return hotel;
    }

    public void setProHotel(Long hotel) {
        this.hotel = hotel;
    }

    public Jugador getJugId() {
        return jugId;
    }

    public void setJugId(Jugador jugId) {
        this.jugId = jugId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propiedad)) {
            return false;
        }
        Propiedad other = (Propiedad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.monopolyjunior.model.Propiedad[ id=" + id + " ]";
    }
    
}
