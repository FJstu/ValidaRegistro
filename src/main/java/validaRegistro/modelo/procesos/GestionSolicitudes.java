package validaRegistro.modelo.procesos;

import validaRegistro.modelo.beans.Solicitud;

import java.util.HashMap;

public class GestionSolicitudes {
    public HashMap<String, Solicitud> crearSolicitudes() {
        HashMap<String, Solicitud> solicitudes = new HashMap<>();

        solicitudes.put("carlos23", new Solicitud("carlos23", "miperro12", "carlos@gmail.com", "Carlos", "Martínez"));
        solicitudes.put("lucia99", new Solicitud("lucia99", "lasagna5", "lucia@hotmail.com", "Lucía", "Fernández"));
        solicitudes.put("pedro12", new Solicitud("pedro12", "ajedrez23", "pedro@yahoo.com", "Pedro", "Sánchez"));
        solicitudes.put("ana456", new Solicitud("ana456", "flores99", "ana@gmail.com", "María", "López"));
        solicitudes.put("jorge77", new Solicitud("jorge77", "verano24", "jorge@outlook.com", "Jorge", "Ramírez"));

        return solicitudes;
    }

    public void mostrarSolicitudes(HashMap<String, Solicitud> solicitudes) {
        System.out.println("SOLICITUDES:");
        for (Solicitud solicitud : solicitudes.values()) {
            System.out.println(solicitud);
        }
    }
}
