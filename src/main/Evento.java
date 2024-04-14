package main;
import java.util.Scanner;

public class Evento {
    private String[][] eventos;
    private int cantidadEventos;

    // Constructor
    public Evento(int maxEventos) {
        eventos = new String[maxEventos][4]; // Cada evento tiene nombre, descripción, lugar, fechaHora
        cantidadEventos = 0;
    }

    // Método para agregar un evento
    public void agregarEvento(String nombre, String descripcion, String lugar, String fechaHora) {
        if (cantidadEventos < eventos.length) {
            eventos[cantidadEventos][0] = nombre;
            eventos[cantidadEventos][1] = descripcion;
            eventos[cantidadEventos][2] = lugar;
            eventos[cantidadEventos][3] = fechaHora;
            cantidadEventos++;
            System.out.println("Evento agregado correctamente.");
        } else {
            System.out.println("No se pueden agregar más eventos. La capacidad máxima ha sido alcanzada.");
        }
    }

    // Método para mostrar todos los eventos
    public void mostrarEventos() {
        System.out.println("Lista de Eventos del Zoológico:");
        for (int i = 0; i < cantidadEventos; i++) {
            System.out.println("Nombre: " + eventos[i][0]);
            System.out.println("Descripción: " + eventos[i][1]);
            System.out.println("Lugar: " + eventos[i][2]);
            System.out.println("Fecha y Hora: " + eventos[i][3]);
        }
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad maxima de eventos que puede haber:");
        int maxEventos = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        
        Evento manager = new Evento(maxEventos);
        
        System.out.println("Ingrese el nombre del evento:");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese la descripción del evento:");
        String descripcion = scanner.nextLine();
        
        System.out.println("Ingrese el lugar del evento:");
        String lugar = scanner.nextLine();
        
        System.out.println("Ingrese la fecha y hora del evento:");
        String fechaHora = scanner.nextLine();

        manager.agregarEvento(nombre, descripcion, lugar, fechaHora);
        manager.mostrarEventos();
        
        scanner.close();
    }
}
