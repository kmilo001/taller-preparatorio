import java.util.Scanner;

public class Libreria {
    private String titulo, autor;
    private double precio;
    Scanner entrada = new Scanner(System.in);

    public Libreria() {
        super();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    // Método que recibe datos de entrada y llena la matriz Libreria ...
    public Libreria[][] llenarMatrizLibreria(int dim) {
        Libreria[][] matrizL = new Libreria[dim][dim];
        for (int i = 0; i < matrizL.length; i++) {
            for (int j = 0; j < matrizL.length; j++) {
                Libreria info = new Libreria();
                System.out.print("\nIngrese el título del libro: ");
                info.setTitulo(entrada.next());
                System.out.print("Ingrese el autor del libro: ");
                info.setAutor(entrada.next());
                System.out.print("Ingrese el precio del libro: ");
                info.setPrecio(entrada.nextDouble());
                matrizL[i][j] = info;
            }
        }
        return matrizL;
    }

    // Método que imprime el libro más caro con sus características ...
    public void encontrarLibroCaro(Libreria[][] matrizSearch){
        double precioC = 0;
        Libreria libroCaro = new Libreria();

        for (int i = 0; i < matrizSearch.length; i++) {
            for (int j = 0; j < matrizSearch.length; j++) {
               if(matrizSearch[i][j].getPrecio() > precioC){
                precioC = matrizSearch[i][j].getPrecio();
                libroCaro = matrizSearch[i][j];
               }
            }
        }

        System.out.println("\nEl libro más caro es: ");
        System.out.println("\nTitulo: " + libroCaro.getTitulo());
        System.out.println("Autor: " + libroCaro.getAutor());
        System.out.println("Precio: " + libroCaro.getPrecio());
    }

    // Método que imprime y muestra los registros de la matriz ...
    public void mostrarMatrizLibreria(Libreria[][] matrizLib) {
        for (int i = 0; i < matrizLib.length; i++) {
            for (int j = 0; j < matrizLib.length; j++) {
                System.out.println("Libro: " + matrizLib[i][j].getTitulo());
                System.out.println("Autor: " + matrizLib[i][j].getAutor());
                System.out.println("Precio: " + matrizLib[i][j].getPrecio());
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("\nIngrese la dimensión de la matriz Libreria: ");
        int dim = entrada.nextInt();
        Libreria[][] matrizLibreria = new Libreria[dim][dim];
        Libreria gabo = new Libreria();

        matrizLibreria = gabo.llenarMatrizLibreria(dim);
        gabo.mostrarMatrizLibreria(matrizLibreria);
        gabo.encontrarLibroCaro(matrizLibreria);
    }

    
}
