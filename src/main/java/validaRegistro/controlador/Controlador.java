package validaRegistro.controlador;

import validaRegistro.modelo.beans.Solicitud;
import validaRegistro.modelo.procesos.GestionArchivo;
import validaRegistro.modelo.procesos.GestionSolicitudes;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controlador {

    public void ejecutar() {
        Scanner teclado = new Scanner(System.in);
        GestionArchivo gestionArchivo = new GestionArchivo();
        GestionSolicitudes gestionSolicitudes = new GestionSolicitudes();

        try {
            System.out.print("Nombre del archivo a leer: ");
            String nombreArchivoLectura = teclado.nextLine().trim();

            HashMap<String, Solicitud> solicitudes = gestionArchivo.cargarArchivo(nombreArchivoLectura);
            gestionSolicitudes.mostrarSolicitudes(solicitudes);

        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
