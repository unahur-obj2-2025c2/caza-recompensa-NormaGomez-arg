package ar.edu.unahur.obj2.profugos;

import java.util.HashSet;
import java.util.Set;

public class Agencia {

    private Set<Cazador> cazadores;

    public Agencia() {
        this.cazadores = new HashSet<>();
    }

    public void agregarCazador(Cazador cazador) {
        this.cazadores.add(cazador);
    }

    public Set<Cazador> getCazadores() {
        return cazadores;
    }
    public Set<IProfugo> getTodosLosCapturados() {

        Set<IProfugo> capturados = new HashSet<>();

        for (Cazador cazador : cazadores) {
            capturados.addAll(cazador.getProfugosCapturados());
        }

        return capturados;
    }
    public IProfugo getProfugoMasHabil() {

    IProfugo masHabil = null;

    for (IProfugo profugo : getTodosLosCapturados()) {

        if (masHabil == null ||
            profugo.getHabilidad() > masHabil.getHabilidad()) {

            masHabil = profugo;
        }
    }

    return masHabil;
}
    public Cazador getCazadorConMasCapturas() {

    Cazador cazadorConMasCapturas = null;

    for (Cazador cazador : cazadores) {

        if (cazadorConMasCapturas == null ||
            cazador.getCapturas() > cazadorConMasCapturas.getCapturas()) {

            cazadorConMasCapturas = cazador;
        }
    }

    return cazadorConMasCapturas;
}
}
