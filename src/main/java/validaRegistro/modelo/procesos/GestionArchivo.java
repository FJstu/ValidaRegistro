package validaRegistro.modelo.procesos;

import validaRegistro.modelo.beans.Solicitud;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;

public class GestionArchivo {

    public void escribirArchivo(HashMap<String, Solicitud> solicitudes, String nombreArchivo) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true));

            for (Solicitud solicitud : solicitudes.values()) {
                bw.write(String.valueOf(solicitud));
                bw.newLine();
            }
            bw.close();
        } catch (IOException ioe) {
            System.out.println("Error de entrada y salida: "+ioe.getMessage());
        }
    }

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

    public void validarNombreArchivo(GestionSolicitudes gestionSolicitudes,
    HashMap<String, Solicitud> solicitudes, String nombreArchivo) throws InputMismatchException {
        if (nombreArchivo != null && nombreArchivo.contains(".txt")) {
            escribirArchivo(solicitudes, nombreArchivo);
            gestionSolicitudes.mostrarSolicitudes(cargarArchivo(nombreArchivo));
        } else {
            throw new InputMismatchException("ERROR: Nombre no válido.");
        }
    }
}
