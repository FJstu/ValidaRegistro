package validaRegistro.controlador;

import validaRegistro.modelo.procesos.GestionArchivo;
import validaRegistro.modelo.procesos.GestionSolicitudes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controlador {
    public void ejecutar() {
        Scanner teclado = new Scanner(System.in);
        GestionSolicitudes gestionSolicitudes = new GestionSolicitudes();
        GestionArchivo gestionArchivo = new GestionArchivo();

        try {
            System.out.print("Nombre del archivo: ");
            String nombreArchivo = teclado.nextLine();
            gestionArchivo.validarNombreArchivo(gestionSolicitudes, nombreArchivo);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
