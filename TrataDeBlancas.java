import java.util.LinkedList;
import java.util.Scanner;

/**
 * TrataDeBlancas
 */
public class TrataDeBlancas {
    LinkedList<Persona> personas;

    private TrataDeBlancas(){
        personas = new LinkedList<>();
        personas.add(new Persona("Juanita","Perez",20,Persona.Genero.Femenino,15000));
        personas.add(new Persona("Casimira","Lopez",21,Persona.Genero.Femenino,13000));
        personas.add(new Persona("China","R.",19,Persona.Genero.Femenino, 0));
        personas.add(new Persona("Pepa","Pig",18,Persona.Genero.Femenino,50000));
    }

    private void agregar(Persona persona){
        personas.add(persona);
    }

    private Persona vender(int index){
        return personas.remove(index);
    }

    private void registrar(String primerNombre, String apellido, int edad, Persona.Genero genero, double precio){
        //agregar el codigo para agregar personas a la tienda
    }

    public static void main(String[] args) {
        TrataDeBlancas miTienda = new TrataDeBlancas();
        Scanner scan, reg;
        scan = reg = new Scanner(System.in);
        int op;
        String primerNombre, apellido;
        int edad, genero;
        double precio;
        while (true){
            scan = new Scanner(System.in);
            primerNombre = apellido = null;
            edad = genero = 0;
            precio = 0;
            System.out.println("Menu");
            System.out.println("1. ingresar mercancía");
            System.out.println("2. vender");
            System.out.println("3. salir");
            System.out.print("> ");
            op = scan.nextInt();
            if(op == 3) break;
            if(op == 1){
                reg = new Scanner(System.in);
                System.out.println("\n########## Registro ############\n");
                System.out.print("Nombre: ");
                primerNombre = reg.nextLine();
                System.out.print("Apellido: ");
                apellido = reg.nextLine();
                System.out.print("Edad: ");
                edad = reg.nextInt();
                System.out.print("(1 masculino 2 femenino, cualquier otro femenino) Genero: ");
                genero = reg.nextInt();
                System.out.print("Precio: ");
                precio = reg.nextDouble();
                System.out.println();
                miTienda.registrar(primerNombre, apellido, edad, genero == 1?Persona.Genero.Masculino:Persona.Genero.Femenino, precio);
            }else if(op == 2){
                System.out.println("\n########## Personas en Stock ############\n");
                for(int i = 0; i < miTienda.personas.size(); i++){
                    System.out.println(String.format("%d. %s", i+1, miTienda.personas.get(i)));
                }
                System.out.println();
                System.out.print("Seleccionar (0 para salir) > ");
                op = scan.nextInt();
                if(op != 0) {
                    Persona producto = miTienda.vender(op-1);
                    System.out.println(String.format("se vendió a %s por un precio de %.2f", producto.primerNombre, producto.precio));
                }
                System.out.println();
            }
        }
        scan.close();
        reg.close();
    }
}