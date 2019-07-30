package ventana1;

public class Persona {
    
    private String user;
    private String password;
    
    public Persona() {
        user = "PorDefecto";
        password = "1234";
    }

    public Persona(String usuario, String contraseña) {
        this.user = usuario;
        this.password = contraseña;
    }

    public String getUsuario() {
        return user;
    }

    public void setUsuario(String usuario) {
        this.user = usuario;
    }

    public String getContraseña() {
        return password;
    }

    public void setContraseña(String contraseña) {
        this.password = contraseña;
    }

    @Override
    public String toString() {
        return "Persona: " + "Usuario = " + user + ", Contrase\u00f1a = " + password;
    }
    
}
