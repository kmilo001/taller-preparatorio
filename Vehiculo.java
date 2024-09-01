import java.util.Scanner;

public class Vehiculo {
    private String vehiculo, marca, color;
    private int modelo;
    private double precio;
    Scanner entrada = new Scanner(System.in); // Definimos el objeto de la clase Scanner en los atributos ...

    public Vehiculo() {
        super();
    }

    // Getters y Setters ...
    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método que crea y llena matriz objetual ...
    public Vehiculo[][] llenarMatrizVehiculos(int tam){ // Método que retorna una matriz de tipo Vehiculo, en nuestro caso "MatrizV"
        Vehiculo[][] matrizV = new Vehiculo[tam][tam]; // Definimos una matriz de tipo Vehiculo ...

        // For que recorre y llena la matriz objetual ...
        for (int i = 0; i < matrizV.length; i++) {
            for (int j = 0; j < matrizV.length; j++) {
                Vehiculo data = new Vehiculo(); // Objeto que guardará la información de los atributos ...
                System.out.print("\nIngrese el tipo de vehículo: ");
                data.setVehiculo(entrada.next());
                System.out.print("Ingrese la marca del vehículo: ");
                data.setMarca(entrada.next());
                System.out.print("Ingrese el color del vehículo: ");
                data.setColor(entrada.next());
                System.out.print("Ingrese el modelo del vehículo: ");
                data.setModelo(entrada.nextInt());
                System.out.print("Ingrese el precio del vehículo: ");
                data.setPrecio(entrada.nextDouble());
                matrizV[i][j] = data; // Asignamos al espacio de la matriz [i][j] los datos ingresados mediante el Objeto "data" ...
            }
        }
        return matrizV;
    }

    // Método que determina aumento o decremento del precio del Vehículo según su modelo ...
    public double precioFinal(int modelo, double precioOg){
        double precioF = 0;
        if(modelo >= 2000 && modelo <= 2015){
            precioF = precioOg * 0.85;
        }
        else if(modelo > 2015){
            precioF = precioOg * 1.15;
        }
        return precioF;
    }

    // Método que imprime la matriz objetual ...
    public void mostrarMatriz(Vehiculo[][] matrizResult){
        for (int i = 0; i < matrizResult.length; i++) {
            for (int j = 0; j < matrizResult.length; j++) {
                System.out.print("\nEl tipo de vehículo es: " + matrizResult[i][j].getVehiculo());
                System.out.print("\nLa marca del vehículo es: " + matrizResult[i][j].getMarca());
                System.out.print("\nEl color del vehículo es: " + matrizResult[i][j].getColor());
                System.out.print("\nEl modelo del vehículo es: " + matrizResult[i][j].getModelo());
                System.out.print("\nEl precio del vehículo es: " + matrizResult[i][j].getPrecio());
                System.out.println("\nEl precio final del vehículo es: " + precioFinal(matrizResult[i][j].getModelo(), matrizResult[i][j].getPrecio()));
            }
            System.out.println("");
        }
    }
}
