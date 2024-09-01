import java.util.Scanner;

public class Tienda {
    private String nombre;
    private int cantidadProducto;
    Scanner entrada = new Scanner(System.in);

    public Tienda() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Tienda[][] llenarMatrizTienda(int tam) {
        Tienda[][] matrizT = new Tienda[tam][tam];
        for (int i = 0; i < matrizT.length; i++) {
            for (int j = 0; j < matrizT.length; j++) {
                Tienda data = new Tienda();
                System.out.print("\nIngrese el nombre del producto: ");
                data.setNombre(entrada.next());
                System.out.print("Ingrese el stock del producto: ");
                data.setCantidadProducto(entrada.nextInt());
                matrizT[i][j] = data;
            }
        }
        return matrizT;
    }

    public int sumarStock(Tienda[][] matrizPr) {
        int inventario = 0;
        for (int i = 0; i < matrizPr.length; i++) {
            for (int j = 0; j < matrizPr.length; j++) {
                inventario += matrizPr[i][j].getCantidadProducto();
            }
        }
        return inventario;
    }

    public void mostrarMatrizTienda(Tienda[][] matrizPr) {
        for (int i = 0; i < matrizPr.length; i++) {
            for (int j = 0; j < matrizPr.length; j++) {
                System.out.println("\nProducto: " + matrizPr[i][j].getNombre());
                System.out.println("Cantidad stock: " + matrizPr[i][j].getCantidadProducto());
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Tienda Maria = new Tienda();

        System.out.print("\nIngrese el tamaño de la matriz: ");
        int tam = entrada.nextInt();
        Tienda[][] MatrizObj = new Tienda[tam][tam];
        MatrizObj = Maria.llenarMatrizTienda(tam);
        Maria.mostrarMatrizTienda(MatrizObj);
        System.out.println("\nEl inventario total de la tienda es de : " + Maria.sumarStock(MatrizObj));
    }
}
