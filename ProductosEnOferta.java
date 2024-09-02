import java.util.Scanner;

public class ProductosEnOferta {

    private String[][] nombresProductos; // Matriz para almacenar los nombres de los productos
    private int[][] matrizProductos;     // Matriz para almacenar el estado de los productos (0 o 1)
    private int n;                       // Tamaño de la matriz (n x n)

    // Método para establecer el tamaño de la matriz y inicializarla
    public void inicializarMatriz(int n) {
        this.n = n;
        matrizProductos = new int[n][n];     // Inicializamos la matriz de estados
        nombresProductos = new String[n][n]; // Inicializamos la matriz de nombres
    }

    // Método para establecer el nombre y el estado de un producto en la matriz
    public void setProducto(int fila, int columna, String nombre, int valor) {
        nombresProductos[fila][columna] = nombre;
        matrizProductos[fila][columna] = valor;
    }

    // Método para contar los productos en oferta (valor 1)
    public int contarProductosEnOferta() {
        int contador = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrizProductos[i][j] == 1) {  // Si el producto está en oferta (valor 1)
                    contador++;  // Incrementamos el contador
                }
            }
        }
        return contador;  // Retornamos el número total de productos en oferta
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductosEnOferta productos = new ProductosEnOferta();

        System.out.print("Ingrese el tamaño de la matriz (n): ");
        int n = scanner.nextInt();
        productos.inicializarMatriz(n);

        // Ingresar datos en la matriz
        System.out.println("Ingrese los nombres y estados de los productos (0 para no oferta, 1 para oferta):");
        scanner.nextLine(); // Limpiar el buffer del Scanner
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Nombre del producto [" + i + "][" + j + "]: ");
                String nombre = scanner.nextLine();

                int valor;
                while (true) {
                    System.out.print("¿El producto está en oferta? (0 para no, 1 para sí): ");
                    if (scanner.hasNextInt()) {
                        valor = scanner.nextInt();
                        if (valor == 0 || valor == 1) {  // Validar la entrada
                            break;  // Salir del bucle si la entrada es válida
                        } else {
                            System.out.println("Error: Debe ingresar 0 o 1.");
                        }
                    } else {
                        System.out.println("Error: Debe ingresar un número (0 o 1).");
                        scanner.next(); // Limpiar la entrada no válida
                    }
                }

                productos.setProducto(i, j, nombre, valor);
                scanner.nextLine(); // Limpiar el buffer del Scanner
            }
        }

        // Contar y mostrar la cantidad de productos en oferta
        int totalOfertas = productos.contarProductosEnOferta();
        System.out.println("Total de productos en oferta: " + totalOfertas);
    }
}