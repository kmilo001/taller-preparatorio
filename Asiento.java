import java.util.Scanner;

public class Asiento {
    private int numeroA, fila;
    private double precio;
    Scanner entrada = new Scanner(System.in);

    public Asiento() {
        super();
    }

    public int getNumeroA() {
        return numeroA;
    }

    public void setNumeroA(int numeroA) {
        this.numeroA = numeroA;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método que recibe la información del asiento y lo almacena como registro en la matriz Asiento
    public Asiento[][] llenarMatrizAsiento(int tam) {
        Asiento[][] matrizA = new Asiento[tam][tam];
        for (int i = 0; i < matrizA.length; i++) {
            System.out.println("\n ----- ASIENTOS DE LA FILA: " + (i+1) + " -----");
            for (int j = 0; j < matrizA.length; j++) {
                Asiento info = new Asiento();
                System.out.print("\nIngrese el número de asiento: ");
                info.setNumeroA(entrada.nextInt());
                System.out.print("Ingrese el precio del asiento: ");
                info.setPrecio(entrada.nextDouble());
                info.setFila(i);
                matrizA[i][j] = info;
            }
        }
        return matrizA;
    }

    // Método que organiza las filas de la matriz por el precio de los asientos
    // Utilizamos el método burbuja para el ordenamiento de vectores o matrices ...
    public void organizarFilas(Asiento[][] matrizAsi){
        for (int i = 0; i < matrizAsi.length; i++) { // For (i) que recorre las filas de la matriz
            for (int j = 0; j < matrizAsi.length - 1; j++) { // for (j) permite hacer saltos entre los elementos de la fila, su rango va hasta un elemento menos de la fila puesto que la comparación del burbuja se hace en pares.
                for (int k = 0; k < matrizAsi.length - 1 - j; k++) { // for (k) hace la comparación en pares de los elementos de las filas. Su rango es .length - 1 - j porque cada que aumenta la variable j se reduce la cantidad de comparaciones.
                    if(matrizAsi[i][k].getPrecio() > matrizAsi[i][k + 1].getPrecio()){
                        Asiento temp = matrizAsi[i][k];
                        matrizAsi[i][k] = matrizAsi[i][k + 1];
                        matrizAsi[i][k + 1] = temp;
                    }    
                }
            }
        }
    }

    // Método que imprime los registros de la matriz de manera ordenada ...
    public void mostrarMatrizAsiento(Asiento[][] matrizAsi) {
        System.out.println("\n ----- ASIENTOS DEL TEATRO ORGANIZADO POR FILAS ----- ");
        for (int i = 0; i < matrizAsi.length; i++) {
            for (int j = 0; j < matrizAsi.length; j++) {
                System.out.println("\nNúmero: " + matrizAsi[i][j].getNumeroA());
                System.out.println("Fila: " + (matrizAsi[i][j].getFila() + 1));
                System.out.println("Precio: " + matrizAsi[i][j].getPrecio());
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("\nIngrese el tamaño de la matriz TEATRO : ");
        int tam = entrada.nextInt();

        Asiento[][] matrizTeatro = new Asiento[tam][tam];
        Asiento teatro = new Asiento();

        matrizTeatro = teatro.llenarMatrizAsiento(tam);
        teatro.organizarFilas(matrizTeatro);
        teatro.mostrarMatrizAsiento(matrizTeatro);
    }
}
