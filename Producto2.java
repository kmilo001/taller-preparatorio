import java.util.Scanner;

class Producto2 {
    private String nombre;
    private int cantidad;

    // Constructor
    public Producto2(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para cantidad
    public int getCantidad() {
        return cantidad;
    }

    // Setter para cantidad
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

class Producto1 {
    private Producto2[][] matriz;

    // Constructor
    public Producto1(int filas, int columnas) {
        matriz = new Producto2[filas][columnas];
    }

    // Método para ingresar datos en la matriz
    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Ingrese el nombre del producto en la posición [" + i + "][" + j + "]: ");
                String nombre = scanner.next();
                System.out.println("Ingrese la cantidad para el producto '" + nombre + "': ");
                int cantidad = scanner.nextInt();
                matriz[i][j] = new Producto2(nombre, cantidad);
            }
        }
    }

    // Método para calcular el inventario total
    public int calcularInventarioTotal() {
        int total = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                total += matriz[i][j].getCantidad();
            }
        }

        return total;
    }

    // Método para imprimir los productos
    public void imprimirProductos() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Producto2 producto = matriz[i][j];
                System.out.println("Producto en la posición [" + i + "][" + j + "]: Nombre = " + producto.getNombre() + ", Cantidad = " + producto.getCantidad());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de filas de la matriz: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas de la matriz: ");
        int columnas = scanner.nextInt();

        Producto1 producto1 = new Producto1(filas, columnas);
        producto1.ingresarDatos();

        int inventarioTotal = producto1.calcularInventarioTotal();
        System.out.println("El inventario total de la tienda es: " + inventarioTotal);

        System.out.println("Datos de los productos ingresados:");
        producto1.imprimirProductos();
    }
}
