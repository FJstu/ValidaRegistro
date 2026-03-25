package modelo.beans;

import java.io.Serializable;

public class Solicitud implements Serializable {
    private String login; // (Es el nombre que usa el usuario para acceder al sistema.)
    private String clave;
    private String email;
    private String nombreCompleto;

    public Solicitud(String login, String clave, String email, String nombreCompleto) {
        this.login = login;
        this.clave = clave;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getClave() {
        return clave;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public boolean esValida() {
        return this.login.length() >= 5
            && this.clave.length() >= 5
            && this.email.length() >= 5
            && this.nombreCompleto.length() >= 5
                && this.email.contains("@");
    }

    public String toString() {
        return this.login+":"+this.clave+":"+this.email+":"+this.nombreCompleto;
    }
}