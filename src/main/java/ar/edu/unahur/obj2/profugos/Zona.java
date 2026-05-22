package ar.edu.unahur.obj2.profugos;
import java.util.HashSet;
import java.util.Set;

public class Zona {

    private String nombre;
    private Set<IProfugo> profugos;

    public Zona(String nombre) {
        this.nombre = nombre;
        this.profugos = new HashSet<>();
    }

    public void agregarProfugo(IProfugo profugo) {
        profugos.add(profugo);
    }

    public Set<IProfugo> getProfugos() {
        return profugos;
    }

    public String getNombre() {
        return nombre;
    }
}
