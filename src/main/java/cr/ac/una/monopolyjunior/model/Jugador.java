/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ANTHONY
 */
@Entity
@Table(name = "MNP_JUGADOR", schema = "UNA")
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j"),
    @NamedQuery(name = "Jugador.findByJugId", query = "SELECT j FROM Jugador j WHERE j.id = :id"),
    @NamedQuery(name = "Jugador.findByJugNombre", query = "SELECT j FROM Jugador j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Jugador.findByJugSaldo", query = "SELECT j FROM Jugador j WHERE j.saldo = :saldo"),
    @NamedQuery(name = "Jugador.findByJugFicha", query = "SELECT j FROM Jugador j WHERE j.ficha = :ficha"),
    @NamedQuery(name = "Jugador.findByJugPosicionx", query = "SELECT j FROM Jugador j WHERE j.posicionX = :posicionX"),
    @NamedQuery(name = "Jugador.findByJugPosiciony", query = "SELECT j FROM Jugador j WHERE j.posicionY = :posicionY")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "MNP_JUGADOR_JUG_ID_GENERATOR", sequenceName = "una.MNP_JUGADOR_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MNP_JUGADOR_JUG_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "JUG_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "JUG_NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "JUG_SALDO")
    private Long saldo;
    @Basic(optional = false)
    @Column(name = "JUG_FICHA")
    private String ficha;
    @Basic(optional = false)
    @Column(name = "JUG_POSICIONX")
    private Long posicionX;
    @Basic(optional = false)
    @Column(name = "JUG_POSICIONY")
    private Long posicionY;
    @OneToMany(mappedBy = "jugId", fetch = FetchType.LAZY)
    private List<Propiedad> propiedadList;
    @JoinColumn(name = "TAB_ID", referencedColumnName = "TAB_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tablero tabId;

    public Jugador() {
    }
    
    public Jugador(Long id) {
        this.id = id;
    }

    public Jugador(Long id, String nombre, Long saldo, String ficha, Long posicionX, Long posicionY) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
        this.ficha = ficha;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public Long getId() {
        return id;
    }

    public Jugador(JugadorDto jugadorDto) {
        this.id = jugadorDto.getId();
        actualizar(jugadorDto);
    }
    
    public void actualizar(JugadorDto jugadorDto) {
        this.nombre = jugadorDto.getNombre();
        this.saldo = Long.valueOf(jugadorDto.getSaldo());
        this.ficha = jugadorDto.getFicha();
        this.posicionX = Long.valueOf(jugadorDto.getPosicionX());
        this.posicionY = Long.valueOf(jugadorDto.getPosicionY());
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public Long getPosicionx() {
        return posicionX;
    }

    public void setPosicionx(Long posicionX) {
        this.posicionX = posicionX;
    }

    public Long getPosiciony() {
        return posicionY;
    }

    public void setPosiciony(Long posicionY) {
        this.posicionY = posicionY;
    }

    public List<Propiedad> getPropiedadList() {
        return propiedadList;
    }

    public void setPropiedadList(List<Propiedad> propiedadList) {
        this.propiedadList = propiedadList;
    }

    public Tablero getTabId() {
        return tabId;
    }

    public void setTabId(Tablero tabId) {
        this.tabId = tabId;
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
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.monopolyjunior.model.Jugador[ id=" + id + " ]";
    }
    
}
