package modelo.procesos;

import modelo.beans.Solicitud;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class GestionArchivo {

    public void crearArchivo(File archivo, HashMap<String, Solicitud> solicitudes) {
        if (!archivo.exists()) {
            archivo = new File("solicitudes.txt");
        }
    }

    public void guardarSolicitud(Solicitud solicitud) {

    }
}
