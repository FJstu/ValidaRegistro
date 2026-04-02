package validaRegistro.modelo.procesos;

import validaRegistro.modelo.beans.Solicitud;

import java.util.HashMap;

public class GestionSolicitudes {

    public void mostrarSolicitudes(HashMap<String, Solicitud> solicitudes) {
        System.out.println("SOLICITUDES VÁLIDAS:");
        for (Solicitud solicitud : solicitudes.values()) {
            System.out.println(solicitud);
        }
    }
}
