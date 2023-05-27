/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "MNP_TABLERO", schema = "UNA")
@NamedQueries({
    @NamedQuery(name = "Tablero.findAll", query = "SELECT t FROM Tablero t"),
    @NamedQuery(name = "Tablero.findByTabId", query = "SELECT t FROM Tablero t WHERE t.id = :id"),
    @NamedQuery(name = "Tablero.findByTabJugador1debe", query = "SELECT t FROM Tablero t WHERE t.jugador1debe = :jugador1debe"),
    @NamedQuery(name = "Tablero.findByTabJugador2debe", query = "SELECT t FROM Tablero t WHERE t.jugador2debe = :jugador2debe")})
public class Tablero implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "MNP_TABLERO_TAB_ID_GENERATOR", sequenceName = "una.MNP_TABLERO_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MNP_TABLERO_TAB_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "TAB_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "TAB_JUGADOR1DEBE")
    private String jugador1debe;
    @Basic(optional = false)
    @Column(name = "TAB_JUGADOR2DEBE")
    private String jugador2debe;
    @OneToMany(mappedBy = "tabId", fetch = FetchType.LAZY)
    private List<Jugador> jugadorList;

    public Tablero() {
    }

    public Tablero(Long id) {
        this.id = id;
    }

    public Tablero(Long id, String jugador1debe, String jugador2debe) {
        this.id = id;
        this.jugador1debe = jugador1debe;
        this.jugador2debe = jugador2debe;
    }
    
    public Tablero(TableroDto tableroDto) {
        this.id = tableroDto.getId();
        actualizarTablero(tableroDto);
    }     
    
    public void actualizarTablero(TableroDto tableroDto){
        this.jugador1debe = tableroDto.player1Debe ? "S" : "N";
        this.jugador2debe = tableroDto.player2Debe ? "S" : "N";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJugador1debe() {
        return jugador1debe;
    }

    public void setJugador1debe(String jugador1debe) {
        this.jugador1debe = jugador1debe;
    }

    public String getJugador2debe() {
        return jugador2debe;
    }

    public void setJugador2debe(String jugador2debe) {
        this.jugador2debe = jugador2debe;
    }

    public List<Jugador> getJugadorList() {
        return jugadorList;
    }

    public void setJugadorList(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
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
        if (!(object instanceof Tablero)) {
            return false;
        }
        Tablero other = (Tablero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.monopolyjunior.model.Tablero[ id=" + id + " ]";
    }
    
}
