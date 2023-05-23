package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class PropiedadDto {

    private String nombre;
    private int precioCompra;
    private int renta;
    private boolean hipotecada;
    private int valorHipoteca;
    private JugadorDto propietario;

    public PropiedadDto() {
        this.nombre = "";
        this.precioCompra = 0;
        this.renta = 0;
        this.hipotecada = false;
        this.valorHipoteca = 0;
        this.propietario = null;
    }

    public PropiedadDto(String nombre, int precioCompra, int renta, int valorHipoteca) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.renta = renta;
        this.hipotecada = false;
        this.valorHipoteca = valorHipoteca;
        this.propietario = null;
    }

    // Getters y setters
    public String getNombre() {
        return this.nombre;
    }

    public int getPrecioCompra() {
        return this.precioCompra;
    }

    public int getRenta() {
        return this.renta;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

    public void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }

    public int getValorHipoteca() {
        return valorHipoteca;
    }

    public void setValorHipoteca(int valorHipoteca) {
        this.valorHipoteca = valorHipoteca;
    }

    public JugadorDto getPropietario() {
        return this.propietario;
    }

    public void setPropietario(JugadorDto propietario) {
        this.propietario = propietario;
    }
    
    public boolean tienePropietario() {
        return this.propietario != null;
    }
}