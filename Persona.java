/**
 * Persona
 */
public class Persona {
    String primerNombre;
    String apellido;
    int edad;
    Genero genero;
    double precio;

    public Persona(String primerNombre, String apellido, int edad, Genero genero, double precio){
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format(precio == 0?"%s %s edad: %d genero: %s precio: %s":"%s %s edad: %d genero: %s precio: %.2f", primerNombre, apellido, edad, genero, precio==0?"Gratis":precio);
    }

    public enum Genero{Masculino,Femenino}
}