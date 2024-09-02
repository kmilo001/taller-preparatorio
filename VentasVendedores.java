import java.util.Scanner;

// Clase principal que contiene el método main
public class VentasVendedores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vendedor[] vendedores = new Vendedor[5]; // Array para 5 vendedores

        // Leer nombres y ventas de los vendedores
        for (int i = 0; i < vendedores.length; i++) {
            System.out.print("Ingrese el nombre del vendedor " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            vendedores[i] = new Vendedor(nombre);

            // Leer las ventas de cada mes para el vendedor actual
            for (int mes = 0; mes < 12; mes++) {
                System.out.print("Ingrese las ventas del mes " + (mes + 1) + " para " + nombre + ": ");
                int venta = scanner.nextInt();
                vendedores[i].setVentas(mes, venta);
            }
            scanner.nextLine(); // Limpiar el buffer
        }

        // Encontrar el vendedor con mayores ventas
        Vendedor mejorVendedor = vendedores[0];
        int maxVentas = mejorVendedor.getTotalVentas();

        for (int i = 1; i < vendedores.length; i++) {
            int ventasActuales = vendedores[i].getTotalVentas();
            if (ventasActuales > maxVentas) {
                mejorVendedor = vendedores[i];
                maxVentas = ventasActuales;
            }
        }

        // Mostrar el resultado
        System.out.println("El vendedor con mayores ventas es: " + mejorVendedor.getNombre());
        System.out.println("Ventas totales: " + maxVentas);

        
    }
}

// Clase no pública Vendedor dentro del mismo archivo
class Vendedor {
    private String nombre;
    private int[] ventas; // Ventas de cada mes

    // Constructor de la clase Vendedor
    public Vendedor(String nombre) {
        this.nombre = nombre;
        this.ventas = new int[12]; // Inicializamos para 12 meses
    }

    // Método getter para el nombre del vendedor
    public String getNombre() {
        return nombre;
    }

    // Método setter para las ventas de un mes específico
    public void setVentas(int mes, int venta) {
        if (mes >= 0 && mes < 12) {
            this.ventas[mes] = venta;
        }
    }

    // Método getter para obtener las ventas de un mes específico
    public int getVenta(int mes) {
        if (mes >= 0 && mes < 12) {
            return ventas[mes];
        } else {
            return 0; // Retornar 0 si el mes no es válido
        }
    }

    // Método para calcular el total de ventas en el año
    public int getTotalVentas() {
        int total = 0;
        for (int venta : ventas) {
            total += venta;
        }
        return total;
    }
}


