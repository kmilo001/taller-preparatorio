import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Producto5 {
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto5(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto5{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}

public class FusionMatrices {

    // Método para leer una matriz de productos desde la entrada estándar
    public static Producto5[] leerProductos(Scanner scanner, int tamaño) {
        Producto5[] productos = new Producto5[tamaño];
        for (int i = 0; i < tamaño; i++) {
            System.out.println("Ingrese el nombre del producto " + (i + 1) + ":");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el precio del producto " + (i + 1) + ":");
            double precio = scanner.nextDouble();
            System.out.println("Ingrese el stock del producto " + (i + 1) + ":");
            int stock = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            productos[i] = new Producto5(nombre, precio, stock);
        }
        return productos;
    }

    // Método para fusionar dos matrices de productos
    public static Producto5[] fusionarMatrices(Producto5[] matriz1, Producto5[] matriz2) {
        // Crear una lista para almacenar los productos fusionados
        List<Producto5> listaFusionada = new ArrayList<>();

        // Procesar la primera matriz
        for (Producto5 p1 : matriz1) {
            boolean encontrado = false;
            for (Producto5 p2 : listaFusionada) {
                if (p1.getNombre().equals(p2.getNombre())) {
                    p2.setStock(p2.getStock() + p1.getStock());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                listaFusionada.add(new Producto5(p1.getNombre(), p1.getPrecio(), p1.getStock()));
            }
        }

        // Procesar la segunda matriz
        for (Producto5 p1 : matriz2) {
            boolean encontrado = false;
            for (Producto5 p2 : listaFusionada) {
                if (p1.getNombre().equals(p2.getNombre())) {
                    p2.setStock(p2.getStock() + p1.getStock());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                listaFusionada.add(new Producto5(p1.getNombre(), p1.getPrecio(), p1.getStock()));
            }
        }

        // Convertir la lista en una matriz
        return listaFusionada.toArray(new Producto5[0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la primera matriz
        System.out.println("Ingrese el número de productos para la primera tienda:");
        int tamaño1 = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        Producto5[] tienda1 = leerProductos(scanner, tamaño1);

        // Leer la segunda matriz
        System.out.println("Ingrese el número de productos para la segunda tienda:");
        int tamaño2 = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        Producto5[] tienda2 = leerProductos(scanner, tamaño2);

        // Fusionar las matrices
        Producto5[] fusionados = fusionarMatrices(tienda1, tienda2);

        // Mostrar los productos fusionados
        System.out.println("Productos fusionados:");
        for (Producto5 p : fusionados) {
            System.out.println(p);
        }
    }
}
