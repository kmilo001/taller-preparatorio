import java.util.Scanner;

public class Supermercado {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir las dimensiones de la matriz
        System.out.print("Ingrese el número de filas de la matriz: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas de la matriz: ");
        int columnas = scanner.nextInt();
        
        // Crear la matriz original
        Producto6[][] matrizOriginal = new Producto6[filas][columnas];
        
        // Llenar la matriz original con productos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("Ingrese los datos para el producto en la posición [" + i + "][" + j + "]:");
                System.out.print("Nombre: ");
                String nombre = scanner.next();
                System.out.print("Precio: ");
                double precio = scanner.nextDouble();
                System.out.print("Disponibilidad (true/false): ");
                boolean disponibilidad = scanner.nextBoolean();
                matrizOriginal[i][j] = new Producto6(nombre, precio, disponibilidad);
            }
        }
        
        // Filtrar la matriz
        Producto6[][] matrizFiltrada = filtrarProductosDisponibles(matrizOriginal);
        
        // Mostrar la matriz filtrada
        System.out.println("\nProductos disponibles:");
        for (int i = 0; i < matrizFiltrada.length; i++) {
            for (int j = 0; j < matrizFiltrada[i].length; j++) {
                if (matrizFiltrada[i][j] != null) {
                    System.out.println(matrizFiltrada[i][j]);
                }
            }
        }
        
        scanner.close();
    }
    
    // Método para filtrar los productos disponibles
    public static Producto6[][] filtrarProductosDisponibles(Producto6[][] matrizOriginal) {
        // Contar cuántos productos disponibles hay
        int count = 0;
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[i].length; j++) {
                if (matrizOriginal[i][j] != null && matrizOriginal[i][j].getDisponibilidad()) {
                    count++;
                }
            }
        }
        
        // Crear una matriz filtrada con la misma cantidad de filas pero con las columnas ajustadas
        Producto6[][] matrizFiltrada = new Producto6[matrizOriginal.length][count];
        int index = 0;
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[i].length; j++) {
                if (matrizOriginal[i][j] != null && matrizOriginal[i][j].getDisponibilidad()) {
                    matrizFiltrada[i][index++] = matrizOriginal[i][j];
                }
            }
        }
        
        return matrizFiltrada;
    }
}
