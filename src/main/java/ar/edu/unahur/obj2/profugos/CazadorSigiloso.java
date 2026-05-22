package ar.edu.unahur.obj2.profugos;

public class CazadorSigiloso extends Cazador {
    public CazadorSigiloso (Integer experiencia){
        super(experiencia);
    }
    @Override
    protected Boolean cumpleCondicionEspecifica(IProfugo profugo) {
        
        return profugo.getHabilidad() < 50;
    }
    @Override
    protected void intimidar(IProfugo profugo) {
        profugo.disminuirInocencia();
        profugo.reducirHabilidad();
    }
    
}
