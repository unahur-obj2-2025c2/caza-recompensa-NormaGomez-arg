package ar.edu.unahur.obj2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.profugos.*;


public class ProfugoTest {


    @Test
    public void unProfugoTieneInocenciaHabilidadYNerviosismo() {
        IProfugo profugo = new Profugo(30, 80, true);

        assertEquals(30, profugo.getInocencia());
        assertEquals(80, profugo.getHabilidad());
        assertTrue(profugo.esNervioso());
    }
    @Test
    public void unProfugoPuedeDejarDeEstarNervioso(){
        IProfugo profugo = new Profugo(30, 80, true);
        profugo.dejarDeEstarNervioso();
        assertFalse(profugo.esNervioso());

    }
    @Test
    public void unProfugoPuedeVolverseNervioso(){
        IProfugo profugo = new Profugo(30, 80, false);
        profugo.volverseNervioso();
        assertTrue(profugo.esNervioso());
    }
   @Test
    public void reducirHabilidadBaja5PeroNoBajaDeCero() {
        IProfugo profugo = new Profugo(30, 3, true);

        profugo.reducirHabilidad();

        assertEquals(0, profugo.getHabilidad());
    }
    @Test
    public void disminuirInocenciaBaja2PeroNoBajaDeCero() {
        IProfugo profugo = new Profugo(1, 80, true);

        profugo.disminuirInocencia();

        assertEquals(0, profugo.getInocencia());
    }
    @Test
    public void duplicaHabilidadNoPasa100(){
        IProfugo p = new Profugo(30, 40, true);
        IProfugo entrenado = new ArtesMarcialesAvanzadas(p);
        assertEquals(80,entrenado.getHabilidad());

    }
    @Test
    public void duplicaHabilidadNoPasa100_2(){
        IProfugo p = new Profugo(30, 80, true);
        IProfugo entrenado = new ArtesMarcialesAvanzadas(p);
        assertEquals(100,entrenado.getHabilidad());

    }
    @Test
    public void nuncaEstaNervioso(){
        IProfugo p = new Profugo(30, 80, true);
        IProfugo entrenado = new EntrenamientoElite(p);
        assertFalse(entrenado.esNervioso());
    }
    @Test
    public void inocenciaNuncaMenorQue40(){
        IProfugo p = new Profugo(30, 40, true);
        IProfugo entrenado = new ProteccionLegal(p);
        assertEquals(40,entrenado.getInocencia());

    }
    @Test
    public void inocenciaNuncaMenorQue40a(){
        IProfugo p = new Profugo(70, 40, true);
        IProfugo entrenado = new ProteccionLegal(p);
        assertEquals(70,entrenado.getInocencia());

    }
    @Test
    public void unaZonaPuedeTenerProfugos() {

        Zona zona = new Zona("Palermo");

        IProfugo p1 = new Profugo(30, 40, true);

        zona.agregarProfugo(p1);

        assertEquals(1, zona.getProfugos().size());
    }
    @Test
    public void unCazadorCumpleCondicionGeneral(){
        Cazador cazador = new CazadorUrbano(50);

        IProfugo p2 = new Profugo(30, 40, true);

        assertTrue(cazador.cumpleCondicionGeneral(p2));
    }
    @Test
    public void UnCazadorCapturaYEliminaDeLaZona() {
        Zona zona = new Zona("Palermo");
        IProfugo p3 = new Profugo(10,40,false);
        IProfugo p4 = new Profugo(60,40,false);
        Cazador cazador = new CazadorUrbano(50);
        zona.agregarProfugo(p3);
        zona.agregarProfugo(p4);
        cazador.realizarCaptura(zona);
        assertEquals(1,zona.getProfugos().size());
        assertEquals(1,cazador.getCapturas());
    }
    @Test
    public void sumaExperienciaCorrectamente() {

        Zona zona = new Zona("Palermo");

        IProfugo p1 = new Profugo(10, 40, false);
        IProfugo p2 = new Profugo(60, 20, false);

        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);

        Cazador cazador = new CazadorUrbano(50);

        cazador.realizarCaptura(zona);

        assertEquals(72, cazador.getExperiencia());
    }
    @Test
    public void laAgenciaConoceTodosLosCapturados() {

        Zona zona = new Zona("Palermo");

        IProfugo p1 = new Profugo(10, 40, false);

        zona.agregarProfugo(p1);

        Cazador cazador = new CazadorUrbano(50);

        cazador.realizarCaptura(zona);

        Agencia agencia = new Agencia();

        agencia.agregarCazador(cazador);

        assertEquals(1, agencia.getTodosLosCapturados().size());
    }


@Test
public void laAgenciaConoceAlCazadorConMasCapturas() {

    Zona zona = new Zona("Palermo");

    IProfugo p1 = new Profugo(10, 40, false);
    IProfugo p2 = new Profugo(10, 30, false);

    zona.agregarProfugo(p1);
    zona.agregarProfugo(p2);

    Cazador cazador = new CazadorUrbano(50);

    cazador.realizarCaptura(zona);

    Agencia agencia = new Agencia();
    agencia.agregarCazador(cazador);

    assertEquals(cazador, agencia.getCazadorConMasCapturas());
}
}

