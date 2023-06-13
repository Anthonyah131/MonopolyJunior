package cr.ac.una.monopolyjunior.model;

import cr.ac.una.monopolyjunior.model.Jugador;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-13T09:04:49", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Propiedad.class)
public class Propiedad_ { 

    public static volatile SingularAttribute<Propiedad, String> hipotecada;
    public static volatile SingularAttribute<Propiedad, Long> casas;
    public static volatile SingularAttribute<Propiedad, Long> hotel;
    public static volatile SingularAttribute<Propiedad, Long> id;
    public static volatile SingularAttribute<Propiedad, Jugador> jugId;
    public static volatile SingularAttribute<Propiedad, String> nombre;

}