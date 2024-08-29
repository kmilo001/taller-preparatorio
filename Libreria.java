import java.util.Scanner;

public class Libreria {
    // una libreria organizada como una matriz cada celda contiene un objeto libro
    // con los siguientes atributos: titulo, autor, precio escribe una algoritmo con
    // el precio mas algoritmo
    String titulo = "";
    String autor = "";
    double precio = 0.0;
    Scanner sc = new Scanner(System.in);

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

    public Libreria() {
        this.titulo = "";
        this.autor = "";
        this.precio = 0.0;
    }

    public void EjecutarPunto3() {
        int cant = 0;
        System.out.println("Ingrese la cantidad de registros");
        cant = sc.nextInt();
        Libreria[][] matriz = new Libreria[cant][cant];
        Libreria li = new Libreria();
        double precioMayor = 0;
        matriz = li.LlenarMatriz(cant);
        precioMayor = li.PrecioMayor(matriz);
        System.out.println("el libro mas costoso es: " + precioMayor);

    }

    public Libreria[][] LlenarMatriz(int cant) {
        Libreria[][] matriz = new Libreria[cant][cant];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                Libreria li = new Libreria();
                System.out.println("Ingrese titulo");
                li.setTitulo(sc.next());
                System.out.println("Ingrese Autor");
                li.setAutor(sc.next());
                System.out.println("Ingrese el precio");
                li.setPrecio(sc.nextDouble());
                matriz[i][j] = li;
            }
        }
        return matriz;
    }

    public double PrecioMayor(Libreria[][] matriz) {
        double mayorValor = 0.0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j].getPrecio() > mayorValor) {
                    mayorValor = matriz[i][j].getPrecio();
                }

            }
        }
        return mayorValor;

    }

}
