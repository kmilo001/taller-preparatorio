import java.util.Scanner;

public class MainVehiculo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Vehiculo prueba = new Vehiculo();

        System.out.print("\nIngrese el tamaño de la matriz objetual: ");
        int tam = entrada.nextInt();
        Vehiculo[][] Mo = new Vehiculo[tam][tam]; 

        Mo = prueba.llenarMatrizVehiculos(tam);
        /* El método llenarMatrizVehiculos retorna una matriz objetual de tipo Vehiculo la cual está siendo almacenada
        en la matriz Mo que es de tipo matriz Vehiculo ... 
        El objeto "prueba" es meramente un objeto de la clase Vehiculo para ejecutar métodos ... */
        prueba.mostrarMatriz(Mo);
    }
}
