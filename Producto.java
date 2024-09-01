import java.util.Scanner;

public class Producto {
    private String nombre;
    private int stock;
    private double precio;
    Scanner entrada = new Scanner(System.in);

    public Producto() {
        super();
    }

    public Producto(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para llenar las matrices de tipo Producto
    public Producto[][] llenarTienda(int tam, Producto[][] matrizT, String nombreT) {
        matrizT = new Producto[tam][tam];
        System.out.println("\n ----- INFORMACIÓN DE " + nombreT + " ----- ");
        for (int i = 0; i < matrizT.length; i++) {
            for (int j = 0; j < matrizT.length; j++) {
                Producto infoT = new Producto();
                System.out.print("\nIngrese producto: ");
                infoT.setNombre(entrada.next());
                System.out.print("Ingrese stock: ");
                infoT.setStock(entrada.nextInt());
                System.out.print("Ingrese el precio: ");
                infoT.setPrecio(entrada.nextDouble());
                matrizT[i][j] = infoT;
            }
        }
        return matrizT;
    }

    // Método para fusionar matrices ...
    public void fusionarMatrices(Producto[][] matriz1, Producto[][] matriz2, int tam) {
        Producto[][] matrizIdenticos = new Producto[tam][tam];
        Producto[][] matrizDiferentes = new Producto[tam][tam];
        double precioM = 0;
        int stockMix = 0;

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (matriz1[i][j].getNombre().equalsIgnoreCase(matriz2[i][j].getNombre())) {

                    if (matriz1[i][j].getPrecio() > matriz2[i][j].getPrecio()) {
                        precioM = matriz1[i][j].getPrecio();
                    } else {
                        precioM = matriz2[i][j].getPrecio();
                    }

                    stockMix = matriz1[i][j].getStock() + matriz2[i][j].getStock();
                    Producto productoMix = new Producto(matriz1[i][j].getNombre(), stockMix, precioM);
                    matrizIdenticos[i][j] = productoMix;
                } else {
                    matrizDiferentes[i][j] = matriz1[i][j];

                    for (int k = 0; k < tam; k++) {
                        for (int l = 0; l < tam; l++) {
                            if (matrizDiferentes[k][l] == null) {
                                matrizDiferentes[k][l] = matriz2[i][j];
                                break;
                            }
                        }
                    }

                }
            }
        }

        mostrarMatrizTienda(matrizIdenticos);
        mostrarMatrizTienda(matrizDiferentes);
    }

    // Método para imprimir matrices ...
    public void mostrarMatrizTienda(Producto[][] matrizT) {
        for (int i = 0; i < matrizT.length; i++) {
            for (int j = 0; j < matrizT.length; j++) {
                if (matrizT[i][j] != null) {
                    System.out.println("\nProducto: " + matrizT[i][j].getNombre());
                    System.out.println("Cantidad stock: " + matrizT[i][j].getStock());
                    System.out.println("Precio: " + matrizT[i][j].getPrecio());
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Producto ejecutor = new Producto();
        String nomTienda1, nomTienda2;

        System.out.print("\n Ingrese la dimensión de las matrices TIENDA: ");
        int dim = entrada.nextInt();

        System.out.print("\nIngrese el nombre de la primera Tienda: ");
        nomTienda1 = entrada.next();
        Producto[][] Tienda1 = new Producto[dim][dim];
        Tienda1 = ejecutor.llenarTienda(dim, Tienda1, nomTienda1);

        System.out.print("\nIngrese el nombre de la segunda Tienda: ");
        nomTienda2 = entrada.next();
        Producto[][] Tienda2 = new Producto[dim][dim];
        Tienda2 = ejecutor.llenarTienda(dim, Tienda2, nomTienda2);

        ejecutor.fusionarMatrices(Tienda1, Tienda2, dim);

    }
}
