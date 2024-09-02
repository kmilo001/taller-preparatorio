import java.util.ArrayList;
import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    // Listas para cada calificación
    ArrayList<Estudiante> grupoA = new ArrayList<>();
    ArrayList<Estudiante> grupoB = new ArrayList<>();
    ArrayList<Estudiante> grupoC = new ArrayList<>();

    System.out.print("Ingrese el número de estudiantes: ");
    int numEstudiantes = scanner.nextInt();
    scanner.nextLine();  // Consumir el salto de línea

    for (int i = 0; i < numEstudiantes; i++) {
        System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la calificación del estudiante (A, B, C): ");
        char calificacion = scanner.nextLine().charAt(0);

        Estudiante estudiante = new Estudiante(nombre, calificacion);

        switch (calificacion) {
            case 'A':
                grupoA.add(estudiante);
                break;
            case 'B':
                grupoB.add(estudiante);
                break;
            case 'C':
                grupoC.add(estudiante);
                break;
            default:
                System.out.println("Calificación no válida. Se omitirá al estudiante.");
                break;
        }
    }

    // Imprimir los grupos
    System.out.println("Calificacion : A)");
    printEstudiantes(grupoA);

    System.out.println("Calificacion : B)");
    printEstudiantes(grupoB);

    System.out.println("Calificacion : C)");
    printEstudiantes(grupoC);

    scanner.close();
}

// Método para imprimir estudiantes
private static void printEstudiantes(ArrayList<Estudiante> grupo) {
    if (grupo.isEmpty()) {
        System.out.println("No hay estudiantes en este grupo.");
    } else {
        for (Estudiante estudiante : grupo) {
            System.out.println(estudiante.getNombre() + " - " + estudiante.getCalificacion());
        }
    }
}
