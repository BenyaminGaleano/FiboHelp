/**
 * Persona
 */
public class Persona {
    String primerNombre;
    String apellido;
    int edad;
    Genero genero;

    public Persona(String primerNombre, String apellido, int edad, Genero genero){
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
    }

    public enum Genero{Masculino,Femenino}
}