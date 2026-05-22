package ar.edu.unahur.obj2.profugos;
import java.util.HashSet;
import java.util.Set;

public abstract class Cazador {
    protected Integer experiencia;
    protected Integer capturas;
    protected Set<IProfugo> profugosCapturados;


    public Cazador(Integer experiencia) {
        this.experiencia = experiencia;
        this.capturas = 0;
        this.profugosCapturados = new HashSet<>();
    }

    public Integer getExperiencia() {
        return experiencia;
    }
    public Integer getCapturas() {
        return capturas;
    }
   public Set<IProfugo> getProfugosCapturados() {
    return this.profugosCapturados;
}
    public Boolean cumpleCondicionGeneral (IProfugo profugo){
        return this.experiencia > profugo.getInocencia();
    }
    protected abstract Boolean cumpleCondicionEspecifica(IProfugo profugo);

    public Boolean puedeCapturar(IProfugo profugo) {
        return cumpleCondicionGeneral(profugo)
        && cumpleCondicionEspecifica(profugo);
    }
    protected abstract void intimidar(IProfugo profugo);

    public void realizarCaptura(Zona zona) {

    Set<IProfugo> capturados = new HashSet<>();
    Set<IProfugo> intimidados = new HashSet<>();

    for (IProfugo profugo : zona.getProfugos()) {

    if (this.puedeCapturar(profugo)) {
        capturados.add(profugo);
        this.profugosCapturados.add(profugo);
        this.capturas = this.capturas + 1;
    } 
    else {
        this.intimidar(profugo);
        intimidados.add(profugo);
    }
    }

    zona.getProfugos().removeAll(capturados);
    this.experiencia = this.experiencia + calcularExperiencia(intimidados);
    }   
   private Integer calcularExperiencia(Set<IProfugo> intimidados) {

    Integer minimo = 0;

    if (!intimidados.isEmpty()) {

        minimo = 9999;

        for (IProfugo profugo : intimidados) {

            if (profugo.getHabilidad() < minimo) {
                minimo = profugo.getHabilidad();
            }
        }
    }

    return minimo + (2 * this.capturas);
}

  

}



