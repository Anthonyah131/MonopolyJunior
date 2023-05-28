package cr.ac.una.monopolyjunior.model;

import cr.ac.una.monopolyjunior.model.Jugador;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-27T21:41:58", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Tablero.class)
public class Tablero_ { 

    public static volatile ListAttribute<Tablero, Jugador> jugadorList;
    public static volatile SingularAttribute<Tablero, String> jugador1debe;
    public static volatile SingularAttribute<Tablero, String> jugador2debe;
    public static volatile SingularAttribute<Tablero, Long> id;

}