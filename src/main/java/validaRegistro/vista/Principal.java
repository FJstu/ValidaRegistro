package validaRegistro.vista;

import validaRegistro.modelo.beans.Solicitud;
import validaRegistro.modelo.procesos.GestionArchivo;
import validaRegistro.modelo.procesos.GestionSolicitudes;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestionArchivo gestionArchivo = new GestionArchivo();
        GestionSolicitudes gestionSolicitudes = new GestionSolicitudes();

        HashMap<String, Solicitud> solicitudes = gestionSolicitudes.crearSolicitudes();
        try {
            System.out.print("Nombre del archivo: ");
            String nombreArchivo = teclado.nextLine();
            if (nombreArchivo != null && nombreArchivo.contains(".txt")) {
                gestionArchivo.escribirArchivo(solicitudes, nombreArchivo);
                gestionSolicitudes.mostrarSolicitudes(gestionArchivo.cargarArchivo(nombreArchivo));
            }

        } catch (InputMismatchException e) {
            System.out.println("Nombre no válido.");
        }
    }
}
