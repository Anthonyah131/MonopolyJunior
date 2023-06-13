package cr.ac.una.monopolyjunior.model;

import cr.ac.una.monopolyjunior.model.Propiedad;
import cr.ac.una.monopolyjunior.model.Tablero;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-13T09:04:49", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Jugador.class)
public class Jugador_ { 

    public static volatile SingularAttribute<Jugador, Tablero> tabId;
    public static volatile SingularAttribute<Jugador, String> ficha;
    public static volatile ListAttribute<Jugador, Propiedad> propiedadList;
    public static volatile SingularAttribute<Jugador, Long> id;
    public static volatile SingularAttribute<Jugador, Long> saldo;
    public static volatile SingularAttribute<Jugador, String> nombre;
    public static volatile SingularAttribute<Jugador, Long> posicionX;
    public static volatile SingularAttribute<Jugador, Long> posicionY;

}