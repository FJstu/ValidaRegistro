package validaRegistro.modelo.procesos;

import validaRegistro.modelo.beans.Solicitud;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;

public class GestionArchivo {

    public HashMap<String, Solicitud> cargarArchivo(String nombreArchivo) {
        String linea;
        HashMap<String, Solicitud> solicitudes = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                Solicitud solicitud = new Solicitud(partes[0], partes[1], partes[2], partes[3], partes[4]);
                if (solicitud.esValida()) {
                    solicitudes.put(solicitud.getLogin(), solicitud);
                }
            }
            br.close();
        } catch (IOException ioe) {
            System.out.println("Error de entrada y salida: "+ioe.getMessage());
        }
        return solicitudes;
    }

    public void validarNombreArchivo(GestionSolicitudes gestionSolicitudes, String nombreArchivo) throws InputMismatchException {
        if (nombreArchivo != null && nombreArchivo.contains(".txt")) {
            gestionSolicitudes.mostrarSolicitudes(cargarArchivo(nombreArchivo));
        } else {
            throw new InputMismatchException("ERROR: Nombre no válido.");
        }
    }
}
