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
        GestionSolicitudes gestionSolicitudes = new GestionSolicitudes();
        GestionArchivo gestionArchivo = new GestionArchivo();
        HashMap<String, Solicitud> solicitudes = gestionSolicitudes.crearSolicitudes();

        try {
            System.out.print("Nombre del archivo: ");
            String nombreArchivo = teclado.nextLine();
            gestionArchivo.validarNombreArchivo(gestionSolicitudes, solicitudes, nombreArchivo);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
