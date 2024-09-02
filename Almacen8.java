import java.util.ArrayList;
import java.util.Scanner;

public class Almacen8 {
    private static final int NUM_CATEGORIAS = 3; // Número de categorías (ajustar según sea necesario)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear una matriz para las estanterías
        ArrayList<Producto8>[] estanterias = new ArrayList[NUM_CATEGORIAS];
        
        // Inicializar las listas para cada categoría
        for (int i = 0; i < NUM_CATEGORIAS; i++) {
            estanterias[i] = new ArrayList<>();
        }
        
        System.out.println("Ingrese el número de productos:");
        int numProductos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        for (int i = 0; i < numProductos; i++) {
            System.out.println("Ingrese el nombre del producto:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el peso del producto:");
            double peso = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea
            System.out.println("Ingrese la categoría del producto (0, 1, 2):");
            int categoriaIndex = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            if (categoriaIndex < 0 || categoriaIndex >= NUM_CATEGORIAS) {
                System.out.println("Categoría inválida. Inténtelo de nuevo.");
                i--; // Volver a intentar
                continue;
            }
            
            Producto8 producto = new Producto8(nombre, peso, String.valueOf(categoriaIndex));
            estanterias[categoriaIndex].add(producto);
        }
        
        // Mostrar los productos por categoría
        for (int i = 0; i < NUM_CATEGORIAS; i++) {
            System.out.println("Categoría " + i + ":");
            for (Producto8 p : estanterias[i]) {
                System.out.println("Nombre: " + p.getNombre() + ", Peso: " + p.getPeso());
            }
        }
    }
}
