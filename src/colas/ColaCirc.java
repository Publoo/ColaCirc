package colas;

import java.util.Scanner;

public class ColaCirc {

    private static int[] colilla = new int[5];
    private static int colafrente = 0;
    private static int colafinal = 0;
    private static int tamaño = 0;

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("QUE DESEA REALIZAR CON LA COLA: ");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Imprimir");
            System.out.println("4. Salir");

            try {
                opcion = leer.nextInt();
            } catch (Exception punto) {
                System.out.println("Entrada inválida.");
                leer.next(); 
                continue;
            }

            switch (opcion) {
                case 1:
                    insertar(leer);
                    break;
                case 2:
                    eliminar();
                    break;
                case 3:
                    imprimir();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 4);

        leer.close();
    }

    private static void insertar(Scanner leer) {
        if (tamaño == colilla.length) {
            System.out.println("Cola llena, borre algún valor antes de insertar uno nuevo.");
        } else {
            System.out.print("Ingrese el valor a insertar: ");
            int valor = leer.nextInt();
            colilla[colafinal] = valor;
            colafinal = (colafinal + 1) % colilla.length; 
            tamaño++; 
            System.out.println("Valor insertado.");
        }
    }

    private static void eliminar() {
        if (tamaño == 0) {
            System.out.println("Cola vacía, no hay valores para eliminar.");
        } else {
            System.out.println("Valor eliminado: " + colilla[colafrente]);
            colafrente = (colafrente + 1) % colilla.length; 
            tamaño--;
        }
    }

    private static void imprimir() {
        if (tamaño == 0) {
            System.out.println("Cola vacía.");
        } else {
            System.out.println("Elementos de la cola: " + tamaño);
            System.out.println("Frente de la cola: " + colafrente);
            System.out.println("Final de la cola: " + colafinal);
            int i = colafrente;
            for (int cont = 0; cont < tamaño; cont++) {
                System.out.println(colilla[i]);
                i = (i + 1) % colilla.length; 
            }
        }
    }
}

