import java.util.Scanner;

class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Métodos get
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Métodos set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

public class Producto1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir dimensiones de la matriz
        int filas = 0;
        int columnas = 0;
        System.out.println("Ingrese la cantidad de filas: ");
        filas = scanner.nextInt();
        System.out.println("Ingrese la cantidad de columnas: ");
        columnas = scanner.nextInt();

        // Crear la matriz de productos
        Producto[][] matriz = new Producto[filas][columnas];

        // Ingresar datos en la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Crear nombre automático para cada producto
                System.out.print("Nombre del producto: ");
                String nombre = scanner.next();
                System.out.println("Ingrese los datos del " + nombre + " para la posición [" + i + "][" + j + "]:");
                
                
                

                System.out.print("Precio: ");
                double precio = scanner.nextDouble();

                System.out.print("Cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                matriz[i][j] = new Producto(nombre, precio, cantidad);
            }
        }

        // Buscar un producto por nombre
        System.out.print("Ingrese el nombre del producto a buscar (ej. Producto 1): ");
        String nombreBuscado = scanner.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j].getNombre().equalsIgnoreCase(nombreBuscado)) {
                    System.out.println("Producto encontrado en la posición [" + i + "][" + j + "]");
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) break;
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }

        scanner.close();
    }
}
