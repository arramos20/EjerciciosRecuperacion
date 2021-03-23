import java.util.Scanner;

public class Mensaje {
    private int id;
    private String contacto;
    private String cuerpo;

    public Mensaje(int id, String contacto, String cuerpo) {
        this.id = id;
        this.contacto=contacto;
        this.cuerpo=cuerpo;
    }

    public Mensaje(String contacto, String cuerpo) {
        this.contacto=contacto;
        this.cuerpo=cuerpo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "ID: " + id +
                ", Contacto: " + contacto + '\'' +
                ", Cuerpo de texto= " + cuerpo + '\'' +
                '}';
    }
}
