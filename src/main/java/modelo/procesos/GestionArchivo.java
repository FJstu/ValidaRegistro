package modelo.procesos;

import modelo.beans.Solicitud;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestionArchivo {

    public void crearSolicitud(File archivo, HashMap<String, Solicitud> solicitudes) {
        try {
            if (!archivo.exists()) {
                archivo = new File("solicitudes.txt");
            }
        }
    }

    public HashMap<String, Solicitud> guardarSolicitud() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("solicitudes.txt"));
            String linea;
            List<Solicitud> solicitudes = new ArrayList<>();

                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(":");
                    Solicitud solicitud = new Solicitud(partes[0], partes[1], partes[2], partes[3], partes[4]);
                    if (solicitud.esValida()) {
                        solicitudes.put(solicitud.getClave(), solicitud);
                    }
                }
                br.close();
        } catch (IOException ioe) {
            System.out.println("Error de entrada y salida: "+ioe.getMessage());
        }
    }
}
